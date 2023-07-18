package com.inova.uni.controller;

import com.inova.uni.dto.request.StudentRequestDto;
import com.inova.uni.dto.response.StudentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inova.uni.entity.Student;
import com.inova.uni.services.StudentService;
import com.inova.uni.util.StandardResponse;

@RestController
@RequestMapping("api/v1/student")

public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping(value="/create")
	public ResponseEntity<StandardResponse> save(@RequestBody StudentRequestDto requestDto){
		return new ResponseEntity<>(
				new StandardResponse(
						201,
						studentService.save(requestDto),
						null
						),HttpStatus.CREATED

				);

	}
	

	 @PutMapping(value = "/update",params = {"id"}) 
	 public ResponseEntity<StandardResponse> updateStudent(@RequestBody StudentRequestDto dto, @RequestParam String id)  {
	        return new ResponseEntity<>(
	                new StandardResponse(
	                        201 ,
	                        studentService.updateStudent(dto,id),
	                        null

	                ), HttpStatus.CREATED
	        );

	    }
	@GetMapping("/{id}")
	public ResponseEntity<StandardResponse> find(@PathVariable String id){
		return new ResponseEntity<>(
				new StandardResponse(
						200 ,
						id+" Details!",
						studentService.findStudent(id)

				), HttpStatus.OK
		);

	}
	 	@GetMapping("")
	 	public ResponseEntity<StandardResponse> findAllStudents(){

	 		return new ResponseEntity<>(
	                new StandardResponse(
	                        200 ,
	                       "Data list",
	                        studentService.findAllStudent()

	                ), HttpStatus.OK
	        );
			
	 	}
}
