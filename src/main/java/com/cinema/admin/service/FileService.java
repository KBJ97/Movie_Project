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
public class FileService {

    private final MovieMapper movieMapper;


    @Value("${spring.servlet.multipart.location}")
    private String filePath;

    //등록하기
    public void insertMovie(MovieDTO movieDTO) {
        // 영화 등록
        movieMapper.insertMovie(movieDTO);

        List<FileDTO> fileDTOs = fileUpload(movieDTO);
        FileDTO fileDTO = (FileDTO) fileUpload(movieDTO);


    }

        //파일 업로드
        public List<FileDTO> fileUpload (MovieDTO dto){

            List<FileDTO> uploadedFiles = new ArrayList<>();

            MultipartFile[] files = new MultipartFile[]{
                dto.getThumb1(),
                dto.getThumb2(),
                dto.getThumb3(),

            };

            log.info("fileUpload...1");
            MultipartFile mf = dto.getFname();

            log.info("fileUpload...2 : " + mf);

            if (!mf.isEmpty()) {
                // 파일 첨부 했을 경우
                String path = new File(filePath).getAbsolutePath();
                log.info("fileUpload...3 : " + path);

                String oriName = mf.getOriginalFilename();
                String ext = oriName.substring(oriName.lastIndexOf("."));
                String newName = UUID.randomUUID().toString() + ext;

                log.info("fileUpload...4 : " + oriName);

                // 여기서 파일을 실제로 업로드하고, uploadedFiles 목록에 추가해야 합니다.
                // 파일을 저장하고 FileDTO 객체를 만들어 uploadedFiles 목록에 추가하는 코드가 필요합니다.

                // 예를 들어, 파일을 저장하고 FileDTO를 생성한 다음 uploadedFiles에 추가하는 방법은 다음과 같을 수 있습니다:
                // FileDTO fileDTO = new FileDTO();
                // fileDTO.setOriginalName(oriName);
                // fileDTO.setNewName(newName);
                // fileDTO.setFilePath(path);
                // uploadedFiles.add(fileDTO);
            }

            log.info("fileUpload...8");
            return uploadedFiles;
        }

}
