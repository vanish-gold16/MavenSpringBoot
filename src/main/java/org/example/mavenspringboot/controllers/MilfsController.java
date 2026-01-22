package org.example.mavenspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MilfsController {

    @GetMapping("/milfs")
    public String milfs(Model model){
        model.addAttribute("title", "Main page");
        return "milfs";
    }

}
