package com.bk.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bk.domain.Users;
@Repository
public interface   IUsersRepo  extends JpaRepository <Users, Long>{
	
	/*@Query("SELECT new com.bk.dto.UserCatgoryDto(u.userId,u.fname,u.lname,u.phone,u.email,c.userCategoryId,c.userCategoryCode,c.userCategoryName,c.userCategoryDescription) "
			+ "FROM Users u, UserCategory c  where c.userCategoryCode = ?0 AND u.userId = ?1")
	   List<UserCatgoryDto> fetchUsrCatDtoDataInnerJoin();
	
	*/
}
