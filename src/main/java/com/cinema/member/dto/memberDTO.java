package com.cinema.member.dto;

import com.cinema.member.entity.memberEntity;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class memberDTO {
    private String uid;
    private String name;
    private String hp;
    private String address;
    private int point;
    private String birth;
    private String type;

    public memberEntity toEntity() {
        return memberEntity.builder()
                .uid(uid)
                .name(name)
                .hp(hp)
                .address(address)
                .point(point)
                .birth(birth)
                .type(type)
                .build();
    }
}
