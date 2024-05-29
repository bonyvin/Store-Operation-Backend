package com.storeManagment.manpowerplanning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeManagment.manpowerplanning.entity.Employee;
import com.storeManagment.manpowerplanning.entity.ManPlanning;

public interface ManPlanningRepository extends JpaRepository<ManPlanning, Long>{
	
	List<ManPlanning> findByStartDateAndStore(String stardDate,String store);
	
	ManPlanning findByEmp(Employee emp);
	
	ManPlanning findByEmpAndStartDate(Employee emp,String startDate);

}
