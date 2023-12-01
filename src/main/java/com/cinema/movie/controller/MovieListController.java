package com.cinema.movie.controller;

import com.cinema.admin.dto.MovieDTO;
import com.cinema.admin.service.MovieService;
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
    private final MovieService movieService;

    int total=0;

    @GetMapping(value= {"/movie","/movie/index"})
    public String index(Model model, @RequestParam(required = false) String search, @RequestParam(defaultValue = "1") int pg) {


        List<MovieDTO> movies;
        if (search != null && !search.isEmpty()) {
            //페이지 관련 변수
            int start=0;
            int currentPage =1;
            int lastPageNum=0;
            int pageGroupCurrent=1;
            int pageGroupStart=1;
            int pageGroupEnd=0;
            int pageStartNum=0;


            // 현재페이지계산
            currentPage = pg;

            // 전체 영화 갯수
            total = movieListServie.countMoviesContainName(search);

            log.info("total = " + total);

            //LIMIT 시작값계산
            start =(currentPage -1)*36;

            if(total%10 == 0){
                lastPageNum =(total/36);
            }else{
                lastPageNum =(total/36)+1;
            }

            if(pageGroupEnd < 1) {
                pageGroupEnd = 1;
            }

            //페이지 그룹계산
            // 페이지 그룹 계산 (5개 단위로 나누기)
            pageGroupCurrent = (int) Math.ceil(currentPage / 5.0); // 현재 페이지 그룹 계산
            pageGroupStart = (pageGroupCurrent - 1) * 5 + 1; // 페이지 그룹의 시작 페이지 계산
            pageGroupEnd = Math.min(pageGroupCurrent * 5, lastPageNum); // 페이지 그룹의 끝 페이지 계산

            if(pageGroupEnd > lastPageNum){
                pageGroupEnd=lastPageNum;
            }

            //페이지 시작번호 계산
            pageStartNum = total-start;
            movies = movieListServie.selectMoviesByName(search);

            model.addAttribute("currentPage", currentPage);
            model.addAttribute("total", total);
            model.addAttribute("lastPageNum", lastPageNum);
            model.addAttribute("pageGroupCurrent", pageGroupCurrent);
            model.addAttribute("pageGroupStart", pageGroupStart);
            model.addAttribute("pageGroupEnd", pageGroupEnd);
            model.addAttribute("pageStartNum", pageStartNum);

        } else {
            //페이지 관련 변수
            int start=0;
            int currentPage =1;
            int lastPageNum=0;
            int pageGroupCurrent=1;
            int pageGroupStart=1;
            int pageGroupEnd=0;
            int pageStartNum=0;


            // 현재페이지계산
            currentPage = pg;

            // 전체 영화 갯수
            total = movieService.movieCount();

            log.info("total = " + total);

            //LIMIT 시작값계산
            start =(currentPage -1)*36;

            if(total%10 == 0){
                lastPageNum =(total/36);
            }else{
                lastPageNum =(total/36)+1;
            }

            if(pageGroupEnd < 1) {
                pageGroupEnd = 1;
            }

            //페이지 그룹계산
            // 페이지 그룹 계산 (5개 단위로 나누기)
            pageGroupCurrent = (int) Math.ceil(currentPage / 5.0); // 현재 페이지 그룹 계산
            pageGroupStart = (pageGroupCurrent - 1) * 5 + 1; // 페이지 그룹의 시작 페이지 계산
            pageGroupEnd = Math.min(pageGroupCurrent * 5, lastPageNum); // 페이지 그룹의 끝 페이지 계산

            if(pageGroupEnd > lastPageNum){
                pageGroupEnd=lastPageNum;
            }

            //페이지 시작번호 계산
            pageStartNum = total-start;


            movies = movieListServie.selectMovies(start);

            if(pageGroupEnd < 1) {
                pageGroupEnd = 1;
            }
            model.addAttribute("start", start);
            model.addAttribute("currentPage", currentPage);
            model.addAttribute("total", total);
            model.addAttribute("lastPageNum", lastPageNum);
            model.addAttribute("pageGroupCurrent", pageGroupCurrent);
            model.addAttribute("pageGroupStart", pageGroupStart);
            model.addAttribute("pageGroupEnd", pageGroupEnd);
            model.addAttribute("pageStartNum", pageStartNum);

        }



        log.info("movies = " + movies);

        model.addAttribute("movies", movies);



        return "/movie/board/index";
    }

    @GetMapping(value= "/movie/nowMovie")
    public String nowMovie(Model model, @RequestParam(required = false) String search, @RequestParam(defaultValue = "1") int pg) {

        List<MovieDTO> movies;
        if (search != null && !search.isEmpty()) {
            movies = movieListServie.selectMoviesByName(search);
        } else {
            //페이지 관련 변수
            int start=0;
            int currentPage =1;
            int lastPageNum=0;
            int pageGroupCurrent=1;
            int pageGroupStart=1;
            int pageGroupEnd=0;
            int pageStartNum=0;


            // 현재페이지계산
            currentPage = pg;

            // 전체 영화 갯수
            total = movieListServie.countNowMovies(LocalDateTime.now());

            log.info("total = " + total);

            //LIMIT 시작값계산
            start =(currentPage -1)*36;

            if(total%10 == 0){
                lastPageNum =(total/36);
            }else{
                lastPageNum =(total/36)+1;
            }

            if(pageGroupEnd < 1) {
                pageGroupEnd = 1;
            }

            //페이지 그룹계산
            // 페이지 그룹 계산 (5개 단위로 나누기)
            pageGroupCurrent = (int) Math.ceil(currentPage / 5.0); // 현재 페이지 그룹 계산
            pageGroupStart = (pageGroupCurrent - 1) * 5 + 1; // 페이지 그룹의 시작 페이지 계산
            pageGroupEnd = Math.min(pageGroupCurrent * 5, lastPageNum); // 페이지 그룹의 끝 페이지 계산

            if(pageGroupEnd > lastPageNum){
                pageGroupEnd=lastPageNum;
            }

            //페이지 시작번호 계산
            pageStartNum = total-start;

            movies = movieListServie.selectNowMovies(LocalDateTime.now(), start);
            model.addAttribute("currentPage", currentPage);
            model.addAttribute("total", total);
            model.addAttribute("lastPageNum", lastPageNum);
            model.addAttribute("pageGroupCurrent", pageGroupCurrent);
            model.addAttribute("pageGroupStart", pageGroupStart);
            model.addAttribute("pageGroupEnd", pageGroupEnd);
            model.addAttribute("pageStartNum", pageStartNum);
        }
        log.info("movies = " + movies);

        model.addAttribute("movies", movies);

        return "/movie/board/nowMovie";
    }

    @GetMapping(value= "/movie/laterMovie")
    public String laterMovie(Model model, @RequestParam(required = false) String search,  @RequestParam(defaultValue = "1") int pg) {

        List<MovieDTO> movies;
        if (search != null && !search.isEmpty()) {
            movies = movieListServie.selectMoviesByName(search);
        } else {
            //페이지 관련 변수
            int start=0;
            int currentPage =1;
            int lastPageNum=0;
            int pageGroupCurrent=1;
            int pageGroupStart=1;
            int pageGroupEnd=0;
            int pageStartNum=0;


            // 현재페이지계산
            currentPage = pg;

            // 전체 영화 갯수
            total = movieListServie.countFutureMovies(LocalDateTime.now());

            log.info("total = " + total);

            //LIMIT 시작값계산
            start =(currentPage -1)*36;

            if(total%10 == 0){
                lastPageNum =(total/36);
            }else{
                lastPageNum =(total/36)+1;
            }

            if(pageGroupEnd < 1) {
                pageGroupEnd = 1;
            }

            //페이지 그룹계산
            // 페이지 그룹 계산 (5개 단위로 나누기)
            pageGroupCurrent = (int) Math.ceil(currentPage / 5.0); // 현재 페이지 그룹 계산
            pageGroupStart = (pageGroupCurrent - 1) * 5 + 1; // 페이지 그룹의 시작 페이지 계산
            pageGroupEnd = Math.min(pageGroupCurrent * 5, lastPageNum); // 페이지 그룹의 끝 페이지 계산

            if(pageGroupEnd > lastPageNum){
                pageGroupEnd=lastPageNum;
            }

            //페이지 시작번호 계산
            pageStartNum = total-start;

            movies = movieListServie.selectFutureMovies(LocalDateTime.now(), start);
            model.addAttribute("currentPage", currentPage);
            model.addAttribute("total", total);
            model.addAttribute("lastPageNum", lastPageNum);
            model.addAttribute("pageGroupCurrent", pageGroupCurrent);
            model.addAttribute("pageGroupStart", pageGroupStart);
            model.addAttribute("pageGroupEnd", pageGroupEnd);
            model.addAttribute("pageStartNum", pageStartNum);
        }
        log.info("movies = " + movies);

        model.addAttribute("movies", movies);

        return "/movie/board/laterMovie";
    }

}
