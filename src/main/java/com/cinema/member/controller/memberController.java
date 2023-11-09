package com.cinema.member.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class memberController {

    @GetMapping("/member/login")
    public String login() {
        return "/member/login";
    }
    @GetMapping("/member/join")
    public String join() {
        return "/member/join";
    }
    @GetMapping("/member/findId")
    public String findId() {
        return "/member/findId";
    }
    @GetMapping("/member/findPass")
    public String findPass() {
        return "/member/findPass";
    }






}
