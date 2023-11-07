package com.cinema.policy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class policyDTO {
/* 신문고 제보 시 필요한 항목*/

    /*제보내용*/
    private int ano;
    private String company;
    private String cate;
    private String title;
    private String content;
    private String file;

    /*제보자*/
    private String name;
    private String contact;
    private int phoneNumber;
    private String email;
}
