package com.inova.uni.util.Mapper;

import com.inova.uni.dto.request.ModuleRequestDto;
import com.inova.uni.dto.response.ModuleResponseDto;
import com.inova.uni.entity.Module;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ModuleMapper {

    public ModuleResponseDto toModuleResponseDto (Module module){
        return new ModuleResponseDto(
                module.getId(),
                module.isCreditCourse(),
                module.getNoOfCredit()
        );

    }
    public List<ModuleResponseDto> toModuleResponseDtoList (List<Module> modules){
        ArrayList<ModuleResponseDto> dtos = new ArrayList<>();
        for (Module m:modules  ) {
            dtos.add(
                toModuleResponseDto(m)
            );
        }
        return dtos;
    }
    public Module toModule(ModuleRequestDto dto){
        Module module = new Module();
        module.setId(dto.getId());
        module.setCreditCourse(dto.isCreditCourse());
        module.setNoOfCredit(dto.getNoOfCredit());
        return module;
    }
}
