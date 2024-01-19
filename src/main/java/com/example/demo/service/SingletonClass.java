package com.example.demo.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("prototype")
public class SingletonClass implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private static volatile SingletonClass instance;

    private SingletonClass() {
        if (instance != null) {
            throw new IllegalStateException("Cannot create instance. Use getInstance() method.");
        }
    }

    public static SingletonClass getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }

    public static void someStaticMethod() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of Singleton class is not allowed");
    }

    private Object readResolve() {
        return instance;
    }
}
