package com.example.ktech_spring_project2.instructor;

import com.example.ktech_spring_project2.instructor.model.Instructor;
import com.example.ktech_spring_project2.instructor.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    private  final PostService postService;

    public  PostController(PostService postService){
        this.postService = postService;
    }
    @GetMapping("/create")
    public String createPostForm(
            Model model
    ) {
        model.addAttribute("instructor", new Instructor());
        return "instructors/create.html";
    }

    @PostMapping("/create")
    public String createPost(
            @ModelAttribute Post post
    ) {
        postService.creatPost(post.getId(), null);
        return "redirect:/instructors";
    }

    @GetMapping("/{id}/edit")
    public String editPostForm(
            @PathVariable Long id,
            Model model
    ) {
        Post post = postService.findPostById(id).orElseThrow();
        model.addAttribute("post", new Post());
        return "posts/create.html";
    }

    @PostMapping("/{id}/edit")
    public String editPost(
            @PathVariable Long id,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("password") String password
    ) {
        postService.updatePost(id, title, content, password);
        return "redirect:/instructors/" +id;
    }


    @PostMapping("/{id}/delete")
    public String deletePost(
            @PathVariable Long id,
            @RequestParam("password") String password
    ){
       postService.deletePost(id, password);
        return "redirect:/instructors";
    }
}
