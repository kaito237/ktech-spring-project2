package com.example.ktech_spring_project2.instructor.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private String writer;

    @Setter
    @OneToMany(mappedBy = "article")
    private List<Comment> comments;

    public Instructor() {}

    public Instructor(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }


}
