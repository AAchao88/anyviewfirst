package com.chao.www.po;

import java.util.Date;

public class Team {
    private int id;
    private String team_name;
    private int create_user_id;
    private Date create_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getCreate_user_id() {
        return create_user_id;
    }

    public void setCreate_user_id(int create_user_id) {
        this.create_user_id = create_user_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Team(int id, String team_name, int create_user_id, Date create_time) {
        this.id = id;
        this.team_name = team_name;
        this.create_user_id = create_user_id;
        this.create_time = create_time;
    }

    public Team() {
    }
}
