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
@Table(name = "MasterStoreVisit")
public class MasterStoreVisit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape=Shape.STRING)
	private LocalDateTime date;
    
    private String parameter;
    
    private String subParameter;
    
    private String ratingForparameter;
    
    private String ratingSubParameter;
    
    private String month;
    
    private String year;
    
    private String storeName;
    
    public String getVisitNo() {
		return visitNo;
	}

	public void setVisitNo(String visitNo) {
		this.visitNo = visitNo;
	}

	private String inspector;
    
    private String msgParameter;
    
    private String visitNo;

	public MasterStoreVisit(LocalDateTime date, String parameter, String subParameter, String ratingForparameter,
			String ratingSubParameter, String month, String year, String storeName, String inspector,
			String msgParameter, String visitNo) {
		super();
		this.date = date;
		this.parameter = parameter;
		this.subParameter = subParameter;
		this.ratingForparameter = ratingForparameter;
		this.ratingSubParameter = ratingSubParameter;
		this.month = month;
		this.year = year;
		this.storeName = storeName;
		this.inspector = inspector;
		this.msgParameter = msgParameter;
		this.visitNo = visitNo;
	}

	public MasterStoreVisit(LocalDateTime date, String parameter, String subParameter, String ratingForparameter,
			String ratingSubParameter, String month, String year, String storeName, String inspector,
			String msgParameter) {
		super();
		this.date = date;
		this.parameter = parameter;
		this.subParameter = subParameter;
		this.ratingForparameter = ratingForparameter;
		this.ratingSubParameter = ratingSubParameter;
		this.month = month;
		this.year = year;
		this.storeName = storeName;
		this.inspector = inspector;
		this.msgParameter = msgParameter;
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

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getSubParameter() {
		return subParameter;
	}

	public void setSubParameter(String subParameter) {
		this.subParameter = subParameter;
	}

	public String getRatingForparameter() {
		return ratingForparameter;
	}

	public void setRatingForparameter(String ratingForparameter) {
		this.ratingForparameter = ratingForparameter;
	}

	public String getRatingSubParameter() {
		return ratingSubParameter;
	}

	public void setRatingSubParameter(String ratingSubParameter) {
		this.ratingSubParameter = ratingSubParameter;
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

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getInspector() {
		return inspector;
	}

	public void setInspector(String inspector) {
		this.inspector = inspector;
	}

	public String getMsgParameter() {
		return msgParameter;
	}

	public void setMsgParameter(String msgParameter) {
		this.msgParameter = msgParameter;
	}

	public MasterStoreVisit() {
		super();
		// TODO Auto-generated constructor stub
	}

}
