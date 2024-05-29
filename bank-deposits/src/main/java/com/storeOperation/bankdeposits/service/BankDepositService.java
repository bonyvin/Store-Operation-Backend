package com.storeOperation.bankdeposits.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.storeOperation.bankdeposits.entity.BankDepositView;
import com.storeOperation.bankdeposits.entity.BankDeposits;
import com.storeOperation.bankdeposits.entity.BankDepositsDetails;
import com.storeOperation.bankdeposits.entity.Bankname;

public interface BankDepositService {
	
	String addBankDeposit(String storeName,String date,Long totalCash,Long cashToDeposited,String bankName,
			String bankBranch,String depositerName,String status,String bankDepositNumber,
			MultipartFile photo);
	String addBankDetailsDeposite(String date,String storeName, String handoverno, MultipartFile image);
	BankDepositView viewDetail(String date);
	BankDeposits viewBankDeposit(String date);
	List<BankDeposits> viewAllBankDeposits(String storeName);
	String addBankDetails(List<Bankname> banks);
	List<Bankname> getAllBankDetails();
	byte[] downloadImage(String date);

}
