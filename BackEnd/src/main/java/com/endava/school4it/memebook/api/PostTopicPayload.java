package com.endava.school4it.memebook.api;

public class PostTopicPayload {
    private String title;
    private String mediaUrl;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { this.title = title; }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
