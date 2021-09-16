package luxoft.example.springboot.controller;

import luxoft.example.springboot.bean.WelcomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Hello world";
    }

    @GetMapping("/welcome-with-object")
    public WelcomeBean welcomeWithObject(){
        return new WelcomeBean("Hello World");
    }

    @GetMapping("/welcome-with-parameter/name/{name}")
    public WelcomeBean welcomeWithParameter(@PathVariable String name){
        return new WelcomeBean("Hello World from "+ name);
    }
}
