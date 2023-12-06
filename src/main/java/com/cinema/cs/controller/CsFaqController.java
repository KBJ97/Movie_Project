package com.cinema.cs.controller;

import groovy.util.logging.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Log4j2
@Controller
public class CsFaqController {
    @GetMapping("/cs/faq")
    public String faq() {
        return "/cs/faq";
    }
}
