package com.bk.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bk.domain.Trip;
@Repository
	public interface  Itrip  extends JpaRepository <Trip, Long> {
		
}
