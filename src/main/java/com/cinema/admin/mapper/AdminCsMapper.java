package com.cinema.admin.mapper;

import com.cinema.cs.dto.CsNoticeDTO;
import com.cinema.cs.dto.CsQnaDTO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface AdminCsMapper {

    public List<CsNoticeDTO> selectAdminNotices();

    public List<CsQnaDTO> selectAdminQna();
}
