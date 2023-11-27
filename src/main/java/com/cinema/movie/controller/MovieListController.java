package com.cinema.movie.controller;

import com.cinema.admin.dto.MovieDTO;
import com.cinema.movie.service.MovieListServie;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class MovieListController {

    private final MovieListServie movieListServie;

    @GetMapping(value= {"/movie","/movie/index"})
    public String index(Model model, @RequestParam(required = false) String search) {

        List<MovieDTO> movies;
        if (search != null && !search.isEmpty()) {
            movies = movieListServie.selectMoviesByName(search);
        } else {
            movies = movieListServie.selectMovies(0);
        }
        log.info("movies = " + movies);

        model.addAttribute("movies", movies);

        return "/movie/board/index";
    }

    @GetMapping(value= "/movie/nowMovie")
    public String nowMovie(Model model, @RequestParam(required = false) String search) {

        List<MovieDTO> movies;
        if (search != null && !search.isEmpty()) {
            movies = movieListServie.selectMoviesByName(search);
        } else {
            movies = movieListServie.selectNowMovies(LocalDateTime.now());
        }
        log.info("movies = " + movies);

        model.addAttribute("movies", movies);

        return "/movie/board/nowMovie";
    }

    @GetMapping(value= "/movie/laterMovie")
    public String laterMovie(Model model, @RequestParam(required = false) String search) {

        List<MovieDTO> movies;
        if (search != null && !search.isEmpty()) {
            movies = movieListServie.selectMoviesByName(search);
        } else {
            movies = movieListServie.selectFutureMovies(LocalDateTime.now());
        }
        log.info("movies = " + movies);

        model.addAttribute("movies", movies);

        return "/movie/board/laterMovie";
    }

}