package com.chao.po;

public class Like {
    private Integer id;
    private Integer user_id;
    private Integer follow_id;

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

    public Integer getFollow_id() {
        return follow_id;
    }

    public void setFollow_id(Integer follow_id) {
        this.follow_id = follow_id;
    }

    public Like(Integer id, Integer user_id, Integer follow_id) {
        this.id = id;
        this.user_id = user_id;
        this.follow_id = follow_id;
    }

    public Like() {
    }
}
