package com.cinema.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieReviewDTO {

    public int reviewNum;
    public int movieNum;
    public String content;
    public int score;
    public LocalDateTime writeDate;
}
