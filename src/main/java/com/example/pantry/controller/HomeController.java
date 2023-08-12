package com.example.pantry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    //to miejsce powoduje że localhost:8080 przekierowuje mnie na homeView
    @GetMapping()
    public String getHome() {
        return "index";
    }

    @GetMapping("/profiles")
    public String showProfileHome() {
        return "profilesView";  // to jest nazwa widoku (np. profilesView.html), który zostanie zwrócony
    }

}
