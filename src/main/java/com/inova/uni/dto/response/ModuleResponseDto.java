package com.inova.uni.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModuleResponseDto {

	private String id;

	private boolean creditCourse;

	private int noOfCredit;


}
