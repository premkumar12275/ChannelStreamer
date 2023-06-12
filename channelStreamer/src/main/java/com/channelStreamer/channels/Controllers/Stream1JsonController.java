package com.channelStreamer.channels.Controllers;

import com.channelStreamer.channels.Dto.DataObjectStream1;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.channelStreamer.channels.Dto.*;
import com.channelStreamer.channels.service.*;

@RestController
@RequestMapping("/api/stream1")
public class Stream1JsonController {

    private static final String stream_limit = "stream_limit";
    private static final String write_limit = "write_limit";
    @RequestMapping("/writeData/{"+write_limit+"}")
    public void writeData(@PathVariable(write_limit) int writeLimit){
        Stream1JsonService stream1Service = new Stream1JsonService();
        stream1Service.writeDataIntoJson(writeLimit);
    }

    @RequestMapping("/readData/{"+stream_limit+"}")
    public List<DataObjectStream1> readData(@PathVariable(stream_limit) int streamLimit){
        Stream1JsonService stream1Service = new Stream1JsonService();
        List<DataObjectStream1> filteredElements = stream1Service.readDataFromJson(streamLimit);
        return filteredElements;
    }
}
