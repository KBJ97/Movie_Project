package com.cinema.admin.service;

import com.cinema.admin.dto.FileDTO;
import com.cinema.admin.dto.MovieDTO;
import com.cinema.admin.mapper.MovieMapper;
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

    @Value("${spring.servlet.multipart.location}")
    private String filePath;


    public void insertMovie(MovieDTO movieDTO){
        log.info("insertMovie service");

        List<FileDTO> fileDTOSs = thumbUpload(movieDTO);
        log.info("fileDTO : " + fileDTOSs );



        // 썸네일 업로드
        //thumbUpload(movieDTO);

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




}