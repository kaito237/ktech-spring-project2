package com.example.ktech_spring_project2.instructor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String content;
    @Setter
    private String writer;
    @Setter
    @ManyToOne
    private User user;
    private Instructor instructor;

    public Comment() {}

    public Comment(String content, String writer, Instructor instructor){
        this.content = content;
        this.writer = writer;
        this.instructor = instructor;
    }
}
