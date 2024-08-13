package com.example.ktech_spring_project2.instructor;

import com.example.ktech_spring_project2.instructor.model.Instructor;
import com.example.ktech_spring_project2.instructor.model.Post;
import com.example.ktech_spring_project2.instructor.repo.InstructorRepository;
import com.example.ktech_spring_project2.instructor.repo.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(
            String title,
            String content,
            String password
    ) {
        Post post = new Post( title, content, password);
        return postRepository.save(post);

    }
    // read all

    public List<Post> readAll() {
        return  postRepository.findAll();
    }


    // read one

    public Post readOne(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    //update
    public Post update(
            Long id,
            String title,
            String content,
            String password
    ) {
        Optional<Post> optionalTarget = postRepository.findById(id);
        if (optionalTarget.isEmpty()) {
            return null;
        }
        Post target = optionalTarget.get();
        target.setPassword(title);
        target.setContent(content);
        target.setPassword(password);
        return postRepository.save(target);
    }

    //delete

}
