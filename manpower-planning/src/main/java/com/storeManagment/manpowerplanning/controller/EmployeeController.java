package com.storeManagment.manpowerplanning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storeManagment.manpowerplanning.entity.Employee;
import com.storeManagment.manpowerplanning.entity.ManPlanning;
import com.storeManagment.manpowerplanning.entity.Shifts;
import com.storeManagment.manpowerplanning.service.EmployeeService;
import com.storeManagment.manpowerplanning.service.ManPlanningService;
import com.storeManagment.manpowerplanning.service.ShiftsService;

@RestController
@RequestMapping("/api/manplanning")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private ManPlanningService manPlannigService;
	
	@Autowired
	private ShiftsService shiftService;
	

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
		Employee empAdd = empService.addEmployee(emp);
		return new ResponseEntity<>(empAdd,HttpStatus.CREATED);
	}
	
	@PostMapping("/addEmployeeTimeTable/{empId}")
	public ResponseEntity<ManPlanning> addManPlanningSchedule(@RequestBody ManPlanning emp,@PathVariable("empId") Long empId){
		ManPlanning manplan = manPlannigService.addManPlanningShedule(emp,empId);
		return new ResponseEntity<>(manplan,HttpStatus.CREATED);
	}
	
	@GetMapping("/showTimeTable/{startDate}/{store}")
	public ResponseEntity<List<ManPlanning>> showSchedule(@PathVariable("startDate") String startDate,@PathVariable("store") String store){
		List<ManPlanning> manplan = manPlannigService.showTimeTable(startDate,store);
		return new ResponseEntity<>(manplan,HttpStatus.OK);
	}
	
	@GetMapping("/showUserDetails/{username}")
	public ResponseEntity<Employee> showUserDetails(@PathVariable("username") String username){
		Employee emp = empService.userDetails(username);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@PostMapping("/shifts")
	public ResponseEntity<String> addShifts(@RequestBody Shifts shifts){
		String shiftsNew = shiftService.addShifts(shifts);
		return new ResponseEntity<>(shiftsNew,HttpStatus.CREATED);
	}
	
	@PutMapping("/editshifts/{id}")
	public ResponseEntity<Shifts> editShifts(@RequestBody Shifts shifts,@PathVariable("id") Long id){
		Shifts editShift = shiftService.editShifts(id, shifts);
		return new ResponseEntity<>(editShift,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteShift/{id}")
	public ResponseEntity<String> deleteShift(@PathVariable("id") Long id){
		String editShift = shiftService.deleteShift(id);
		return new ResponseEntity<>(editShift,HttpStatus.OK);
	}
	
	@GetMapping("/showAllShifts/{storeName}")
	public ResponseEntity<List<Shifts>> showAllShifts(@PathVariable("storeName") String storeName){
		List<Shifts> shiftsAll = shiftService.showAllShifts(storeName);
		return new ResponseEntity<>(shiftsAll,HttpStatus.OK);
	}
	
	@GetMapping("/showAllActiveShifts/{storeName}")
	public ResponseEntity<List<Shifts>> showAllActiveShifts(@PathVariable("storeName") String storeName){
		List<Shifts> shiftsAll = shiftService.showActiveShifts(storeName);
		return new ResponseEntity<>(shiftsAll,HttpStatus.OK);
	}
	
	@GetMapping("/viewByIdShift/{id}")
	public ResponseEntity<Shifts> viewById(@PathVariable("id") Long id){
		Shifts editShift = shiftService.viewById(id);
		return new ResponseEntity<>(editShift,HttpStatus.OK);
	}
	
	@PutMapping("editSchedule/{empId}/{startDate}")
	public ResponseEntity<ManPlanning> editScheduleOfEmp(@PathVariable("empId") Long empId,@PathVariable("startDate") String startDate,@RequestBody ManPlanning emp){
		ManPlanning plan = manPlannigService.editManPlanningShedule(emp, empId,startDate);
		return new ResponseEntity<>(plan,HttpStatus.OK);
	}
	
	
	@GetMapping("viewAllemployee/{storeName}")
	public ResponseEntity<List<Employee>> allEmployeeList(@PathVariable("storeName") String storeName){
		List<Employee> allList = empService.allEmployeeList(storeName);
		return new ResponseEntity<>(allList,HttpStatus.OK);
	}
	

}
