package com.cinema.cs.controller;

import com.cinema.cs.dto.CsNoticeDTO;
import com.cinema.cs.service.CsNoticeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log4j2
@Controller
public class CsNoticeController {

    @Autowired
    private CsNoticeService csNoticeService;

    @GetMapping("/cs/notice")
    public String notice(Model model, @RequestParam(defaultValue = "1") int pg) {

        int pageSize = 10; // 페이지당 표시될 항목 수

        // 전체 공지사항 수
        int totalNotices = csNoticeService.noticeCountTotal();

        // 총 페이지 수 계산
        int lastPageNum = (int) Math.ceil((double) totalNotices / pageSize);

        // 현재 페이지의 그룹을 계산
        int pageGroupSize = 10; // 페이지 그룹 크기
        int pageGroupStart = ((pg - 1) / pageGroupSize) * pageGroupSize + 1;
        int pageGroupEnd = Math.min(pageGroupStart + pageGroupSize - 1, lastPageNum);

        // 현재 페이지의 첫 항목의 인덱스 계산
        int startNum = (pg - 1) * pageSize;

        // 페이징 정보 모델에 추가
        model.addAttribute("totalNotices",totalNotices);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("pageGroupStart", pageGroupStart);
        model.addAttribute("pageGroupEnd", pageGroupEnd);
        model.addAttribute("pageStartNum", startNum + 1);
        model.addAttribute("pg", pg);

        // 목록 출력 시작
        List<CsNoticeDTO> notices = csNoticeService.selectNotices(startNum);

        // 목록을 모델에 추가
        model.addAttribute("notices", notices);

        return "/cs/notice";
    }

    @GetMapping("/cs/view")
    public String view(Model model, int noticeNo) {

        CsNoticeDTO notice = csNoticeService.selectNoticeByNo(noticeNo);

        model.addAttribute("notice", notice);

        return "/cs/view";
    }

}
