package com.example.domain;

import java.util.Date;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class Reply {
    private Integer id;
    private String content;
    private String replyDate;
    private Integer author;
    private UserBasic replyAuthor;
    private Integer topic;
    private Topic topicText;
    private HostReply hostReply;

    public Reply() {}

    public Reply(String content, String replyDate, Integer author, UserBasic replyAuthor, Integer topic, Topic topicText) {
        this.content = content;
        this.replyDate = replyDate;
        this.author = author;
        this.replyAuthor = replyAuthor;
        this.topic = topic;
        this.topicText = topicText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(String replyDate) {
        this.replyDate = replyDate;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getTopic() {
        return topic;
    }

    public void setTopic(Integer topic) {
        this.topic = topic;
    }

    public HostReply getHostReply() {
        return hostReply;
    }

    public void setHostReply(HostReply hostReply) {
        this.hostReply = hostReply;
    }

    public UserBasic getReplyAuthor() {
        return replyAuthor;
    }

    public void setReplyAuthor(UserBasic replyAuthor) {
        this.replyAuthor = replyAuthor;
    }

    public Topic getTopicText() {
        return topicText;
    }

    public void setTopicText(Topic topicText) {
        this.topicText = topicText;
    }
}
