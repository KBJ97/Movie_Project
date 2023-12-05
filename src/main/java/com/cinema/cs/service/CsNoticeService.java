package com.cinema.cs.service;

import com.cinema.cs.dto.CsNoticeDTO;
import com.cinema.cs.mapper.CsNoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsNoticeService {

    @Autowired
    private CsNoticeMapper csNoticeMapper;

    // CRUD 시작
    public int insertNotice(CsNoticeDTO dto) {
        return csNoticeMapper.insertNotice(dto);
    }

    public CsNoticeDTO selectNotice(int noticeNo) {
        return csNoticeMapper.selectNotice(noticeNo);
    }

    public List<CsNoticeDTO> selectNotices(int start) {
        return csNoticeMapper.selectNotices(start);
    }

    public int updateNotice(CsNoticeDTO dto) {
        return csNoticeMapper.updateNotice(dto);
    }

    public int deleteNotice(int noticeNo) {
        return csNoticeMapper.deleteNotice(noticeNo);
    }
    // CRUD 끝

    // 페이징 시작
    public int noticeCountTotal() {
        return csNoticeMapper.noticeCountTotal();
    }

    // 페이지 마지막 번호
    public int getLastPageNum(int total) {

        int lastPageNum = 0;

        if(total % 10 == 0){
            lastPageNum = total / 10;
        }else{
            lastPageNum = total / 10 + 1;
        }

        return lastPageNum;
    }

    // 페이지 그룹
    public int[] getPageGroupNum(int currentPage, int lastPageNum) {
        int currentPageGroup = (int) Math.ceil(currentPage / 10.0);
        int pageGroupStart = (currentPageGroup - 1) * 10 + 1;
        int pageGroupEnd = currentPageGroup * 10;

        // 페이지 그룹 마지막 넘버가 페이지 넘버보다 클 경우, 페이지 마지막 넘버 = 페이지 그룹 마지막 넘버
        if (pageGroupEnd > lastPageNum) {
            pageGroupEnd = lastPageNum;
        }

        int[] result = {pageGroupStart, pageGroupEnd};

        return result;
    }

    // 페이지 시작번호
    public int getPageStartNum(int total, int currentPage) {
        int pageSize = 10; // 페이지당 표시될 항목 수
        int start = total - ((currentPage - 1) * pageSize);
        return start;
    }

    // Limit 시작번호
    public int getStartNum(int currentPage) {
        int pageSize = 10; // 페이지당 표시될 항목 수
        return (currentPage - 1) * pageSize;
    }

    public CsNoticeDTO selectNoticeByNo(int noticeNo){
        return csNoticeMapper.selectNoticeByNo(noticeNo);
    }

}