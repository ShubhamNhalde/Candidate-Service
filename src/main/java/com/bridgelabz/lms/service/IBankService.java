package com.bridgelabz.lms.service;

import com.bridgelabz.lms.dto.BankInfoDto;
import com.bridgelabz.lms.dto.ResponseDto;
import com.bridgelabz.lms.model.BankInfo;

import java.util.List;

public interface IBankService {

    BankInfo addBankInfo(BankInfoDto bankInfoDto);

    List<BankInfo> getAllBankDeatils();

    BankInfo updateBankInfo(long id, BankInfoDto bankInfoDto);
}
