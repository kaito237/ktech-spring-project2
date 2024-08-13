package com.example.ktech_spring_project2.instructor;

import com.example.ktech_spring_project2.instructor.model.Instructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService service;
    public InstructorController(InstructorService service) {
        this.service = service;
    }

    // CREATE
    @GetMapping("list")
    public String ListInstructor(Model model) {

        List<Instructor> instructors = service.findAllInstructor();
        model.addAttribute("instructors", instructors);
        return "instructors/list.html";
    }

    @GetMapping("list/{broad}")
    public String ListInstructor(Model model, @PathVariable String broad) {
        List<Instructor> instructors = service.findAllInstructor();
        model.addAttribute("instructors", instructors);
        return "instructors/list.html";
    }
    @GetMapping("/create")// hien thi ra trang de nhap thong tin
    public String createInstructor(Model model) {
        Instructor instructor = new Instructor();
        model.addAttribute("instructor", instructor);
        return "instructors/create.html";
    }

    // sau nhap nhap thong itn lcik nut save de luu
    @PostMapping("/create")// hien thi ra trang de nhap thong tin
    public String createInstructor(@ModelAttribute("instructor") Instructor instructor) {
        instructor.setName("aaa");
        service.create(instructor);
        return "redirect:/instructors/list";
    }


}