package com.bk.dto;

/**
 * @author Eric
 *
 */
public class UserRadissonDto {
	  private long userId;
	  private String fname;
	  private String lname;
	  private String phone;
	  private String email;
	  private UserCategoryRaddissonDto userCat;
	  
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
	public UserCategoryRaddissonDto getUserCat() {
		return userCat;
	}
	public void setUserCat(UserCategoryRaddissonDto userCat) {
		this.userCat = userCat;
	}
	

	
	
}
