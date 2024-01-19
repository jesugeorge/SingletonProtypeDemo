package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SingletonClass;

@RestController
public class MyController {

    private final SingletonClass singletonClass;

    @Autowired
    public MyController(SingletonClass singletonClass) {
        this.singletonClass = singletonClass;
    }

    @GetMapping("/singleton")
    public String singletonEndpoint() {
    	int hashCode = singletonClass.hashCode();
        return "Hashcode for singleton class is as follows: "+hashCode;
    }
}