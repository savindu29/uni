package com.inova.uni.util.Mapper;

import com.inova.uni.dto.request.StudentRequestDto;
import com.inova.uni.dto.response.StudentResponseDto;
import com.inova.uni.entity.Department;
import com.inova.uni.entity.Student;
import com.inova.uni.repo.DepartmentRepo;
import com.inova.uni.repo.StudentRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class StudentMapper {
    @Autowired
    private final  DepartmentMapper departmentMapper = new DepartmentMapper();


    public StudentResponseDto toStudentResponseDto (Student student){
        return new StudentResponseDto(
                student.getStudent_id(),
                student.getFullname(),
                student.getGender(),
                student.getBirthday(),
                student.getMobileNo(),
                student.getAddress(),
                departmentMapper.toDepartmentResponseDto(student.getDepartment())


        );

    }
    public Student toStudent(StudentRequestDto requestDto){
        Student student = new Student();
        student.setStudent_id(requestDto.getStudentId());
        student.setFullname(requestDto.getFullname());
        student.setGender(requestDto.getGender());
        student.setBirthday(requestDto.getBirthday());
        student.setMobileNo(requestDto.getMobileNo());
        student.setAddress(requestDto.getAddress());
        return student;
    }
    public List<StudentResponseDto> toStudentResponseDtoList (List<Student> students){
        ArrayList<StudentResponseDto> dtos = new ArrayList<>();
        for (Student s:students  ) {
            dtos.add(
                    toStudentResponseDto(s)
            );
        }
        return dtos;
    }
}
