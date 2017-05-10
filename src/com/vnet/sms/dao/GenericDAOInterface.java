package com.vnet.sms.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Define create, modify, delete, findAll, findById methods
 * 
 * @Author 
 * @Revision 
 */
public interface GenericDAOInterface<T, PK extends Serializable> {
	/**
	 * Create a object
	 * 
	 * @param t object
	 * @return t object
	 */
	public T create(T t);

	/**
	 * Modify object
	 * 
	 * @param t object
	 * @return t object
	 */
	public T modify(T t);

	/**
	 * Delete t object
	 * 
	 * @param t object
	 */
	public void delete(T t);

	/**
	 * Find all objects of table and sort them
	 * 
	 * @param tableName
	 *            table to select
	 * @param ascFields
	 *            list of fields are sorted in ascending order
	 * @param descFields
	 *            list of fields are sorted in descending order
	 * @return List of objects or null
	 */
	public List<T> findAll(String tableName, List<String> ascFields, List<String> descFields);
	
	/**
	 * Find all objects of table and sort them
	 * 
	 * @param tableName
	 *            table to select
	 * @param condition
	 *            Select condition
	 * @param order
	 *            Order clause
	 * @return List of objects or null
	 */
	public List<T> findByCondition(String tableName, String condition, String order);
	
	/**
	 * Delete objects of table by condition
	 * 
	 * @param tableName
	 *            table to select
	 * @param condition
	 * @return void
	 */
	public void deleteByCondition(String tableName, String condition);
	
	/**
	 * Find object by id
	 * 
	 * @return object or null
	 */
	public T findById(PK id);
}
