package com.cinema.cs.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CsQnaDTO {
   private int qnaNo;
    private String qnaCate;
    private String writer;
    private String title;
    private String content;
    private MultipartFile file1;
    private MultipartFile file2;
    private MultipartFile file3;
    private String rdate;
}
