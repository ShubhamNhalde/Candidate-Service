package com.bridgelabz.lms.service;

import com.bridgelabz.lms.dto.HiredCandidateDto;
import com.bridgelabz.lms.model.HiredCandidate;

import java.util.List;

public interface IHiredCandidateService {

    String createCandidate(HiredCandidateDto hiredCandidateDto);

    List<HiredCandidate> getAllCandidates();

    HiredCandidate getCandidateById(String token);

    HiredCandidate deleteCandidate(String token);

    HiredCandidate updateCandidate(String token, HiredCandidateDto hiredCandidateDto);

     long count1();

     HiredCandidate updateStatus(String token, HiredCandidateDto hiredCandidateDto);

     HiredCandidate jobOfferMail(String token);
}
