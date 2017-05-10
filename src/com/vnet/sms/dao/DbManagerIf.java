package com.vnet.sms.dao;

import org.hibernate.SessionFactory;

public interface DbManagerIf {

	public SessionFactory getSessionFactory();
}
