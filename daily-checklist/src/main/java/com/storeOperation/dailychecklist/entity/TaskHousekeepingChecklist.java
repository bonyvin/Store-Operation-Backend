package com.storeOperation.dailychecklist.entity;

import java.time.LocalDateTime;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="TaskHouseKeeping")
public class TaskHousekeepingChecklist {
	
	@Override
	public String toString() {
		return "TaskHousekeepingChecklist [id=" + id + ", date=" + date + ", checkListId=" + checkListId
				+ ", subChecklistId=" + subChecklistId + ", storeName=" + storeName + ", status=" + status
				+ ", roomName=" + roomName + ", isHoliday=" + isHoliday + ", submitTime=" + submitTime + ", imageData="
				+ Arrays.toString(imageData) + ", imageData1=" + Arrays.toString(imageData1) + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
    private String date;
	private String checkListId;
	private String subChecklistId;
	private String storeName;
	private String status;
	private String roomName;
	private String isHoliday;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape=Shape.STRING)
    private LocalDateTime submitTime; 
	public TaskHousekeepingChecklist(Long id, String date, String checkListId, String subChecklistId, String storeName,
			String status, String roomName, String isHoliday, LocalDateTime submitTime, byte[] imageData) {
		super();
		this.id = id;
		this.date = date;
		this.checkListId = checkListId;
		this.subChecklistId = subChecklistId;
		this.storeName = storeName;
		this.status = status;
		this.roomName = roomName;
		this.isHoliday = isHoliday;
		this.submitTime = submitTime;
		this.imageData = imageData;
	}
	public String getIsHoliday() {
		return isHoliday;
	}
	public void setIsHoliday(String isHoliday) {
		this.isHoliday = isHoliday;
	}
	public LocalDateTime getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(LocalDateTime submitTime) {
		this.submitTime = submitTime;
	}
	@Lob
	@Column(name="imageData",length=1000)
	private byte[] imageData;
	
	@Lob
	@Column(name="imageData1",length=1000)
	private byte[] imageData1;
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
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
	public String getCheckListId() {
		return checkListId;
	}
	public void setCheckListId(String checkListId) {
		this.checkListId = checkListId;
	}
	public String getSubChecklistId() {
		return subChecklistId;
	}
	public void setSubChecklistId(String subChecklistId) {
		this.subChecklistId = subChecklistId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public TaskHousekeepingChecklist(Long id, String date, String checkListId, String subChecklistId, String storeName,
			String status) {
		super();
		this.id = id;
		this.date = date;
		this.checkListId = checkListId;
		this.subChecklistId = subChecklistId;
		this.storeName = storeName;
		this.status = status;
	}
	public TaskHousekeepingChecklist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaskHousekeepingChecklist(String date, String checkListId, String subChecklistId, String storeName,
			String status, String roomName, byte[] imageData) {
		super();
		this.date = date;
		this.checkListId = checkListId;
		this.subChecklistId = subChecklistId;
		this.storeName = storeName;
		this.status = status;
		this.roomName = roomName;
		this.imageData = imageData;
	}
	public TaskHousekeepingChecklist(String date, String checkListId, String subChecklistId, String storeName,
			String status, String roomName) {
		super();
		this.date = date;
		this.checkListId = checkListId;
		this.subChecklistId = subChecklistId;
		this.storeName = storeName;
		this.status = status;
		this.roomName = roomName;
	}
	public TaskHousekeepingChecklist(String date, String checkListId, String subChecklistId, String storeName,
			String status, String roomName, String isHoliday, LocalDateTime submitTime, byte[] imageData,
			byte[] imageData1) {
		super();
		this.date = date;
		this.checkListId = checkListId;
		this.subChecklistId = subChecklistId;
		this.storeName = storeName;
		this.status = status;
		this.roomName = roomName;
		this.isHoliday = isHoliday;
		this.submitTime = submitTime;
		this.imageData = imageData;
		this.imageData1 = imageData1;
	}
	public byte[] getImageData1() {
		return imageData1;
	}
	public void setImageData1(byte[] imageData1) {
		this.imageData1 = imageData1;
	}
	
	
	
	
	

}
