package com.cinema.admin.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieInfoDTO {
    private int movieInfoNum;
    private int theaterNum;
    private String theaterName;
    private int movieNum;
    private LocalDate playDate;
    private int region1;
    private int region2;

    private String movieName;
    private String region1Name;
    private String region2Name;

    @DateTimeFormat(pattern = "HH:mm")
    private Time playTime;

    private int price;
    private String roomName;


    // Getter
    public Time getPlayTime() {
        return playTime;
    }

    // Setter
    @DateTimeFormat(pattern = "HH:mm")
    public void setPlayTime(String playTime) {
        this.playTime = Time.valueOf(LocalTime.parse(playTime));
    }
}
