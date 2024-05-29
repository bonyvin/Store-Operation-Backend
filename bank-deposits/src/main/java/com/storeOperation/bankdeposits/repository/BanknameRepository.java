package com.storeOperation.bankdeposits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.bankdeposits.entity.Bankname;

public interface BanknameRepository extends JpaRepository<Bankname, Long>{

}
