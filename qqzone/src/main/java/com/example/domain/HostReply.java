package com.example.domain;

import java.util.Date;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class HostReply {
    private Integer id;
    private String content;
    private String hostReplyDate;
    private Integer author;
    private UserBasic hostReplyAuthor;
    private Integer reply;
    private Reply replyText;

    public HostReply() {
    }

    public HostReply(Integer id) {
        this.id = id;
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

    public String getHostReplyDate() {
        return hostReplyDate;
    }

    public void setHostReplyDate(String hostReplyDate) {
        this.hostReplyDate = hostReplyDate;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getReply() {
        return reply;
    }

    public void setReply(Integer reply) {
        this.reply = reply;
    }

    public UserBasic getHostReplyAuthor() {
        return hostReplyAuthor;
    }

    public void setHostReplyAuthor(UserBasic hostReplyAuthor) {
        this.hostReplyAuthor = hostReplyAuthor;
    }

    public Reply getReplyText() {
        return replyText;
    }

    public void setReplyText(Reply replyText) {
        this.replyText = replyText;
    }
}
