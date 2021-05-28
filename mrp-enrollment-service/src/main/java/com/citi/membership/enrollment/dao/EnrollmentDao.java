package com.citi.membership.enrollment.dao;

import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.EnrollmentDaoReq;
import com.citi.membership.enrollment.model.EnrollmentDaoResp;

public interface EnrollmentDao {

	public EnrollmentDaoResp createEnroll(EnrollmentDaoReq daoReq) throws BusinessException, SystemException;
	

	


	

}
