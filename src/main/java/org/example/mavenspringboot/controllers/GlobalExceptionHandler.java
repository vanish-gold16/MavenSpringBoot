package org.example.mavenspringboot.controllers;

import org.example.mavenspringboot.exceptions.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PostNotFoundException.class)
    public String handlePostNotFound(PostNotFoundException ex, Model model){
        model.addAttribute("message", ex.getMessage());
        return "errors/404";
    }

}
