package com.cinema.admin.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieInfoDTO {
    private int movieInfoNum;
    private int theaterNum;
    private int movieNum;
    private int playTime;
    private int price;
}
