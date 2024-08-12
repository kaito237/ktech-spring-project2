package com.example.ktech_spring_project2.instructor;

import com.example.ktech_spring_project2.instructor.model.Instructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService service;
    public InstructorController(InstructorService service) {
        this.service = service;
    }

    // CREATE
    @GetMapping("/instructors")
    public String ListInstructor(Model model) {
        List<Instructor> instructors = service.findAllInstructor();
        model.addAttribute("instructors", instructors);
        return "instructors/list.html";
    }
    @GetMapping("{/Id}")
    public String viewInstructor(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        Instructor instructor = service.findInstructorById(id).orElseThrow();
        model.addAttribute("instructor", service.readOne(id));
        return "instructors/view.html";
    }
}
