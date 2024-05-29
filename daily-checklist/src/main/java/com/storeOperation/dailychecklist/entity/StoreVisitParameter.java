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
@Table(name = "StoreVisitParameter")
public class StoreVisitParameter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape=Shape.STRING)
	private LocalDateTime date;
    
    private String parameters;

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

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public StoreVisitParameter(Long id, LocalDateTime date, String parameters) {
		super();
		this.id = id;
		this.date = date;
		this.parameters = parameters;
	}

	public StoreVisitParameter(LocalDateTime date, String parameters) {
		super();
		this.date = date;
		this.parameters = parameters;
	}

	public StoreVisitParameter() {
		super();
		// TODO Auto-generated constructor stub
	}
    

}
