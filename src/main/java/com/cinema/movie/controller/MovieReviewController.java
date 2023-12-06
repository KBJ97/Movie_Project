package com.cinema.movie.controller;

import com.cinema.admin.dto.MovieDTO;
import com.cinema.admin.service.MovieService;
import com.cinema.movie.dto.MovieReviewDTO;
import com.cinema.movie.service.MovieReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RequestMapping("/cinema/movie")
@Controller
public class MovieReviewController {

    private final MovieService movieService;
    private final MovieReviewService movieReviewService;

    @GetMapping("/movie/movieView")
    public ModelAndView movieView(@RequestParam("movieNum") int movieNum) {
        ModelAndView modelAndView = new ModelAndView("movieView");

        MovieDTO movie = movieService.getMovieByNum(movieNum);
        modelAndView.addObject("movie", movie);

        // 기존의 리뷰 목록 가져오는 코드
        List<MovieReviewDTO> reviews = movieReviewService.getListOfMovie(movieNum);
        modelAndView.addObject("reviews", reviews);

        // 리뷰 작성 폼을 위한 빈 객체 추가
        modelAndView.addObject("reviewDTO", new MovieReviewDTO());

        return modelAndView;
    }

    @PostMapping("/movie/movieView")
    public String addReview(@ModelAttribute MovieReviewDTO reviewDTO, Model model) {
        movieReviewService.register(reviewDTO);

        // 리뷰 작성 후에도 영화 정보와 리뷰 목록을 다시 가져와야 함
        MovieDTO movie = movieService.getMovieByNum(reviewDTO.getMovieNum());
        model.addAttribute("movie", movie);

        List<MovieReviewDTO> reviews = movieReviewService.getListOfMovie(reviewDTO.getMovieNum());
        model.addAttribute("reviews", reviews);

        return "movieView";
    }
}