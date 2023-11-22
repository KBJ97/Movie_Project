package com.cinema.admin.mapper;

import com.cinema.admin.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieMapper {

    public void insertMovie(MovieDTO movieDTO);
    public void insertFile(FileDTO fileDTO);

    public List<MovieDTO> selectMovies(int start, int end);

    public List<MovieDTO> selectMovie();

    public List<RegionDTO> selectRegion2Ajax(int region1Num);

    public List<RegionDTO> selectRegion1Ajax();

    public List<TheaterDTO> selectCinemaAjax(int region1Num, int region2Num);

    public void insertMovieInfo(MovieInfoDTO movieInfoDTO);

    public List<MovieInfoDTO> selectMovieInfo(int start, int end);

    public void insertFileCinema(FileDTO fileDTO);

    public void deleteMovie(int movieNum);

    public void insertTheater(TheaterDTO theaterDTO);

    public void insertRoom(RoomDTO roomDTO);

    public int movieCount();

    public int movieInfoCount();
}
