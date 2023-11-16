package com.cinema.policy.service;

import com.cinema.policy.dto.PolicyDTO;
import com.cinema.policy.mapper.PolicyMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Log4j2
@Service
@RequiredArgsConstructor
public class PolicyService {

    private final PolicyMapper policyMapper;

    public static String getPath(HttpServletRequest request, Model model) {

        return "/policy/newsroomre";
    }


    public void insertRepo(PolicyDTO dto) {

        log.info("insertRepo...1");

        policyMapper.insertRepo(dto);

    }


    public static String getPath() {

        return "/policy/newsroomre";
    }
}

