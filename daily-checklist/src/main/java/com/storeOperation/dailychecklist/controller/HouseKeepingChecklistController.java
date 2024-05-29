package com.storeOperation.dailychecklist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.storeOperation.dailychecklist.dto.SUbChecklistDto;
import com.storeOperation.dailychecklist.entity.HousekeepingChecklist;
import com.storeOperation.dailychecklist.entity.StartDayChecklist;
import com.storeOperation.dailychecklist.entity.StoreRooms;
import com.storeOperation.dailychecklist.entity.SubHousekeepingChecklist;
import com.storeOperation.dailychecklist.entity.TaskHousekeepingChecklist;
import com.storeOperation.dailychecklist.service.HouseKeepingChecklistService;

@RestController
@RequestMapping("/api/dayChecklist")
public class HouseKeepingChecklistController {
	
	@Autowired
	private HouseKeepingChecklistService houseKeppingService;
	
	
	@PostMapping("/addHouseChecklistType")
	public ResponseEntity<String> createHouseChecklistType(@RequestBody HousekeepingChecklist checklist){
		String savedCheckList = houseKeppingService.addHouseChecklist(checklist);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@PostMapping("/addSubHouseChecklistType")
	public ResponseEntity<String> createSubHouseChecklistType(@RequestBody SUbChecklistDto checklist){
		String savedCheckList = houseKeppingService.addSubHouseChecklist(checklist);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@PostMapping("/addTaskHouseChecklistType")
	public ResponseEntity<List<TaskHousekeepingChecklist>> addTaskHouseChecklistType(@RequestBody List<TaskHousekeepingChecklist> checklist){
		List<TaskHousekeepingChecklist> savedCheckList = houseKeppingService.addTaskHouseChecklist(checklist);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@GetMapping("/getTaskHouseChecklist/{date}/{housecheck}/{storeName}/{roomName}")
	public ResponseEntity<List<TaskHousekeepingChecklist>> getTaskHouseChecklist(@PathVariable("date") String date,@PathVariable("housecheck") String housecheck,@PathVariable("storeName") String storeName,@PathVariable("roomName") String roomName){
		List<TaskHousekeepingChecklist> savedCheckList = houseKeppingService.getTaskDoneHouseChecklist(date, housecheck, storeName, roomName);
		return new ResponseEntity<>(savedCheckList,HttpStatus.OK);
	}
	
	@GetMapping("/getAllHouseKeepingChecklistType")
	public ResponseEntity<List<HousekeepingChecklist>> getAllHosueChecklist(){
		return new ResponseEntity<>(houseKeppingService.getHouseKeeping(),HttpStatus.OK);
	}

	@GetMapping("/getAllSubHousekeepingChecklist/{checklistType}")
	public ResponseEntity<List<SubHousekeepingChecklist>> getAllSubchecklist(@PathVariable("checklistType") String checkListType){
		return new ResponseEntity<>(houseKeppingService.getAllSubHouseKeepingChecklist(checkListType), HttpStatus.OK);
	}
	
	@PostMapping("/addstoreRoomName")
	public ResponseEntity<String> addStoreRoomName(@RequestBody List<StoreRooms> storerooms){
		return new ResponseEntity<>(houseKeppingService.addStorerooms(storerooms), HttpStatus.OK);
	}
	
	
	@GetMapping("/rooms/{storeName}")
	public ResponseEntity<List<StoreRooms>> getAllRoomsInStore(@PathVariable("storeName") String storeName){
		return new ResponseEntity<>(houseKeppingService.storeRooms(storeName), HttpStatus.OK);
	}
	
	@PostMapping("/addImageFilesInCheckList/{checklistType}/{storeName}/{roomName}/{date}")
	public ResponseEntity<String> addImageAllSubchecklist(@PathVariable("checklistType") String checkListType
			,@PathVariable("storeName") String storeName,
			@PathVariable("roomName") String roomName,
			@PathVariable("date") String date,@RequestParam MultipartFile imageData,@RequestParam MultipartFile imageData1){
		return new ResponseEntity<>(houseKeppingService.addImageData(imageData,imageData1, checkListType, date, storeName,roomName), HttpStatus.OK);
	}
}
									