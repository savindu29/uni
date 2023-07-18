package com.inova.uni.services.impl;

import com.inova.uni.dto.request.ModuleRequestDto;
import com.inova.uni.dto.response.ModuleResponseDto;
import com.inova.uni.entity.Module;
import com.inova.uni.repo.ModuleRepo;
import com.inova.uni.services.ModuleService;
import com.inova.uni.util.Mapper.ModuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

;
@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    private  ModuleRepo moduleRepo;
    private final ModuleMapper moduleMapper = new ModuleMapper();

    @Override
    public String save(ModuleRequestDto dto) {
        if(dto!=null) {
            Module m = moduleMapper.toModule(dto);
            System.out.println(m);
            moduleRepo.save(m);
            return "saved Module";

        }
        return "module save unsuccessful !!";
    }

    @Override
    public ModuleResponseDto findModule(String id) {
        Optional<Module> m = moduleRepo.findById(id);
        if(m.isPresent()){

            return moduleMapper.toModuleResponseDto(m.get());
        }
        return null;
    }

    @Override
    public List<ModuleResponseDto> findAllModule() {
        List<Module> m = moduleRepo.findAll();
        if(!m.isEmpty()) {
            return moduleMapper.toModuleResponseDtoList(m);
        }
        return null;
    }

    @Override
    public String updateModule(ModuleRequestDto module, String id) {
        Optional<Module> m = moduleRepo.findById(id);
        if(m.isPresent()){
            m.get().setNoOfCredit(module.getNoOfCredit());
            m.get().setCreditCourse(module.isCreditCourse());
            moduleRepo.save(m.get());
            return m.get().getId()+"was updated!!";
        }
        return "module not founded!!";
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
