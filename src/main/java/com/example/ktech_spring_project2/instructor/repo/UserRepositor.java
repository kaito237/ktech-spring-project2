package com.example.ktech_spring_project2.instructor.model.repo;

import com.example.ktech_spring_project2.instructor.model.Instructor;
import com.example.ktech_spring_project2.instructor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositor
extends JpaRepository<User, Long> {
    /*
       SELECT * FROM student WHERE email LIKE '%{?}'
        */
    List<User> findAllByEmailEndingWith(String email);
    /*
    SELECT * FROM student WHERE advisor_id = ?;
     */
    List<User> findAllByAdvisor(Instructor advisor);
    List<User> findAllByAdvisorId(Long id);
    List<User> findAllByAdvisorLastName(String lastName);
}
