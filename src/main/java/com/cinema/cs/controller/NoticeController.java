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
    public String notice(Model model, String pg) {

        // 페이징 시작
        int total = csNoticeService.noticeCountTotal();
        int lastPageNum = csNoticeService.getLastPageNum(total);
        int currentPg = csNoticeService.getCurrentPage(pg);
        int start = csNoticeService.getStartNum(currentPg);
        int[] result = csNoticeService.getPageGroupNum(currentPg, lastPageNum);
        int pageStartNum = csNoticeService.getPageStartNum(total, currentPg);
        int startNum = csNoticeService.getStartNum(currentPg);

        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("pageGroupStart", result[0]);
        model.addAttribute("pageGroupEnd", result[1]);
        model.addAttribute("pageStartNum", pageStartNum+1);
        //페이징 끝

        // 목록 출력 시작
        List<csDTO> notices = csNoticeService.selectNotices(start);

        /*
        log.info(notices.get(1).getNoticeNo());
        log.info(notices.get(1).getRdate());
        log.info(notices.get(1).getTitle());
        */
        model.addAttribute("notices", notices);
        // 목록 출력 끝

        return "/cs/notice";
    }

}
