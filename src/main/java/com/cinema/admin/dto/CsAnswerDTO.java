package com.cinema.admin.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CsAnswerDTO {

    private int answerNo;
    private int qnaNo;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime rdate;


}
