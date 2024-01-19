package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    	String currentTime = getCurrentTime();
        return "Time: "+currentTime+"<br><br>Hashcode for singleton class is as follows: "+hashCode;
    }
    
    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}