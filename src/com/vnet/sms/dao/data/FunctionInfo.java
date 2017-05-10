package com.vnet.sms.dao.data;

import java.io.Serializable;

public class FunctionInfo implements Serializable {

	public int functionId;
	public int functionParentId;
	public String functionName;

	public FunctionInfo() {
	}

	public FunctionInfo(int functionId, int functionParentId, String functionName) {
		this.functionId = functionId;
		this.functionParentId = functionParentId;
		this.functionName = functionName;
	}

	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}

	public int getFunctionId() {
		return functionId;
	}

	public void setFunctionParentId(int functionParentId) {
		this.functionParentId = functionParentId;
	}

	public int getFunctionParentId() {
		return functionParentId;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getFunctionName() {
		return this.functionName;
	}

}