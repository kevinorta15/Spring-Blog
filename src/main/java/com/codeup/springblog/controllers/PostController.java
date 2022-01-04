package com.codeup.springblog.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

public class PostController {

    private final PostRepository postDao;

    @GetMapping("/posts")
    @ResponseBody
    public String indexPosts() {
        return "Placeholder: index for posts";
    }

    @GetMapping("/posts/show")
    public String individualPosts(Model model) {
//        Post newPost = new Post("Hello World", "Welcome to Codeup");
//        model.addAttribute("post", newPost);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePost() {
        return "Placeholder for the create post form!";
    }

    public String createPost() {
        return "";
    }

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

//    @GetMapping("delete/{id}")
}
