package com.bridgelabz.lms.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class QualificationDto {

    @NotNull
    public String degree;
    @NotNull
    public String yearOfPassing;
    @NotNull
    public String finalPercentage;
    @NotNull
    public String finalCertification;
    @NotNull
    public String trainingDuration;
    @NotNull
    public String course;
}
