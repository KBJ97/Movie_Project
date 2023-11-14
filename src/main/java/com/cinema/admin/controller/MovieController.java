package com.cinema.admin.controller;


import com.cinema.admin.dto.MovieDTO;
import com.cinema.admin.dto.MovieInfoDTO;
import com.cinema.admin.dto.RegionDTO;
import com.cinema.admin.mapper.MovieMapper;
import com.cinema.admin.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

        // 세로 A~F열, 가로 1~10을 생성하는 데이터 전달
        char[] rows = {'A', 'B', 'C', 'D', 'E', 'F'};
        int[] cols = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        model.addAttribute("rows", rows);
        model.addAttribute("cols", cols);

        return "/admin/board/theaterRegister";
    }

}
