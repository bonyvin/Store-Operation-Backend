package com.storeOperation.bankdeposits.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.storeOperation.bankdeposits.entity.BankDepositView;
import com.storeOperation.bankdeposits.entity.BankDeposits;
import com.storeOperation.bankdeposits.entity.BankDepositsDetails;
import com.storeOperation.bankdeposits.entity.Bankname;
import com.storeOperation.bankdeposits.exception.UserExceptionHandler;
import com.storeOperation.bankdeposits.repository.BankDepositDetailRepository;
import com.storeOperation.bankdeposits.repository.BankDepositRepository;
import com.storeOperation.bankdeposits.repository.BanknameRepository;
import com.storeOperation.bankdeposits.service.BankDepositService;
import com.storeOperation.bankdeposits.utils.ImageUtils;


@Service
public class BankDepositServiceImpl implements BankDepositService {
	
	@Autowired
	private BankDepositRepository bankDepositRepo;
	
	@Autowired
	private BanknameRepository bankdetailsrepo;
	
	@Autowired
	private BankDepositDetailRepository bankDepositDetailRepo;

	@Override
	public String addBankDeposit(String storeName,String date,Long totalCash,Long cashToDeposited,String bankName,
			String bankBranch,String depositerName,String status,String bankDepositNumber,
			MultipartFile photo) {
		BankDeposits savedDeposit = bankDepositRepo.findByDate(date);
		if(savedDeposit != null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Request already exist!! You can only update!");
		}
		BankDeposits bankdeposite = new BankDeposits();
		bankdeposite.setBankBranch(bankBranch);
		bankdeposite.setBankDepositNumber(bankDepositNumber);
		bankdeposite.setBankName(bankName);
		bankdeposite.setCashToDeposited(cashToDeposited);
		bankdeposite.setDate(date);
		bankdeposite.setDepositerName(depositerName);
		bankdeposite.setStatus(status);
		bankdeposite.setStoreName(storeName);
		bankdeposite.setTotalCash(totalCash);
		try {
			bankdeposite.setImageData(photo.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BankDeposits savedDepositDetail = bankDepositRepo.save(bankdeposite);
		return "Bank deposit saved sucessfully!";
	}

	@Override
	public String addBankDetailsDeposite(String date,String storeName, String handoverno, MultipartFile image) {
		BankDeposits savedDeposit = bankDepositRepo.findByDateAndStoreName(date,storeName);
		if(savedDeposit == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Request not exist!!");
		}
		savedDeposit.setStatus("Completed");
		bankDepositRepo.save(savedDeposit);
		try {
			BankDepositsDetails detailAdded = bankDepositDetailRepo.save(new BankDepositsDetails(date, handoverno,image.getBytes(), savedDeposit));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Added bank Deposit detail sucessfully!";
		
	}

	@Override
	public BankDepositView viewDetail(String date) {
		BankDeposits savedDeposit = bankDepositRepo.findByDate(date);
//		BankDepositsDetails bankdetails = bankDepositDetailRepo.findByDate(date);
		if(savedDeposit == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Request not exist!!");
		}
		
		BankDepositsDetails bankDetailsDeposit = bankDepositDetailRepo.findByBankDeposit(savedDeposit);
		
		return new BankDepositView(savedDeposit, bankDetailsDeposit);
		
	}

	@Override
	public List<BankDeposits> viewAllBankDeposits(String storeName) {
		// TODO Auto-generated method stub
		return bankDepositRepo.findByStoreName(storeName);
	}

	@Override
	public BankDeposits viewBankDeposit(String date) {
		BankDeposits savedDeposit = bankDepositRepo.findByDate(date);
		if(savedDeposit == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Request not exist!!");
		}
		return savedDeposit;
	}

	@Override
	public String addBankDetails(List<Bankname> banks) {
		List<Bankname> banksDetails = banks.stream().map(bank -> bankdetailsrepo.save(bank)).collect(Collectors.toList());
		
		if(banksDetails.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Something went wrong!!");
		}
		return  "Bank added Sucessfully";
	}

	@Override
	public byte[] downloadImage(String date) {
		BankDeposits savedDeposit = bankDepositRepo.findByDate(date);
		byte[] images=ImageUtils.decompressImage(savedDeposit.getImageData());
		return images;
	}

	@Override
	public List<Bankname> getAllBankDetails() {		
		return bankdetailsrepo.findAll();
	}

}
