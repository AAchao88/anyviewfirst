package com.chao.po;

import java.util.Date;

public class Article {
    private Integer id;
    private String title;
    private String content;
    private String author_id;
    private Date create_time;
    private Date update_time;
    private Integer like;
    private Integer collect;
    private String comment;
    private Integer category_id;

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

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Article(Integer id, String title, String content, String author_id, Date create_time, Date update_time, Integer like, Integer collect, String comment, Integer category_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author_id = author_id;
        this.create_time = create_time;
        this.update_time = update_time;
        this.like = like;
        this.collect = collect;
        this.comment = comment;
        this.category_id = category_id;
    }

    public Article() {
    }
}
