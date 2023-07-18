package com.inova.uni.controller;

import com.inova.uni.dto.request.ModuleRequestDto;
import com.inova.uni.services.ModuleService;
import com.inova.uni.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/module")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;
    @PostMapping(value = "/create")
    public ResponseEntity<StandardResponse> save(@RequestBody ModuleRequestDto module){
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        moduleService.save(module),
                        null
                ), HttpStatus.CREATED
        );
    }


    @PutMapping(value = "/update",params = {"id"})
    public ResponseEntity<StandardResponse> updateModule(@RequestBody ModuleRequestDto module, @RequestParam String id)  {
        return new ResponseEntity<>(
                new StandardResponse(
                        201 ,
                        moduleService.updateModule(module,id),
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
                        moduleService.findModule(id)

                ), HttpStatus.OK
        );

    }
    @GetMapping("")
    public ResponseEntity<StandardResponse> findAllModules(){

        return new ResponseEntity<>(
                new StandardResponse(
                        200 ,
                        "Data list",
                        moduleService.findAllModule()

                ), HttpStatus.OK
        );

    }
}
