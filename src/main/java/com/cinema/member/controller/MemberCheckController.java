package com.cinema.member.controller;

import com.cinema.member.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequestMapping("/member/check")
@RestController
public class MemberCheckController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/uid/{uid}")
    public int checkUid(@PathVariable("uid") String uid) {
        return memberService.countUid(uid);
    }

    @GetMapping("/hp/{hp}")
    public int checkHp(@PathVariable("hp") String hp) {
        int result = memberService.countHp(hp);
        return result;
    }

}
