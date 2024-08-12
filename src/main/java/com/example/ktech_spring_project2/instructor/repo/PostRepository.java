package com.example.ktech_spring_project2.instructor.repo;

import com.example.ktech_spring_project2.instructor.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository
extends JpaRepository<Post, Long> {
}
