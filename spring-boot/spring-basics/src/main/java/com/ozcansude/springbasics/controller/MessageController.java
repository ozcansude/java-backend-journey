package com.ozcansude.springbasics.controller;

import com.ozcansude.springbasics.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/example")
    public String example(){
        return "Hello World!";
    }
    @GetMapping("/hello")
    public String hello(){
        return messageService.getMessage();
    }
}
