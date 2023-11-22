package com.cinema.map.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class MapController {


    @GetMapping("/map/theaterInfo")
    public String theaterInfo() {
        return "/map/theaterInfo";
    }

    @GetMapping("/map/theaterMain")
    public String theaterMain() {
        return "/map/theaterMain";
    }
}