package com.cinema.movie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review")
public class MovieReviewEntity {
    @Id
    public int reviewNum;

    public int movieNum;
    public String content;
    public int score;
    public LocalDateTime writeDate;
}
