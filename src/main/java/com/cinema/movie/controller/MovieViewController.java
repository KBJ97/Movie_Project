package com.cinema.movie.controller;


import com.cinema.admin.dto.MovieDTO;
import com.cinema.movie.service.MovieListServie;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Log4j2
@RequiredArgsConstructor
@Controller
public class MovieViewController {

    private final MovieListServie movieListServie;

    @GetMapping(value = "/movie/movieView")
    public String movieView(Model model, int movieNum) {

        MovieDTO movie = movieListServie.selectMovieByNum(movieNum);

        model.addAttribute("movie", movie);

        return "/movie/board/movieView";
    }

}
