package com.dooioo.samples.blog.model;

import com.dooioo.web.model.BaseEntity;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 12-8-14
 * Time: 下午3:52
 */
public class Category extends BaseEntity {

    private int id;
    private String name;
    private Date createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
