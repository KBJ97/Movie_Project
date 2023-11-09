package com.cinema.member.entity;

import com.cinema.member.dto.memberDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member")
public class memberEntity {
    @Id
    private String uid;
    private String name;
    private String hp;
    private String address;
    private int point;
    private String birth;
    private String type;


    public memberDTO toDTO() {
        return memberDTO.builder()
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