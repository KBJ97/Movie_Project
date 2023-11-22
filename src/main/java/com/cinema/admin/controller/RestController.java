package com.cinema.admin.controller;

import com.cinema.admin.dto.RegionDTO;
import com.cinema.admin.dto.TheaterDTO;
import com.cinema.admin.service.MovieService;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Log4j2
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private MovieService movieService;

    @ResponseBody
    @GetMapping("/admin/timeRegister/{region1Num}")
    public List<RegionDTO> region2List(@PathVariable int region1Num){

        List<RegionDTO> region2List = movieService.selectRegion2Ajax(region1Num);

        return  region2List;
    }

    @ResponseBody
    @GetMapping("/admin/timeRegister/{region1Num}/{region2Num}")
    public List<TheaterDTO> cinemaList( @PathVariable int region1Num, @PathVariable int region2Num) {
        List<TheaterDTO> cinemaList = movieService.selectCinemaAjax(region1Num, region2Num);

        return cinemaList;
    }

    @ResponseBody
    @DeleteMapping("/admin/movieRegisterList/deleteMovie/{movieNum}")
    @Transactional
    public String deleteMovie(@PathVariable("movieNum") int movieNum) {

        movieService.deleteMovie(movieNum);

        return "/admin/board/movieRegisterList";
    }


}
