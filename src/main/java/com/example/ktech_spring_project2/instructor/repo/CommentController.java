package com.example.ktech_spring_project2.instructor.repo;

import com.example.ktech_spring_project2.instructor.CommentService;
import com.example.ktech_spring_project2.instructor.model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping("/posts/{postId}/comments")
    public String addComment(
            @PathVariable
            Long postId,
            @ModelAttribute
            Comment comment) {
        commentService.save(comment);
        return "redirect:/posts/" + postId;
    }

    @PostMapping("/posts/{postId}/comments/{commentId}/delete")
    public String deleteComment(
            @PathVariable Long postId,
            @PathVariable Long commentId
    ){
        return "redirect:/posts/" + postId;

    }


}
