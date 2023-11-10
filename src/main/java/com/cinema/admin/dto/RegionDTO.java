package com.cinema.admin.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegionDTO {

    private String region1Name;
    private int region1Num;
    private int region2Num;
    private String region2Name;
}
