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
    private String roomName;
    
    //추가필드
    private List<RoomDTO> rooms;
    private int totalSeats;
    private int no;

    private String zip;
    private String addr1;
    private String addr2;


}
