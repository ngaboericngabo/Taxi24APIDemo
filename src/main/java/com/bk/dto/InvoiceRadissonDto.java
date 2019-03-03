package com.bk.dto;

import java.sql.Timestamp;

import com.bk.domain.Trip;

public class InvoiceRadissonDto {

	private long invoiceId;
	private long amount;
	private String  billNumber;
	private  String invoiceStatus;
	private Trip trip;
   private Timestamp crtdDtTime;
public long getInvoiceId() {
	return invoiceId;
}
public void setInvoiceId(long invoiceId) {
	this.invoiceId = invoiceId;
}
public long getAmount() {
	return amount;
}
public void setAmount(long amount) {
	this.amount = amount;
}
public String getBillNumber() {
	return billNumber;
}
public void setBillNumber(String billNumber) {
	this.billNumber = billNumber;
}
public String getInvoiceStatus() {
	return invoiceStatus;
}
public void setInvoiceStatus(String invoiceStatus) {
	this.invoiceStatus = invoiceStatus;
}
public Trip getTrip() {
	return trip;
}
public void setTrip(Trip trip) {
	this.trip = trip;
}
public Timestamp getCrtdDtTime() {
	return crtdDtTime;
}
public void setCrtdDtTime(Timestamp crtdDtTime) {
	this.crtdDtTime = crtdDtTime;
}

	
}
