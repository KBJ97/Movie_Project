package com.cinema.admin.dto;

import lombok.*;

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
    private String openDate;
    private String endDate;
    private String thumb1;
    private String thumb2;
    private String thumb3;
    private int movieAge;
    private int runTime;
    private String screenType;
    private String director;
    private String story;
    private int totalScore;


}
