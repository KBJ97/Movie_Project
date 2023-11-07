package com.cinema.admin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

    @GetMapping(value= {"/admin/register"})
    public String register() {

        return "/admin/register";
    }

    @GetMapping(value= {"/admin/timeRegister"})
    public String timeregister() {

        return "/admin/timeRegister";
    }

    @GetMapping(value= {"/admin/movieList"})
    public String movieList() {

        return "/admin/movieList";
    }

    @GetMapping(value= {"/admin/userList"})
    public String userList() {

        return "/admin/userList";
    }

}
