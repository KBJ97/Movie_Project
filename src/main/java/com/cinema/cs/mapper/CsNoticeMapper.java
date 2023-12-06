package com.cinema.cs.mapper;

import com.cinema.cs.dto.CsNoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CsNoticeMapper {

    // CRUD
    public int insertNotice(CsNoticeDTO dto);

    public CsNoticeDTO selectNotice(int noticeNo);

    public List<CsNoticeDTO> selectNotices(int start);

    public int updateNotice(CsNoticeDTO dto);

    public int deleteNotice(int noticeNo);

    // 페이징
    public int noticeCountTotal();

    public CsNoticeDTO selectNoticeByNo(int noticeNo);

}
