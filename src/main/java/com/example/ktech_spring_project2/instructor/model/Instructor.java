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
    private String name;


    @OneToMany(mappedBy = "instructor")
    private List<Post> posts;


    }


