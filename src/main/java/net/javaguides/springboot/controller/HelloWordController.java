package net.javaguides.springboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    //http get request
    //http://localhost:8080/hello-world

    @GetMapping("/hello-world")
    public String helloWord() {
            return "Hello World! ";
    }
}
