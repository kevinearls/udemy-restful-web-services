package dev.kearls.restfulwebservices.helloworld;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {
    @Autowired
    private HelloWorld hello = new HelloWorld();

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-intl")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        var message = messageSource.getMessage("good.morning.message", null, "Default good morning message", locale);
        return message;
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
