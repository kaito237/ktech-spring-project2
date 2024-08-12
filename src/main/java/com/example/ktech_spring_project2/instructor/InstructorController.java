package com.example.ktech_spring_project2.instructor;
import com.example.ktech_spring_project2.instructor.model.Instructor;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("instructor")
public class InstructorController {
    private final InstructorService service;
    public InstructorController(InstructorService service) {
        this.service = service;
    }

    //- 게시판 보기: `/boards/{boardId}/
    // read all
    @GetMapping("/")
    public String boardList(Model model) {
        List<Instructor> instructors = service.readAll();
        model.addAttribute("instructors", instructors);
        return "boardList.html";
    }

    @PostMapping("/board")
    public String getPostsByBoard(
            @RequestParam("name")
            String name,
            Model model
    ) {
       List<Instructor> instructors = service.getPostsById(name);
        model.addAttribute("instructors", instructors);
        return "instructor/boardList.html";
    }

    // read one
    @GetMapping("/create")
    public String createView(
            Model model
    ){
        return "instructors/read.html";
    }
    //게시글 보기: `/instructors/{usersId}`
    @GetMapping("/instructors/{usersId}")
    public String usersView(
           @PathVariable("id")
           Long id,
           Model model
    ) {
        Instructor instructor = service.readOne(id);
        model.addAttribute("instructor", instructor);
        return "instructors/view";
    }

    //게시글 수정하기: `/instructors/{usersId}/update/

    @GetMapping("{id}/update")
    public String updateView(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        Instructor instructor = service.readOne(id);
        model.addAttribute("instructor", service.readOne(id));
        return "instructors/update.html";
    }

    @PostMapping("{id}/update")
    public String update(
            @PathVariable("id")
            Long id,
            @RequestParam("title")
            String title,
            @RequestParam("content")
            String content,
            @RequestParam("writer")
            String writer
    ) {
        service.update(id, title, content, writer);
        return String.format("redirect:/instructor/%d", id);

    }

    //게시글 삭제하기: `/instructors/{usersId}/delete/
    @PostMapping("{id}/delete")
    public String delete(
            @PathVariable("id")
            Long id
    ) {
        service.delete(id);
        return "redirect:/instructor";
    }



    //댓글 작성하기: `/instructors/{usersId}/comment/
    @PostMapping("/{instructorId}/comment")
    public String addComment(
            @PathVariable("instructorId")
            Long instructorId,
            @RequestParam("content")
            String content
    ) {
        addComment(instructorId, content);
        return String.format("\"redirect:/instructor/%d\", instructorId");
    }

    //댓글 삭제하기: `/instructors/{usersId}/comment/{commentId}/delete/`
    @PostMapping("/{instructorId}/comment/{commentId}/delete")
    public String deleteComment(
            @PathVariable("instructorId")
            Long instructorId,
            @PathVariable("commentId")
            Long commentId
    ) {
        service.delete(instructorId); // Giả sử phương thức này tồn tại
        return String.format("redirect:/instructor/%d", instructorId);
    }







}