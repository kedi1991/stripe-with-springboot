package org.kedi.stripe.integration.stripeintegration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class WebController {

    @GetMapping("/")
    public String home(Model model){
        return "index";
    }
}
