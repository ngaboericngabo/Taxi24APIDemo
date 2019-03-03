package com.bk.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="Users")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Users implements Serializable  {
	private static final long serialVersionUID = 1L;
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long userId;
	 @NotBlank
	  private String fname;
	 @NotBlank
	  private String lname;
	 @NotBlank
	  private String phone;
	 @NotBlank
	  private String email;
	
	 @ManyToOne
	  @JoinColumn(name = "userCategoryId")
	   
	   private UserCategory userCat;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserCategory getUserCat() {
		return userCat;
	}
	public void setUserCat(UserCategory userCat) {
		this.userCat = userCat;
	}
	

	  
	  
}
