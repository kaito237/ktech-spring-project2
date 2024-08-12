package com.example.ktech_spring_project2.instructor;

import com.example.ktech_spring_project2.instructor.model.Post;
import com.example.ktech_spring_project2.instructor.repo.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public  void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
