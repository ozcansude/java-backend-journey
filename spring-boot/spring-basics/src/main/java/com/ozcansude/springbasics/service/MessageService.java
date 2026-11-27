package com.ozcansude.springbasics.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String getMessage() {
        return "Spring Boot is running";
    }

    public String getPersonalMessage(String name){
        return "Hello "+name+"!";
    }
    public String getGreeting(String name){
        return "Welcome "+ name;
    }
    public String toUppercase(String text){
        return text.toUpperCase();
    }
    public int getLength(String text){
        return text.length();
    }
}
