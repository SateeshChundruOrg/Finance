package com.myorg.finance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class HelloWorldController {

    @GetMapping("hello-world")
    @ResponseBody
    public Map<String,String> hello(){
        Map map =new HashMap();
        map.put("data","Hello world");
        return map;
    }

    @GetMapping("google")
    public ResponseEntity redirectToGoogleSite() throws URISyntaxException {
//        URI uri= new URI("http://google.com");
        URI uri= new URI("http://192.168.55.109:8085/hello-world");
       // URI uri= new URI("http://localhost:4200/");


        return  ResponseEntity.status(HttpStatus.FOUND).location(uri).build();

    }
}
