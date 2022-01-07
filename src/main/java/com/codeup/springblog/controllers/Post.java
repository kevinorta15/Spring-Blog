package com.codeup.springblog.controllers;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    public Post(String title, String body) {
//        this.body = body;
//        this.title = title;
//    }

    @Column(nullable = false)
    private String body;
    @Column(nullable = false, length = 75)
    private String title;

    @ManyToOne
    @JoinColumn(name = "post_user_id")
    private User postUser;

//    public Post() {
//
//    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getPostUser() {
        return postUser;
    }

    public void setPostUser(User postUser) {
        this.postUser = postUser;
    }
}
