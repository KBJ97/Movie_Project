package com.cinema.cs.mapper;

import com.cinema.admin.dto.CsFaqDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CsFaqMapper {


    public List<CsFaqDTO> selectFaqs(int start);

}
