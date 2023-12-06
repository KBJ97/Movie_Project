package com.cinema.cs.service;

import com.cinema.admin.dto.CsFaqDTO;
import com.cinema.cs.mapper.CsFaqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsService {

    @Autowired
    private CsFaqMapper csFaqMapper;

    public List<CsFaqDTO> selectFaqs(int start){
        return csFaqMapper.selectFaqs(start);
    }


}
