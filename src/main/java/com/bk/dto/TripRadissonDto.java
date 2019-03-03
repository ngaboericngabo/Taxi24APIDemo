package com.bk.dto;

import java.sql.Timestamp;

import com.bk.domain.Users;

public class TripRadissonDto {
	
	private long TripId;
	private double statLongitude;
	private double statLatutide;
	private double finishLongitude;
	private double finishLatutide;
	private Timestamp statTimeDate;
	private Timestamp finishTimeDate;
	private Users driver;
	private Users rider;
	private String tripStatusCode;
	private long price;
	private Timestamp createdTime;
	
	public long getTripId() {
		return TripId;
	}
	public void setTripId(long tripId) {
		TripId = tripId;
	}
	public void setFinishLatutide(long finishLatutide) {
		this.finishLatutide = finishLatutide;
	}
	public Timestamp getStatTimeDate() {
		return statTimeDate;
	}
	public void setStatTimeDate(Timestamp statTimeDate) {
		this.statTimeDate = statTimeDate;
	}
	public Timestamp getFinishTimeDate() {
		return finishTimeDate;
	}
	public void setFinishTimeDate(Timestamp finishTimeDate) {
		this.finishTimeDate = finishTimeDate;
	}
	public Users getDriver() {
		return driver;
	}
	public void setDriver(Users driver) {
		this.driver = driver;
	}
	public Users getRider() {
		return rider;
	}
	public void setRider(Users rider) {
		this.rider = rider;
	}
	public String getTripStatusCode() {
		return tripStatusCode;
	}
	public void setTripStatusCode(String tripStatusCode) {
		this.tripStatusCode = tripStatusCode;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public double getStatLongitude() {
		return statLongitude;
	}
	public void setStatLongitude(double statLongitude) {
		this.statLongitude = statLongitude;
	}
	public double getStatLatutide() {
		return statLatutide;
	}
	public void setStatLatutide(double statLatutide) {
		this.statLatutide = statLatutide;
	}
	public double getFinishLongitude() {
		return finishLongitude;
	}
	public void setFinishLongitude(double finishLongitude) {
		this.finishLongitude = finishLongitude;
	}
	public double getFinishLatutide() {
		return finishLatutide;
	}
	public void setFinishLatutide(double finishLatutide) {
		this.finishLatutide = finishLatutide;
	}
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	
	
	
	
}
