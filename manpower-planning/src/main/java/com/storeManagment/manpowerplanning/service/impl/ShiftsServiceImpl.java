package com.storeManagment.manpowerplanning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.storeManagment.manpowerplanning.entity.Shifts;
import com.storeManagment.manpowerplanning.exception.UserExceptionHandler;
import com.storeManagment.manpowerplanning.repository.ShiftsRepository;
import com.storeManagment.manpowerplanning.service.ShiftsService;

@Service
public class ShiftsServiceImpl implements ShiftsService {
	
	@Autowired
	private ShiftsRepository shiftRepo;

	@Override
	public String addShifts(Shifts shifts) {
		Shifts shiftNew = shiftRepo.save(shifts);
		if(shiftNew == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Something went wrong!");
		}
		return "Add shift sucessfully!";
		   
	}

	@Override
	public Shifts editShifts(Long id,Shifts shifts) {
		
		Shifts shiftEdit = shiftRepo.findById(id).get();
		if(shiftEdit == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Shift is not present!");
		}
		
		shiftEdit.setShiftName(shifts.getShiftName());
		shiftEdit.setStartTime(shifts.getStartTime());
		shiftEdit.setEndTime(shifts.getEndTime());
		shiftEdit.setBreakHour(shifts.getBreakHour());
		shiftEdit.setStatus(shifts.getStatus());
		shiftEdit.setStoreName(shifts.getStoreName());
		
		return shiftRepo.save(shiftEdit);
		
	}

	@Override
	public String deleteShift(Long id) {
		
		Shifts shiftEdit = shiftRepo.findById(id).get();
		if(shiftEdit == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Shift is not present!");
		}
		
		shiftRepo.deleteById(id);
		
		return "Deleted Sucessfully!";
	}

	@Override
	public List<Shifts> showAllShifts(String storeName) {
		List<Shifts> allShifts = shiftRepo.findByStoreName(storeName);
		return allShifts;
	}

	@Override
	public List<Shifts> showActiveShifts(String storeName) {
		List<Shifts> allActiveShifts = shiftRepo.findByStatusAndStoreName(true, storeName);
		return allActiveShifts;
		
	}

	@Override
	public Shifts viewById(Long id) {
		Shifts shiftEdit = shiftRepo.findById(id).get();
		if(shiftEdit == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Shift is not present!");
		}
		return shiftEdit;
	}
	
	
	
}
