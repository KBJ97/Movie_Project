package com.cinema.policy.mapper;

import com.cinema.policy.dto.PolicyDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PolicyMapper {

    public void insertRepo(PolicyDTO dto);

}


