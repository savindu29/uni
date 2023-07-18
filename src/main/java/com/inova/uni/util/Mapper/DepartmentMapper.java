package com.inova.uni.util.Mapper;

import com.inova.uni.dto.request.DepartmentRequestDto;
import com.inova.uni.dto.response.DepartmentResponseDto;
import com.inova.uni.entity.Department;

import java.util.ArrayList;
import java.util.List;


public class DepartmentMapper {
    public DepartmentResponseDto toDepartmentResponseDto (Department department){
        return new DepartmentResponseDto(
                department.getId(),
                department.getName(),
                department.getDeptHeadName()


        );

    }
    public Department toDepartment(DepartmentRequestDto dto){
        Department department = new Department();
        department.setId(dto.getId());
        department.setName(dto.getName());
        department.setDeptHeadName(dto.getDeptHeadName());
        return department;
    }
    public List<DepartmentResponseDto> toDepartmentList (List<Department> departments){
        ArrayList<DepartmentResponseDto> dtos = new ArrayList<>();
        for (Department d:departments  ) {
            dtos.add(
                    toDepartmentResponseDto(d)
            );
        }
        return dtos;
    }

}
