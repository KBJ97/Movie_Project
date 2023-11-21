package com.cinema.admin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

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
    private int ticketing;
    private String thName;
    private String seat;

    @JsonProperty("room")
    private List<RoomDTO> rooms;

}
