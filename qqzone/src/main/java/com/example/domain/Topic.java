package com.example.domain;

import java.util.List;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class Topic {
    private Integer id;
    private String title;
    private String content;
    private String topicDate;
    private Integer author;
    private UserBasic topicAuthor;
    private List<Reply> replyList;

    public Topic() {}

    public Topic(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(String topicDate) {
        this.topicDate = topicDate;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    public UserBasic getTopicAuthor() {
        return topicAuthor;
    }

    public void setTopicAuthor(UserBasic topicAuthor) {
        this.topicAuthor = topicAuthor;
    }
}
