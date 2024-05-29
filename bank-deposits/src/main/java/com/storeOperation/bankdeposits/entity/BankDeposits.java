package com.storeOperation.bankdeposits.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="bankdeposits")
public class BankDeposits {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	private String date;
	
	private Long totalCash;
	
	private Long cashToDeposited;
	
	private String bankName;
	
	private String bankBranch;
	
	private String depositerName;
	
	@Lob
	@Column(name="imageData",length=1000)
	private byte[] imageData;
	
	private String bankDepositNumber;
	
	private String storeName;
	
	private String status;

	public BankDeposits(String date, Long totalCash, Long cashToDeposited, String bankName, String bankBranch,
			String depositerName, byte[] imageData, String bankDepositNumber, String storeName, String status) {
		super();
		this.date = date;
		this.totalCash = totalCash;
		this.cashToDeposited = cashToDeposited;
		this.bankName = bankName;
		this.bankBranch = bankBranch;
		this.depositerName = depositerName;
		this.imageData = imageData;
		this.bankDepositNumber = bankDepositNumber;
		this.storeName = storeName;
		this.status = status;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getDepositerName() {
		return depositerName;
	}

	public void setDepositerName(String depositerName) {
		this.depositerName = depositerName;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public BankDeposits(Long id, String date, Long totalCash, Long cashToDeposited, String bankName,
			String bankDepositNumber, String storeName,String status) {
		super();
		this.id = id;
		this.date = date;
		this.totalCash = totalCash;
		this.cashToDeposited = cashToDeposited;
		this.bankName = bankName;
		this.bankDepositNumber = bankDepositNumber;
		this.storeName = storeName;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getTotalCash() {
		return totalCash;
	}

	public void setTotalCash(Long totalCash) {
		this.totalCash = totalCash;
	}

	public Long getCashToDeposited() {
		return cashToDeposited;
	}

	public void setCashToDeposited(Long cashToDeposited) {
		this.cashToDeposited = cashToDeposited;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankDepositNumber() {
		return bankDepositNumber;
	}

	public void setBankDepositNumber(String bankDepositNumber) {
		this.bankDepositNumber = bankDepositNumber;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BankDeposits() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
