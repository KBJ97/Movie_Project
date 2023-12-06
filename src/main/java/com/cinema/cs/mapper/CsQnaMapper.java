package com.cinema.cs.mapper;

import com.cinema.cs.dto.CsQnaDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CsQnaMapper {

    public void insertQna(CsQnaDTO csQnaDTO);

}
