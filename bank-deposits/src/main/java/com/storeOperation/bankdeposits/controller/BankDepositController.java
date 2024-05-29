package com.storeOperation.bankdeposits.controller;

import java.util.List;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.storeOperation.bankdeposits.entity.BankDepositView;
import com.storeOperation.bankdeposits.entity.BankDeposits;
import com.storeOperation.bankdeposits.entity.BankDepositsDetails;
import com.storeOperation.bankdeposits.entity.Bankname;
import com.storeOperation.bankdeposits.service.BankDepositService;



@RestController
@RequestMapping("/api/bankDeposit")
public class BankDepositController {
	
	@Autowired
	private BankDepositService bankDepositService;
	
	@PostMapping("/addBankDeposit")
	public ResponseEntity<String> createBankDeposit(@RequestParam String storeName,@RequestParam String date,@RequestParam Long totalCash,
			@RequestParam Long cashToDeposited,@RequestParam String bankName,@RequestParam String bankBranch,
			@RequestParam String depositerName,@RequestParam String status,@RequestParam String bankDepositNumber,
			@RequestParam("imageData") MultipartFile imageData){
		String savedDetails = bankDepositService.addBankDeposit(storeName, date, totalCash, cashToDeposited, bankName, bankBranch, depositerName, status, bankDepositNumber, imageData);
		return new ResponseEntity<>(savedDetails,HttpStatus.CREATED);
	};
	
	@PostMapping("/addBankDepositDetails/{date}/{storeName}")
	public ResponseEntity<String> createBankDepositDetails(@RequestParam("handoverno") String handOverno,@RequestParam("imageData") MultipartFile imageData,@PathVariable("date") String date,@PathVariable("storeName") String storeName){
		String savedDetails = bankDepositService.addBankDetailsDeposite(date, storeName, handOverno, imageData);
		return new ResponseEntity<>(savedDetails,HttpStatus.CREATED);
	}
	
	@GetMapping("/view/bankDeposit/{date}")
	public ResponseEntity<BankDepositView> seeBankDeposit(@PathVariable String date){
		BankDepositView bankDeposit = bankDepositService.viewDetail(date);
		return new ResponseEntity<>(bankDeposit,HttpStatus.OK);
	}
	
	@GetMapping("/view/AllbankDeposit/{storeName}")
	public ResponseEntity<List<BankDeposits>> seeAllBankDeposit(@PathVariable String storeName){
		List<BankDeposits> bankDeposit = bankDepositService.viewAllBankDeposits(storeName);
		return new ResponseEntity<>(bankDeposit,HttpStatus.OK);
	}
	
	
	@GetMapping("/bankDeposits/{date}")
	public ResponseEntity<BankDeposits> seeBankDeposits(@PathVariable String date){
		BankDeposits bankDeposit = bankDepositService.viewBankDeposit(date);
		return new ResponseEntity<>(bankDeposit,HttpStatus.OK);
	}
	
	@PostMapping("/addBankDetails")
	public ResponseEntity<String> createBankDetails(@RequestBody List<Bankname> bankDetails){
		String savedDetails = bankDepositService.addBankDetails(bankDetails);
		return new ResponseEntity<>(savedDetails,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/{date}")
	public ResponseEntity<?> downloadImage(@PathVariable String date){
		byte[] imageData=bankDepositService.downloadImage(date);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

	}
	

	@GetMapping("/getAllBanks")
	public ResponseEntity<List<Bankname>> getAllBankname(){
		List<Bankname> savedDetails = bankDepositService.getAllBankDetails();
		return new ResponseEntity<>(savedDetails,HttpStatus.CREATED);

	}
	
	
	

}
