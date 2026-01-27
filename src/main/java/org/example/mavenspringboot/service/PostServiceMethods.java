package org.example.mavenspringboot.service;

import org.example.mavenspringboot.exceptions.PostNotFoundException;
import org.example.mavenspringboot.models.Post;
import org.example.mavenspringboot.repo.PostRepository;
import org.example.mavenspringboot.repo.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceMethods implements PostService {

    private final PostRepository postRepository;


    public PostServiceMethods(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAll() {
        List<Post> result = new ArrayList<>();
        postRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Post findById(long id) {
            return postRepository.findById(id)
                    .orElseThrow(() -> new PostNotFoundException(id));
    }

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(long id, String title, String fullText) {
        Post existing = findById(id);
        existing.setTitle(title);
        existing.setFullText(fullText);

        return existing;
    }

    @Override
    public void delete(long id) {
        Post existing = findById(id);
        postRepository.delete(existing);
    }
}
