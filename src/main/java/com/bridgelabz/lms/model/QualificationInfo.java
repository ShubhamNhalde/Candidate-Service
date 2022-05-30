package com.bridgelabz.lms.model;

import com.bridgelabz.lms.dto.QualificationDto;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection="qualification_info")
@Data
public class QualificationInfo {


    @Transient
    public static final String SEQUENCE_NAME = "qualification_sequence";

    @Id
    private long id;

    public String degree;
    public String yearOfPassing;
    public String finalPercentage;
    public String trainingDuration;
    public String finalCertification;
    public String course;

    public QualificationInfo() {}

    public QualificationInfo(QualificationDto qualificationDto) {
        this.degree = qualificationDto.getDegree();
        this.yearOfPassing = qualificationDto.getYearOfPassing();
        this.finalPercentage = qualificationDto.getFinalPercentage();
        this.trainingDuration = qualificationDto.getTrainingDuration();
        this.finalCertification = qualificationDto.getFinalCertification();
        this.course = qualificationDto.getCourse();
    }
}
