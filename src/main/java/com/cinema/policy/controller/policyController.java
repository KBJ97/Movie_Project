package com.cinema.policy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
public class policyController {

   @GetMapping("/policy/ethics/") 
    public String ethics(){
       String ethics = null;
       return ethics;
    }

    @GetMapping("/policy/integrity/")
    public String integrity(){
        String integrity = null;
       return integrity;
    }

    @GetMapping("/policy/newsroom")
    public String newsroom(){
       String newsroom = null;
       return "/policy/newsroom";
    }

    @GetMapping("/policy/newsroomre")
    public String newsroomre(){
       String newsroomre = null;
       return "/policy/newsroomre";
    }

    @GetMapping("/policy/newsroomreguide/")
    public String newsroomreguide(){
       String newsroomreguide = null;
       return newsroomreguide;
    }

   
}
