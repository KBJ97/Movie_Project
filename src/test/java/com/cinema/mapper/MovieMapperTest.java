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

}
