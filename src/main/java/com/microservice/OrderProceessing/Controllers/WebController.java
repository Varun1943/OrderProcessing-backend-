package com.microservice.OrderProceessing.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping({"/", "/home"})
    public String home() {
        return "forward:/index.html";   
    }
}
