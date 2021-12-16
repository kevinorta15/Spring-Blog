package com.codeup.springblog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String indexPosts(){
return "Placeholder: index for posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPosts(@PathVariable int id){
return "Placeholder for individual posts of Id " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePost(){
return "Placeholder for the create post form!";
    }

    public String createPost(){

    }
}
