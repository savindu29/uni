package com.inova.uni.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentResponseDto {
    private String student_id;
    private String fullname;
    private String gender;
    private LocalDateTime birthday;
    private String mobileNo;
    private String address;
    private DepartmentResponseDto department;
}
