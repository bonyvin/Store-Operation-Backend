package com.storeManagment.manpowerplanning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeManagment.manpowerplanning.entity.Shifts;

public interface ShiftsRepository extends JpaRepository<Shifts, Long>{
	
    List<Shifts> findByStoreName(String storeName);
    
    List<Shifts> findByStatusAndStoreName(Boolean status,String storeName);
}
