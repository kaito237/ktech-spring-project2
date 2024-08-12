package com.example.ktech_spring_project2.instructor.repo;

import com.example.ktech_spring_project2.instructor.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository
extends JpaRepository<Comment, Long> {
}
