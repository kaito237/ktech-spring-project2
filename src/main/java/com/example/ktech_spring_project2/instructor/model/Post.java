package com.example.ktech_spring_project2.instructor.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String title;

    private  String content;

    private String password;


    @ManyToOne
    private Instructor instructor;


    public Post() {}

    public Post(String title, String content, String password) {
        this.title = title;
        this.content = content;
        this.password = password;
    }

}
