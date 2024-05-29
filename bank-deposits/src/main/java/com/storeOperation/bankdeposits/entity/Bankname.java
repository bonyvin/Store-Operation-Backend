package com.storeOperation.bankdeposits.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bankname {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String bankName;
	private String branchName;
	private String ifscCode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public Bankname(String bankName, String branchName) {
		super();
		this.bankName = bankName;
		this.branchName = branchName;
	}
	
	public Bankname(String bankName, String branchName, String ifscCode) {
		super();
		this.bankName = bankName;
		this.branchName = branchName;
		this.ifscCode = ifscCode;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public Bankname() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
