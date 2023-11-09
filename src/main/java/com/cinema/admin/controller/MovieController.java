package com.cinema.admin.controller;


import com.cinema.admin.dto.MovieDTO;
import com.cinema.admin.mapper.MovieMapper;
import com.cinema.admin.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
public class MovieController {

    private final MovieService movieService;

    @GetMapping(value= "/admin/register")
    public String register() {

        return "/admin/board/register";
    }

    @GetMapping(value= "/admin/timeRegister")
    public String timeRegister() {

        return "/admin/board/timeRegister";
    }

    @GetMapping(value= "/admin/movieList")
    public String movieList() {

        return "/admin/board/movieList";
    }

    @GetMapping(value= "/admin/userList")
    public String userList() {

        return "/admin/board/userList";
    }

    @PostMapping(value= "/admin/register")
    public String register(MovieDTO movieDTO){

        log.info(movieDTO);

        movieService.insertMovie(movieDTO);

        return "/admin/board/register";
    }

}
