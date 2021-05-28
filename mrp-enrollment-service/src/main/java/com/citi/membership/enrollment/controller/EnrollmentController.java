package com.citi.membership.enrollment.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.EnrollmentRequestValidationExcep;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.EnrollmentRequest;
import com.citi.membership.enrollment.model.EnrollmentResponse;
import com.citi.membership.enrollment.model.StatusBlock;
import com.citi.membership.enrollment.service.EnrollmentService;
import com.citi.membership.enrollment.service.EnrollmentServiceImpl;
import com.citi.membership.enrollment.validator.EnrollmentRequestValidator;

@RestController
@RequestMapping(value = "/customer")
@CrossOrigin(origins = "http://localhost:8080")
public class EnrollmentController {
    
	@RequestMapping(value="/enrollment", method=RequestMethod.POST ,consumes = "application/json",
			produces = "application/json" )
	@ResponseBody 
	public EnrollmentResponse createEnroll(@RequestBody EnrollmentRequest enrollmentReq) throws BusinessException, SystemException, EnrollmentRequestValidationExcep {
		
		System.out.println("Entered into controller - start");
		//1. Get the request from consumers/clients
		EnrollmentResponse  enrollmentResp;
		
			//2. Validate the request
			EnrollmentRequestValidator validator=new EnrollmentRequestValidator();
			validator.validate(enrollmentReq);
			
			//3.prepare the request for service
			
			//4. call service and get the response
			EnrollmentService service=new EnrollmentServiceImpl();
			enrollmentResp=service.createEnroll(enrollmentReq);
			
			//5.prepare the controller response
		
		
		System.out.println("Exit into controller - end");
		
		return enrollmentResp;
		
	}
	@RequestMapping(value="/health",method=RequestMethod.GET)
	public String healthCheck() {
		return "service UP and RUN";
		
	}
	
	
	
}
