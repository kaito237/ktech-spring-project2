package com.example.ktech_spring_project2.instructor;

import com.example.ktech_spring_project2.instructor.model.Instructor;
import com.example.ktech_spring_project2.instructor.repo.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }
    public List<Instructor> findAllInstructor() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> findInstructorById(Long id) {
        return instructorRepository.findById(id);
    }

    public Instructor create(Instructor instructor){
        return instructorRepository.save(instructor);

    }

    // readOne

    public Instructor readOne(Long id) {
        // findById는 Optional을 반환한다.
        return instructorRepository.findById(id)
                .orElse(null);
    }


}


