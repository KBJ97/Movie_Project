package com.cinema.admin.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDTO {
    private int reviewNum;
    private int movieNum;
    private String content;
    private int score;
    private LocalDateTime writeDate;
}
