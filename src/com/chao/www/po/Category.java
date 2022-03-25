package com.chao.www.po;

public class Category {

    private int id;
    private String category_name;
    private int create_user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getCreate_user_id() {
        return create_user_id;
    }

    public void setCreate_user_id(int create_user_id) {
        this.create_user_id = create_user_id;
    }

    public Category(int id, String category_name, int create_user_id) {
        this.id = id;
        this.category_name = category_name;
        this.create_user_id = create_user_id;
    }

    public Category() {
    }
}
