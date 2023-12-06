package com.cinema.admin.dto;



import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDTO {

    private String roomName;
    private int rowsTheater;
    private int colsTheater;
    private int totalSeats;
    private int theaterNum;
    private int no;

}
