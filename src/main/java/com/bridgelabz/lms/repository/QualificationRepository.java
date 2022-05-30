package com.bridgelabz.lms.repository;

import com.bridgelabz.lms.model.QualificationInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends MongoRepository<QualificationInfo, Long> {
}
