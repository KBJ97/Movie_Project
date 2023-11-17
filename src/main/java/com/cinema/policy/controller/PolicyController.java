package com.cinema.policy.controller;

import com.cinema.policy.dto.PolicyDTO;
import com.cinema.policy.service.PolicyService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;

@Log4j2
@RequiredArgsConstructor
@Controller
public class PolicyController {

    private final PolicyService policyService;

   @GetMapping("/policy/ethics")
    public String ethics(){
       return "/policy/ethics";
    }

    @GetMapping("/policy/integrity")
    public String integrity(){
       return "/policy/integrity";
    }

    @GetMapping("/policy/newsroom")
    public String newsroom(){

       return "/policy/newsroom";
    }

    @GetMapping("/policy/newsroomreguide")
    public String newsroomreguide(){
        return "/policy/newsroomReGuide";
    }

    /*only register the Article*/
    @GetMapping("/policy/newsroomre")
    public String insertRepo(){

       /* *//*mainService.appVersion(model);*//*

        String path = new File(filePath).getAbsolutePath();
        log.info("path : " + path);
        String ctxPath = PolicyService.getPath(request, model);
        model.addAttribute("ctxPath", ctxPath);*/

       return "/policy/newsroomre";
    }

    @PostMapping("/policy/newsroomre")
    public String insertRepo(PolicyDTO policyDTO){

        log.info("insertRepo...1 : " + policyDTO);
        log.info("insertRepo...2 : " + policyDTO.getPhoneNumber());
        log.info("insertRepo...3 : " + policyDTO.getEmail());

        policyService.insertRepo(policyDTO);

       return "redirect:/policy/newsroomreguide";

    }


}
