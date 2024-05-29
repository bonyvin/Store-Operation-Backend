package com.storeOperations.storeappointments.entity;

import java.util.List;



public class AppointentDto {
	
	private Appointment appointment;
	
	private List<Participants> participants;

	public Appointment getAppointment() {
		return appointment;
	}

	@Override
	public String toString() {
		return "AppointentDto [appointment=" + appointment + ", participants=" + participants + "]";
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public List<Participants> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participants> participants) {
		this.participants = participants;
	}
	
	
	

}
