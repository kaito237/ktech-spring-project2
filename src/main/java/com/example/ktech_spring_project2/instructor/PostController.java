package com.example.ktech_spring_project2.instructor;

import com.example.ktech_spring_project2.instructor.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    private  final PostService postService;

    public  PostController(PostService postService){
        this.postService = postService;
    }
    @GetMapping("/posts/{postId}")
    public String PostView(
            @PathVariable Long postId,
            Model model
    ) {
        Post post = postService.findById(postId);
        model.addAttribute("post", post);
        return "post/posts-view.html";
    }

    @GetMapping("/post/new")
    public String newPost(
            Model model
    ) {
        model.addAttribute("post", new Post());
        return "posts/new.html";
    }

    @GetMapping("/posts/{postId}/edit")
    public String editPost(@PathVariable Long postId, Model model) {
        Post post = postService.findById(postId);
        model.addAttribute("post", post);
        return "posts/edit";
    }
    @PostMapping("/posts")
    public String createPost(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/boards/" + post.getInstructor().getId();
    }

    @PostMapping("/posts/{postId}")
    public String updatePost(@PathVariable Long postId, @ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/posts/" + postId;
    }

    @PostMapping("/posts/{postId}/delete")
    public String deletePost(@PathVariable Long postId) {
        postService.deleteById(postId);
        return "redirect:/instructors";
    }
}
