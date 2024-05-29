package com.storeOperation.dailychecklist.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.storeOperation.dailychecklist.entity.HousekeepingChecklist;
import com.storeOperation.dailychecklist.entity.PlumblingChecklist;
import com.storeOperation.dailychecklist.entity.TaskHousekeepingChecklist;
import com.storeOperation.dailychecklist.entity.TaskPlumblingChecklist;
import com.storeOperation.dailychecklist.exception.UserExceptionHandler;
import com.storeOperation.dailychecklist.repository.PlumblingChecklistRepo;
import com.storeOperation.dailychecklist.repository.TaskPlumblingChecklistRepo;
import com.storeOperation.dailychecklist.service.PlumblingChecklistService;

@Service
public class PlumblingChecklistServiceImpl implements PlumblingChecklistService {
	
	@Autowired
	private PlumblingChecklistRepo plumblingChecklistRepo;
	
	@Autowired
	private TaskPlumblingChecklistRepo taskPlumbingRepo; 

	@Override
	public String createPlumblingChecklist(PlumblingChecklist checklist) {
		PlumblingChecklist checkList = plumblingChecklistRepo.findByPlumblingChecklistName(checklist.getPlumblingChecklistName());			
		if(checkList != null) {
		throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Checklist is already added! You can now update only!");
    }			
		PlumblingChecklist saved =  plumblingChecklistRepo.save(checklist);
		return "Successfully added housekeeping checklist!";
		
	}
	
	public List<PlumblingChecklist> getAllPlumbingChecklist(){
		return plumblingChecklistRepo.findAll();
	}
	
	
	public List<TaskPlumblingChecklist> addTaskPlumbingChecklist(List<TaskPlumblingChecklist> taskChecklist) {
		for(int i=0;i<taskChecklist.size();i++) {
			taskPlumbingRepo.save(taskChecklist.get(i));
		}
		return taskChecklist;	
	}

	@Override
	public List<TaskPlumblingChecklist> getbyDateTaskPlumbling(String date) {
		List<TaskPlumblingChecklist> checklist = taskPlumbingRepo.findByDate(date);
		if(checklist.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Checklist is not found!");
	    } else {
	    	return checklist;
	    }
	}

	@Override
	public String addImageToTaskPlumbling(MultipartFile imageData,MultipartFile imageData1,String checklist, String date,String storeName,String roomName) {
//		List<TaskPlumblingChecklist> taskPlumbing = taskPlumbingRepo.findByDateAndStoreName(date, storeName);
		TaskPlumblingChecklist taskPlumbing = taskPlumbingRepo.findByChecklistAndDateAndStoreNameAndRoomName(checklist, date, storeName, roomName);
		try {
			taskPlumbing.setImageData(imageData.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			taskPlumbing.setImageData1(imageData1.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for(int i=0;i<taskPlumbing.size();i++) {
//			try {
//				taskPlumbing.get(i).setImageData(imageData.getBytes());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			taskPlumbingRepo.save(taskPlumbing.get(i));
//			
//		}
		taskPlumbingRepo.save(taskPlumbing);
		return "Add Image sucessfully!";
	}
}
