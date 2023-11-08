package com.cinema.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping(value= {"/admin","/admin/index"})
    public String index() {

        return "/admin/board/index";
    }


}