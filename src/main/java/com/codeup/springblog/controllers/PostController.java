package com.codeup.springblog.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class PostController {

    private final PostRepository postDao;

    @GetMapping("/posts")
    @ResponseBody
    public String indexPosts() {
        return "Placeholder: index for posts";
    }

    @GetMapping("/posts/show")
    public String viewPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
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

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @PostMapping("/deletebyid/{id}")
    public String deletePostbyId(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts/show";
    }

    @GetMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, Model model){
        Post editPost = postDao.getById(id);
        model.addAttribute("postToEdit", editPost);

        return "posts/edit";
    }

}