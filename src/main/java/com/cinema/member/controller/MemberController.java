package com.cinema.member.controller;

import com.cinema.member.dto.MemberDTO;
import com.cinema.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/login")
    public String login(Model model, String success) {
        model.addAttribute("success", success);

        return "/member/login";
    }

    @GetMapping("/member/register")
    public String join() {
        return "/member/register";
    }

    @PostMapping("/member/register")
    public String register(MemberDTO dto, HttpServletRequest request) {
        // 사용자에게 비밀번호 입력 받기
        String userPassword = request.getParameter("pass1");

        // 사용자가 입력한 비밀번호를 DTO에 설정
        dto.setPass1(userPassword);
        memberService.save(dto);
        return "redirect:/index?success=200";
    }

    @GetMapping("/member/findId")
    public String findId() {
        return "/member/findId";
    }

    @GetMapping("/member/findPass")
    public String findPass() {
        return "/member/findPass";
    }
}