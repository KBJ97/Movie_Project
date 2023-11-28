package com.cinema.main.controller;

import com.cinema.admin.dto.CateDTO;
import com.cinema.admin.dto.MovieDTO;
import com.cinema.admin.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class MainController {

    private final MovieService movieService;

    @GetMapping(value= {"/","/index"})
    public String index(Model model) {


        List<CateDTO> cateList = movieService.selectAllCate();
        List<MovieDTO> movieList = movieService.selectMovies(0,6);

        log.info("movieList = " + movieList);
        log.info("cateList = " +  cateList);

        model.addAttribute("cateList", cateList);
        model.addAttribute("movieList", movieList);

        return "/index";
    }

}
