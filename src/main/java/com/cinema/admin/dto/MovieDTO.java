package com.cinema.admin.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {
    private int movieNum;
    private int cateNum;
    private String movieName;
    private int price;
    private LocalDate openDate;
    private LocalDate endDate;
    private MultipartFile fileThumb1;
    private MultipartFile fileThumb2;
    private MultipartFile fileThumb3;
    private int movieAge;
    private int runTime;
    private String screenType;
    private String director;
    private String story;
    private String actor;
    private int totalScore;

    // 추가필드
    private String thumb1;
    private String thumb2;
    private String thumb3;

    //추가필드
    private String cateName;

    //private List<ActorDTO> actors;


    //파일 여러개 올릴 수 있는 메서드
    public List<MultipartFile> getThumbs(){
        List<MultipartFile> thumbs = new ArrayList<>();
        if (fileThumb1 != null) {
            thumbs.add(fileThumb1);
        }
        if (fileThumb2 != null) {
            thumbs.add(fileThumb2);
        }
        if (fileThumb3 != null) {
            thumbs.add(fileThumb3);
        }

        return thumbs;
    }



}
