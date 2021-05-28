package com.citi.membership.enrollment.dao;


import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.EnrollmentDaoReq;
import com.citi.membership.enrollment.model.EnrollmentDaoResp;

public class EnrollmentDaoImpl implements EnrollmentDao {


	public EnrollmentDaoResp createEnroll(EnrollmentDaoReq daoReq) throws BusinessException, SystemException  {
		
		System.out.println("Entered into dao - start");
	    //1. get the request from service
		
		//2.prepare the request for database .i.e. prepare the database queries
		
		EnrollmentDaoResp daoRes = null;
		try {
			//3. call db and get the db response .i.e. ResultSet
			
			String dbRespCode="0";  //database response . replace this value with db response later
			String dbRespMsg="success";  //database response . replace this value with db response later
			//4. prepare the dao response
			
			daoRes = new EnrollmentDaoResp();
			
			if("0".equals(dbRespCode)) {
				//TODO :replace the hard code values with database response
			daoRes.setAcknnum("12123abc");
			daoRes.setEnrollStatus("enrollment successful");
			daoRes.setRespCode("0");
			daoRes.setRespMsg("success");
			}else if("100".equals(dbRespCode) || "101".equals(dbRespCode) || "102".equals(dbRespCode)) {
			
				//todo : handle business exceptions
				throw new BusinessException(dbRespCode, dbRespMsg);
			}else {
				//todo : handle system exceptions
				throw new SystemException(dbRespCode, dbRespMsg);
			}
		} catch (BusinessException be) {
			//error log
			be.printStackTrace();
			throw be;
		} catch (SystemException se) {
			//error log
			se.printStackTrace();
			throw se;
		}catch(Exception e) {
			throw new SystemException("8888", "Unknown Error from databse"+e.getMessage());
		}
		
		System.out.println("Exit into dao - end:::::"+daoRes);
		return daoRes;
	}

	
	

}
