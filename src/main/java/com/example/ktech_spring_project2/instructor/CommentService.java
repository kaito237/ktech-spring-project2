package com.example.ktech_spring_project2.instructor;

import com.example.ktech_spring_project2.instructor.model.Comment;
import com.example.ktech_spring_project2.instructor.model.Post;
import com.example.ktech_spring_project2.instructor.repo.CommentRepository;
import com.example.ktech_spring_project2.instructor.repo.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    private  final CommentRepository commentRepository;

    private  final PostRepository postRepository;

    public CommentService(
            CommentRepository commentRepository,
            PostRepository postRepository
    ) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }


    public Comment addComment(
            Long id,
            Comment comment
    ) {
        Post post = postRepository.findById(id).orElseThrow();
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    public Optional<Comment> findCommentById(Long id) {
        return commentRepository.findById(id);
    }


    public  void deleteComment(Long id, String password) throws IllegalAccessException {
        Comment comment = commentRepository.findById(id).orElseThrow();
        if (comment.getPassword().equals(password)) {
            commentRepository.delete(comment);
        } else {
            throw new IllegalAccessException("password not match");
        }
    }

}
