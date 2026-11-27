package com.ozcansude.springbasics.controller;

import com.ozcansude.springbasics.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String name){
        return messageService.getPersonalMessage(name);
    }
    @GetMapping("/greet")
    public String greet(@RequestParam("name") String name){
        return messageService.getGreeting(name);
    }

    @GetMapping("/uppercase")
    public String toUppercase(@RequestParam("text") String text){
        return messageService.toUppercase(text);
    }

    @GetMapping("/length")
    public int length(@RequestParam("text") String text){
        return messageService.getLength(text);
    }
}
