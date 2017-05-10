package com.vnet.sms.dao.daoIf.loginRegister;

import com.vnet.sms.dao.model.Users;

public interface UsersDaoIf {

	Users findUser(String userName, String password);
	public Users updateStatusUser(Users user);
	public Users merge(Users user) ;
	public Users checkExistUsername(String userName);

	boolean findUserName(String userName);
}
