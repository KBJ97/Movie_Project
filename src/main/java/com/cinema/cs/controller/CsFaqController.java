package com.cinema.cs.controller;

import com.cinema.admin.dto.CsFaqDTO;
import com.cinema.cs.service.CsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Log4j2
@Controller
public class CsFaqController {

    @Autowired
    private CsService csService;

    @GetMapping("/cs/faq")
    public String faq(Model model) {

        List<CsFaqDTO> faqList = csService.selectFaqs(0);

        log.info("faqList= " + faqList);
        model.addAttribute("faqList", faqList);

        return "/cs/faq";
    }
}
