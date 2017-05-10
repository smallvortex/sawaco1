package com.vnet.sms.common.util.hql;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.ResultTransformer;

import com.vnet.sms.dao.data.UserRole;

public class UserRoleDataTransformer implements ResultTransformer {

	/*
	Method to convert to generic type list
	*/
	@Override
	public List<UserRole> transformList(List arg0) {
		List<UserRole> resultList = new ArrayList<UserRole>();
		for (Object fr : arg0) {
			resultList.add((UserRole) fr);
		}
		return resultList;
	}

	/*
	Code to transform your query output to Object
	*/
	@Override
	public UserRole transformTuple(Object[] arg0, String[] arg1) {
		System.out.println("UserRoleDataTransformer.transformTuple()");
		UserRole tempUserRole = new UserRole();
		tempUserRole.setUserId((Integer) arg0[0]);
		tempUserRole.setUserName((String) arg0[1]);
		tempUserRole.setfullName((String) arg0[2]);
		tempUserRole.setCompany((String) arg0[3]);
		tempUserRole.setRoleId((Integer) arg0[4]);
		tempUserRole.setRoleName((String) arg0[5]);
		return tempUserRole;
	}
}