package com.inova.uni.services;

import java.util.List;

import com.inova.uni.dto.request.ModuleRequestDto;
import com.inova.uni.dto.response.ModuleResponseDto;
import org.springframework.stereotype.Service;

import com.inova.uni.entity.Module;
@Service
public interface ModuleService {
	public String save(ModuleRequestDto module);
	public ModuleResponseDto findModule(String id);
	public List<ModuleResponseDto> findAllModule();
	public String updateModule(ModuleRequestDto module,String id);
	public boolean delete(String id);
}
