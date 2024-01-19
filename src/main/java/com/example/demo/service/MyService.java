package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final SingletonClass singletonClass;

    @Autowired
    public MyService(SingletonClass singletonClass) {
        this.singletonClass = singletonClass;
    }

    // Use singletonClass in your service
}

