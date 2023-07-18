package com.inova.uni.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StudentModuleResponseDto {

	private String id;

	private StudentResponseDto student;

	private LectureResponseDto lecture;

	private ModuleResponseDto module;

	private String semesterNumber;

}
