package com.example.ktech_spring_project2.instructor;

import com.example.ktech_spring_project2.instructor.model.Comment;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {

        this.commentService = commentService;
    }
    // 댓글 추가하기
    @PostMapping("/{postId}")
    public String addComment(
            @PathVariable
            Long postId,
            @RequestParam("content") String content,
            @RequestParam("password") String password
    ) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setPassword(password);
        commentService.addComment(postId, comment);
        return "redirect:/posts/" + postId;
    }

    // 댓글 삭제하기

    @SneakyThrows
    @PostMapping("/{postId}/{commentId}/delete")
    public String deleteComment(
            @PathVariable Long postId,
            @PathVariable Long commentId,
            @RequestParam("password") String password
    ){
        commentService.deleteComment(commentId, password);
        return "redirect:/posts/" + postId;

    }


}
