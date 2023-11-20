package com.cinema.cs.service;

import com.cinema.cs.dto.csDTO;
import com.cinema.cs.mapper.CsNoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsNoticeService {

    @Autowired
    private CsNoticeMapper csNoticeMapper;

    public int insertNotice(csDTO dto) {
        return csNoticeMapper.insertNotice(dto);
    }

    public csDTO selectNotice(int noticeNo) {
        return csNoticeMapper.selectNotice(noticeNo);
    }

    public List<csDTO> selectNotices() {
        return csNoticeMapper.selectNotices();
    }

    public int updateNotice(csDTO dto) {
        return csNoticeMapper.updateNotice(dto);
    }

    public int deleteNotice(int noticeNo) {
        return csNoticeMapper.deleteNotice(noticeNo);
    }
}