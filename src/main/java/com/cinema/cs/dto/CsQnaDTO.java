package com.cinema.cs.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

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
    private LocalDateTime rdate;
    
    //추가필드
   private int status; //답변 상태 유무 확인 기본값 : 0 
}
