package com.example.ktech_spring_project2.instructor;

import com.example.ktech_spring_project2.instructor.model.Comment;
import com.example.ktech_spring_project2.instructor.repo.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private  final CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Comment findByID(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public  void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

}
