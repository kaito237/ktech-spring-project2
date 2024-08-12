package com.example.ktech_spring_project2.instructor.repo;

import com.example.ktech_spring_project2.instructor.InstructorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("instructor")
public class InstructorController {

    private final InstructorService service;
    public InstructorController(InstructorService service) {
        this.service = service;
    }

    // CREATE
    @GetMapping("/instructors")
    public String createView() {
        return "instructors/list.html";
    }
    @GetMapping("/instructs/{instructorId}")
    public String listPosts(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("instructor", service.readOne(id));
        return "articles/read.html";
    }
}
