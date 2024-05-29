package com.storeManagment.manpowerplanning.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Shifts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String shiftName;
	
	private String startTime;
	
	private String endTime;
	
	private String breakHour;
	
	private Boolean status;
	
	private String storeName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShiftName() {
		return shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBreakHour() {
		return breakHour;
	}

	public void setBreakHour(String breakHour) {
		this.breakHour = breakHour;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Shifts(String shiftName, String startTime, String endTime, String breakHour, Boolean status,String storeName) {
		super();
		this.shiftName = shiftName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.breakHour = breakHour;
		this.status = status;
		this.storeName = storeName;
	}

	public Shifts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
