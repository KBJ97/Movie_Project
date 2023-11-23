package com.cinema.admin.controller;


import com.cinema.admin.dto.*;
import com.cinema.admin.mapper.MovieMapper;
import com.cinema.admin.service.MovieService;
import com.cinema.member.dto.MemberDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class MovieController {

    int total=0;

    private final MovieService movieService;

    @GetMapping(value = "/admin/register")
    public String register(Model model) {

        List<CateDTO> cateList = movieService.selectAllCate();

        model.addAttribute("cateList", cateList);

        log.info("cateList = " + cateList );
        return "/admin/board/register";
    }

    @GetMapping(value = "/admin/movieRegisterList")
    public String movieRegisterList(Model model, @RequestParam(defaultValue = "1") int pg) {

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

        // 전체 상품 갯수
        total = movieService.movieCount();

        log.info("total = " + total);

        //LIMIT 시작값계산
        start =(currentPage -1)*10;

        if(total%10 == 0){
            lastPageNum =(total/10);
        }else{
            lastPageNum =(total/10)+1;
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

        List<MovieDTO> movies = movieService.selectMovies(start, 10);

        model.addAttribute("movies", movies);
        model.addAttribute("start", start);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("total", total);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("pageGroupCurrent", pageGroupCurrent);
        model.addAttribute("pageGroupStart", pageGroupStart);
        model.addAttribute("pageGroupEnd", pageGroupEnd);
        model.addAttribute("pageStartNum", pageStartNum);

        log.info("moviesNum = " + movies.get(0).getMovieNum());
        log.info("moviesName = " + movies.get(0).getMovieName());
        log.info("moviesAge = " + movies.get(0).getMovieAge());
        log.info("start = "+ start);
        log.info("currentPage = " + currentPage);
        log.info("total = " +  total);
        log.info("lastPageNum = " + lastPageNum);
        log.info("pageGroupStart = " + pageGroupStart);
        log.info("pageGroupEnd = " + pageGroupEnd);
        log.info("pageStartNum = " + pageStartNum);

        return "/admin/board/movieRegisterList";
    }

    @GetMapping(value = "/admin/timeRegister")
    public String timeRegister(Model model) {

        List<MovieDTO> movies = movieService.selectMovie();
        List<RegionDTO> region1List = movieService.selectRegion1Ajax();

        log.info("region1List = " + region1List.get(0).getRegion1Name());

        model.addAttribute("movies", movies);
        model.addAttribute("region1List", region1List);

        return "/admin/board/timeRegister";
    }

    @GetMapping(value = "/admin/movieList")
    public String movieList(Model model, @RequestParam(defaultValue = "1") int pg) {

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

        // 전체 상품 갯수
        total = movieService.movieInfoCount();

        log.info("total = " + total);

        //LIMIT 시작값계산
        start =(currentPage -1)*10;

        if(total%10 == 0){
            lastPageNum =(total/10);
        }else{
            lastPageNum =(total/10)+1;
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

        List<MovieInfoDTO> movieList = movieService.selectMovieInfo(start, 10);



        log.info("movieList = " + movieList);
        log.info("start = "+ start);
        log.info("currentPage = " + currentPage);
        log.info("total = " +  total);
        log.info("lastPageNum = " + lastPageNum);
        log.info("pageGroupStart = " + pageGroupStart);
        log.info("pageGroupEnd = " + pageGroupEnd);
        log.info("pageStartNum = " + pageStartNum);

        model.addAttribute("movieList", movieList);
        model.addAttribute("start", start);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("total", total);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("pageGroupCurrent", pageGroupCurrent);
        model.addAttribute("pageGroupStart", pageGroupStart);
        model.addAttribute("pageGroupEnd", pageGroupEnd);
        model.addAttribute("pageStartNum", pageStartNum);

        return "/admin/board/movieList";
    }

    @GetMapping(value = "/admin/userList")
    public String userList(Model model) {

        List<MemberDTO> members = movieService.selectAllMembers();

        model.addAttribute("members", members);

        return "/admin/board/userList";
    }


    @PostMapping(value = "/admin/register")
    public String register(MovieDTO movieDTO, Model model) {

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
    public String theaterRegister(TheaterDTO theaterDTO) {
        log.info("theaterDTO : " + theaterDTO);
        //log.info("theaterDTO.getRooms : " + theaterDTO.getRooms());

        movieService.insertTheater(theaterDTO);

        log.info("movieService = " + movieService);

        return "/admin/board/theaterRegister";
    }


    @GetMapping(value = "/admin/theaterList")
    public String theaterList(Model model){

        List<RegionDTO> region1List = movieService.selectRegion1Ajax();
        List<TheaterDTO> theaters = movieService.selectAllTheater();


        model.addAttribute("region1List", region1List);

        model.addAttribute("theaters", theaters);

        log.info("theaters = " +theaters );

        return "/admin/board/theaterList";
    }



}
