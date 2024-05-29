package com.storeOperation.productinfomation.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StoreTarget {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape=Shape.STRING)
    private LocalDateTime date;
	
	private String storeName;
	
	private int targetOfStore;
	
	private String month;
	
	private String year;

	public StoreTarget(LocalDateTime date, String storeName, int targetOfStore, String month, String year) {
		super();
		this.date = date;
		this.storeName = storeName;
		this.targetOfStore = targetOfStore;
		this.month = month;
		this.year = year;
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

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getTargetOfStore() {
		return targetOfStore;
	}

	public void setTargetOfStore(int targetOfStore) {
		this.targetOfStore = targetOfStore;
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

	public StoreTarget() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
