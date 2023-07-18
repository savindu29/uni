package com.inova.uni.services.impl;

import com.inova.uni.dto.request.StudentModuleRequestDto;
import com.inova.uni.dto.response.StudentModuleResponseDto;
import com.inova.uni.entity.Lecture;
import com.inova.uni.entity.Module;
import com.inova.uni.entity.Student;
import com.inova.uni.entity.StudentModule;
import com.inova.uni.repo.LectureRepo;
import com.inova.uni.repo.ModuleRepo;
import com.inova.uni.repo.StudentModuleRepo;
import com.inova.uni.repo.StudentRepo;
import com.inova.uni.services.StudentModuleService;
import com.inova.uni.util.Mapper.StudentModuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentModuleServiceImpl implements StudentModuleService {
    @Autowired
    private  StudentModuleRepo studentModuleRepo;

    @Autowired
    private ModuleRepo moduleRepo;
    @Autowired
    private LectureRepo lectureRepo;
    @Autowired
    private StudentRepo studentRepo;
    private final StudentModuleMapper studentModuleMapper = new StudentModuleMapper();

    @Override
    public String save(StudentModuleRequestDto requestDto) {
        if(requestDto!=null) {
            StudentModule studentModule = new StudentModule();
            studentModule.setSemesterNumber(requestDto.getSemesterNumber());
            Student student = studentRepo.findById(requestDto.getStudentId()).get();
            Module module = moduleRepo.findById(requestDto.getModuleId()).get();
            Lecture lecture  = lectureRepo.findById(requestDto.getLectureId()).get();
            studentModule.setStudent(student);
            studentModule.setModule(module);
            studentModule.setLecture(lecture);
            return "saved Student Module";
        }
        return "student save unsuccessful !!";
    }

    @Override
    public StudentModuleResponseDto findStudentModule(String id) {
        return null;
    }

    @Override
    public List<StudentModuleResponseDto> findAllStudentModule() {
        List<StudentModule> s = studentModuleRepo.findAll();
        if(!s.isEmpty()) {
            return studentModuleMapper.studentModuleResponseDtoList(s);
        }
        return null;
    }

    @Override
    public String updateStudentModule(StudentModule studentModule, String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        Optional<StudentModule> s = studentModuleRepo.findById(id);
        if(s.isPresent()){

            studentModuleRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
