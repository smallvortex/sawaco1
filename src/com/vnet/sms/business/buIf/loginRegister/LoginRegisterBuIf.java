package com.vnet.sms.business.buIf.loginRegister;

import com.vnet.sms.dao.model.Users;

public interface LoginRegisterBuIf {
//findUser
	public Users findUser(String userName, String password);
	public String getInfo() ;
}
