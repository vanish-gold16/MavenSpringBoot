package org.example.mavenspringboot.repo;

import org.example.mavenspringboot.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(long id);
    Post create(Post post);
    Post update(long id, String title, String fullText);
    void delete(long id);
}
