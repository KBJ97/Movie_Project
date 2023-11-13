package com.cinema.admin.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterDTO {
    private int theaterNum;
    private String theaterName;
    private int region1Num;
    private int region2Num;
    private int MaxPeople;
    private int ticketing;

}
