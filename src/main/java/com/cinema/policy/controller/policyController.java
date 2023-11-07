package com.cinema.policy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
public class policyController {

   @GetMapping("/policy/ethics")
    public String ethics(){
       return "/policy/ethics";
    }

    @GetMapping("/policy/integrity")
    public String integrity(){
       return "/policy/integrity";
    }

    @GetMapping("/policy/newsroom")
    public String newsroom(){

       return "/policy/newsroom";
    }

    @GetMapping("/policy/newsroomre")
    public String newsroomre(){
       /*제보 내용 첨부파일 등록경로*/
       return "/policy/newsroomre";
    }

    @GetMapping("/policy/newsroomreguide")
    public String newsroomreguide(){
       return "/policy/newsroomreguide";
    }




}
