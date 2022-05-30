package com.bridgelabz.lms.service;

import com.bridgelabz.lms.dto.QualificationDto;
import com.bridgelabz.lms.model.QualificationInfo;
import com.bridgelabz.lms.repository.QualificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QualificationService implements IQualificationService{

    @Autowired
    QualificationRepository repo;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;


    @Override
    public QualificationInfo addQualificationData(QualificationDto qualificationDto) {
        QualificationInfo info = new QualificationInfo(qualificationDto);
        info.setId(sequenceGeneratorService.generateSequence(QualificationInfo.SEQUENCE_NAME));
        return repo.save(info);
    }

    @Override
    public List<QualificationInfo> getQualificationData() {
        List<QualificationInfo> list = repo.findAll();
        return list;
    }

    @Override
    public QualificationInfo updateQualificationById(long id, QualificationDto qualificationDto) {
        Optional<QualificationInfo> updateData = repo.findById(id);
        if (updateData.isPresent()){
            updateData.get().setDegree(qualificationDto.getDegree());
            updateData.get().setFinalPercentage(qualificationDto.getFinalPercentage());
            updateData.get().setYearOfPassing(qualificationDto.getYearOfPassing());
            updateData.get().setFinalCertification(qualificationDto.getFinalCertification());
            updateData.get().setTrainingDuration(qualificationDto.getTrainingDuration());
            updateData.get().setCourse(qualificationDto.getCourse());
        }
        return repo.save(updateData.get());
    }
}
