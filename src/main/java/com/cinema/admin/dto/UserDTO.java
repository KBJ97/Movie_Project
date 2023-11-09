package com.cinema.admin.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String uid;
    private String name;
    private String hp;
    private String address;
    private int point;
    private String birth;
    private String type;
}
