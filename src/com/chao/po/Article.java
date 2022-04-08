package com.chao.po;

import java.util.Date;

public class Article {
    private Integer id;
    private String title;
    private String content;
    private Integer author_id;
    private Date create_time;
    private Date update_time;
    private Integer like;
    private Integer favorite;
    private Integer comment;
    private Integer knowledgebase_id;
    private String tag;
    private Integer shared;
    private Date deleteTime;
    private Integer deleteStatus;

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author_id=" + author_id +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", like=" + like +
                ", favorite=" + favorite +
                ", comment='" + comment + '\'' +
                ", knowledgebase_id=" + knowledgebase_id +
                ", tag='" + tag + '\'' +
                ", shared=" + shared +
                ", deleteTime=" + deleteTime +
                ", deleteStatus=" + deleteStatus +
                '}';
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

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public java.sql.Date getCreate_time() {
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

    public Integer getFavorite() {
        return favorite;
    }

    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Integer getKnowledgebase_id() {
        return knowledgebase_id;
    }

    public void setKnowledgebase_id(Integer knowledgebase_id) {
        this.knowledgebase_id = knowledgebase_id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getShared() {
        return shared;
    }

    public void setShared(Integer shared) {
        this.shared = shared;
    }

//    public Article(Integer id, String title, String content, Integer author_id, Date create_time, Date update_time, Integer like, Integer favorite, String comment, Integer knowledgebase_id, String tag, Integer shared) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//        this.author_id = author_id;
//        this.create_time = create_time;
//        this.update_time = update_time;
//        this.like = like;
//        this.favorite = favorite;
//        this.comment = comment;
//        this.knowledgebase_id = knowledgebase_id;
//        this.tag = tag;
//        this.shared = shared;
//    }

    public Article() {
    }

    public Article(Integer id, String title, String content, Date create_time, Date update_time, Integer like, Integer favorite, Integer comment,String tag) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.create_time = create_time;
        this.update_time = update_time;
        this.like = like;
        this.favorite = favorite;
        this.comment = comment;
        this.tag = tag;
    }
}
