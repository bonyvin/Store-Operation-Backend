package com.storeOperation.bankdeposits.entity;

public class BankDepositView {
	
	private BankDeposits bankdeposit;
	private BankDepositsDetails handOverNumber;
	public BankDeposits getBankdeposit() {
		return bankdeposit;
	}
	public void setBankdeposit(BankDeposits bankdeposit) {
		this.bankdeposit = bankdeposit;
	}
	public BankDepositsDetails getHandOverNumber() {
		return handOverNumber;
	}
	public void setHandOverNumber(BankDepositsDetails handOverNumber) {
		this.handOverNumber = handOverNumber;
	}
	public BankDepositView(BankDeposits bankdeposit, BankDepositsDetails handOverNumber) {
		super();
		this.bankdeposit = bankdeposit;
		this.handOverNumber = handOverNumber;
	}
	public BankDepositView() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
