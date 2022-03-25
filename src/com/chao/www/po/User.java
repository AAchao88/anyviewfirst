package com.chao.www.po;

public class User {

    private int id;
    private String username;
    private String password;
    private String nick;
    private String sex;
    private String telephone;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(int id, String username, String password, String nick, String sex, String telephone, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nick = nick;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
    }

    public User() {
    }

}
