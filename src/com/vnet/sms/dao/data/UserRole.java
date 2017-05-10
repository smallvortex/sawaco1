package com.vnet.sms.dao.data;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class UserRole implements Serializable {

	private int userId;
	private String userName;
	private String fullName;
	private String company;
	private int roleId;
	private String roleName;

	public UserRole() {
	}

	public UserRole(int userId, String userName, String fullName, String company, int roleId, String roleName) {
		this.userId = userId;
		this.fullName = fullName;
		this.company = company;
		this.roleId = roleId;
		this.roleName = roleName;
		this.userName = userName;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getuserName() {
		return this.userName;
	}
	

	public void setfullName(String fullName) {
		this.fullName = fullName;
	}

	public String getfullName() {
		return this.fullName;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompany() {
		return this.company;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

}