package com.scaler.ecommerceproject.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

   @GetMapping("/hello")
    public String sayHello() {
        return "Hello World, I'm Ecommerce Project";
    }

    @RequestMapping(value = "/hello/{id}",method = RequestMethod.GET)
    public String sayHelloById(@PathVariable("id") String id) {
        return "Hello World, I'm Ecommerce Project with id: " + id;
    }
}
