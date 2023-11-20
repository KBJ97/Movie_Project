package com.cinema.entity;

import com.cinema.member.dto.MemberDTO;
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
public class MemberEntity {
    @Id
    private String uid;
    private String name;
    private String pass;
    private String hp;
    private int gender;
    private int point;
    private String birth;
    private String type;


    public MemberDTO toDTO() {
        return MemberDTO.builder()
                .uid(uid)
                .name(name)
                .pass(pass)
                .hp(hp)
                .gender(gender)
                .point(point)
                .birth(birth)
                .type(type)
                .build();
    }
}