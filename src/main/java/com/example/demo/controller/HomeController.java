package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Return the name of the view or template to render for the home page
        return "index"; // Replace "index" with the name of your home page view (index.html, index.jsp, etc.)
    }
}
