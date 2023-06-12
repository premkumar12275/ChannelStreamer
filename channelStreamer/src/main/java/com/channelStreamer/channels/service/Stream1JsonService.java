package com.channelStreamer.channels.service;

import com.channelStreamer.channels.Dto.DataObjectStream1;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Stream1JsonService {

    public void writeDataIntoJson( int writeLimit){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<DataObjectStream1> dataObjectStream1List = new ArrayList<>();
            for(int i=0; i<writeLimit; i++)
            {
                DataObjectStream1 data = new DataObjectStream1();
                data.setId(String.valueOf(i));
                data.setCreated_at(String.valueOf(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE)));
                data.setContent("This is from Message stream 1 and content is Hello Mr. " + i);
                data.setSensitive("False");
                data.setStream("stream 1");
                data.setVisibility("public");
                dataObjectStream1List.add(data);
            }
            String jsonString = objectMapper.writeValueAsString(dataObjectStream1List);
            try (FileWriter fileWriter = new FileWriter("stream1.json")) {
                fileWriter.write(jsonString);
                System.out.println("Data written to JSON file successfully.");
                fileWriter.flush();
            } catch (IOException e) {
                System.out.println("Error writing to JSON file: " + e.getMessage());
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            //we should implement proper logging and corresponding handling here
        }
    }

    public List<DataObjectStream1> readDataFromJson(int streamLimit){
        String filePath = "stream1.json";
        List<DataObjectStream1> filteredElements = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<DataObjectStream1> dataObjectStream1List = objectMapper.readValue(new File(filePath),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, DataObjectStream1.class));
            filteredElements = dataObjectStream1List.subList(0, Math.min(dataObjectStream1List.size(), streamLimit));
            return  filteredElements;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            //we should implement proper logging and corresponding handling here
        }
        return filteredElements;
    }
}
