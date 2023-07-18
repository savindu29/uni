package com.inova.uni.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentModuleRequestDto {
    private String id;

    private String studentId;

    private String lectureId;

    private String moduleId;

    private String semesterNumber;
}
