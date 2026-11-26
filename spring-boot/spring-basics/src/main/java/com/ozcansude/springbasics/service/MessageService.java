package com.ozcansude.springbasics.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class MessageService {

    public String getMessage() {
        return "Spring Boot is running";
    }

    public String getPersonalMessage(@PathVariable("name") String name){
        return "Hello "+name+"!";
    }
    public String getGreeting(@RequestParam("name") String name){
        return "Welcome "+ name;
    }

}
