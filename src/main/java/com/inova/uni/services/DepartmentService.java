package com.inova.uni.services;

import java.util.List;

import com.inova.uni.dto.request.DepartmentRequestDto;
import com.inova.uni.dto.response.DepartmentResponseDto;
import org.springframework.stereotype.Service;

import com.inova.uni.entity.Department;
@Service
public interface DepartmentService {
	public String save(DepartmentRequestDto department);
	public DepartmentResponseDto findDepartment(String id);
	public List<DepartmentResponseDto> findAllDepartment();
	public String updateDepartment(DepartmentRequestDto department,String id);
	public boolean delete(String id);
}
