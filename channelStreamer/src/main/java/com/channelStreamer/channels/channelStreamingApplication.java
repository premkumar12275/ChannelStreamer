package com.channelStreamer.channels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;

//import twitter4j.conf.ConfigurationBuilder;

@SpringBootApplication
@RestController
public class channelStreamingApplication {

	public static void main(String[] args) {
		SpringApplication.run(channelStreamingApplication.class, args);
	}

}
