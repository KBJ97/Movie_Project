package com.cinema.mapper;


import com.cinema.admin.dto.MovieDTO;
import com.cinema.admin.mapper.MovieMapper;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieMapperTest {

    @Autowired
    private MovieMapper movieMapper;


    @DisplayName("regiseter 테스트")
    public void selectArticles(MovieDTO movieDTO) {
        System.out.println("테스트1번 입니다.");
        movieMapper.insertMovie(movieDTO);
    }
}
