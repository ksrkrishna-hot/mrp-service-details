package com.citi.membership.enrollment.exception;

public class EnrollmentRequestValidationExcep extends Exception {
	
	private String respCode;
	private String respMsg;
	public EnrollmentRequestValidationExcep(String respCode, String respMsg) {
	
		this.respCode = respCode;
		this.respMsg = respMsg;
	}
	public String getRespCode() {
		return respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	@Override
	public String toString() {
		return "EnrollmentRequestValidationExcep [respCode=" + respCode + ", respMsg=" + respMsg + "]";
	}

	
}
