package com.cinema.policy.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PolicyDTO {
/* 신문고 제보 시 필요한 항목*/

    /*제보내용*/
    private int ano;
    private String company;
    private String cate;
    private String title;
    private String content;
   /* private String file;*/


    /*제보자*/
    private String name;
    private String contact;
    private String phoneNumber;
    private String email;


    // 추가필드
    private String hp1;
    private String hp2;
    private String hp3;
    private String email1;
    private String email2;

    public String getPhoneNumber() {
        return hp1+hp2+hp3;
    }

    public String getEmail() {
        return email1+"@"+email2;
    }
}
