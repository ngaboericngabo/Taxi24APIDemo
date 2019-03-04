package com.bk.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bk.model.UsersAvailability;

/**
 * @author Eric
 *
 */
@Repository
public interface  IAvailability  extends JpaRepository <UsersAvailability, Long> {
	
	@Query("SELECT u,c,a FROM Users u,UserCategory c, UsersAvailability a WHERE a.users=u.userId and c.userCategoryId=u.userCat AND  c.userCategoryCode=?1 and a.status=?2")
	List<Object[]> findUserByUserCategoryCodeAndSatus(String userCategoryCode,String status);

}
