package com.cinema.movie.service;

import com.cinema.movie.dto.MovieReviewDTO;
import com.cinema.movie.entity.MovieReviewEntity;
import com.cinema.movie.repository.MovieReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieReviewService {

    private final MovieReviewRepository movieReviewRepository;

    @Autowired
    public MovieReviewService(MovieReviewRepository movieReviewRepository) {
        this.movieReviewRepository = movieReviewRepository;
    }

    // 영화의 모든 리뷰를 가져온다
    public List<MovieReviewDTO> getListOfMovie(int movieNum) {
        List<MovieReviewEntity> reviewEntities = movieReviewRepository.findByMovieNum(movieNum);
        return reviewEntities.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    // 영화 리뷰 추가
    public Long register(MovieReviewDTO movieReviewDTO) {
        MovieReviewEntity movieReviewEntity = dtoToEntity(movieReviewDTO);
        MovieReviewEntity savedEntity = movieReviewRepository.save(movieReviewEntity);
        return (long) savedEntity.getReviewNum();
    }

    // 특정한 영화리뷰 수정
    public void modify(MovieReviewDTO movieReviewDTO) {
        MovieReviewEntity movieReviewEntity = dtoToEntity(movieReviewDTO);
        movieReviewRepository.save(movieReviewEntity);
    }

    // 영화 리뷰 삭제
    public void remove(Long reviewNum) {
        movieReviewRepository.deleteById(reviewNum);
    }

    // Entity to DTO 변환
    private MovieReviewDTO entityToDto(MovieReviewEntity movieReviewEntity) {
        return MovieReviewDTO.builder()
                .reviewNum(movieReviewEntity.getReviewNum())
                .movieNum(movieReviewEntity.getMovieNum())
                .content(movieReviewEntity.getContent())
                .score(movieReviewEntity.getScore())
                .writeDate(movieReviewEntity.getWriteDate())
                .build();
    }

    // DTO to Entity 변환
    private MovieReviewEntity dtoToEntity(MovieReviewDTO movieReviewDTO) {
        return MovieReviewEntity.builder()
                .reviewNum(movieReviewDTO.getReviewNum())
                .movieNum(movieReviewDTO.getMovieNum())
                .content(movieReviewDTO.getContent())
                .score(movieReviewDTO.getScore())
                .writeDate(movieReviewDTO.getWriteDate())
                .build();
    }
}
