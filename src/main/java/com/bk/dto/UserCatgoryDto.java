package com.bk.dto;

/**
 * @author Eric
 *
 */
public class UserCatgoryDto {
	private long userId;
	private String fname;
	private String lname;
	private String phone;
	private String email;

	private long userCategoryId;
	private String userCategoryCode;
	private String userCategoryName;
	private String userCategoryDescription;

	public UserCatgoryDto(long userId, String fname, String lname, String phone, String email, long userCategoryId,
			String userCategoryCode, String userCategoryName, String userCategoryDescription) {
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.email = email;
		this.userCategoryId = userCategoryId;
		this.userCategoryCode = userCategoryCode;
		this.userCategoryName = userCategoryName;
		this.userCategoryDescription = userCategoryDescription;
	}

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
	

}
