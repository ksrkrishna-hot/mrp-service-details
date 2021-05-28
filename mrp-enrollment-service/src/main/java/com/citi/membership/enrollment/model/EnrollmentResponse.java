package com.citi.membership.enrollment.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value =Include.NON_NULL)
public class EnrollmentResponse {
   
	private StatusBlock statusBlock;
	private String enrollStatus;

	private String description;
	private String ackNum;
	public String getAckNum() {
		return ackNum;
	}
	public void setAckNum(String ackNum) {
		this.ackNum = ackNum;
	}
	public StatusBlock getStatusBlock() {
		return statusBlock;
	}
	public void setStatusBlock(StatusBlock statusBlock) {
		this.statusBlock = statusBlock;
	}
	public String getEnrollStatus() {
		return enrollStatus;
	}
	public void setEnrollStatus(String enrollStatus) {
		this.enrollStatus = enrollStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
