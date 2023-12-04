package com.cinema.admin.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CsFaqDTO {

    private int faqNo;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime rdate;
    private String category;

}
