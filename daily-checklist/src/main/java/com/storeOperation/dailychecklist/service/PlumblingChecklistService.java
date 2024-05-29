package com.storeOperation.dailychecklist.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.storeOperation.dailychecklist.entity.PlumblingChecklist;
import com.storeOperation.dailychecklist.entity.TaskPlumblingChecklist;

public interface PlumblingChecklistService {
	
	String createPlumblingChecklist(PlumblingChecklist checklist);
	List<PlumblingChecklist> getAllPlumbingChecklist();
	List<TaskPlumblingChecklist> addTaskPlumbingChecklist(List<TaskPlumblingChecklist> taskChecklist);
	List<TaskPlumblingChecklist> getbyDateTaskPlumbling(String date);
	String addImageToTaskPlumbling(MultipartFile imageData,MultipartFile imageData1,String checklist, String date,String storeName,String roomName);

}
