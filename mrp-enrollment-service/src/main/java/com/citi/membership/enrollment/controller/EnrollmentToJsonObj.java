package com.citi.membership.enrollment.controller;

import com.citi.membership.enrollment.model.ClientInfo;
import com.citi.membership.enrollment.model.CustomerInfo;
import com.citi.membership.enrollment.model.EnrollmentRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EnrollmentToJsonObj {

	public static void main(String[] args) throws JsonProcessingException {

		EnrollmentRequest enrollmentRequest = new EnrollmentRequest();

		ClientInfo clientInfo = new ClientInfo();
		clientInfo.setClientId("web");
		clientInfo.setChannelId("online");
		clientInfo.setReqId("abc123xyz");
		clientInfo.setMsgTs("29-04-2021");

		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setCardNum("123567875");
		customerInfo.setCvv("567");
		customerInfo.setDob("28-04-1996");
		customerInfo.setEmailId("sivakrishna9840@gmail.com");
		customerInfo.setEnrollDate("01-01-2000");
		customerInfo.setExpDate("12-2022");
		customerInfo.setFirstName("siva");
		customerInfo.setLastName("krishna");
		customerInfo.setMobNum("8374869014");
		customerInfo.setNameOnCard("siva");

		enrollmentRequest.setClientInfo(clientInfo);

		enrollmentRequest.setCustomerInfo(customerInfo);
		
		ObjectMapper objectMapper=new ObjectMapper();
		
		 String resp=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(enrollmentRequest);
		 System.out.println(resp);
		 
	}

}
