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
    @Setter
    private Long id;
    @Setter
    private String title;
    @Setter
    private String writer;
    @Setter
    private String password;

    @Setter
    @ManyToOne
    private Instructor instructor;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

}
