package com.vnet.sms.dao.impl.loginRegister;

// default package
// Generated Oct 7, 2014 2:40:17 PM by Hibernate Tools 3.6.0

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vnet.sms.dao.DbManagerIf;
import com.vnet.sms.dao.daoIf.loginRegister.UsersDaoIf;
import com.vnet.sms.dao.model.Users;

/**
 * Home object for domain model class Users.
 * 
 * @see Users
 * @author Hibernate Tools
 */
@Transactional(value = "transactionManager")
@Repository
public class UsersDaoImpl implements UsersDaoIf, Serializable {
	private static final Log log = LogFactory.getLog(UsersDaoImpl.class);

	@Autowired
	DbManagerIf dbManager;

	public void setDB1Manager(DbManagerIf dbManager) {
		this.dbManager = dbManager;
	}

	
	public Users findUser(String userName, String password) {
		log.debug("getting Users instance with id: ");
		try {
			Criteria criteria = dbManager.getSessionFactory().getCurrentSession().createCriteria(Users.class);
			criteria.add(Restrictions.eq("username", userName));
			criteria.add(Restrictions.eq("password", password));
			Users user = (Users) criteria.uniqueResult();
			if (user == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return user;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public void persist(Users transientInstance) {
		log.debug("persisting Users instance");
		try {
			dbManager.getSessionFactory().getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Users instance) {
		log.debug("attaching dirty Users instance");
		try {
			dbManager.getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Users instance) {
		log.debug("attaching clean Users instance");
		try {
			dbManager.getSessionFactory().getCurrentSession().lock(instance,
					LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Users persistentInstance) {
		log.debug("deleting Users instance");
		try {
			dbManager.getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public Users merge(Users detachedInstance) {
		log.debug("merging Users instance");
		// System.out.println("merging Users instance:"+detachedInstance.toString());
		try {
			Users result = (Users) dbManager.getSessionFactory()
					.getCurrentSession().merge(detachedInstance);
			// System.out.println("merge successful::" + result);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Users findById(int id) {
		log.debug("getting Users instance with id: " + id);
		try {
			Users instance = (Users) dbManager.getSessionFactory()
					.getCurrentSession().get(Users.class, id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Users> findByExample(Users instance) {
		log.debug("finding Users instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Users> results = dbManager.getSessionFactory().getCurrentSession()
					.createCriteria("Users").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/**
	 * Add by BinhNH
	 * 
	 * @param username
	 */
	// Update status and otp for user
	public void updateStatusAndOTP(Users instance) {
		log.debug("Update status and otp for user");
		try {
			dbManager.getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("ok updated rememberPassword status");
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}

	}

	

	// Find password and email of an user
	public Users findPasswordEmailUser(String username) {
		log.debug("Get password and email of an user");
		try {
			Query query = dbManager.getSessionFactory()
					.getCurrentSession()
					.createQuery(
							"FROM Users u WHERE u.username = :username");
			query.setParameter("username", username);
			System.out.println(query.getQueryString());
			@SuppressWarnings("unchecked")
			List<Users> list = query.list();
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	// Check email is existed or not
	public boolean checkExistEmail(String email) {
		log.debug("Check username is existed or not");
		try {
			Query query = dbManager.getSessionFactory()
					.getCurrentSession()
					.createQuery(
							"FROM Users u WHERE u.email = :email");
			query.setParameter("email", email);
			System.out.println(query.getQueryString());
			@SuppressWarnings("unchecked")
			List<Users> list = query.list();
			if (list != null && list.size() > 0) {
				return true;
			}
			return false;
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	// Check username is existed or not
	public boolean checkExistUsername1(String userName) {
		log.debug("Check username is existed or not");
		try {
			Query query = dbManager.getSessionFactory()
					.getCurrentSession()
					.createQuery(
							"FROM Users u WHERE u.username = :username");
			query.setParameter("username", userName);
			System.out.println(query.getQueryString());
			@SuppressWarnings("unchecked")
			List<Users> list = query.list();
			if (list != null && list.size() > 0) {
				return true;
			}
			return false;
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/**
	 *  Create by vtnghia
	 */
	public Users checkExistUsername(String username) {
		Users user = null;
		try {
			Criteria criteria = dbManager.getSessionFactory().getCurrentSession().createCriteria(Users.class);
			criteria.add(Restrictions.eq("username", username));
			user = (Users) criteria.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
		return user;
	}

	// register user <=> add user record to Users in DB
	public boolean registerUser(Users user) {
		boolean result = false;
		log.debug("adding Users user");
		try {
			dbManager.getSessionFactory().getCurrentSession().persist(user);
			result = true;
			System.out.println("add successful");
		} catch (RuntimeException re) {
			log.error("add failed", re);
			throw re;
		}
		return result;
	}

	// Update rememberPassword status
	public void updateRememberPasswordStatus(Users instance) {
		log.debug("update rememberPassword status for this username");
		try {
			dbManager.getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("ok updated rememberPassword status");
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}

	}

	// Find user by (userName, rememberPassword=true) to return password
	public Users findPasswordUser(String username) {
		log.debug("getting Users instance with username = ? and rememberPassword = true");
		try {
			Query query = dbManager.getSessionFactory()
					.getCurrentSession()
					.createQuery(
							"FROM Users u WHERE u.username = :username AND u.rememberPassword = :rememberPassword");
			query.setParameter("username", username);
			query.setParameter("rememberPassword", true);
			System.out.println(query.getQueryString());
			@SuppressWarnings("unchecked")
			List<Users> list = query.list();
			// if (list != null && list.size() > 0) {
			// for (Users user : list) {
			// System.out.println(user.getUsername());
			// System.out.println(user.getPassword());
			// }
			// }
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/** end BinhNH */

	/**
	 * 
	 */
	

	/**
	 *  Create by vtnghia
	 */
	public Users findUserForUpdate(String username, String otp) {
		try {
			Criteria criteria = dbManager.getSessionFactory().getCurrentSession().createCriteria(Users.class);
			criteria.add(Restrictions.eq("username", username));
			if (otp != null) {
				criteria.add(Restrictions.eq("otp", otp));
			}
			Users user = (Users) criteria.uniqueResult();
			if (user == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return user;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/**
	 *  Create by vtnghia
	 */
	public Users updateStatusUser(Users user) {
		try {
			Users userNew = findUserForUpdate(user.getUsername(), user.getOtp());
			if (userNew == null) {
				log.debug("updateStatusUser(), no instance found");
			} else {
				log.debug("updateStatusUser(), instance found");
				System.out.println("updateStatusUser:userNew::" + userNew.toString());
				userNew.setStatus(user.getStatus());
				user = merge(user);
			}
			return userNew;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	

	@Override
	public boolean findUserName(String userName) {
		log.debug("get userName ! ");
		try {

			Query query = dbManager.getSessionFactory().getCurrentSession().createQuery("FROM Users u WHERE u.username= :username");
			query.setParameter("username", userName);
			List<Users> list = query.list();
			
			if(list.size() > 0){
				return true;
			}
			
			return false;

		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
