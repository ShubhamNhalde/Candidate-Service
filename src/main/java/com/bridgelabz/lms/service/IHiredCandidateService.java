package com.bridgelabz.lms.service;

import com.bridgelabz.lms.dto.HiredCandidateDto;
import com.bridgelabz.lms.model.HiredCandidate;

import java.util.List;

public interface IHiredCandidateService {

    HiredCandidate createCandidate(HiredCandidateDto hiredCandidateDto);

    List<HiredCandidate> getAllCandidates();

    HiredCandidate getCandidateById(long id);

    HiredCandidate deleteCandidate(Long id);

    HiredCandidate updateCandidate(long id, HiredCandidateDto hiredCandidateDto);

     long count1();

     HiredCandidate updateStatus(String status, HiredCandidateDto hiredCandidateDto);

     HiredCandidate jobOfferMail(long id );
}
