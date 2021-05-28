package com.citi.membership.enrollment.model;

public class EnrollmentRequest {
      
	private ClientInfo clientInfo;
	private CustomerInfo customerInfo;
	public ClientInfo getClientInfo() {
		return clientInfo;
	}
	public void setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
	}
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	
	
	
}
