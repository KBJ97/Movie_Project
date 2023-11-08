package com.cinema.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {
    private int fileNum;
    private int movieNum;
    private int download;
    private String newName;
    private String oriName;
    private LocalDateTime rdate;
}
