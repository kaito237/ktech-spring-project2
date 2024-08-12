package com.example.ktech_spring_project2.instructor;

import com.example.ktech_spring_project2.instructor.model.Instructor;
import com.example.ktech_spring_project2.instructor.model.Post;
import com.example.ktech_spring_project2.instructor.repo.InstructorRepository;
import com.example.ktech_spring_project2.instructor.repo.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final InstructorRepository instructorRepository;
    public PostService(
            PostRepository postRepository,
            InstructorRepository instructorRepository) {
        this.postRepository = postRepository;
        this.instructorRepository = instructorRepository;
    }

    public Post creatPost(
            Long instructorId,
            Post post
    ) {
        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow();
        post.setInstructor(instructor);
        return postRepository.save(post);
    }
    public Optional<Post> findPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post updatePost(
            Long id,
            String title,
            String content,
            String password
    ) {
        Post post = postRepository.findById(id).orElseThrow();
        if (post.getPassword().equals(password)) {
            post.setTitle(title);
//            post.setContent(content);
            return postRepository.save(post);
        }
        throw new IllegalArgumentException("Password does not match");
    }

    public void deletePost(Long id, String password) {
        Post post = postRepository.findById(id).orElseThrow();
        if (post.getPassword().equals(password)) {
            postRepository.delete(post);
        } else {
            throw new IllegalArgumentException("Password does not match");
        }
    }


}
