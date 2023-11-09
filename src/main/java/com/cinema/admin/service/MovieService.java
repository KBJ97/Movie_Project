package com.cinema.admin.service;

import com.cinema.admin.dto.MovieDTO;
import com.cinema.admin.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieMapper movieMapper;

    @Value("${spring.servlet.multipart.location}")
    private String filePath;


    public void insertMovie(MovieDTO movieDTO){
        log.info("insertMovie service");
        movieMapper.insertMovie(movieDTO);
    }

}