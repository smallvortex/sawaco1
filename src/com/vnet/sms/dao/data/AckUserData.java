package com.vnet.sms.dao.data;

import java.util.Date;

public class AckUserData implements java.io.Serializable {
	private int userId;
	private String username;
	private String email;
	private String company;
	private String fullname;
	private String address;
	private Date createTime;
	private int status;
	private String brandname;
	private Double money;

	public AckUserData() {

	}

	public AckUserData(int userId, String username, String email, String company, String fullname, String address, Date createTime, int status, String brandname, Double money) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.company = company;
		this.fullname = fullname;
		this.address = address;
		this.createTime = createTime;
		this.status = status;
		this.brandname = brandname;
		this.money = money;

	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "AckUserData [userId=" + userId + ", username=" + username + ", email=" + email + ", createTime=" + createTime +
				", company=" + company + ", fullname=" + fullname + ", address=" + address + ", status=" + status + ", brandname=" + brandname + ", money=" + money;
	}
}
