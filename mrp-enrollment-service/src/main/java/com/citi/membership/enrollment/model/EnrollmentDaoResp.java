package com.citi.membership.enrollment.model;

public class EnrollmentDaoResp {
	
     private String respCode;
     private String respMsg;
     private String enrollStatus;
     private String acknnum;
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public String getEnrollStatus() {
		return enrollStatus;
	}
	public void setEnrollStatus(String enrollStatus) {
		this.enrollStatus = enrollStatus;
	}
	public String getAcknnum() {
		return acknnum;
	}
	public void setAcknnum(String acknnum) {
		this.acknnum = acknnum;
	}



}



