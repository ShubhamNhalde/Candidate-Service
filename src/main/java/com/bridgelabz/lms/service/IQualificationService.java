package com.bridgelabz.lms.service;

import com.bridgelabz.lms.dto.QualificationDto;
import com.bridgelabz.lms.model.QualificationInfo;

import java.util.List;

public interface IQualificationService {

    QualificationInfo addQualificationData(QualificationDto qualificationDto);

    List<QualificationInfo> getQualificationData();

    QualificationInfo updateQualificationById(long id, QualificationDto qualificationDto);
}
