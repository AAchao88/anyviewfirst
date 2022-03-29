package com.chao.po;

public class Category {

    private Integer id;
    private String category_name;
    private Integer create_user_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setCreate_user_id(Integer create_user_id) {
        this.create_user_id = create_user_id;
    }

    public Category(Integer id, String category_name, Integer create_user_id) {
        this.id = id;
        this.category_name = category_name;
        this.create_user_id = create_user_id;
    }

    public Category() {
    }
}
