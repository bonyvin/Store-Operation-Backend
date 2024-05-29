package com.storeOperation.dailychecklist.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.storeOperation.dailychecklist.dto.SUbChecklistDto;
import com.storeOperation.dailychecklist.entity.HousekeepingChecklist;
import com.storeOperation.dailychecklist.entity.StoreRooms;
import com.storeOperation.dailychecklist.entity.SubHousekeepingChecklist;
import com.storeOperation.dailychecklist.entity.TaskHousekeepingChecklist;

public interface HouseKeepingChecklistService {
	
	String addHouseChecklist(HousekeepingChecklist houseKeepingChecklist);
	String addSubHouseChecklist(SUbChecklistDto subChecklistDto);
	List<TaskHousekeepingChecklist> addTaskHouseChecklist(List<TaskHousekeepingChecklist> taskHouseChecklist);
//	TaskHousekeepingChecklist addTaskHouseChecklist(TaskHousekeepingChecklist taskHouseChecklist, MultipartFile imageData);
	String addImageData(MultipartFile imageData,MultipartFile imageData1,String checklist,String date,String storeName,String roomName);
	List<TaskHousekeepingChecklist> getTaskDoneHouseChecklist(String date,String checkListId,String storeName,String roomName);
	List<HousekeepingChecklist> getHouseKeeping();
	List<SubHousekeepingChecklist> getAllSubHouseKeepingChecklist(String checklistType);
	
	String addStorerooms(List<StoreRooms> storeRooms);
	
	List<StoreRooms> storeRooms(String storeName);
	
//	String addImageDataToSubcheckList(MultipartFile[] imageData,String checklist,String date,String storeName,String roomName);

}
