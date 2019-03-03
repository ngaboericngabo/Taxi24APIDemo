package com.bk.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bk.domain.Users;
@Repository
public interface   IUsersRepo  extends JpaRepository <Users, Long>{

}
