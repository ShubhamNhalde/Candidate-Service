package com.bridgelabz.lms.controller;


import com.bridgelabz.lms.dto.QualificationDto;
import com.bridgelabz.lms.dto.ResponseDto;
import com.bridgelabz.lms.model.QualificationInfo;
import com.bridgelabz.lms.service.IQualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidatequalification")
public class QualificationController {

    @Autowired
    IQualificationService service;

    @PostMapping("/addqualification")
    public ResponseEntity<ResponseDto> addQualification(@RequestBody QualificationDto qualificationDto) {
        QualificationInfo addData = service.addQualificationData(qualificationDto);
        ResponseDto response = new ResponseDto("Candidate Qualification is Added :", addData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getQualification")
    public ResponseEntity<ResponseDto> getQualificationData(){
        List<QualificationInfo> list = service.getQualificationData();
        ResponseDto response = new ResponseDto("List of all Qualification Candidate :", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/updateEduInfo/{id}")
    public ResponseEntity<ResponseDto> updateQualification(@PathVariable long id, @RequestBody QualificationDto qualificationDto){
        QualificationInfo updateData = service.updateQualificationById(id, qualificationDto);
        ResponseDto response = new ResponseDto("Hiring Candidate Qualification Data Successfully Updated",updateData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}


