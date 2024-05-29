package com.storeOperations.storeappointments.entity;

public class MeetingRequest {
	
	private String topic;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public MeetingRequest(String topic) {
		super();
		this.topic = topic;
	}

	public MeetingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
