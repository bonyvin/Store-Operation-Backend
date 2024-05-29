package com.storeManagment.manpowerplanning.service;

import java.util.List;

import com.storeManagment.manpowerplanning.entity.Shifts;

public interface ShiftsService {
	
	String addShifts(Shifts shifts);
	
	Shifts editShifts(Long id,Shifts shifts);
	
	String deleteShift(Long id);
	
	List<Shifts> showAllShifts(String storeName);
	
	List<Shifts> showActiveShifts(String storeName);
	
	Shifts viewById(Long id);

}
