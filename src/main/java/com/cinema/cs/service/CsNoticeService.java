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

    // CRUD 시작
    public int insertNotice(csDTO dto) {
        return csNoticeMapper.insertNotice(dto);
    }

    public csDTO selectNotice(int noticeNo) {
        return csNoticeMapper.selectNotice(noticeNo);
    }

    public List<csDTO> selectNotices(int start) {
        return csNoticeMapper.selectNotices(start);
    }

    public int updateNotice(csDTO dto) {
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
        int currentPageGroup = (int)Math.ceil(currentPage / 10.0);
        int pageGroupStart = (currentPageGroup - 1) * 10 + 1;
        int pageGroupEnd = currentPageGroup * 10;

        // 페이지 그룹 마지막 넘버가 페이지 넘버보다 클 경우, 페이지 마지막 넘버 = 페이지 그룹 마지막 넘버
        // ex) 페이지 넘버가 8이 마지막일 경우, 페이지 그룹 마지막 넘버가 10이 아니라 8이 됨.
        if(pageGroupEnd > lastPageNum){
            pageGroupEnd = lastPageNum;
        }

        int[] result = {pageGroupStart, pageGroupEnd};

        return result;
    }

    // 페이지 시작번호
    public int getPageStartNum(int total, int currentPage) {
        int start = (currentPage - 1) * 10;
        return total - start;
    }

    // 현재 페이지 번호
    public int getCurrentPage(String pg) {
        int currentPage = 1;

        if(pg != null){
            currentPage = Integer.parseInt(pg);
        }

        return currentPage;
    }

    // Limit 시작번호
    public int getStartNum(int currentPage) {
        return (currentPage - 1) * 10;
    }
}