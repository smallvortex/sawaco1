package com.vnet.sms.common.util.hql;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.ResultTransformer;

import com.vnet.sms.dao.data.FunctionInfo;

public class FunctionsDataTransformer implements ResultTransformer {

	/*
	Method to convert to generic type list
	*/
	@Override
	public List<FunctionInfo> transformList(List arg0) {
		List<FunctionInfo> resultList = new ArrayList<FunctionInfo>();
		for (Object obj : arg0) {
			resultList.add((FunctionInfo) obj);
		}
		return resultList;
	}

	/*
	Code to transform your query output to Object
	*/
	@Override
	public FunctionInfo transformTuple(Object[] arg0, String[] arg1) {
		System.out.println("FunctionsByUserIdDataTransformer.transformTuple()");
		FunctionInfo temp = new FunctionInfo();
		temp.setFunctionId((Integer) arg0[0]);
		temp.setFunctionName((String) arg0[1]);
		temp.setFunctionParentId((Integer) arg0[2]);
		return temp;
	}
}