package com.cinema.member.entity;

import com.cinema.member.dto.MemberDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    private String type;
    @Column(name = "birth")
    private String birth;

    public MemberDTO toDTO() {
        return MemberDTO.builder()
                .uid(uid)
                .name(name)
                .pass1(pass)
                .hp(hp)
                .gender(gender)
                .point(point)
                .birth(birth)
                .type(type)
                .build();
    }

    public void setBirthFromString(String birth) {
        this.birth = convertToDatabaseColumn(birth);
    }

    public String convertToDatabaseColumn(String attribute) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyMMdd");
        LocalDate birthDate = LocalDate.parse(attribute, inputFormatter);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return outputFormatter.format(birthDate);
    }
}