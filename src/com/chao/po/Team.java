package com.chao.po;

import java.util.Date;

public class Team {
    private Integer id;
    private String team_name;
    private Integer create_user_id;
    private Date create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
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

    public Team(Integer id, String team_name, Integer create_user_id, Date create_time) {
        this.id = id;
        this.team_name = team_name;
        this.create_user_id = create_user_id;
        this.create_time = create_time;
    }

    public Team() {
    }
}
