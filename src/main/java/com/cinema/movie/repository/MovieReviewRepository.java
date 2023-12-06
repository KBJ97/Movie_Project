package com.cinema.movie.repository;

import com.cinema.movie.entity.MovieReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieReviewRepository extends JpaRepository<MovieReviewEntity, Long> {
    List<MovieReviewEntity> findByMovieNum(int movieNum);
}
