package com.citi.membership.enrollment.service;

import java.util.List;

import com.citi.membership.enrollment.dao.EnrollmentDao;
import com.citi.membership.enrollment.dao.EnrollmentDaoImpl;
import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.CardDetails;
import com.citi.membership.enrollment.model.CardDetailsResponse;
import com.citi.membership.enrollment.model.ClientInfo;
import com.citi.membership.enrollment.model.EnrollmentDaoReq;
import com.citi.membership.enrollment.model.EnrollmentDaoResp;
import com.citi.membership.enrollment.model.EnrollmentRequest;
import com.citi.membership.enrollment.model.EnrollmentResponse;
import com.citi.membership.enrollment.model.StatusBlock;
import com.citi.membership.enrollment.serviceclient.CardsServiceClient;
import com.citi.membership.enrollment.serviceclient.CardsServiceClientImpl;

public class EnrollmentServiceImpl implements EnrollmentService {

	public EnrollmentResponse createEnroll(EnrollmentRequest enrollmentReq) throws BusinessException, SystemException   {

		System.out.println("Entered into service - start");
		// 1. Get the enrollment request from controller

		// 2. prepare the request for service client
		
		// 3. call service client
           
		CardsServiceClient cardsServiceClient=new CardsServiceClientImpl();
		CardDetailsResponse cardDetailsResponse=cardsServiceClient.getCardDetails(enrollmentReq.getCustomerInfo().getCardNum());
		
		if(cardDetailsResponse !=null) {
			List<CardDetails> cardDetailsList = cardDetailsResponse.getCardDetails();
			
			for(CardDetails cardDetails : cardDetailsList) {
			String card13digit	=cardDetails.getCardNum().substring(13, 15);
			if(!"pa".equals(cardDetails.getProductType()) || !"active".equals(cardDetails.getStatus())
					|| !cardDetails.isPrimary()) {
				//TODO: handle user defined exception - you are not eligible for this enrollments
			  }
			}
		}
	    //TODO: once will get the response from card details then we need to write the below business  logic
		//one cardproducts, status, primarycard, ....etc
		//if all the checks are success then only it will call to Enrollment DAO else it will throw exception from here 
		
		
		// 4. prepare the request for dao

		EnrollmentDaoReq daoReq = new EnrollmentDaoReq();
		daoReq.setCardNum(enrollmentReq.getCustomerInfo().getCardNum());
		daoReq.setCvv(enrollmentReq.getCustomerInfo().getCvv());
		daoReq.setDob(enrollmentReq.getCustomerInfo().getDob());
		daoReq.setEmailId(enrollmentReq.getCustomerInfo().getEmailId());
		daoReq.setEnrollDate(enrollmentReq.getCustomerInfo().getEnrollDate());
		daoReq.setExpDate(enrollmentReq.getCustomerInfo().getExpDate());
		daoReq.setFirstName(enrollmentReq.getCustomerInfo().getFirstName());
		daoReq.setLastName(enrollmentReq.getCustomerInfo().getLastName());
		daoReq.setMobNum(enrollmentReq.getCustomerInfo().getMobNum());
		daoReq.setNameOnCard(enrollmentReq.getCustomerInfo().getNameOnCard());

		daoReq.setClientId(enrollmentReq.getClientInfo().getClientId());
		daoReq.setMsgTs(enrollmentReq.getClientInfo().getMsgTs());

		// 5. call dao and get the dao response

		EnrollmentDao enrollmentDao = new EnrollmentDaoImpl();
		EnrollmentDaoResp daoResp = enrollmentDao.createEnroll(daoReq);

		// 6. prepare the service response with the help of dao

		EnrollmentResponse enrollmentResponse = new EnrollmentResponse();
	
		StatusBlock statusBlock=new StatusBlock();
		statusBlock.setRespCode(daoResp.getRespCode());
		statusBlock.setRespMsg(daoResp.getRespMsg());
		
		enrollmentResponse.setStatusBlock(statusBlock);
		enrollmentResponse.setEnrollStatus(daoResp.getEnrollStatus());
		enrollmentResponse.setAckNum(daoResp.getAcknnum());
		
		System.out.println("Exit into service - end::::"+enrollmentResponse);
		return enrollmentResponse;
	}

}
