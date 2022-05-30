package com.bridgelabz.lms.service;

import com.bridgelabz.lms.dto.HiredCandidateDto;
import com.bridgelabz.lms.model.HiredCandidate;
import com.bridgelabz.lms.repository.CandidateRepository;
import com.bridgelabz.lms.util.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class HiredCandidateService implements IHiredCandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    EmailSenderService sender;

    public HiredCandidate createCandidate(HiredCandidateDto hiredCandidateDto) {
        HiredCandidate hiredCandidate = new HiredCandidate(hiredCandidateDto);
        hiredCandidate.setId(sequenceGeneratorService.generateSequence(HiredCandidate.SEQUENCE_NAME));
        return candidateRepository.save(hiredCandidate);
    }

    @Override
    public List<HiredCandidate> getAllCandidates() {
        List<HiredCandidate> userData = candidateRepository.findAll();
        return userData;
    }

    @Override
    public HiredCandidate getCandidateById(long id) {
        return candidateRepository.findById(id).orElseThrow(null);
    }

    @Override
    public HiredCandidate deleteCandidate(Long id) {
        Optional<HiredCandidate> hiredCandidate = candidateRepository.findById(id);
        hiredCandidate.ifPresent(candidate -> candidateRepository.delete(candidate));
        return null;
    }

    @Override
    public HiredCandidate updateCandidate(long id, HiredCandidateDto hiredCandidateDto) {
        Optional<HiredCandidate> hiredCandidate = candidateRepository.findById(id);
        if (hiredCandidate.isPresent()){
            hiredCandidate.get().setFirstName(hiredCandidateDto.getFirstName());
            hiredCandidate.get().setLastName(hiredCandidateDto.getLastName());
            hiredCandidate.get().setEmail(hiredCandidateDto.getEmail());
            hiredCandidate.get().setMobileNumber(hiredCandidateDto.getMobileNumber());
            hiredCandidate.get().setHiredDate(hiredCandidateDto.getHiredDate());
            hiredCandidate.get().setDegree(hiredCandidateDto.getDegree());
            hiredCandidate.get().setOnBoardingStatus(hiredCandidateDto.getOnBoardingStatus());
            hiredCandidate.get().setStatus(hiredCandidateDto.getStatus());
            hiredCandidate.get().setJoinDate(hiredCandidateDto.getJoinDate());
            hiredCandidate.get().setLocation(hiredCandidateDto.getLocation());
        }
        return candidateRepository.save(hiredCandidate.get());
    }

    @Override
    public long count1() {
        return candidateRepository.count();
    }

    @Override
    public HiredCandidate updateStatus(String status, HiredCandidateDto hiredCandidateDto) {
        Optional<HiredCandidate> updateStatus = candidateRepository.getCandidateByStatus(status);
        updateStatus.get().setStatus(hiredCandidateDto.getStatus());
        return candidateRepository.save(updateStatus.get());
    }

    @Override
    public HiredCandidate jobOfferMail(long id) {
        Optional<HiredCandidate> hiredCandidate = candidateRepository.findById(id);
        if (hiredCandidate.isPresent()){
            sender.sendEmail(hiredCandidate.get().getEmail(), "Job Offer", "This is a Candidate Job Offer Notification");
        }
        return hiredCandidate.get();
    }


}
