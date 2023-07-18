package com.inova.uni.services;

import java.util.List;

import com.inova.uni.dto.request.StudentModuleRequestDto;
import com.inova.uni.dto.response.StudentModuleResponseDto;
import org.springframework.stereotype.Service;

import com.inova.uni.entity.StudentModule;
@Service
public interface StudentModuleService {
	public String save(StudentModuleRequestDto studentModule);
	public StudentModuleResponseDto findStudentModule(String id);
	public List<StudentModuleResponseDto> findAllStudentModule();
	public String updateStudentModule(StudentModule studentModule,String id);
	public boolean delete(String id);

}
