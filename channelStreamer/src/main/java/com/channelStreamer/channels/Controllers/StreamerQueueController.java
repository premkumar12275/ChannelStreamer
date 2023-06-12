package com.channelStreamer.channels.Controllers;

import com.channelStreamer.channels.Dto.DataObjectStream1;
import com.channelStreamer.channels.Dto.DataObjectStream2;
import com.rabbitmq.client.*;
import com.rabbitmq.client.impl.AMQConnection;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.channelStreamer.channels.service.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/api/queue")
public class StreamerQueueController {

    private static final String stream_limit = "stream_limit";

    @RequestMapping("/publish/{"+stream_limit+"}")
    public List<String> insertIntoQueue(@PathVariable(stream_limit) int streamLimit) throws IOException, TimeoutException
    {
        Stream1JsonService stream1Service = new Stream1JsonService();
        Stream2JsonService stream2Service = new Stream2JsonService();
        List<DataObjectStream1> stream1DataStreamList = stream1Service.readDataFromJson(streamLimit);
        List<DataObjectStream2> stream2DataStreamList = stream2Service.readDataFromJson(streamLimit);
        StreamPublisherService publisherService = new StreamPublisherService();
        List<String> contentList = new ArrayList<>();
        for(DataObjectStream1 data1: stream1DataStreamList ){
            publisherService.publishIntoQueue(data1.getContent());
            contentList.add(data1.getContent());
        }
        for(DataObjectStream2 data2: stream2DataStreamList ){
            publisherService.publishIntoQueue(data2.getContent());
            contentList.add(data2.getContent());
        }
        return contentList;
    }

    @RequestMapping("/consume")
    public List<String> consumeQueue() throws IOException, TimeoutException
    {
        StreamConsumerService consumerService = new StreamConsumerService();
        List<String> resultList = consumerService.consumeFromQueue();
        return resultList;
    }
}
