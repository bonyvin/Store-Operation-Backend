package com.storeOperation.dailychecklist.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DayStartChecklist")
public class StartDayChecklist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	private String date;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape=Shape.STRING)
    private LocalDateTime submitTime;
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
	private String isHoliday;
	private float floatingAmount;
	private float storeSafeAmount;
	private Long noOfCashier;
	private Long noOfBackendStaff;
	private String storeTime;
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
	public float getFloatingAmount() {
		return floatingAmount;
	}
	public void setFloatingAmount(float floatingAmount) {
		this.floatingAmount = floatingAmount;
	}
	public float getStoreSafeAmount() {
		return storeSafeAmount;
	}
	public void setStoreSafeAmount(float storeSafeAmount) {
		this.storeSafeAmount = storeSafeAmount;
	}
	public Long getNoOfCashier() {
		return noOfCashier;
	}
	public void setNoOfCashier(Long noOfCashier) {
		this.noOfCashier = noOfCashier;
	}
	public Long getNoOfBackendStaff() {
		return noOfBackendStaff;
	}
	public void setNoOfBackendStaff(Long noOfBackendStaff) {
		this.noOfBackendStaff = noOfBackendStaff;
	}
	public String getStoreTime() {
		return storeTime;
	}
	public void setStoreTime(String storeTime) {
		this.storeTime = storeTime;
	}
	
	public StartDayChecklist(Long id, String date, float floatingAmount, float storeSafeAmount, Long noOfCashier,
			Long noOfBackendStaff, String storeTime, String storeName) {
		super();
		this.id = id;
		this.date = date;
		this.floatingAmount = floatingAmount;
		this.storeSafeAmount = storeSafeAmount;
		this.noOfCashier = noOfCashier;
		this.noOfBackendStaff = noOfBackendStaff;
		this.storeTime = storeTime;
		this.storeName = storeName;
	}
	public StartDayChecklist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public StartDayChecklist(String date, LocalDateTime submitTime, String isHoliday, float floatingAmount,
			float storeSafeAmount, Long noOfCashier, Long noOfBackendStaff, String storeTime, String storeName,
			String reason) {
		super();
		this.date = date;
		this.submitTime = submitTime;
		this.isHoliday = isHoliday;
		this.floatingAmount = floatingAmount;
		this.storeSafeAmount = storeSafeAmount;
		this.noOfCashier = noOfCashier;
		this.noOfBackendStaff = noOfBackendStaff;
		this.storeTime = storeTime;
		this.storeName = storeName;
		this.reason = reason;
	}
	

}
