package com.inova.uni.util.Mapper;

import com.inova.uni.dto.response.StudentModuleResponseDto;
import com.inova.uni.entity.StudentModule;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class StudentModuleMapper {
    private final ModuleMapper moduleMapper  = new ModuleMapper();
    private final StudentMapper studentMapper = new StudentMapper();
    private final LectureMapper lectureMapper = new LectureMapper();
    public StudentModuleResponseDto toStudentModuleResponseDto (StudentModule studentModule){
        return new StudentModuleResponseDto(
                studentModule.getId(),
                studentMapper.toStudentResponseDto(studentModule.getStudent()),
                lectureMapper.toLectureResponseDto(studentModule.getLecture()),
                moduleMapper.toModuleResponseDto(studentModule.getModule()),
                studentModule.getSemesterNumber()

        );

    }
    public List<StudentModuleResponseDto> studentModuleResponseDtoList (List<StudentModule> studentModules){
        ArrayList<StudentModuleResponseDto> dtos = new ArrayList<>();
        for (StudentModule s:studentModules  ) {
            dtos.add(
                    toStudentModuleResponseDto(s)
            );
        }
        return dtos;
    }
}
