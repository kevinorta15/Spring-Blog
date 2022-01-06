package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }
//    @GetMapping("/posts")
//    @ResponseBody
//    public String indexPosts() {
//        return "Placeholder: index for posts";
//    }

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



    @PostMapping("/deletebyid/{id}")
    public String deletePostbyId(@PathVariable long id) {
        long deletePostId = id;
        postDao.deleteById(deletePostId);
        return "redirect:/posts/show";
    }

    @GetMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, Model model){
        Post editPost = postDao.getById(id);
        model.addAttribute("postToEdit", editPost);

        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String saveEditPost(@RequestParam(name= "postTitle") String title, @RequestParam(name = "postBody") String postBody, @RequestParam(name = "postId") long id){
        return "redirect:/posts";
    }
}