package com.storeOperation.dailychecklist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "store_rooms")
public class StoreRooms {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String storeName;
	private String roomName;
	private String checkList;
	public String getCheckList() {
		return checkList;
	}
	public void setCheckList(String checkList) {
		this.checkList = checkList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public StoreRooms(String storeName, String roomName) {
		super();
		this.storeName = storeName;
		this.roomName = roomName;
	}
	public StoreRooms() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoreRooms(String storeName, String roomName, String checkList) {
		super();
		this.storeName = storeName;
		this.roomName = roomName;
		this.checkList = checkList;
	}
	

}
