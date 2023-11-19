package com.cinema.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeatController {

    @GetMapping("/seats")
    public String showSeats(Model model) {
        // 좌석 정보 준비 (예: A1, A2, ...)
        String[] rows = {"A", "B", "C", "D", "E", "F", "G"};
        String[] columns = {"1", "2", "3", "4", "5", "6", "7"};

        // 선택된 좌석 정보 (예: A1, B3, ...)
        String[] selectedSeats = {"A1", "B3"};

        // 모델에 데이터 추가
        model.addAttribute("rows", rows);
        model.addAttribute("columns", columns);
        model.addAttribute("selectedSeats", selectedSeats);

        // 뷰 이름 반환 (여기서는 seat.html 파일을 가정)
        return "seat";
    }
}