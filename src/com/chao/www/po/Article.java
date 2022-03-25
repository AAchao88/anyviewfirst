package com.chao.www.po;

import java.util.Date;

public class Article {
    private int id;
    private String title;
    private String content;
    private String author_id;
    private Date create_time;
    private Date update_time;
    private int like;
    private int collect;
    private String comment;
    private int category_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getCollect() {
        return collect;
    }

    public void setCollect(int collect) {
        this.collect = collect;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Article(int id, String title, String content, String author_id, Date create_time, Date update_time, int like, int collect, String comment, int category_id) {
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
