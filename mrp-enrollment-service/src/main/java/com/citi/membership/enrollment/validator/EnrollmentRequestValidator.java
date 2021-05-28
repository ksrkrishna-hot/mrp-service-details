package com.citi.membership.enrollment.validator;

import com.citi.membership.enrollment.exception.EnrollmentRequestValidationExcep;
import com.citi.membership.enrollment.model.ClientInfo;
import com.citi.membership.enrollment.model.CustomerInfo;
import com.citi.membership.enrollment.model.EnrollmentRequest;
import com.citi.membership.enrollment.util.EnrollmentConsatnt;

public class EnrollmentRequestValidator {

	public void validate(EnrollmentRequest enrollmentReq) throws EnrollmentRequestValidationExcep {
		// TODO :Validate the request.If any one of the element is invalid then send
		// exception
		// Need to handle user defined exception.

		if (enrollmentReq == null || enrollmentReq.getClientInfo() == null || enrollmentReq.getCustomerInfo() == null) {

			throw new EnrollmentRequestValidationExcep(EnrollmentConsatnt.ENS001, EnrollmentConsatnt.ENS001_DESC);
		}

		ClientInfo clientInfo = enrollmentReq.getClientInfo();
		// client id null or empty scenarios
		if (clientInfo.getClientId() == null || "".equals(clientInfo.getClientId())) {
			throw new EnrollmentRequestValidationExcep(EnrollmentConsatnt.ENS002, EnrollmentConsatnt.ENS002_DESC);
		}

		// channel id null or empty scenarios
		if (clientInfo.getChannelId() == null || "".equals(clientInfo.getChannelId())) {
			throw new EnrollmentRequestValidationExcep(EnrollmentConsatnt.ENS003, EnrollmentConsatnt.ENS003_DESC);
		}

		CustomerInfo customerInfo = enrollmentReq.getCustomerInfo();
		// channel id null or empty scenarios
		if (customerInfo.getCardNum() == null || "".equals(customerInfo.getCardNum())) {
			throw new EnrollmentRequestValidationExcep(EnrollmentConsatnt.ENS004, EnrollmentConsatnt.ENS004_DESC);
		}
	}

}
