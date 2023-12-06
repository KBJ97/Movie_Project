package com.cinema.admin.controller;

import com.cinema.admin.dto.RegionDTO;
import com.cinema.admin.dto.TheaterDTO;
import com.cinema.admin.service.MovieService;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private MovieService movieService;

    @ResponseBody
    @GetMapping("/admin/timeRegister/{region1Num}")
    public List<RegionDTO> region2List(@PathVariable int region1Num){

        List<RegionDTO> region2List = movieService.selectRegion2Ajax(region1Num);

        return  region2List;
    }

    @ResponseBody
    @GetMapping("/admin/timeRegister/{region1Num}/{region2Num}")
    public List<TheaterDTO> cinemaList( @PathVariable int region1Num, @PathVariable int region2Num) {
        List<TheaterDTO> cinemaList = movieService.selectCinemaAjax(region1Num, region2Num);

        return cinemaList;
    }

    @ResponseBody
    @GetMapping("/admin/timeRegister/room/{region1Num}/{region2Num}")
    public List<TheaterDTO> roomList( @PathVariable int region1Num, @PathVariable int region2Num) {
        List<TheaterDTO> roomList = movieService.selectRoomAjax(region1Num, region2Num);

        return roomList;
    }


    @DeleteMapping("/admin/movieRegisterList/deleteMovie/{movieNum}")
    @Transactional
    public ResponseEntity<String> deleteMovie(@PathVariable("movieNum") int movieNum) {
        log.info(movieNum);
        movieService.deleteMovie(movieNum);

        return ResponseEntity.ok("Movie deleted successfully");
    }

    @DeleteMapping("/admin/movieList/deleteMovieInfo/{movieInfoNum}")
    @Transactional
    public ResponseEntity<String> deleteMovieInfo(@PathVariable("movieInfoNum") int movieInfoNum) {
        log.info(movieInfoNum);
        movieService.deleteMovieInfo(movieInfoNum);

        return ResponseEntity.ok("Movie deleted successfully");
    }

    @DeleteMapping("/admin/theaterList/deleteTheater/{no}")
    @Transactional
    public ResponseEntity<String> deleteTheater(@PathVariable("no") int no) {
        log.info(no);
        movieService.deleteTheater(no);

        return ResponseEntity.ok("theater deleted successfully");
    }


}
