package org.example.mavenspringboot.controllers;

import org.example.mavenspringboot.models.Post;
import org.example.mavenspringboot.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HentaiController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/hentai")
    public String hentai(Model model){
        Iterable<Post> posts = postRepository.findAll();
        return "hentai";
    }
}
