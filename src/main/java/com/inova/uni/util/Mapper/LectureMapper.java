package com.inova.uni.util.Mapper;

import com.inova.uni.dto.request.LectureRequestDto;
import com.inova.uni.dto.response.LectureResponseDto;
import com.inova.uni.entity.Lecture;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class LectureMapper {
    public LectureResponseDto toLectureResponseDto (Lecture lecture){
        return new LectureResponseDto(
                lecture.getId(),
                lecture.getFullName(),
                lecture.getEmpNo(),
                lecture.getMobileNo(),
                lecture.getBasicSalary()
        );

    }
    public List<LectureResponseDto> toLectureResponseDtoList (List<Lecture> lectures){
        ArrayList<LectureResponseDto> dtos = new ArrayList<>();
        for (Lecture l:lectures  ) {
            dtos.add(
                    toLectureResponseDto(l)
            );
        }
        return dtos;
    }
    public Lecture toLecture(LectureRequestDto dto){
        Lecture l = new Lecture();
        l.setId(dto.getId());
        l.setFullName(dto.getFullName());
        l.setFullName(dto.getFullName());
        l.setEmpNo(dto.getEmpNo());
        l.setMobileNo(dto.getMobileNo());
        l.setBasicSalary(dto.getBasicSalary());
        return l;
    }
}
