package com.erdinc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

//  http://localhost:8080
//  http://127.0.0.1:8080
    @RestController
    @RequestMapping
public class AppMain {


    @GetMapping
    public String index(){
        return "DevOps Pipeline";
    }

    @GetMapping("info")
    public String info(){
        return "Info : " + LocalDateTime.now();
    }

}
