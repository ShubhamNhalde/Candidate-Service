package com.bridgelabz.lms.dto;

import lombok.Data;

import java.util.Date;

@Data
public class HiredCandidateDto {

    public long id;
    private String firstName;
    private String lastName;
    private String email;
    private long mobileNumber;
    private Date hiredDate;
    private String degree;
    private String onBoardingStatus;
    private String status;
    private Date joinDate;
    private String location;
}
