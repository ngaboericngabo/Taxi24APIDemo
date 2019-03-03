package com.bk.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bk.domain.UsersAvailability;
@Repository
public interface  IAvailability  extends JpaRepository <UsersAvailability, Long> {
	
	

}
