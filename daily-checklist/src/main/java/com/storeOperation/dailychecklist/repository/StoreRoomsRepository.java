package com.storeOperation.dailychecklist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.dailychecklist.entity.StoreRooms;

public interface StoreRoomsRepository extends JpaRepository<StoreRooms, Long>{
	
	List<StoreRooms> findByStoreName(String storeName);

}
