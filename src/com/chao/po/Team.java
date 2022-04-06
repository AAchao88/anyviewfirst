package com.chao.po;

public class Team {
    private Integer id;
    private Integer create_user_id;
    private String team_name;
    private String invitationCode1;
    private String invitationCode2;
    private String invitationCode3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreate_user_id() {
        return create_user_id;
    }

    public void setCreate_user_id(Integer create_user_id) {
        this.create_user_id = create_user_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getInvitationCode1() {
        return invitationCode1;
    }

    public void setInvitationCode1(String invitationCode1) {
        this.invitationCode1 = invitationCode1;
    }

    public String getInvitationCode2() {
        return invitationCode2;
    }

    public void setInvitationCode2(String invitationCode2) {
        this.invitationCode2 = invitationCode2;
    }

    public String getInvitationCode3() {
        return invitationCode3;
    }

    public void setInvitationCode3(String invitationCode3) {
        this.invitationCode3 = invitationCode3;
    }

    public Team() {
    }

    public Team( Integer create_user_id, String team_name, String invitationCode1, String invitationCode2, String invitationCode3) {
        this.create_user_id = create_user_id;
        this.team_name = team_name;
        this.invitationCode1 = invitationCode1;
        this.invitationCode2 = invitationCode2;
        this.invitationCode3 = invitationCode3;
    }
}
