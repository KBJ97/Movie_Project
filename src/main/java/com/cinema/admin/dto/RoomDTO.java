package com.cinema.admin.dto;



import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDTO {

    private String room;
    private int rowsTheater;
    private int colsTheater;
    private int totalSeats;
    private int theaterNum;



}
