package com.chao.www.po;

import java.util.Date;

public class Comment {

    private int id;
    private String content;
    private String create_user;
    private int article_id;
    private Date create_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Comment(int id, String content, String create_user, int article_id, Date create_time) {
        this.id = id;
        this.content = content;
        this.create_user = create_user;
        this.article_id = article_id;
        this.create_time = create_time;
    }

    public Comment() {
    }
}
