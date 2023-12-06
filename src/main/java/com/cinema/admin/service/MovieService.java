package com.cinema.admin.service;

import com.cinema.admin.dto.*;
import com.cinema.admin.mapper.AdminCsMapper;
import com.cinema.admin.mapper.MovieMapper;
import com.cinema.cs.dto.CsNoticeDTO;
import com.cinema.cs.dto.CsQnaDTO;
import com.cinema.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieMapper movieMapper;

    private final AdminCsMapper adminCsMapper;

    @Value("${spring.servlet.multipart.location}")
    private String filePath;


    public void insertMovie(MovieDTO movieDTO){
        log.info("insertMovie service");

        List<FileDTO> fileDTOSs = thumbUpload(movieDTO);
        log.info("fileDTO : " + fileDTOSs );

        // 썸네일 업로드
        movieDTO.setThumb1(fileDTOSs.get(0).getNewName());
        movieDTO.setThumb2(fileDTOSs.get(1).getNewName());
        movieDTO.setThumb3(fileDTOSs.get(2).getNewName());

        log.info("메인 사진 thumb1 = " + movieDTO.getThumb1());
        log.info("메인 사진 fileThumb1= " +movieDTO.getFileThumb1());

        log.info("메인 사진 thumb2 = " + movieDTO.getThumb2());
        log.info("메인 사진 fileThumb2= " +movieDTO.getFileThumb2());

        log.info("메인 사진 thumb3 = " + movieDTO.getThumb3());
        log.info("메인 사진 fileThumb3= " +movieDTO.getFileThumb3());


        movieMapper.insertMovie(movieDTO);
    }

    @Value("${upload.path.thumbs}")
    private String thumbPath;

    public List<FileDTO> thumbUpload(MovieDTO dto) {

        List<FileDTO> uploadFiles = new ArrayList<>();
        log.info("fileUpload...1");

        log.info("fileUpload...2 : " + dto);
        for (MultipartFile mf : dto.getThumbs()){

            if(!mf.isEmpty()){
                // 파일 첨부 했을 경우
                String path = new File(filePath).getAbsolutePath();
                log.info("fileUpload...3 : " + path);

                String oName = mf.getOriginalFilename();
                String ext = oName.substring(oName.lastIndexOf("."));
                String sName = UUID.randomUUID().toString()+ext;
                
                //fileCinema에 넣기
                FileDTO fileDTO = new FileDTO();

                fileDTO.setOriName(oName);
                fileDTO.setNewName(sName);
                fileDTO.setMovieNum(dto.getMovieNum());

                movieMapper.insertFileCinema(fileDTO);

                log.info("fileUpload...4 : " + oName);

                try {
                    log.info("fileUpload...5");
                    mf.transferTo(new File(path, sName));
                    log.info("fileUpload...6");
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
                log.info("fileUpload...7");
                uploadFiles.add(FileDTO.builder().oriName(oName).newName(sName).build());
            }
        }

        log.info("fileUpload...8");
        return uploadFiles;
    }


    public List<MovieDTO> selectMovies(int start, int end){
        return movieMapper.selectMovies(start, end);
    }

    public List<MovieDTO> selectMovie(){
        return movieMapper.selectMovie();
    }

    public List<RegionDTO> selectRegion2Ajax(int region1Num){
        return movieMapper.selectRegion2Ajax(region1Num);
    }

    public List<RegionDTO> selectRegion1Ajax(){
        return movieMapper.selectRegion1Ajax();
    }

    public List<TheaterDTO> selectCinemaAjax(int region1Num, int region2Num){

        return movieMapper.selectCinemaAjax(region1Num, region2Num);
    }

    public void insertMovieInfo(MovieInfoDTO movieInfoDTO){
        movieMapper.insertMovieInfo(movieInfoDTO);
    }

    public List<MovieInfoDTO> selectMovieInfo(int start, int end){
        return movieMapper.selectMovieInfo(start, end);
    }

   public void deleteMovie(int movieNum){
        movieMapper.deleteMovie(movieNum);
   }

    public void insertTheater(TheaterDTO theaterDTO){

        log.info("insertTheater...1");
        List<RoomDTO> newList = new ArrayList<>();


        ///for(RoomDTO roomDTO: theaterDTO.getRooms()){

           // log.info("insertTheater...2 : " + roomDTO);

           // theaterDTO.setRoomName(roomDTO.getRoomName());

        //}
        movieMapper.insertTheater(theaterDTO);

        log.info("insertTheater...3");

        for(RoomDTO roomDTO: theaterDTO.getRooms()){

            log.info("insertTheater...4 : " + roomDTO);

            roomDTO.setTheaterNum(theaterDTO.getTheaterNum());
            newList.add(roomDTO);
        }

        movieMapper.insertRooms(newList);

    }

   public int movieCount(){
        return movieMapper.movieCount();
   }

   public int movieInfoCount(){
        return  movieMapper.movieInfoCount();
   }


   public List<TheaterDTO> selectAllTheater(int start, int end){
        return movieMapper.selectAllTheater(start, end);
   }

    public List<TheaterDTO> selectTheaterByRegion(int region1Num, int regionNum2){
        return movieMapper.selectTheaterByRegion(region1Num,regionNum2);
    }

    public List<MemberDTO> selectAllMembers(int start, int end){
        return movieMapper.selectAllMembers(start, end);
    }

    public List<CateDTO> selectAllCate(){
        return movieMapper.selectAllCate();
    }


    public void deleteMovieInfo(int movieInfoNum){
        movieMapper.deleteMovieInfo(movieInfoNum);
    }


    public List<MovieDTO> selectMoviesByCate(int cateNum){
        return movieMapper.selectMoviesByCate(cateNum);
    }

    public void deleteTheater(int no){
        movieMapper.deleteTheater(no);
    }

    public int theaterCount(){
        return movieMapper.theaterCount();
    };

    public int memberCount(){
        return movieMapper.memberCount();
    };

    public List<MovieInfoDTO> selectMovieInfoList(){
        return movieMapper.selectMovieInfoList();
    }

    public List<CsNoticeDTO> selectAdminNotices(){
        return adminCsMapper.selectAdminNotices();
    }

    public List<CsQnaDTO> selectAdminQna(){
        return adminCsMapper.selectAdminQna();
    }


    public CsQnaDTO selectQnaByQnaNo(int qnaNo){
        return adminCsMapper.selectQnaByQnaNo(qnaNo);
    };

    public void insertCsAnswer(CsAnswerDTO csAnswerDTO){
        adminCsMapper.insertCsAnswer(csAnswerDTO);
    }

    public CsAnswerDTO selectCsAnswer(int qnaNo){
        return adminCsMapper.selectCsAnswer(qnaNo);
    }

    public void updateCsQnaStatus(int qnaNo){
        adminCsMapper.updateCsQnaStatus(qnaNo);
    }

    public CsAnswerDTO selectCsAnswerByQnaNo(int qnaNo){
        return adminCsMapper.selectCsAnswerByQnaNo(qnaNo);
    }

    public void updateCsAnswer(CsAnswerDTO csAnswerDTO){
        adminCsMapper.updateCsAnswer(csAnswerDTO);
    }

    public void insertNotice(CsNoticeDTO csNoticeDTO){
        adminCsMapper.insertNotice(csNoticeDTO);
    }

    public void insertFaq(CsFaqDTO csFaqDTO){
        adminCsMapper.insertFaq(csFaqDTO);
    }

    public List<CsFaqDTO> selectFAQs(){
        return adminCsMapper.selectFAQs();
    }

    public List<TheaterDTO> selectRoomAjax(int region1Num, int region2Num){
        return movieMapper.selectRoomAjax(region1Num, region2Num);
    }


}