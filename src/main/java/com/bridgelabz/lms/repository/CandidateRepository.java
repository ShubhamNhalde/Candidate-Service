package com.bridgelabz.lms.repository;

import com.bridgelabz.lms.model.HiredCandidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends MongoRepository<HiredCandidate, Long> {


    @Query("{status: ?0}")
    Optional<HiredCandidate> getCandidateByStatus(String status);
}
