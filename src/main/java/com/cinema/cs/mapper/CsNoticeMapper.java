package com.cinema.cs.mapper;

import com.cinema.cs.dto.csDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CsNoticeMapper {
    public int insertNotice(csDTO dto);
    public csDTO selectNotice(int noticeNo);
    public List<csDTO> selectNotices();

    public int updateNotice(csDTO dto);

    public int deleteNotice(int noticeNo);
}
