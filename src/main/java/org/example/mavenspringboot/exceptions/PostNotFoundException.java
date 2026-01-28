package org.example.mavenspringboot.exceptions;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(long id){

        super("Post not found: " + id);
    }

}
