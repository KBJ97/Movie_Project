package com.cinema.admin.controller;


import com.cinema.admin.dto.*;
import com.cinema.admin.mapper.MovieMapper;
import com.cinema.admin.service.MovieService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class MovieController {

    private final MovieService movieService;

    @GetMapping(value = "/admin/register")
    public String register() {

        return "/admin/board/register";
    }

    @GetMapping(value = "/admin/movieRegisterList")
    public String movieRegisterList(Model model) {

        List<MovieDTO> movies = movieService.selectMovies();

        log.info("moviesNum = " + movies.get(0).getMovieNum());
        log.info("moviesName = " + movies.get(0).getMovieName());
        log.info("moviesAge = " + movies.get(0).getMovieAge());

        model.addAttribute("movies", movies);

        return "/admin/board/movieRegisterList";
    }

    @GetMapping(value = "/admin/timeRegister")
    public String timeRegister(Model model) {

        List<MovieDTO> movies = movieService.selectMovies();
        List<RegionDTO> region1List = movieService.selectRegion1Ajax();

        log.info("region1List = " + region1List.get(0).getRegion1Name());

        model.addAttribute("movies", movies);
        model.addAttribute("region1List", region1List);

        return "/admin/board/timeRegister";
    }

    @GetMapping(value = "/admin/movieList")
    public String movieList(Model model) {

        List<MovieInfoDTO> movieList = movieService.selectMovieInfo();

        log.info("movieList = " + movieList);

        model.addAttribute("movieList", movieList);

        return "/admin/board/movieList";
    }

    @GetMapping(value = "/admin/userList")
    public String userList() {

        return "/admin/board/userList";
    }


    @PostMapping(value = "/admin/register")
    public String register(MovieDTO movieDTO) {

        log.info(movieDTO);

        movieService.insertMovie(movieDTO);


        return "/admin/board/register";
    }

    @PostMapping(value = "/admin/timeRegister")
    public String movieInfo(MovieInfoDTO movieInfoDTO) {

        movieService.insertMovieInfo(movieInfoDTO);

        log.info(movieInfoDTO.getMovieInfoNum());
        log.info(movieInfoDTO.getPlayTime());
        log.info(movieInfoDTO.getPlayDate());

        return "/admin/board/timeRegister";

    }

    @GetMapping(value = "/admin/theaterRegister")
    public String theaterRegister(Model model) {

        List<RegionDTO> region1List = movieService.selectRegion1Ajax();


        log.info("region1List = " + region1List.get(0).getRegion1Name());

        model.addAttribute("region1List", region1List);
        return "/admin/board/theaterRegister";
    }


    @PostMapping(value = "/admin/theaterRegister")
    public String theaterRegister(Model model, TheaterDTO theaterDTO) {

        log.info("theaterDTO : " + theaterDTO);

        //theaterDTO.setTheaterNum(100);

        movieService.insertTheater(theaterDTO);


        return "/admin/board/theaterRegister";
    }




    @DeleteMapping("/admin/movieList/deleteMovie/{movieNum}")
    @Transactional
    public void deleteMovie(@PathVariable("movieNum") int movieNum) {


        movieService.deleteMovie(movieNum);
    }

}
