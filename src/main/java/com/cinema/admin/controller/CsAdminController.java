package com.cinema.admin.controller;


import com.cinema.admin.dto.MovieInfoDTO;
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
public class CsAdminController {

    private final MovieService movieService;

    @GetMapping(value= "/admin/qnaList")
    public String qnaList(Model model) {


        return "/admin/board/qnaList";
    }


}
