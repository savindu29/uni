package com.inova.uni.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LectureRequestDto {
    private String id;

    private String fullName;

    private String empNo;

    private String mobileNo;

    private double basicSalary;
}
