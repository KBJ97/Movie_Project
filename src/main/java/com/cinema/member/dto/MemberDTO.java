package com.cinema.member.dto;

import com.cinema.member.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private String uid;
    private String name;
    private String pass1;
    private String hp;
    private int gender;
    private int point;
    private String birth;
    private String type;

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .uid(uid)
                .name(name)
                .pass(pass1)
                .hp(hp)
                .gender(gender)
                .point(point)
                .birth(birth)
                .type(type)
                .build();
    }
}