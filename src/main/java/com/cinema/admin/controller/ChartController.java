package com.cinema.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ChartController {

    @GetMapping("/chart")
    public String showDashboard(Model model) {
        // Assuming you have some data to populate the chart
        List<String> labels = Arrays.asList("Label1", "Label2", "Label3");
        List<Integer> data = Arrays.asList(10, 20, 30);

        model.addAttribute("labels", labels);
        model.addAttribute("data", data);

        return "/admin/board/chart"; // Assuming your Thymeleaf template is in the "admin" folder and named "dashboard.html"
    }
}