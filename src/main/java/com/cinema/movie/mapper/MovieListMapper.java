package com.cinema.movie.mapper;

import com.cinema.admin.dto.MovieDTO;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Mapper
public interface MovieListMapper {

    public List<MovieDTO> selectMovies(int start);

    public List<MovieDTO> selectMoviesByName(String keyword);

    public List<MovieDTO> selectFutureMovies(LocalDateTime currentTime);

    public List<MovieDTO> selectNowMovies(LocalDateTime currentTime);

}
