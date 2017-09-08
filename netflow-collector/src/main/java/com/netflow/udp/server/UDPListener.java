package com.netflow.udp.server;

import com.netflow.bean.V5.NetFlowV5Header;
import com.netflow.bean.V5.NetFlowV5Packet;
import com.netflow.bean.V5.NetFlowV5Parser;
import com.netflow.bean.V9.*;
import com.netflow.bean.kafka.NetflowBean;
import com.netflow.kafka.producer.NetflowKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by carlos on 4/09/17.
 *
 * UDP NetFlow Listener
 */
@Component
public class UDPListener extends Thread{

    private static final Logger LOGGER = LoggerFactory.getLogger(UDPListener.class);

    @Value("${server.udp_port}")
    int udpPort;

    @Value("${server.udp_address}")
    String udpAddress;

    @Autowired
    private NetflowKafkaProducer netflowKafkaProducer;

    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[102400];


    @PostConstruct
    public void startProducing() throws UnknownHostException{
        try {
            InetAddress udpServerAddress = InetAddress.getByName(udpAddress);
            socket = new DatagramSocket(udpPort,udpServerAddress);
            LOGGER.info("UDP Server Up and Running.....");
            run();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        running = true;

        while (running) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            //String packetReceived = new String(packet.getData(), 0, packet.getLength());

            parseV5Packet(packet.getData());

            //System.out.println("Packet received: " + packetReceived);


            /**
            if (packetReceived.equals("end")) {
                running = false;
                continue;
            }


            try {
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
             **/

        }

        socket.close();

    }


    /**
     * Netflow v9 parser
     *
     * @param packetReceived byte[] Netflow packet V9
     */
    public void parseV9Packet(byte[] packetReceived) {

        NetFlowV9TemplateCache cache = new NetFlowV9TemplateCache();
        NetFlowV9Packet p1 = NetFlowV9Parser.parsePacket(packetReceived, cache);

        System.out.println("Version: " + "V" + p1.getHeader().getVersion());

        List<NetFlowV9Template> lsTEmplates  = p1.getTemplates();

        NetFlowV9OptionTemplate newTEmplate = p1.getOptionTemplate();

        for (NetFlowV9Template template: lsTEmplates) {
            System.out.println("Origen " + 2);
        }

        List<NetFlowV9Record> lsRecords = p1.getRecords();

        for (NetFlowV9Record record : lsRecords) {
            Map<String, Object> mpFields = record.getFields();
            System.out.println("Origen " + 1);
        }
    }


    /**
     * Netflow v5 parser
     *
     * @param packetReceived byte[] Netflow packet V5
     */
    public void parseV5Packet(byte[] packetReceived){

        NetFlowV5Packet packet = NetFlowV5Parser.parsePacket(packetReceived);
        NetFlowV5Header header = packet.getHeader();
        Date date = Date.from( Instant.ofEpochSecond( header.getUnixSecs() ) );

        Map<String, Object> records = packet.getRecords().get(0).toMap();
        LOGGER.info("################## NETFLOW V5 #######################");
        LOGGER.info("Netflow Version: V" + header.getVersion());
        LOGGER.info("Destination address: " + records.get("dst_addr"));
        LOGGER.info("Destination Port: " + records.get("dst_port"));
        LOGGER.info("Source address: " + records.get("src_addr"));
        LOGGER.info("Source Port: " + records.get("src_port"));
        LOGGER.info("Protocol: " + records.get("protocol"));
        LOGGER.info("Size: " + records.get("packet_count"));
        LOGGER.info("Date: " + date.toString());
        LOGGER.info("Next Hop: " + records.get("next_hop"));
        LOGGER.info("Tos: " + records.get("tos"));
        LOGGER.info(" ");

        NetflowBean netflowBean = new NetflowBean();
        netflowBean.setDate(date.toString());
        netflowBean.setMessageProtocol(records.get("protocol").toString());
        netflowBean.setNetflowProtocol(new Integer(header.getVersion()).toString());
        netflowBean.setSize(records.get("packet_count").toString());
        netflowBean.setSourceIpAddress(records.get("src_addr").toString());
        netflowBean.setSourcePort(records.get("src_port").toString());
        netflowBean.setTargetIpAddress(records.get("dst_addr").toString());
        netflowBean.setTargetPort(records.get("dst_port").toString());
        netflowBean.setNextHop(records.get("next_hop").toString());
        netflowBean.setTos(records.get("tos").toString());

        netflowKafkaProducer.sendNetflowToKafka(netflowBean);

        LOGGER.info("Netflow sended to Kafka");
    }


}
