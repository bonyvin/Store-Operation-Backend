package com.storeOperation.productinfomation.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeTarget {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape=Shape.STRING)
    private LocalDateTime date;
	
	private String employeeName;
	
	private int targetOfEmp;
	
	private String month;
	
	private String year;
	
	private String storeName;

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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getTargetOfEmp() {
		return targetOfEmp;
	}

	public void setTargetOfEmp(int targetOfEmp) {
		this.targetOfEmp = targetOfEmp;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public EmployeeTarget(LocalDateTime date, String employeeName, int targetOfEmp, String month, String year) {
		super();
		this.date = date;
		this.employeeName = employeeName;
		this.targetOfEmp = targetOfEmp;
		this.month = month;
		this.year = year;
	}

	public EmployeeTarget() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
