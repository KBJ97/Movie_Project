package com.cinema.admin.entity;

import com.cinema.admin.dto.FileDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "cinemaFile")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fileNum;
    private int movieNum;
    private int download;
    private String newName;
    private String oriName;
    @CreationTimestamp
    private LocalDateTime rdate;


    public FileDTO toDTO() {
        return FileDTO.builder()
                .fileNum(fileNum)
                .movieNum(movieNum)
                .download(download)
                .newName(newName)
                .oriName(oriName)
                .rdate(rdate)
                .build();
    }

}
