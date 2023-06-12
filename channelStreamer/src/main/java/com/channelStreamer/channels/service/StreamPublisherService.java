package com.channelStreamer.channels.service;
import com.rabbitmq.client.*;
import com.rabbitmq.client.impl.AMQConnection;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class StreamPublisherService {

    private static final String RABBITMQ_HOST = "localhost";
    private static final int RABBITMQ_PORT = 5672;
    private static final String RABBITMQ_USERNAME = "user";
    private static final String RABBITMQ_PASSWORD = "password";
    private static final String EXCHANGE_NAME = "prem-rabbitMQ";

    public boolean publishIntoQueue(String message) throws IOException, TimeoutException
    {
        boolean result = false;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RABBITMQ_HOST);
        factory.setPort(RABBITMQ_PORT);
        factory.setUsername(RABBITMQ_USERNAME);
        factory.setPassword(RABBITMQ_PASSWORD);
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
