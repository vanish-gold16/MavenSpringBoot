package org.example.mavenspringboot.controllers;

import org.example.mavenspringboot.models.Post;
import org.example.mavenspringboot.repo.PostRepository;
import org.example.mavenspringboot.repo.PostService;
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

    private final PostService postService;

    public HentaiController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/hentai")
    public String hentai(Model model){
        Iterable<Post> posts = postService.findAll();
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
        return "redirect:/hentai";
    }

    @GetMapping("/hentai/{id}")
    public String hentaiDetails(@PathVariable(value = "id") long id,
                            Model model){

        Post post = postService.findById(id);
        model.addAttribute("post", post);

        return "hentai-details";
    }

    @GetMapping("/hentai/{id}/edit")
    public String hentaiEdit(@PathVariable(value = "id") long id,
                                Model model){

        Post post = postService.findById(id);
        model.addAttribute("post", post);

        return "hentai-edit";
    }

    @PostMapping("/hentai/{id}/edit")
    public String hentaiPostUpdate(@PathVariable(value = "id") long id,
                                @RequestParam String title, @RequestParam String details,
                                @RequestParam String full_text, Model model){
        Post post = postService.findById(id);
        post.setTitle(title);
        post.setDetails(details);
        post.setFullText(full_text);

        return "redirect:/hentai";
    }

    @PostMapping("/hentai/{id}/remove")
    public String hentaiPostDelete(@PathVariable(value = "id") long id, Model model){
        postService.delete(id);

        return "redirect:/hentai";
    }

}
