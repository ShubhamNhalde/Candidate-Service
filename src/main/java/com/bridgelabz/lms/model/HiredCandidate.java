package com.bridgelabz.lms.model;

import com.bridgelabz.lms.dto.HiredCandidateDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Data
@Document(collection = "HiredCandidate")
public class HiredCandidate {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private long id;

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

    public HiredCandidate() {
        super();
    }

    public HiredCandidate(HiredCandidateDto hiredCandidateDto) {

        this.firstName = hiredCandidateDto.getFirstName();
        this.lastName = hiredCandidateDto.getLastName();
        this.email = hiredCandidateDto.getEmail();
        this.mobileNumber = hiredCandidateDto.getMobileNumber();
        this.hiredDate = hiredCandidateDto.getHiredDate();
        this.degree = hiredCandidateDto.getDegree();
        this.onBoardingStatus = hiredCandidateDto.getOnBoardingStatus();
        this.status = hiredCandidateDto.getStatus();
        this.joinDate = hiredCandidateDto.getJoinDate();
        this.location = hiredCandidateDto.getLocation();

    }

    public HiredCandidate(long id, HiredCandidateDto hiredCandidateDto) {

        this.id = hiredCandidateDto.id;
        this.firstName = hiredCandidateDto.getFirstName();
        this.lastName = hiredCandidateDto.getLastName();
        this.email = hiredCandidateDto.getEmail();
        this.mobileNumber = hiredCandidateDto.getMobileNumber();
        this.hiredDate = hiredCandidateDto.getHiredDate();
        this.degree = hiredCandidateDto.getDegree();
        this.onBoardingStatus = hiredCandidateDto.getOnBoardingStatus();
        this.status = hiredCandidateDto.getStatus();
        this.joinDate = hiredCandidateDto.getJoinDate();
        this.location = hiredCandidateDto.getLocation();

    }
}
