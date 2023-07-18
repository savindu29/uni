package com.inova.uni.controller;

import com.inova.uni.dto.request.StudentModuleRequestDto;
import com.inova.uni.entity.Student;
import com.inova.uni.entity.StudentModule;
import com.inova.uni.services.StudentModuleService;
import com.inova.uni.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/student_module")
public class StudentModuleController {
    @Autowired
    private StudentModuleService studentModuleService;
    @PostMapping(value="/create")
    public ResponseEntity<StandardResponse> save(@RequestBody StudentModuleRequestDto studentModule){
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        studentModuleService.save(studentModule),
                        null
                ),HttpStatus.CREATED

        );

    }
    @GetMapping("")
    public ResponseEntity<StandardResponse> findAllStudentModules(){

        return new ResponseEntity<>(
                new StandardResponse(
                        200 ,
                        "Data list",
                        studentModuleService.findAllStudentModule()

                ), HttpStatus.OK
        );

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse>  deleteStudentModule(@PathVariable String id){
        return new ResponseEntity<>(
                new StandardResponse(
                        200 ,
                        id+" Details!",
                        studentModuleService.delete(id)

                ), HttpStatus.OK
        );
    }

}
