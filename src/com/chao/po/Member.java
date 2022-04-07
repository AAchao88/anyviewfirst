package com.chao.po;

public class Member {

    private Integer id;
    private Integer team_id;
    private Integer member_id;
    private Integer member_permission;
    private Integer knowledgebase_id;
    private String team_name;
    private String knowledgebase_name;

    public String getKnowledgebase_name() {
        return knowledgebase_name;
    }

    public void setKnowledgebase_name(String knowledgebase_name) {
        this.knowledgebase_name = knowledgebase_name;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    public Integer getMember_permission() {
        return member_permission;
    }

    public void setMember_permission(Integer member_permission) {
        this.member_permission = member_permission;
    }

    public Integer getKnowledgebase_id() {
        return knowledgebase_id;
    }

    public void setKnowledgebase_id(Integer knowledgebase_id) {
        this.knowledgebase_id = knowledgebase_id;
    }

    public Member() {
    }

    public Member(Integer knowledgebase_id, String knowledgebase_name) {
        this.knowledgebase_id = knowledgebase_id;
        this.knowledgebase_name = knowledgebase_name;
    }
}
