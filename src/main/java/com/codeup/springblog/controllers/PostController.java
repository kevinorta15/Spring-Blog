package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    //    @GetMapping("/posts")
//    @ResponseBody
//    public String indexPosts() {
//        return "Placeholder: index for posts";
//    }

    @GetMapping("/posts/show")
    public String viewPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        model.addAttribute("user", userDao.findAll());
        return "posts/show";
    }
@GetMapping("/posts/create")
public String createPost(Model model){
        model.addAttribute("post", new Post());
        return "/posts/create";
}

    @PostMapping("/posts/create")
    public String viewCreatePost(@ModelAttribute Post post) {
        post.setPostUser(userDao.getById(1L));
        postDao.save(post);
        return "redirect:/posts/show";
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
    public String saveEditPost(@RequestParam(name= "postTitle") String postTitle, @RequestParam(name = "postBody") String postBody, @RequestParam(name = "postId") long id){
        Post postToEdit = postDao.getById(id);

        postToEdit.setBody(postBody);
        postToEdit.setTitle(postTitle);
        ;

        postDao.save(postToEdit);

        return "redirect:/posts/show";
    }
}