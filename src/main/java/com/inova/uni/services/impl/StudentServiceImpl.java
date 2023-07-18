package com.inova.uni.services.impl;

import com.inova.uni.dto.request.StudentRequestDto;
import com.inova.uni.dto.response.StudentResponseDto;
import com.inova.uni.entity.Department;
import com.inova.uni.entity.Student;
import com.inova.uni.repo.DepartmentRepo;
import com.inova.uni.repo.StudentRepo;
import com.inova.uni.services.StudentService;
import com.inova.uni.util.Mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private  StudentRepo studentRepo;

	private final StudentMapper studentMapper = new StudentMapper();
	@Autowired
	private  DepartmentRepo departmentRepo;
	@Override
	public String save(StudentRequestDto requestDto) {

		if(requestDto!=null) {
			Optional<Department> department = departmentRepo.findById(requestDto.getDepartmentId());
			Student student = studentMapper.toStudent(requestDto);
			student.setDepartment(department.get());
			studentRepo.save(student);
			return "saved student";
		}
		return "student save unsuccessful !!";
	}
	@Override
	public StudentResponseDto findStudent(String id) {
		Optional<Student> s = studentRepo.findById(id);
		if(s.isPresent()){

			return studentMapper.toStudentResponseDto(s.get());
		}
		return null;
	}
	@Override
	public List<StudentResponseDto> findAllStudent(){
		List<Student> s = studentRepo.findAll();
		if(!s.isEmpty()) {
			return studentMapper.toStudentResponseDtoList(s);
		}
		return null;
	}
	@Override
	public String updateStudent(StudentRequestDto student,String id) {
		Optional<Student> s = studentRepo.findById(id);
		if(s.isPresent()) {
			s.get().setFullname(student.getFullname());
			s.get().setGender(student.getGender());
			s.get().setBirthday(student.getBirthday());
			s.get().setMobileNo(student.getMobileNo());
			s.get().setAddress(student.getAddress());

			Optional<Department> department = departmentRepo.findById(student.getDepartmentId());
			s.get().setDepartment(department.get());




			studentRepo.save(s.get());
			return s.get().getFullname()+" was updated!!";
		}
		return "Student not founded!!";
	}
	public boolean delete(String id) {
		return false;
	}
	

}
