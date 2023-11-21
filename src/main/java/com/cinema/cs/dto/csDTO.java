package com.cinema.cs.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class csDTO {
    private int noticeNo;
    private String uid;
    private String title;
    private String content;
    private LocalDateTime rdate;
}