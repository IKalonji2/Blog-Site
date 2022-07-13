package com.bbdgrad.blogsite.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "Blog")
@Entity
public class Blog {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long blogID;

    @ManyToOne
    @JoinColumn(name = "category_categoryid")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_userid")
    private User user;

    private String title;
    private String body;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;

    public Long getBlogID() {
        return blogID;
    }

    public void setBlogID(Long blogID) {
        this.blogID = blogID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
