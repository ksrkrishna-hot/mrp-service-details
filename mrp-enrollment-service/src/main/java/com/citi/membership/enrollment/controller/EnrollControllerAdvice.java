package com.citi.membership.enrollment.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.EnrollmentRequestValidationExcep;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.EnrollmentResponse;
import com.citi.membership.enrollment.model.StatusBlock;
import com.citi.membership.enrollment.util.EnrollmentConsatnt;

@ControllerAdvice
public class EnrollControllerAdvice {
	
	@ExceptionHandler(value = EnrollmentRequestValidationExcep.class)
	@ResponseBody
   public EnrollmentResponse handleReqInvalidException(EnrollmentRequestValidationExcep excep) {
		EnrollmentResponse enrollmentResponse = buildStatusBlock(excep);
	return enrollmentResponse;
	   
   }

	private EnrollmentResponse buildStatusBlock(EnrollmentRequestValidationExcep excep) {
		//Todo: need to implement error logs
		EnrollmentResponse enrollmentResponse = buildStatusBlock(excep.getRespCode(),excep.getRespMsg());
		return enrollmentResponse;
	}
	
	@ExceptionHandler(value = BusinessException.class)
	@ResponseBody
   public EnrollmentResponse handleDataError(BusinessException be) {
		
		
		EnrollmentResponse enrollmentResponse = buildStatusBlock(be.getRespCode(),be.getRespMsg());
	return enrollmentResponse;
	
	   
   }
	
	@ExceptionHandler(value = SystemException.class)
	@ResponseBody
   public EnrollmentResponse handleSystemError(SystemException se) {
		
		EnrollmentResponse enrollmentResponse = buildStatusBlock(se.getRespCode(),se.getRespMsg());
	return enrollmentResponse;
	   
   }
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
   public EnrollmentResponse handleDataError(Exception e) {
		
		
		EnrollmentResponse enrollmentResponse = buildStatusBlock(EnrollmentConsatnt.GENERIC_ERROR_CODE,EnrollmentConsatnt.GENERIC_ERROR_MSG);
	return enrollmentResponse;
	
	   
   }

	private EnrollmentResponse buildStatusBlock(String respCode , String respMsg) {
		EnrollmentResponse enrollmentResponse=new EnrollmentResponse();
		StatusBlock statusBlock=new StatusBlock();
		statusBlock.setRespCode(respCode);
		statusBlock.setRespMsg(respMsg);
		
		enrollmentResponse.setStatusBlock(statusBlock);
		return enrollmentResponse;
	}
}
