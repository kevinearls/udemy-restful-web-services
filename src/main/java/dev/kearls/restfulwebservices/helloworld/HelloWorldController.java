package dev.kearls.restfulwebservices.helloworld;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @Autowired
    private HelloWorld hello = new HelloWorld();

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorld helloWorldBean() {
        hello.setMessage("Get lost");
        return hello;
    }

    @GetMapping("/hello-world/{name}")
    public HelloWorld helloWorldWithPathVariable(@PathVariable String name) {
        hello.setMessage("Get lost " + name);
        return hello;
    }
}
