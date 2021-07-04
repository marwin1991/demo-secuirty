package com.codecool.advance.demosecuirty.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PingController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/ping")
    public String ping(){
        return "ping";
    }
}
