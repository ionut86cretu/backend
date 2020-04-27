package com.endava.school4it.memebook.api;

public class PostTopicPayload {

	private String mediaUrl;
	private String author;
	private String title;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String comment) {
		this.title = comment;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}
}
