package org.example.mavenspringboot.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BestCPController {


    @GetMapping("/best-cp")
    public String bestCPMain(Model model){
        model.addAttribute("title", "BEST CP");
        return "best-cp";
    }

}
