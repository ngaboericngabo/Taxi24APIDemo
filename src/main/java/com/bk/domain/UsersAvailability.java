package com.bk.domain;
import java.io.Serializable;
import java.sql.Timestamp;
public class UsersAvailability extends GenericDomain implements Serializable {
	  private static final long serialVersionUID = 1L;

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
	
	
	 
	 
	 
	 
	 
}
