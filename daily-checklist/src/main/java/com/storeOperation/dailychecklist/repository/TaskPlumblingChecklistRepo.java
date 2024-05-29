package com.storeOperation.dailychecklist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.dailychecklist.entity.TaskPlumblingChecklist;

public interface TaskPlumblingChecklistRepo extends JpaRepository<TaskPlumblingChecklist, Long>{
	
	List<TaskPlumblingChecklist> findByDate(String date);
	List<TaskPlumblingChecklist> findByDateAndStoreName(String date,String storeName);
	TaskPlumblingChecklist findByChecklistAndDateAndStoreNameAndRoomName(String checklist,String date,String storeName,String roomName);
}
