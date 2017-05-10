package com.vnet.sms.business.Impl.loginRegister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnet.sms.business.buIf.loginRegister.LoginRegisterBuIf;
import com.vnet.sms.dao.daoIf.loginRegister.UsersDaoIf;
import com.vnet.sms.dao.model.Users;

//@Service – annotate classes at service layer level.
@Service
public class LoginRegisterBuImpl implements LoginRegisterBuIf {

	// DI via Spring
	@Autowired
	UsersDaoIf usersDaoImpl;

	public void setTblUsersDaoImpl(UsersDaoIf usersDaoImpl) {
		this.usersDaoImpl = usersDaoImpl;
	}

	@Override
	public Users findUser(String userName, String password) {
		return usersDaoImpl.findUser(userName, password);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "Jersey + Spring!!!";
	}
    

}
