package com.channelStreamer.channels.service;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class StreamConsumerService {
    private static final String RABBITMQ_HOST = "localhost";
    private static final int RABBITMQ_PORT = 5672;
    private static final String RABBITMQ_USERNAME = "user";
    private static final String RABBITMQ_PASSWORD = "password";
    private static final String EXCHANGE_NAME = "prem-rabbitMQ";

    public List<String> consumeFromQueue() throws IOException, TimeoutException
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RABBITMQ_HOST);
        factory.setPort(RABBITMQ_PORT);
        factory.setUsername(RABBITMQ_USERNAME);
        factory.setPassword(RABBITMQ_PASSWORD);
        List<String> resultList = new ArrayList<>();
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, EXCHANGE_NAME, "");
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("Delivering message to corresponding channels: " + message);
                    resultList.add(message);
                }
            };
            channel.basicConsume(queueName, true, consumer);
            return resultList;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return resultList;
    }
}
