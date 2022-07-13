package com.bbdgrad.blogsite.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import net.bytebuddy.description.type.TypeList;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "blog")
@Entity
public class blog {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long blogID;

    @ManyToOne
    @JoinColumn(name = "categoryID", referencedColumnName = "categoryID")
    private category category;

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private user user;

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

    public com.bbdgrad.blogsite.models.category getCategory() {
        return category;
    }

    public void setCategory(com.bbdgrad.blogsite.models.category category) {
        this.category = category;
    }

    public com.bbdgrad.blogsite.models.user getUser() {
        return user;
    }

    public void setUser(com.bbdgrad.blogsite.models.user user) {
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
