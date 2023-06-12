package com.channelStreamer.channels.service;
import twitter4j.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
//import twitter4j.conf.ConfigurationBuilder;

public class TwitterStreamService {
    public static final String consumerKey = "q0t6Fitibqjix8g3u2zbJjZqM";
    public static final String consumerSecret = "WaqSAyEFMnI74UHwZe8ot9e48wQQqd1QC4vtieJIPqAH6BjnhD";
    public static final String accessToken = "1020049285-aVW4pZWmfu08qggBvuHnvOWHdObtoEkudFNMNmk";
    public static final String accessTokenSecret = "FGw2MpHIw6ViTw0nVwyImzBLVL7Uy7V3MRd5xLPyuPD32";

    public void readTwitterStream() throws IOException, TimeoutException
    {
        /*try {
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey(consumerKey)
                    .setOAuthConsumerSecret(consumerSecret)
                    .setOAuthAccessToken(accessToken)
                    .setOAuthAccessTokenSecret(accessTokenSecret);
            TwitterStreamFactory tf = new TwitterStreamFactory(cb.build());
            TwitterStream twitterStream = tf.getInstance();
            twitterStream.addListener(new StatusListener() {
                @Override
                public void onStatus(Status status) {
                    String tweet = processTweet(status);
                    try {
                        StreamPublisherService publisherService = new StreamPublisherService();
                        publisherService.publishIntoQueue(tweet);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        catch (Exception ex){
            ex.printStackTrace();
        }*/
    }
}
