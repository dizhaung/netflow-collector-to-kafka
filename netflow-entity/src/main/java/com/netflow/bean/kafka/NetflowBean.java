package com.netflow.bean.kafka;

import java.io.Serializable;

/**
 * Object to send to kafka
 *
 * Created by e049890 on 4/09/17.
 */
public class NetflowBean implements Serializable{

    private String sourceIpAddress;
    private String sourcePort;
    private String targetIpAddress;
    private String targetPort;
    private String date;
    private String size;
    private String messageProtocol;
    private String netflowProtocol;
    private String nextHop;
    private String tos;

    public String getNextHop() {
        return nextHop;
    }

    public void setNextHop(String nextHop) {
        this.nextHop = nextHop;
    }

    public String getTos() {
        return tos;
    }

    public void setTos(String tos) {
        this.tos = tos;
    }

    public String getSourceIpAddress() {
        return sourceIpAddress;
    }

    public void setSourceIpAddress(String sourceIpAddress) {
        this.sourceIpAddress = sourceIpAddress;
    }

    public String getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(String sourcePort) {
        this.sourcePort = sourcePort;
    }

    public String getTargetIpAddress() {
        return targetIpAddress;
    }

    public void setTargetIpAddress(String targetIpAddress) {
        this.targetIpAddress = targetIpAddress;
    }

    public String getTargetPort() {
        return targetPort;
    }

    public void setTargetPort(String targetPort) {
        this.targetPort = targetPort;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMessageProtocol() {
        return messageProtocol;
    }

    public void setMessageProtocol(String messageProtocol) {
        this.messageProtocol = messageProtocol;
    }

    public String getNetflowProtocol() {
        return netflowProtocol;
    }

    public void setNetflowProtocol(String netflowProtocol) {
        this.netflowProtocol = netflowProtocol;
    }
}
