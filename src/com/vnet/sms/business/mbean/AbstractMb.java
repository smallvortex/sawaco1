package com.vnet.sms.business.mbean;

import org.primefaces.context.RequestContext;

import com.vnet.sms.common.constant.VnetConstant;
import com.vnet.sms.common.util.JSFMessageUtil;

public class AbstractMb {

	public AbstractMb() {
		super();
	}

	protected void displayErrorMessageToUser(String message) {
		JSFMessageUtil messageUtil = new com.vnet.sms.common.util.JSFMessageUtil();
		messageUtil.sendErrorMessageToUser(message);
	}

	protected void displayInfoMessageToUser(String message) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendInfoMessageToUser(message);
	}

	protected void closeDialog() {
		getRequestContext().addCallbackParam(VnetConstant.KEEP_DIALOG_OPENED, false);
	}

	protected void keepDialogOpen() {
		getRequestContext().addCallbackParam(VnetConstant.KEEP_DIALOG_OPENED, true);
	}

	protected RequestContext getRequestContext() {
		return RequestContext.getCurrentInstance();
	}
}