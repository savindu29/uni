package com.inova.uni.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModuleRequestDto {

    private String id;

    private boolean creditCourse;

    private int noOfCredit;
}
