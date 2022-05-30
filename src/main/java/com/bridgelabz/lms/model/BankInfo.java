package com.bridgelabz.lms.model;

import com.bridgelabz.lms.dto.BankInfoDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="bank_info")
@Data
public class BankInfo {

    @Transient
    public static final String SEQUENCE_NAME = "bankId_sequence";

    @Id
    private long id;

    public String panNumber;
    public String aadharNumber;
    public String bankName;
    public String bankAccountNumber;
    public String ifscCode;

    public BankInfo() {
        super();
    }

    public BankInfo(BankInfoDto bankInfoDto) {
        this.panNumber = bankInfoDto.getPanNumber();
        this.aadharNumber = bankInfoDto.getAadharNumber();
        this.bankName = bankInfoDto.getBankName();
        this.bankAccountNumber = bankInfoDto.getBankAccountNumber();
        this.ifscCode = bankInfoDto.getIfscCode();

    }
}
