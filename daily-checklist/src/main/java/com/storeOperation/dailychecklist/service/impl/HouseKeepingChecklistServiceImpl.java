package com.storeOperation.dailychecklist.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.netflix.discovery.converters.Auto;
import com.storeOperation.dailychecklist.dto.SUbChecklistDto;
import com.storeOperation.dailychecklist.entity.HousekeepingChecklist;
import com.storeOperation.dailychecklist.entity.StartDayChecklist;
import com.storeOperation.dailychecklist.entity.StoreRooms;
import com.storeOperation.dailychecklist.entity.SubHousekeepingChecklist;
import com.storeOperation.dailychecklist.entity.TaskHousekeepingChecklist;
import com.storeOperation.dailychecklist.exception.UserExceptionHandler;
import com.storeOperation.dailychecklist.repository.HouseKeepingChecklistRepository;
import com.storeOperation.dailychecklist.repository.StoreRoomsRepository;
import com.storeOperation.dailychecklist.repository.SubHousekeepingChecklistRepository;
import com.storeOperation.dailychecklist.repository.TaskHousekeepingChecklistRepository;
import com.storeOperation.dailychecklist.service.HouseKeepingChecklistService;

@Service
public class HouseKeepingChecklistServiceImpl implements HouseKeepingChecklistService{
	
	@Autowired
	private HouseKeepingChecklistRepository houseKeepingRepo;
	
	@Autowired
	private SubHousekeepingChecklistRepository subHousechecklistRepo;
	
	@Autowired
	private TaskHousekeepingChecklistRepository taskHouseKeepingRepo;
	
	@Autowired
	private StoreRoomsRepository storeRoomsRepo;

	@Override
	public String addHouseChecklist(HousekeepingChecklist houseKeepingChecklist) {
		 HousekeepingChecklist checkList = houseKeepingRepo.findByCheckListType(houseKeepingChecklist.getCheckListType());			
			if(checkList != null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Checklist is already added! You can now update only!");
	    }			
			
			HousekeepingChecklist saved =  houseKeepingRepo.save(houseKeepingChecklist);
			return "Successfully added housekeeping checklist!";
		
	}

	@Override
	public String addSubHouseChecklist(SUbChecklistDto subChecklistDto) {
		
		HousekeepingChecklist checkList = houseKeepingRepo.findByCheckListType(subChecklistDto.getHousekeepigChecklistType());			
		if(checkList != null) {
			SubHousekeepingChecklist subchecklist = new SubHousekeepingChecklist();
			subchecklist.setSubChecklistName(subChecklistDto.getSubChecklistName());
			subchecklist.setHousekeepingChecklistType(subChecklistDto.getHousekeepigChecklistType());
			subHousechecklistRepo.save(subchecklist);
		
    }	else {
    	throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Housekeeping Checklist type is not present!");
    }
		return "Successfully added housekeeping sub checklist!";
		
		
	}

	@Override
	public List<TaskHousekeepingChecklist> addTaskHouseChecklist(List<TaskHousekeepingChecklist> taskHouseChecklist) {
		
		for(int i=0;i<taskHouseChecklist.size();i++) {
			taskHouseKeepingRepo.save(taskHouseChecklist.get(i));
		}
		
		return taskHouseChecklist;
		
		
	}

	@Override
	public List<TaskHousekeepingChecklist> getTaskDoneHouseChecklist(String date, String checkListId,String storeName,String roomName) {
		
		List<TaskHousekeepingChecklist> dateCheck = taskHouseKeepingRepo.findByDate(date);
		List<TaskHousekeepingChecklist> checklist = taskHouseKeepingRepo.findByCheckListId(checkListId);
		List<TaskHousekeepingChecklist> storeData = taskHouseKeepingRepo.findByStoreName(storeName);
//		TaskHousekeepingChecklist subChecklist = taskHouseKeepingRepo.findBySubChecklistId(subCheckList);
		
		if(dateCheck != null && checklist != null && storeData!= null) {
			return taskHouseKeepingRepo.findByCheckListIdAndStoreNameAndDateAndRoomName(checkListId, storeName, date, roomName);
		}
		else {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Date and checklist type is mismatched!");
		}
	}

	@Override
	public List<HousekeepingChecklist> getHouseKeeping() {
		List<HousekeepingChecklist> getAllChecklist = houseKeepingRepo.findAll();
		if(getAllChecklist != null) {
			return getAllChecklist;
		} else {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Something went wrong!!");
		}
	}

	@Override
	public List<SubHousekeepingChecklist> getAllSubHouseKeepingChecklist(String checklistType) {
		List<SubHousekeepingChecklist> getAllSubChecklist = subHousechecklistRepo.findByHousekeepingChecklistType(checklistType);
		if(getAllSubChecklist != null) {
			return getAllSubChecklist;
		} else {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "HouseKeeping checklist type is not found!!");
		}
	}

	@Override
	public String addStorerooms(List<StoreRooms> storeRooms) {
		List<StoreRooms> roomDetails = storeRooms.stream().map(room -> storeRoomsRepo.save(room)).collect(Collectors.toList());
				
		if(roomDetails.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Something went wrong!!");
		}
		return  "Rooms added Sucessfully";
	}

	@Override
	public List<StoreRooms> storeRooms(String storeName) {
		// TODO Auto-generated method stub
		return storeRoomsRepo.findByStoreName(storeName);
	}

	@Override
	public String addImageData(MultipartFile imageData,MultipartFile imageData1,String checklist, String date, String storeName,String roomName) {
		TaskHousekeepingChecklist taskList = taskHouseKeepingRepo.findBySubChecklistIdAndStoreNameAndDateAndRoomName(checklist, storeName, date,roomName);
		System.out.println(taskList);
//		for(int i=0;i<taskList.size();i++) {
//			try {
//				taskList.get(i).setImageData(imageData.getBytes());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			taskHouseKeepingRepo.save(taskList.get(i));
//		}
		try {
			taskList.setImageData(imageData.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			taskList.setImageData1(imageData1.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		taskHouseKeepingRepo.save(taskList);
		return "Image addded sucessfully";
	}



//	@Override
//	public TaskHousekeepingChecklist addTaskHouseChecklist(TaskHousekeepingChecklist taskHouseChecklist,
//			MultipartFile imageData) {
//		TaskHousekeepingChecklist taskList = new TaskHousekeepingChecklist();
//		taskList.setCheckListId(taskHouseChecklist.getCheckListId());
//		taskList.setDate(taskHouseChecklist.getDate());
//		try {
//			taskList.setImageData(imageData.getBytes());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		taskList.setRoomName(taskHouseChecklist.getRoomName());
//		taskList.setStatus(taskHouseChecklist.getStatus());
//		taskList.setStoreName(taskHouseChecklist.getStoreName());
//		taskList.setSubChecklistId(taskHouseChecklist.getSubChecklistId());
//		
//		taskHouseKeepingRepo.save(taskList);
//		
//		return taskList;
//		
//	}
	

}
