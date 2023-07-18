package com.inova.uni.services.impl;

import com.inova.uni.dto.request.DepartmentRequestDto;
import com.inova.uni.dto.response.DepartmentResponseDto;
import com.inova.uni.entity.Department;
import com.inova.uni.repo.DepartmentRepo;
import com.inova.uni.services.DepartmentService;
import com.inova.uni.util.Mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private  DepartmentRepo departmentRepo;
    private final DepartmentMapper departmentMapper = new DepartmentMapper();
    @Override
    public String save(DepartmentRequestDto department) {
        if(department!=null) {
            Department d = departmentMapper.toDepartment(department);
            departmentRepo.save(d);
            return "saved department";
        }
        return "department save unsuccessfull!!";
    }

    @Override
    public DepartmentResponseDto findDepartment(String id) {
        Optional<Department> d = departmentRepo.findById(id);
        if(d.isPresent()){
            return departmentMapper.toDepartmentResponseDto(d.get());
        }
        return null;
    }

    @Override
    public List<DepartmentResponseDto> findAllDepartment() {
        List<Department> d = departmentRepo.findAll();
        if(!d.isEmpty()) {
            return departmentMapper.toDepartmentList(d);
        }
        return null;
    }

    @Override
    public String updateDepartment(DepartmentRequestDto department, String id) {
        Optional<Department> d = departmentRepo.findById(id);
        if(d.isPresent()){
            d.get().setName(department.getName());
            d.get().setDeptHeadName(department.getDeptHeadName());
            departmentRepo.save(d.get());
            return d.get().getName()+" was updated!!";
        }
        return "Department was not found!!";
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
