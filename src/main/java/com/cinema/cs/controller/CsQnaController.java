package com.cinema.cs.controller;

import com.cinema.cs.service.CsQnaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class CsQnaController {

    @Autowired
    private CsQnaService csQnaService;
    @GetMapping("/cs/qna")
    public String qna() {
        return "/cs/qna";
    }

    /*
    public String insert(MultipartFile file) {
        if(!file.isEmpty()) {

        }
        return "redirect:/cs/qna";
    }

     */
}
