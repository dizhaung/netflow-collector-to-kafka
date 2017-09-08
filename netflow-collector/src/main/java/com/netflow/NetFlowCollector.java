package com.netflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.UnknownHostException;

@SpringBootApplication
public class NetFlowCollector {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(NetFlowCollector.class, args);
    }
}