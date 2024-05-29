package com.storeOperation.dailychecklist.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "StoreVisitSubParameter")
public class StoreVisitSubParameter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape=Shape.STRING)
	private LocalDateTime date;
    
    private String subStoreVisitParameter;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parameter_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private StoreVisitParameter storevisitParemeter;

	public StoreVisitSubParameter(LocalDateTime date, String subStoreVisitParameter,
			StoreVisitParameter storevisitParemeter) {
		super();
		this.date = date;
		this.subStoreVisitParameter = subStoreVisitParameter;
		this.storevisitParemeter = storevisitParemeter;
	}

	public StoreVisitSubParameter() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getSubStoreVisitParameter() {
		return subStoreVisitParameter;
	}

	public void setSubStoreVisitParameter(String subStoreVisitParameter) {
		this.subStoreVisitParameter = subStoreVisitParameter;
	}

	public StoreVisitParameter getStorevisitParemeter() {
		return storevisitParemeter;
	}

	public void setStorevisitParemeter(StoreVisitParameter storevisitParemeter) {
		this.storevisitParemeter = storevisitParemeter;
	}
    
    

}
