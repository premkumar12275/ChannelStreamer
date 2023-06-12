package com.channelStreamer.channels.Dto;

public class DataObjectStream1
{
    private String id;
    private String created_at;
    private String sensitive;
    private String visibility;
    private String content;
    private String stream;


    public DataObjectStream1() {
    }

    public String getContent() {
        return content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getId() {
        return id;
    }

    public String getSensitive() {
        return sensitive;
    }

    public String getStream() {
        return stream;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSensitive(String sensitive) {
        this.sensitive = sensitive;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}
