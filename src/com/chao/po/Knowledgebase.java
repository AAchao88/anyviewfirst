package com.chao.po;

import java.util.Date;

public class Knowledgebase {
    private Integer id;
    private String knowledgebase_name;
    private Integer create_user_id;
    private Date create_time;
    private String tag;

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

    public Date getCreate_time() {
        return create_time;
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

    public Knowledgebase(Integer id, String knowledgebase_name, Integer create_user_id, Date create_time, String tag) {
        this.id = id;
        this.knowledgebase_name = knowledgebase_name;
        this.create_user_id = create_user_id;
        this.create_time = create_time;
        this.tag = tag;
    }

    public Knowledgebase() {
    }
}
