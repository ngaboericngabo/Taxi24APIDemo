package com.bk.domain;

import java.sql.Timestamp;

public class GenericDomain {
	  private static final long serialVersionUID = -6665275582900585705L;

	  public GenericDomain() {

	  }

	  private String createdBy;
	
	  private Timestamp crtdDtTime;


	  private Timestamp optLock;

	  private Timestamp upDtTime;

	
	  private String updatedBy;

	  public String getCreatedBy() {
	    return this.createdBy;
	  }

	  public void setCreatedBy(String createdBy) {
	    this.createdBy = createdBy;
	  }

	 

	  public String getUpdatedBy() {
	    return this.updatedBy;
	  }

	  public void setUpdatedBy(String updatedBy) {
	    this.updatedBy = updatedBy;
	  }

	public Timestamp getCrtdDtTime() {
		return crtdDtTime;
	}

	public void setCrtdDtTime(Timestamp crtdDtTime) {
		this.crtdDtTime = crtdDtTime;
	}

	public Timestamp getOptLock() {
		return optLock;
	}

	public void setOptLock(Timestamp optLock) {
		this.optLock = optLock;
	}

	public Timestamp getUpDtTime() {
		return upDtTime;
	}

	public void setUpDtTime(Timestamp upDtTime) {
		this.upDtTime = upDtTime;
	}
	  
	  
	  
}
