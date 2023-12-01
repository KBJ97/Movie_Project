package com.cinema.movie.service;

import com.cinema.admin.dto.MovieDTO;
import com.cinema.movie.mapper.MovieListMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class MovieListServie {

    private final MovieListMapper movieListMapper;
    public List<MovieDTO> selectMovies(int start){
        return movieListMapper.selectMovies(start);
    }

    public List<MovieDTO> selectMoviesByName(String keyword){
        return movieListMapper.selectMoviesByName(keyword);
    }

    public List<MovieDTO> selectFutureMovies(LocalDateTime currentTime){
        return movieListMapper.selectFutureMovies(currentTime);
    }

    public List<MovieDTO> selectNowMovies(LocalDateTime currentTime){
        return movieListMapper.selectNowMovies(currentTime);
    }

    public MovieDTO selectMovieByNum(int movieNum){
        return movieListMapper.selectMovieByNum(movieNum);
    }

    public int countMoviesContainName(String keyword){
        return movieListMapper.countMoviesContainName(keyword);
    };


}
