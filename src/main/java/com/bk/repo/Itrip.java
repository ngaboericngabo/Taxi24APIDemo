package com.bk.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bk.model.Trip;

   /**
 * @author Eric
 *
 */
@Repository
	public interface  Itrip  extends JpaRepository <Trip, Long> {
	
	@Query("SELECT t FROM Trip t WHERE t.tripStatusCode=?1")
	List<Trip> findTripByTripStatusCode(String tripStatusCode);
		
}
