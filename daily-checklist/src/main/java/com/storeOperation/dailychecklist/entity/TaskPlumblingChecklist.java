package com.storeOperation.dailychecklist.entity;

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
@Table(name="TaskPlumbling")
public class TaskPlumblingChecklist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
    private String date;
	private String checklist;
	private String storeName;
	private String status;
	private String roomName;
	@Lob
	@Column(name="imageData",length=1000)
	private byte[] imageData;
	
	@Lob
	@Column(name="imageData1",length=1000)
	private byte[] imageData1;
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
	public String getChecklist() {
		return checklist;
	}
	public void setChecklist(String checklist) {
		this.checklist = checklist;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public TaskPlumblingChecklist(Long id, String date, String checklist, String storeName, String status) {
		super();
		this.id = id;
		this.date = date;
		this.checklist = checklist;
		this.storeName = storeName;
		this.status = status;
	}
	public TaskPlumblingChecklist() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public TaskPlumblingChecklist(String date, String checklist, String storeName, String status, String roomName) {
		super();
		this.date = date;
		this.checklist = checklist;
		this.storeName = storeName;
		this.status = status;
		this.roomName = roomName;
	}
	@Override
	public String toString() {
		return "TaskPlumblingChecklist [id=" + id + ", date=" + date + ", checklist=" + checklist + ", storeName="
				+ storeName + ", status=" + status + ", roomName=" + roomName + ", imageData="
				+ Arrays.toString(imageData) + "]";
	}
	public byte[] getImageData1() {
		return imageData1;
	}
	public void setImageData1(byte[] imageData1) {
		this.imageData1 = imageData1;
	}
	
	

}
