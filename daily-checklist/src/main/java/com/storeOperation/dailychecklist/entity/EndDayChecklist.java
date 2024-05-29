package com.storeOperation.dailychecklist.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DayEndChecklist")
public class EndDayChecklist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public LocalDateTime getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(LocalDateTime submitTime) {
		this.submitTime = submitTime;
	}
	public String getIsHoliday() {
		return isHoliday;
	}
	public void setIsHoliday(String isHoliday) {
		this.isHoliday = isHoliday;
	}
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	private String date;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape=Shape.STRING)
    private LocalDateTime submitTime;
    private String isHoliday;
    private float eodCashAmount;
    private float storeSafeAmount;
    private String bankDepositDone;
    private String storeClose;
    private String storeName;
	private String reason;

	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
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
	public float getEodCashAmount() {
		return eodCashAmount;
	}
	public void setEodCashAmount(float eodCashAmount) {
		this.eodCashAmount = eodCashAmount;
	}
	public float getStoreSafeAmount() {
		return storeSafeAmount;
	}
	public void setStoreSafeAmount(float storeSafeAmount) {
		this.storeSafeAmount = storeSafeAmount;
	}
	public String getBankDepositDone() {
		return bankDepositDone;
	}
	public void setBankDepositDone(String bankDepositDone) {
		this.bankDepositDone = bankDepositDone;
	}
	public String getStoreClose() {
		return storeClose;
	}
	public void setStoreClose(String storeClose) {
		this.storeClose = storeClose;
	}
	public EndDayChecklist(Long id, String date, float eodCashAmount, float storeSafeAmount, String bankDepositDone,
			String storeClose) {
		super();
		this.id = id;
		this.date = date;
		this.eodCashAmount = eodCashAmount;
		this.storeSafeAmount = storeSafeAmount;
		this.bankDepositDone = bankDepositDone;
		this.storeClose = storeClose;
	}
	
	
	public EndDayChecklist(Long id, String date, float eodCashAmount, float storeSafeAmount, String bankDepositDone,
			String storeClose, String storeName) {
		super();
		this.id = id;
		this.date = date;
		this.eodCashAmount = eodCashAmount;
		this.storeSafeAmount = storeSafeAmount;
		this.bankDepositDone = bankDepositDone;
		this.storeClose = storeClose;
		this.storeName = storeName;
	}
	public EndDayChecklist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public EndDayChecklist(String date, LocalDateTime submitTime, String isHoliday, float eodCashAmount,
			float storeSafeAmount, String bankDepositDone, String storeClose, String storeName, String reason) {
		super();
		this.date = date;
		this.submitTime = submitTime;
		this.isHoliday = isHoliday;
		this.eodCashAmount = eodCashAmount;
		this.storeSafeAmount = storeSafeAmount;
		this.bankDepositDone = bankDepositDone;
		this.storeClose = storeClose;
		this.storeName = storeName;
		this.reason = reason;
	}
    
    
    
    

}
