package org.example.mavenspringboot.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BestCPController {

    @GetMapping("/best-cp")
    public String bestCPMain(Model model){
        return "best-cp";
    }

}
