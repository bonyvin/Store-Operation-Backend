package com.storeOperation.dailychecklist.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class SubParameterDto {
	
	private String subParameter;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape=Shape.STRING)
	private LocalDateTime date;

	public String getSubParameter() {
		return subParameter;
	}

	public void setSubParameter(String subParameter) {
		this.subParameter = subParameter;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public SubParameterDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubParameterDto(String subParameter, LocalDateTime date) {
		super();
		this.subParameter = subParameter;
		this.date = date;
	}

}
