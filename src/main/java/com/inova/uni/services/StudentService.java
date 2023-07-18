package com.inova.uni.services;

import java.util.List;

import com.inova.uni.dto.request.StudentRequestDto;
import com.inova.uni.dto.response.StudentResponseDto;
import org.springframework.stereotype.Service;

import com.inova.uni.entity.Student;
@Service
public interface StudentService {
	public String save(StudentRequestDto requestDto);
	public StudentResponseDto findStudent(String id);
	public List<StudentResponseDto> findAllStudent();
	public String updateStudent(StudentRequestDto dto,String id);
	public boolean delete(String id);

}
