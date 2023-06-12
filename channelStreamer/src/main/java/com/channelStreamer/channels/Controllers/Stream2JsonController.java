package com.channelStreamer.channels.Controllers;

import com.channelStreamer.channels.Dto.DataObjectStream2;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.channelStreamer.channels.service.*;

import java.util.List;

@RestController
@RequestMapping("/api/stream2")
public class Stream2JsonController {

    private static final String stream_limit = "stream_limit";
    private static final String write_limit = "write_limit";
    @RequestMapping("/writeData/{"+write_limit+"}")
    public void writeData(@PathVariable(write_limit) int writeLimit){
        Stream2JsonService stream2Service = new Stream2JsonService();
        stream2Service.writeDataIntoJson(writeLimit);
    }

    @RequestMapping("/readData/{"+stream_limit+"}")
    public List<DataObjectStream2> readData(@PathVariable(stream_limit) int streamLimit){
        Stream2JsonService stream2Service = new Stream2JsonService();
        List<DataObjectStream2> filteredElements = stream2Service.readDataFromJson(streamLimit);
        return filteredElements;
    }
}
