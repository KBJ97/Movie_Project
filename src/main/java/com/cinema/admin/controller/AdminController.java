package com.cinema.admin.controller;

import com.cinema.admin.dto.CsFaqDTO;
import com.cinema.admin.dto.MovieInfoDTO;
import com.cinema.admin.service.MovieService;
import com.cinema.cs.dto.CsNoticeDTO;
import com.cinema.cs.dto.CsQnaDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class AdminController {

    private final MovieService movieService;

    @GetMapping(value= {"/admin","/admin/index"})
    public String index(Model model) {


        List<MovieInfoDTO> movieList = movieService.selectMovieInfoList();
        List<CsNoticeDTO> noticeList = movieService.selectAdminNotices();
        List<CsQnaDTO> qnaList = movieService.selectAdminQna();
        List<CsFaqDTO> faqList = movieService.selectFAQs();

        log.info("movieList", movieList);
        log.info("noticeList", noticeList);

        model.addAttribute("movieList", movieList);
        model.addAttribute("noticeList", noticeList);
        model.addAttribute("qnaList", qnaList);
        model.addAttribute("faqList", faqList);

        return "/admin/board/index";
    }


}
