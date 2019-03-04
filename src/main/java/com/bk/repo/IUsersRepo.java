package com.bk.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bk.model.Users;

/**
 * @author Eric
 *
 */
@Repository
public interface IUsersRepo extends JpaRepository<Users, Long> {

	@Query("SELECT u FROM Users u WHERE u.userId = ?1")
	Users findUserByUserId(Long userId);

	@Query("SELECT u,c FROM Users u,UserCategory c WHERE c.userCategoryId=u.userCat AND u.userId = ?1 and c.userCategoryCode= ?2")
	Users findUserByUserIdAndUserCategoryCode(Long userId, String userCategoryCode);

	@Query("SELECT u,c FROM Users u,UserCategory c WHERE c.userCategoryId=u.userCat AND  c.userCategoryCode=?1")
	List<Object[]> findUserByUserCategoryCode(String userCategoryCode);

	/*
	 * @Query("SELECT new com.bk.dto.UserCatgoryDto(u.userId,u.fname,u.lname,u.phone,u.email,c.userCategoryId,c.userCategoryCode,c.userCategoryName,c.userCategoryDescription) "
	 * +
	 * "FROM Users u, UserCategory c  where c.userCategoryCode = ?0 AND u.userId = ?1"
	 * ) List<UserCatgoryDto> fetchUsrCatDtoDataInnerJoin();
	 * 
	 */
}
