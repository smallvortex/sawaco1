package com.vnet.sms.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;

/**
 * Implement all methods from GenericDAO as create, modify, delete, findAll,
 * findById
 * 
 * @Author 
 * @Revision
 */
public class GenericDAOImp<T, PK extends Serializable> implements
		GenericDAOInterface<T, PK> {
	private static final String ORDER_BY_STR = " ORDER BY ";
	private static final String COMMA_STR = ",";
	private static final String DESC_STR = " DESC ";

	protected Class<T> entityClass;
	DbManagerIf dbManager;
	
	@SuppressWarnings("unchecked")
	protected GenericDAOImp() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass
				.getActualTypeArguments()[0];
	}

	
	@Override
	public T create(T t) {
		dbManager.getSessionFactory().getCurrentSession().persist(t);
		return t;
	}

	
	@Override
	public T modify(T t) {
		dbManager.getSessionFactory().getCurrentSession().saveOrUpdate(t);
		return t;
	}

	
	@Override
	public void delete(T t) {
		dbManager.getSessionFactory().getCurrentSession().delete(t);;
	}

	public void deleteListMultiKey(String tableName, PK[] pkList) {
		try {
			dbManager.getSessionFactory().getCurrentSession().getTransaction()
					.begin();
			for (PK pk : pkList) {
				T t = findById(pk);
				System.out.println(pk);
				System.out.println(t);
				dbManager.getSessionFactory().getCurrentSession().delete(t);
			}
			dbManager.getSessionFactory().getCurrentSession().getTransaction()
					.commit();
		} catch (Exception ex) {
			//ex.printStackTrace();
		}
	}

	public void deleteListSingleKey(String tableName, String keyName,
			PK[] pkList) {
		try {
			dbManager.getSessionFactory().getCurrentSession().getTransaction()
					.begin();
			String keyList = "";
			for (PK pk : pkList) {
				keyList += "'" + String.valueOf(pk) + "',";
			}
			keyList = keyList.substring(0, keyList.length() - 1);
			String deleteQuery = " DELETE from " + tableName + " where "
					+ keyName + " in (" + keyList + ")";

			dbManager.getSessionFactory().getCurrentSession().createQuery(deleteQuery).executeUpdate();

			dbManager.getSessionFactory().getCurrentSession().getTransaction().commit();
		} catch (Exception ex) {
			//ex.printStackTrace();
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(String tableName, List<String> ascFields, List<String> descFields) {
		
		try {
			StringBuilder orderStringBuilder = new StringBuilder("");
			if (ascFields != null) {
				for (String ascField : ascFields) {
					if ("".equals(orderStringBuilder.toString())) {
						orderStringBuilder.append(ascField);
					} else {
						orderStringBuilder.append(COMMA_STR);
						orderStringBuilder.append(ascField);
					}
				}
			}
			if (descFields != null) {
				for (String descField : descFields) {
					if ("".equals(orderStringBuilder.toString())) {
						orderStringBuilder.append(descField);
					} else {
						orderStringBuilder.append(COMMA_STR);
						orderStringBuilder.append(descField);
					}
					orderStringBuilder.append(DESC_STR);
				}
			}
			if (orderStringBuilder.length() > 0) {
				orderStringBuilder.insert(0, ORDER_BY_STR);
			}
			StringBuilder nativeSql = new StringBuilder("SELECT * FROM ");
			nativeSql.append(tableName);
			nativeSql.append(orderStringBuilder);
			Query query = dbManager.getSessionFactory().getCurrentSession().createQuery(nativeSql.toString());
			
			List<T> resultList = (List<T>) query.list();
			return resultList;
		} catch (Exception ex) {
			//ex.printStackTrace();
			return null;
		} finally {
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByCondition(String tableName, String condition, String order) {
		System.out.println("!!!!! findByCondition");
		try {
			
			StringBuilder nativeSql = new StringBuilder("SELECT * FROM ");
			nativeSql.append(tableName);
			nativeSql.append(" where " + condition + " ");
			nativeSql.append(order);

			Query query = dbManager.getSessionFactory().getCurrentSession().createQuery(nativeSql.toString());
			List<T> list = query.list();
			
			return list;

		} catch (RuntimeException re) {
			throw re;
		}
		
	}

	
	@Override
	public void deleteByCondition(String tableName, String condition) {
		try {

			StringBuilder nativeSql = new StringBuilder("DELETE FROM ");
			nativeSql.append(tableName);
			nativeSql.append(" where " + condition);
			System.out.println(nativeSql);
			dbManager.getSessionFactory().getCurrentSession().createQuery(nativeSql.toString());

		} catch (Exception ex) {
			//ex.printStackTrace();
		}
	}

	
	@Override
	public T findById(PK id) {
		T t = null;
		try {
			t = (T) dbManager.getSessionFactory().getCurrentSession().get(entityClass, id);
		} catch (Exception ex) {
			//ex.printStackTrace();
		}
		return t;
	}
}
