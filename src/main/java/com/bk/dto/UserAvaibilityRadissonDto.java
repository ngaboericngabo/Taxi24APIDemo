package com.bk.dto;

import java.sql.Timestamp;

import com.bk.domain.Users;

public class UserAvaibilityRadissonDto {
	 private long availableDriverId;
	 private long latitude;
	 private long longitude;
	 private Users users;
	 private Timestamp availableDateTime;
	 private String status;
	public long getAvailableDriverId() {
		return availableDriverId;
	}
	public void setAvailableDriverId(long availableDriverId) {
		this.availableDriverId = availableDriverId;
	}
	public long getLatitude() {
		return latitude;
	}
	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	public long getLongitude() {
		return longitude;
	}
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Timestamp getAvailableDateTime() {
		return availableDateTime;
	}
	public void setAvailableDateTime(Timestamp availableDateTime) {
		this.availableDateTime = availableDateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 
	 
	 
}
