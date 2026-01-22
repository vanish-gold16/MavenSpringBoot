package org.example.mavenspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HentaiController {

    @GetMapping("/hentai")
    public String hentai(Model model){
        model.addAttribute("title", "Hentai page");
        return "hentai";
    }
}
