package com.inova.uni.controller;

import com.inova.uni.dto.request.LectureRequestDto;
import com.inova.uni.entity.Lecture;
import com.inova.uni.services.LectureService;
import com.inova.uni.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/lecture")
public class LectureController {

    @Autowired
    private LectureService lectureService;
    @PostMapping(value = "/create")
    public ResponseEntity<StandardResponse> save(@RequestBody LectureRequestDto lecture){
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        lectureService.save(lecture),
                        null
                ), HttpStatus.CREATED
        );
    }


    @PutMapping(value = "/update",params = {"id"})
    public ResponseEntity<StandardResponse> updateLecture(@RequestBody LectureRequestDto lecture, @RequestParam String id)  {
        return new ResponseEntity<>(
                new StandardResponse(
                        201 ,
                        lectureService.updateLecture(lecture,id),
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
                        lectureService.findLecture(id)

                ), HttpStatus.OK
        );

    }
    @GetMapping("")
    public ResponseEntity<StandardResponse> findAllLectures(){

        return new ResponseEntity<>(
                new StandardResponse(
                        200 ,
                        "Data list",
                        lectureService.findAllLecture()

                ), HttpStatus.OK
        );

    }
}
