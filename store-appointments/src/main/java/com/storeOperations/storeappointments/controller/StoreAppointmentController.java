package com.storeOperations.storeappointments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.storeOperations.storeappointments.entity.AppointentDto;
import com.storeOperations.storeappointments.entity.Appointment;
import com.storeOperations.storeappointments.entity.MeetingRequest;
import com.storeOperations.storeappointments.service.StoreAppointementService;

@RestController
@RequestMapping("/api/appointment")
public class StoreAppointmentController {
	
	@Autowired
	private StoreAppointementService storeAppointment;
	

	@PostMapping("/addAppointment")
	public ResponseEntity<String> createAppointment(@RequestBody AppointentDto appointmnetDto){
		String savedapp = storeAppointment.addAppointments(appointmnetDto);
		return new ResponseEntity<>(savedapp,HttpStatus.CREATED);
	}
	
	@GetMapping("/showAppointment/{id}")
	public ResponseEntity<AppointentDto> showAppointment(@PathVariable("id") Long id){
		AppointentDto savedapp = storeAppointment.viewAppointment(id);
		return new ResponseEntity<>(savedapp,HttpStatus.OK);
	}
	
	@GetMapping("/showAppointmentStore/{storeName}/{date}")
	public ResponseEntity<List<Appointment>> showAppointmentStore(@PathVariable("storeName") String storeName,@PathVariable("date") String date){
		List<Appointment> savedapp = storeAppointment.showStoreAppointment(storeName,date);
		return new ResponseEntity<>(savedapp,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAppointment/{id}")
	public ResponseEntity<String> deleteAppointmentStore(@PathVariable("id") Long id){
		String deleteApp = storeAppointment.cancelAppointment(id);
		return new ResponseEntity<>(deleteApp,HttpStatus.OK);
	}
	
	@PutMapping("/updateAppointment/{id}")
	public ResponseEntity<String> updateAppointmentStore(@PathVariable("id") Long id,@RequestBody AppointentDto appointmnetDto){
		String updateApp = storeAppointment.changeAppointment(id, appointmnetDto);
		return new ResponseEntity<>(updateApp,HttpStatus.OK);
	}
	
//	private static final String ZOOM_API_URL = "https://api.zoom.us/v2/users/me/meetings";
//	
//	   @PostMapping("/createMeeting")
//	   public String createMeeting(@RequestBody MeetingRequest meetingRequest) {
//	       // Create a RestTemplate instance
//	       RestTemplate restTemplate = new RestTemplate();
//	       // Prepare request body
//	       String requestBody = "{\"topic\":\"" + meetingRequest.getTopic() + "\",\"type\":2}";
//	       // Set headers
//	       HttpHeaders headers = new HttpHeaders();
//	       headers.setContentType(MediaType.APPLICATION_JSON);
//	       headers.set("Authorization", "Bearer YOUR_ZOOM_API_TOKEN");
//	       // Create a POST request to Zoom API
//	       HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
//	       ResponseEntity<String> response = restTemplate.postForEntity(ZOOM_API_URL, entity, String.class);
//	       // Return the Zoom meeting link
//	       if (response.getStatusCode() == HttpStatus.CREATED) {
////	           JsonObject jsonResponse = new Gson().fromJson(response.getBody(), JsonObject.class);
////	           String meetingUrl = jsonResponse.get("join_url").getAsString();
//	           return response.getBody();
//	       } else {
//	           return "Error creating meeting";
//	       }
//	   }
	
	
	

}
