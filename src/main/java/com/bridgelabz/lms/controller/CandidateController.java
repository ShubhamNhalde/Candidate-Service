package com.bridgelabz.lms.controller;

import com.bridgelabz.lms.dto.HiredCandidateDto;
import com.bridgelabz.lms.dto.ResponseDto;
import com.bridgelabz.lms.model.HiredCandidate;
import com.bridgelabz.lms.repository.CandidateRepository;
import com.bridgelabz.lms.service.IHiredCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RequestMapping("/hired-candidate")
@RestController
public class CandidateController {

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    IHiredCandidateService iHiredCandidateService;

    @PostMapping("/addCandidate")
    public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody HiredCandidateDto hiredCandidateDto) {
        String hiredCandidate = iHiredCandidateService.createCandidate(hiredCandidateDto);
        ResponseDto response = new ResponseDto("Hired Candidate Added Successfully !!!", hiredCandidate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getAllCandidates() {
        List<HiredCandidate> candidates = iHiredCandidateService.getAllCandidates();
        ResponseDto response = new ResponseDto("GET CALL FOR HIRED CANDIDATES SUCCESSFUL", candidates);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/{token}")
    public ResponseEntity<ResponseDto> getById(@PathVariable String token) {
        HiredCandidate hiredCandidate = iHiredCandidateService.getCandidateById(token);
        ResponseDto response = new ResponseDto("GET CALL FOR VIEW PROFILE SUCCESSFUL", hiredCandidate);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{token}")
    public ResponseEntity<ResponseDto> deleteCandidate(@PathVariable String token) {
        iHiredCandidateService.deleteCandidate(token);
        ResponseDto response = new ResponseDto("DELETED CANDIDATE DATA SUCCESSFULLY !!!", "DATABASE UPDATED.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{token}")
    public ResponseEntity<ResponseDto> updateCandidateData(@PathVariable String token,
                                                           @RequestBody HiredCandidateDto hiredCandidateDto) {
        HiredCandidate hiredCandidate = iHiredCandidateService.updateCandidate(token, hiredCandidateDto);
        ResponseDto response = new ResponseDto("UPDATED CANDIDATE DATA SUCCESSFULLY !!!", hiredCandidate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<ResponseDto> getCount (){
        long hiredCandidate = iHiredCandidateService.count1();
        ResponseDto response = new ResponseDto("Candidates Count",hiredCandidate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/updateStatus/{token}")
    public ResponseEntity<ResponseDto> getStatus(@PathVariable String token, @RequestBody HiredCandidateDto hiredCandidateDto){
        HiredCandidate hiredCandidate = iHiredCandidateService.updateStatus(token, hiredCandidateDto);
        ResponseDto responseDto = new ResponseDto("Candidate Status Updated", hiredCandidate);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/jobofferMail/{token}")
    public ResponseEntity<ResponseDto> sendOffer(@PathVariable String token){
        HiredCandidate hiredCandidate = iHiredCandidateService.jobOfferMail(token);
        ResponseDto response = new ResponseDto("Email send successfully", hiredCandidate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Value("${file.upload-dir}")
    String FILE_DIRECTORY;

    @PostMapping("/uploadFile")
    public ResponseEntity<ResponseDto> uploadDoc(@RequestParam("File") MultipartFile file) throws IOException {

        File myFile = new File(FILE_DIRECTORY+file.getOriginalFilename());
        myFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();
        ResponseDto response = new ResponseDto("The Document Uploaded Successfully", myFile);
        return new ResponseEntity<ResponseDto>( response, HttpStatus.OK);

    }

}
