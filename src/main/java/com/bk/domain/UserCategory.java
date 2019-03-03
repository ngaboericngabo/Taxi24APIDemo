package com.bk.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@Table(name="UserCategory")
@EntityListeners(AuditingEntityListener.class)
public class UserCategory  implements Serializable  {
	  private static final long serialVersionUID = 1L;
	  @Id
      @GeneratedValue(strategy =GenerationType.AUTO)
	 private long userCategoryId;
	 private String userCategoryCode;
	 private String userCategoryName;
	 private String userCategoryDescription;
	

	public long getUserCategoryId() {
		return userCategoryId;
	}
	public void setUserCategoryId(long userCategoryId) {
		this.userCategoryId = userCategoryId;
	}
	public String getUserCategoryCode() {
		return userCategoryCode;
	}
	public void setUserCategoryCode(String userCategoryCode) {
		this.userCategoryCode = userCategoryCode;
	}
	public String getUserCategoryName() {
		return userCategoryName;
	}
	public void setUserCategoryName(String userCategoryName) {
		this.userCategoryName = userCategoryName;
	}
	public String getUserCategoryDescription() {
		return userCategoryDescription;
	}
	public void setUserCategoryDescription(String userCategoryDescription) {
		this.userCategoryDescription = userCategoryDescription;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	 
}
