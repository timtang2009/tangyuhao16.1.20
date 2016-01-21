package com.dooioo.samples.blog.model;

import com.dooioo.web.model.BasePageEntity;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 12-11-28
 * Time: 下午4:56
 */
public class Comment extends BasePageEntity {
    private Integer id;
    private Integer articleId;
    private Integer userId;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private int status;

    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
