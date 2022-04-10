package com.chao.po;

import java.util.Date;

public class Favorite {
    private Integer id;
    private Integer user_id;
    private Integer article_id;
    private Date delete_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public Date getDelete_time() {
        return delete_time;
    }

    public void setDelete_time(Date delete_time) {
        this.delete_time = delete_time;
    }

    public Favorite(Integer id, Integer user_id, Integer article_id, Date delete_time) {
        this.id = id;
        this.user_id = user_id;
        this.article_id = article_id;
        this.delete_time = delete_time;
    }

    public Favorite() {
    }
}
