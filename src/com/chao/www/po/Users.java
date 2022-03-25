package com.chao.www.po;

public class Users {

    private Integer id;
    private String username;
    private String password;
    private String sex;
    private Integer telephone;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users(Integer id, String username, String password, String sex, Integer telephone, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
    }

    public Users() {
    }

}
