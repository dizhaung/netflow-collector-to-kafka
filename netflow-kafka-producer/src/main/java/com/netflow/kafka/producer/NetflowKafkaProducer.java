package com.netflow.kafka.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflow.bean.kafka.NetflowBean;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Service
public class NetflowKafkaProducer {

    @Value("${kafka.brokers}")
    String brokers;

    @Value("${kafka.port}")
    String port;

	private static final Logger LOGGER = LoggerFactory.getLogger(NetflowKafkaProducer.class);

    private static final String TOPIC = "NetflowV5";

    @Autowired
    private ObjectMapper objectMapper;

    private Producer<String,String> producerCallback;


    @PostConstruct
    public void startProducing() {
    	Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers + ":" + port);
        props.put("acks", "all");
        props.put("reconnect.backoff.ms", 5000);
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        producerCallback = new KafkaProducer<>(props);
    }


    /**
     * Method to send netflows collected to kafka topic
     *
     * @param netflowBean com.netflow information
     */
    public void sendNetflowToKafka(final NetflowBean netflowBean){

        try {
            String messageData = objectMapper.writeValueAsString(netflowBean);
            ProducerRecord<String,String> record = new ProducerRecord<>(TOPIC, String.valueOf(System.nanoTime()).toString(), messageData);

            producerCallback.send(record,
                   (metadata, e) -> {
                       if(e != null){
                           e.printStackTrace();
                       }
                       LOGGER.info("The offset of the record we just sent is: " + metadata.offset());
                   });

        } catch (Exception e) {
             e.printStackTrace();
        }

        //producerCallback.close();

    }

}