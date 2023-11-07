package com.cinema.admin.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActorDTO {
    private int actorNum;
    private String actorName;
    private String actorBirth;

}
