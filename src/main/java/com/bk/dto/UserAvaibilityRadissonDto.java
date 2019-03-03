package com.bk.dto;

import java.sql.Timestamp;

import com.bk.domain.Users;

public class UserAvaibilityRadissonDto {

	 private double latitude;
	 private double longitude;
	 private UserRadissonDto userRadissonDto;
	 private Timestamp availableDateTime;
	 private String status;
	 private double distance;
	

	public void setLongitude(long longitude) {
		this.longitude = longitude;
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
	public UserRadissonDto getUserRadissonDto() {
		return userRadissonDto;
	}
	public void setUserRadissonDto(UserRadissonDto userRadissonDto) {
		this.userRadissonDto = userRadissonDto;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	 
	 
	 
}
