package com.dooioo.samples.blog.model;

import com.dooioo.web.model.BasePageEntity;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 12-11-2
 * Time: 下午4:07
 */
public class Article extends BasePageEntity {

    private Integer id;
    private Integer userId;
    private Integer categoryId;
    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;

    //ext
    private String categoryName;
    private String username;

    public Integer getId() {
        return id;
    }

    public Article setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Article setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Article setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Article setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isNew() {
        return id == null;
    }
}
