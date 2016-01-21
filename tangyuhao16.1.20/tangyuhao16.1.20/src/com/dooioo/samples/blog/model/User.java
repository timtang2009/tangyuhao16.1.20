package com.dooioo.samples.blog.model;

import com.dooioo.web.model.BaseEntity;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 12-8-14
 * Time: 下午4:23
 */
public class User extends BaseEntity {

    private int id;
    private String name;
    private String password;
    private String email;
    private Date createdAt;

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public User setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
}
