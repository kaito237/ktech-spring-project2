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
    public String createPost(
            Model model
    ) {
        model.addAttribute("instructor", new Instructor());
        return "instructors/create.html";
    }

    @PostMapping("create")
    public String create(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("password") String password //
    ) {
        // Gọi phương thức tạo bài viết từ service
        Long id = postService.createPost(title, content, password).getId();

        // Chuyển hướng đến trang chi tiết của bài viết mới tạo
        return String.format("redirect:/instructors/%d", id);
    }
    // READ ALL
    @GetMapping  // /articles
    public String readAll(Model model) {
        model.addAttribute("articles", postService.readAll());
        return "articles/home.html";
    }

    // READ ONE
    //  /articles/1 => id = 1
    //  /articles/2 => id = 2
    //  /articles/3 => id = 3
    @GetMapping("{id}")
    public String readOne(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("article", postService.readOne(id));
        return "articles/read.html";
    }

    // update == submit

    @GetMapping("/{id}/update")
    public String editPostForm(
            @PathVariable Long id,
            Model model
    ) {
        model.addAttribute("instructor", postService.readOne(id));
        model.addAttribute("post", new Post());
        return "posts/read.html";
    }

    @PostMapping("/{id}/update")
    public String editPost(
            @PathVariable Long id,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("password") String password
    ) {
        postService.update(id, title, content, password);
        return "redirect:/posts/%d" +id;
    }


}
