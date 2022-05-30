package com.bridgelabz.lms.repository;

import com.bridgelabz.lms.model.HiredCandidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends MongoRepository<HiredCandidate, Long> {
}
