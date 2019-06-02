package com.bryan.baseproject.controller;

import com.bryan.baseproject.model.Parameter;
import com.bryan.baseproject.service.model.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/parameter")
public class ParameterController {

    @Autowired
    protected ParameterService parameterService;

    @GetMapping("/")
    public ResponseEntity<List<Parameter>> findAll(){
        return new ResponseEntity<>(this.parameterService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/jdbc/")
    public ResponseEntity<List<Parameter>> parameterList(){
        return new ResponseEntity<>(this.parameterService.parameterList(), HttpStatus.OK);
    }

    @PostMapping("/upload/xlsx/")
    public ResponseEntity<?> uploadXLSX(@RequestParam("file") MultipartFile file){
        try{
            Object obj = this.parameterService.uploadXLSX(file);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
