package com.cinema.admin.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {
    private int movieNum;
    private int cateNum;
    private String movieName;
    private int price;
    private LocalDate openDate;
    private LocalDate endDate;
    private MultipartFile thumb1;
    private MultipartFile thumb2;
    private MultipartFile thumb3;
    private int movieAge;
    private int runTime;
    private String screenType;
    private String director;
    private String story;
    private int totalScore;
    private MultipartFile fname;


}
