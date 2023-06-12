package com.channelStreamer.channels.service;
/*import io.github.sys1yagi.mastodon4j.*;
import io.github.sys1yagi.mastodon4j.api.method.Timelines;*/

public class MastodonStreamService {
    public static final String ACCESS_TOKEN = "tnxdc9QkVVZEZp9sRdGknPbqYFcrSyBs-ksEdsMrRz4";
    public static final String INSTANCE_URL = "https://mastodon.social/";
    /*public void readMastodonStream()
    {
        MastodonClient mastodonClient = new MastodonClient.Builder(INSTANCE_URL)
                .accessToken(ACCESS_TOKEN)
                .build();
        Timelines timelines = new Timelines(mastodonClient);
        try {
            Response<java.util.List<Status>> response = timelines.getPublicTimeline().execute();
            if (response.isSuccessful()) {
                java.util.List<Status> statuses = response.body();
                StreamPublisherService publisherService = new StreamPublisherService();
                for (Status status : statuses) {
                    publisherService.publishIntoQueue(status.getContent());
                }
            } else {
                System.out.println("Failed to fetch the public timeline: " + response.errorBody().string());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
