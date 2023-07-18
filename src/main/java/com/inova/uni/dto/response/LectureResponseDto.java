package com.inova.uni.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class LectureResponseDto {

	private String id;

	private String fullName;

	private String empNo;

	private String mobileNo;

	private double basicSalary;


}
