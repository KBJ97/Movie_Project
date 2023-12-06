package com.cinema.cs.controller;

import com.cinema.cs.dto.CsQnaDTO;
import com.cinema.cs.service.CsQnaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
public class CsQnaController {

    private final CsQnaService csQnaService;

    @GetMapping("/cs/qna")
    public String qna() {
        return "/cs/qna";
    }

    @PostMapping("/cs/qna")
    public String qna(CsQnaDTO csQnaDTO) {

        log.info("csQnaDTO = " + csQnaDTO );
        csQnaService.insertQna(csQnaDTO);

        return "/cs/qna";
    }



}
