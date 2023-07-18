package com.inova.uni.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentResponseDto {

    private String id;

    private String name;

    private String dept_head_name;
}
