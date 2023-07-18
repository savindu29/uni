package com.inova.uni.services.impl;

import com.inova.uni.dto.request.LectureRequestDto;
import com.inova.uni.dto.response.LectureResponseDto;
import com.inova.uni.entity.Lecture;
import com.inova.uni.repo.LectureRepo;
import com.inova.uni.services.LectureService;
import com.inova.uni.util.Mapper.LectureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LectureServiceImpl implements LectureService {
    @Autowired
    private  LectureRepo lectureRepo;
    private final LectureMapper lectureMapper = new LectureMapper();
    @Override
    public String save(LectureRequestDto lecture) {
        if(lecture!=null) {
            Lecture d = lectureMapper.toLecture(lecture);
            lectureRepo.save(d);
            return "saved lecture";
        }
        return "lecture save unsuccessfull!!";
    }

    @Override
    public LectureResponseDto findLecture(String id) {
        Optional<Lecture> l = lectureRepo.findById(id);
        if(l.isPresent()){

            return lectureMapper.toLectureResponseDto(l.get());
        }
        return null;
    }

    @Override
    public List<LectureResponseDto> findAllLecture() {
        List<Lecture> l = lectureRepo.findAll();
        if(!l.isEmpty()) {
            return lectureMapper.toLectureResponseDtoList(l);
        }
        return null;
    }

    @Override
    public String updateLecture(LectureRequestDto lecture, String id) {
        Optional<Lecture> l = lectureRepo.findById(id);
        if(l.isPresent()){
            l.get().setFullName(lecture.getFullName());
            l.get().setEmpNo(lecture.getEmpNo());
            l.get().setMobileNo(lecture.getMobileNo());
            l.get().setBasicSalary(lecture.getBasicSalary());
            lectureRepo.save(l.get());
            return l.get().getFullName()+"was updated!!";
        }
        return "Lecture not founded!!";
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
