package com.myorg.finance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;


@RestController
public class HelloWorldController {

    @GetMapping("hello-world")
    public String hello(){
        return "Hello World How are you today? new realease";
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("google")
    public ResponseEntity redirectToGoogleSite() throws URISyntaxException {
        URI uri= new URI("http://google.com");

    return  ResponseEntity.status(HttpStatus.FOUND).location(uri).build();

    }
}
