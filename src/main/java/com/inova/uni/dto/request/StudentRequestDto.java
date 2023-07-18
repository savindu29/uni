package com.inova.uni.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class StudentRequestDto {
//	@JsonProperty("student_id")
    private String studentId;
    private String fullname;
    private String gender;
    private LocalDateTime birthday;
    private String mobileNo;
    private String address;
    private String departmentId;
}
