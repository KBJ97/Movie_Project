package com.cinema.cs.controller;

import com.cinema.cs.dto.csDTO;
import com.cinema.cs.service.CsNoticeService;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Log4j2
@Controller
public class NoticeController {

    @Autowired
    private CsNoticeService csNoticeService;

    @GetMapping("/cs/notice")
    public String notice(Model model) {

        List<csDTO> notices = csNoticeService.selectNotices();

        log.info(notices.get(1).getNoticeNo());
        log.info(notices.get(1).getRdate());
        log.info(notices.get(1).getTitle());

        model.addAttribute("notices", notices);

        return "/cs/notice";
    }
}
