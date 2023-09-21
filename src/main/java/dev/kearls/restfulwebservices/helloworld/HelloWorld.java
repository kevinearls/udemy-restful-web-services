package dev.kearls.restfulwebservices.helloworld;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
    private String message = "Hello World";

//    public HelloWorld(String message) {
//        this.message = message;
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
