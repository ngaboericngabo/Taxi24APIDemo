package com.bk.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@Table(name="Trip")
@EntityListeners(AuditingEntityListener.class)
public class Trip   implements Serializable {
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
private long TripId;
private double statLongitude;
private double statLatutide;
private double finishLongitude;
private double finishLatutide;
private Timestamp statTimeDate;
private Timestamp finishTimeDate;
private Timestamp createdTime;
private String tripStatusCode;
private String comment;
private long price;
@ManyToOne
@JoinColumn(name = "driverId")
private Users driver;
@ManyToOne
@JoinColumn(name = "rederId")
private Users rider;

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
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
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
