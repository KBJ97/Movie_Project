package com.cinema.cs.service;

import com.cinema.cs.dto.CsQnaDTO;
import com.cinema.cs.mapper.CsQnaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
@Log4j2
public class CsQnaService {

    private final CsQnaMapper csQnaMapper;

    public void insertQna(CsQnaDTO csQnaDTO){
        csQnaMapper.insertQna(csQnaDTO);
    }


}
