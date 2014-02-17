package com.epam.model.entities;

import java.util.Date;

public class News extends AbstractEntity {
    private String content;
    private String title;
    private String brief;
    private Date createdAt;

    public News() {
    }

    public News(String title, String brief, String content) {
        super();
        this.title = title;
        this.brief = brief;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
