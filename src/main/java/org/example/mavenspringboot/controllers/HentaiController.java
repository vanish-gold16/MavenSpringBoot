package org.example.mavenspringboot.controllers;

import org.example.mavenspringboot.models.Post;
import org.example.mavenspringboot.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HentaiController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/hentai")
    public String hentai(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "hentai";
    }

    @GetMapping("/hentai/add")
    public String hentaiAdd(Model model){
        return "hentai-add";
    }

    @PostMapping("/hentai/add")
    public String hentaiPostAdd(@RequestParam String title, @RequestParam String details,
                                @RequestParam String full_text, Model model){
        Post post = new Post(title, details, full_text);
        postRepository.save(post);
        return "redirect:/hentai";
    }

    @GetMapping("/hentai/{id}")
    public String hentaiDetails(@PathVariable(value = "id") long id,
                            Model model){
        if(!postRepository.existsById(id)){
            return "redirect:/hentai";
        }

        Optional<Post> post = postRepository.findById(id);
        List<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);

        return "hentai-details";
    }

}
