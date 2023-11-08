package com.cinema.admin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

    @GetMapping(value= {"/admin/register"})
    public String register() {

        return "/admin/board/register";
    }

    @GetMapping(value= {"/admin/timeRegister"})
    public String timeregister() {

        return "/admin/board/timeRegister";
    }

    @GetMapping(value= {"/admin/movieList"})
    public String movieList() {

        return "/admin/board/movieList";
    }

    @GetMapping(value= {"/admin/userList"})
    public String userList() {

        return "/admin/board/userList";
    }

}
