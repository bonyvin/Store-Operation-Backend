package com.storeManagment.manpowerplanning.service;

import java.util.List;

import com.storeManagment.manpowerplanning.entity.ManPlanning;

public interface ManPlanningService {
	
	ManPlanning addManPlanningShedule(ManPlanning manPlanning,Long empId);
	ManPlanning editManPlanningShedule(ManPlanning manPlanning,Long empId,String startDate);	
	List<ManPlanning> showTimeTable(String startDate,String store);

}
