package com.bridgelabz.lms.controller;


import com.bridgelabz.lms.dto.HiredCandidateDto;
import com.bridgelabz.lms.dto.ResponseDto;
import com.bridgelabz.lms.model.HiredCandidate;
import com.bridgelabz.lms.repository.CandidateRepository;
import com.bridgelabz.lms.service.IHiredCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/hired-candidate")
@RestController
public class CandidateController {

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    IHiredCandidateService iHiredCandidateService;

    @PostMapping("/addCandidate")
    public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody HiredCandidateDto hiredCandidateDto) {
        HiredCandidate hiredCandidate = iHiredCandidateService.createCandidate(hiredCandidateDto);
        ResponseDto response = new ResponseDto("Hired Candidate Added Successfully !!!", hiredCandidate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getAllCandidates() {
        List<HiredCandidate> candidates = iHiredCandidateService.getAllCandidates();
        ResponseDto response = new ResponseDto("GET CALL FOR HIRED CANDIDATES SUCCESSFUL", candidates);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDto> getById(@PathVariable("id") long id) {
        HiredCandidate hiredCandidate = iHiredCandidateService.getCandidateById(id);
        ResponseDto response = new ResponseDto("GET CALL FOR VIEW PROFILE " + id + "SUCCESSFUL", hiredCandidate);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteCandidate(@PathVariable("id") long id) {
        iHiredCandidateService.deleteCandidate(id);
        ResponseDto response = new ResponseDto("DELETED CANDIDATE DATA SUCCESSFULLY !!!", "DATABASE UPDATED.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateCandidateData(@PathVariable("id") long id,
                                                           @RequestBody HiredCandidateDto hiredCandidateDto) {
        HiredCandidate hiredCandidate = iHiredCandidateService.updateCandidate(id, hiredCandidateDto);
        ResponseDto response = new ResponseDto("UPDATED CANDIDATE DATA SUCCESSFULLY !!!", hiredCandidate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
