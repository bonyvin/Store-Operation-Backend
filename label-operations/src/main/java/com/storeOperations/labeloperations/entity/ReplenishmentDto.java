package com.storeOperations.labeloperations.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class ReplenishmentDto {
	
	private String selfLabel;
	
	private String storeName;
	
public ReplenishmentDto(String selfLabel, String storeName, String status, LocalDateTime lastupdatedTime,
			List<Replenishment> listItem) {
		super();
		this.selfLabel = selfLabel;
		this.storeName = storeName;
		this.status = status;
		this.lastupdatedTime = lastupdatedTime;
		this.listItem = listItem;
	}

public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getLastupdatedTime() {
		return lastupdatedTime;
	}

	public void setLastupdatedTime(LocalDateTime lastupdatedTime) {
		this.lastupdatedTime = lastupdatedTime;
	}

private String status;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape=Shape.STRING)
	private LocalDateTime lastupdatedTime;
	
	
	private List<Replenishment> listItem;

	public String getSelfLabel() {
		return selfLabel;
	}

	public void setSelfLabel(String selfLabel) {
		this.selfLabel = selfLabel;
	}

	public List<Replenishment> getListItem() {
		return listItem;
	}

	public void setListItem(List<Replenishment> listItem) {
		this.listItem = listItem;
	}

	public ReplenishmentDto(String selfLabel, List<Replenishment> listItem) {
		super();
		this.selfLabel = selfLabel;
		this.listItem = listItem;
	}

	public ReplenishmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public ReplenishmentDto(String selfLabel, String storeName, List<Replenishment> listItem) {
		super();
		this.selfLabel = selfLabel;
		this.storeName = storeName;
		this.listItem = listItem;
	}
	
	
	

}
