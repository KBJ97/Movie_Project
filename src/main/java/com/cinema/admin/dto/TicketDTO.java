package com.cinema.admin.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO {
    private String ticketCode;
    private String uid;
    private String buyDate;
    private String seat;
    private int movieInfoNum;
    private int theaterNum;
    private int movieNum;
}
