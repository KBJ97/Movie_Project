package com.cinema.admin.mapper;

import com.cinema.admin.dto.FileDTO;
import com.cinema.admin.dto.MovieDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieMapper {

    public void insertMovie(MovieDTO movieDTO);
    public void insertFile(FileDTO fileDTO);

    public List<MovieDTO> selectMovies();

}
