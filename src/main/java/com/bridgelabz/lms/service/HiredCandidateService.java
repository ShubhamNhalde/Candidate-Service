package com.bridgelabz.lms.service;

import com.bridgelabz.lms.dto.HiredCandidateDto;
import com.bridgelabz.lms.model.HiredCandidate;
import com.bridgelabz.lms.repository.CandidateRepository;
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
            HiredCandidate update = new HiredCandidate(id,hiredCandidateDto);
            candidateRepository.save(update);
            return update;
        }else {
            throw null;
        }
    }
}
