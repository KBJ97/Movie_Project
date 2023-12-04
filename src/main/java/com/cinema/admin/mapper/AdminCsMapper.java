package com.cinema.admin.mapper;


import com.cinema.admin.dto.CsAnswerDTO;
import com.cinema.admin.dto.CsFaqDTO;
import com.cinema.cs.dto.CsNoticeDTO;
import com.cinema.cs.dto.CsQnaDTO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface AdminCsMapper {

    public List<CsNoticeDTO> selectAdminNotices();

    public List<CsQnaDTO> selectAdminQna();

    public CsQnaDTO selectQnaByQnaNo(int qnaNo);

    public void insertCsAnswer(CsAnswerDTO csAnswerDTO);

    public CsAnswerDTO selectCsAnswer(int qnaNo);

    public void updateCsQnaStatus(int qnaNo);

    public CsAnswerDTO selectCsAnswerByQnaNo(int qnaNo);

    public void updateCsAnswer(CsAnswerDTO csAnswerDTO);

    public void insertNotice(CsNoticeDTO csNoticeDTO);

    public void insertFaq(CsFaqDTO csFaqDTO);

    public List<CsFaqDTO> selectFAQs();

}
