package com.chao.po;

import java.util.Date;

public class KnowledgeBase {
    private Integer id;
    private String knowledgebase_name;
    private Integer create_user_id;
    private Date create_time;
    private String tag;
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKnowledgebase_name() {
        return knowledgebase_name;
    }

    public void setKnowledgebase_name(String knowledgebase_name) {
        this.knowledgebase_name = knowledgebase_name;
    }

    public Integer getCreate_user_id() {
        return create_user_id;
    }

    public void setCreate_user_id(Integer create_user_id) {
        this.create_user_id = create_user_id;
    }

    public java.sql.Date getCreate_time() {
        return (java.sql.Date) create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public KnowledgeBase(Integer id, String knowledgebase_name, Integer create_user_id, Date create_time, String tag,String category) {
        this.id = id;
        this.knowledgebase_name = knowledgebase_name;
        this.create_user_id = create_user_id;
        this.create_time = create_time;
        this.tag = tag;
        this.category = category;
    }

    public KnowledgeBase() {
    }
}
