package com.vnet.sms.dao;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "dbManager")
public class DbManager implements DbManagerIf, Serializable {

	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(DbManager.class);

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory1(SessionFactory sessionFactory1) {
		this.sessionFactory = sessionFactory1;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
