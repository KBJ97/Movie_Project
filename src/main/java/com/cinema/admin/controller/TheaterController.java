package com.cinema.admin.controller;

import com.cinema.admin.dto.TheaterDTO;
import com.cinema.admin.service.MovieService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
public class TheaterController {

    @Autowired
    private MovieService movieService;

    @ResponseBody
    @GetMapping("/admin/theater/{region1Num}/{region2Num}")
    public List<TheaterDTO> theaterList(
            @PathVariable(value = "region1Num") int region1Num,
            @PathVariable(value = "region2Num") int region2Num){



        List<TheaterDTO> theaters = movieService.selectTheaterByRegion(region1Num, region2Num);
        log.info(theaters);


        return theaters;
    }
}