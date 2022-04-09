package com.chao.po;

import java.util.Date;

public class Comment {

    private Integer id;
    private String content;
    private Integer create_user_id;
    private Integer article_id;
    private Date create_time;

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

    public Integer getCreate_user() {
        return create_user_id;
    }

    public void setCreate_user(Integer create_user) {
        this.create_user_id = create_user;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Comment(Integer id, String content, Integer create_user, Integer article_id, Date create_time) {
        this.id = id;
        this.content = content;
        this.create_user_id = create_user_id;
        this.article_id = article_id;
        this.create_time = create_time;
    }

    public Comment() {
    }
}
