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
@Table(name="UsersAvailability")
@EntityListeners(AuditingEntityListener.class)
public class UsersAvailability implements Serializable {
	  private static final long serialVersionUID = 1L;
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long availableDriverId;
	 private double latitude;
	 private double longitude;
	 private Timestamp availableDateTime;
	 private String status;
	 @ManyToOne
	 @JoinColumn(name = "userId")
	 private Users users;
	 
	public long getAvailableDriverId() {
		return availableDriverId;
	}
	public void setAvailableDriverId(long availableDriverId) {
		this.availableDriverId = availableDriverId;
	}

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
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
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
	
	
	 
	
	 
	 
	 
	 
}
