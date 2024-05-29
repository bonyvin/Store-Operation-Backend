package com.storeManagment.manpowerplanning.service;

import java.util.List;

import com.storeManagment.manpowerplanning.entity.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee emp);
	Employee userDetails(String username);
	List<Employee> allEmployeeList(String storeName);


}
