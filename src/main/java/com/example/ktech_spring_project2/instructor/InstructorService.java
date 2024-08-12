package com.example.ktech_spring_project2.instructor;
import com.example.ktech_spring_project2.instructor.model.Instructor;
import com.example.ktech_spring_project2.instructor.model.repo.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    public Instructor findByID(Long id){
        return instructorRepository.findById(id).orElse(null);

    }

    // readOne

    public Instructor readOne(Long id) {
        // findById는 Optional을 반환한다.
        return instructorRepository.findById(id)
                .orElse(null);
    }

//    // update
//    public  Instructor update(
//            long id,
//            String title,
//            String content,
//            String writer
//    ) {
//        Optional<Instructor> optionalTarget = repository.findById(id);
//        if (optionalTarget.isEmpty()) {
//            return null;
//        }
//        Instructor target = optionalTarget.get();
//        target.setTitle(title);
//        target.setContent(content);
//        target.setWriter(writer);
//        return repository.save(target);
//    }
//
//    // delete
//    public void delete(Long id) {
//        repository.deleteById(id);
//    }

}


