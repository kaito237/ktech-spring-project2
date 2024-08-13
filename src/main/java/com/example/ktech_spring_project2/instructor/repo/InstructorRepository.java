package com.example.ktech_spring_project2.instructor.repo;

import com.example.ktech_spring_project2.instructor.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorRepository
        extends JpaRepository<Instructor, Long> {

    List<Instructor> findByTitle(String title);
}