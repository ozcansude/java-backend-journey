package com.ozcansude.springbasics.service;

import org.springframework.stereotype.Service;


@Service
public class MessageService {

    public String getMessage() {
        return "Spring Boot is running";
    }

}
