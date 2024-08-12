package com.example.ktech_spring_project2.instructor.repo;

import com.example.ktech_spring_project2.instructor.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository
extends JpaRepository<Instructor, Long> {
}
