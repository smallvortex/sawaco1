package com.vnet.sms.dao.model;
// default package
// Generated Dec 18, 2014 9:53:13 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "USERS"
		, catalog = "syssmsvnet")
public class Users implements java.io.Serializable {

	private int userId;
	private String username;
	private String password;
	private Integer parentId;
	private String email;
	private Date createTime;
	private String ipAddress;
	private String company;
	private String fullname;
	private String address;
	private String question;
	private String answer;
	private String sharekey;
	private int status;
	private Boolean prepaid;
	private Byte priority;
	private Boolean brandnameNoCheck;
	private Date lastLogin;
	private Date lastModify;
	private Integer modifyId;
	private Integer createId;
	private Boolean smppEnable;
	private Boolean webSericeEnable;
	private String sessionId;
	private Boolean messageDouble;
	private Boolean emailStatistics;
	private Integer allowTypeMsg;
	private String phonelist;
	private String emailAlert;
	private int roleId;
	private String otp;
	private int accessCount;

	public Users() {
	}

	public Users(int userId, String username, String email, String fullname, int status, int roleId, int accessCount) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.fullname = fullname;
		this.status = status;
		this.roleId = roleId;
		this.accessCount = accessCount;
	}

	public Users(int userId, String username, String password, Integer parentId, String email, Date createTime, String ipAddress, String company, String fullname, String address, String question,
			String answer, String sharekey, int status, Boolean prepaid, Byte priority, Boolean brandnameNoCheck, Date lastLogin, Date lastModify, Integer modifyId, Integer createId,
			Boolean smppEnable, Boolean webSericeEnable, String sessionId, Boolean messageDouble, Boolean emailStatistics, Integer allowTypeMsg, String phonelist, String emailAlert, int roleId,
			String otp, int accessCount) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.parentId = parentId;
		this.email = email;
		this.createTime = createTime;
		this.ipAddress = ipAddress;
		this.company = company;
		this.fullname = fullname;
		this.address = address;
		this.question = question;
		this.answer = answer;
		this.sharekey = sharekey;
		this.status = status;
		this.prepaid = prepaid;
		this.priority = priority;
		this.brandnameNoCheck = brandnameNoCheck;
		this.lastLogin = lastLogin;
		this.lastModify = lastModify;
		this.modifyId = modifyId;
		this.createId = createId;
		this.smppEnable = smppEnable;
		this.webSericeEnable = webSericeEnable;
		this.sessionId = sessionId;
		this.messageDouble = messageDouble;
		this.emailStatistics = emailStatistics;
		this.allowTypeMsg = allowTypeMsg;
		this.phonelist = phonelist;
		this.emailAlert = emailAlert;
		this.roleId = roleId;
		this.otp = otp;
		this.accessCount = accessCount;
	}
    
	@Id
	@Column(name = "UserID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "Username", nullable = false)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "Password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "ParentID")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "Email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Create_Time", length = 23)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "IP_Address")
	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name = "Company")
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "Fullname", nullable = false)
	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(name = "Address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Question")
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Column(name = "Answer")
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Column(name = "Sharekey")
	public String getSharekey() {
		return this.sharekey;
	}

	public void setSharekey(String sharekey) {
		this.sharekey = sharekey;
	}

	@Column(name = "Status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "Prepaid")
	public Boolean getPrepaid() {
		return this.prepaid;
	}

	public void setPrepaid(Boolean prepaid) {
		this.prepaid = prepaid;
	}

	@Column(name = "Priority")
	public Byte getPriority() {
		return this.priority;
	}

	public void setPriority(Byte priority) {
		this.priority = priority;
	}

	@Column(name = "BrandnameNoCheck")
	public Boolean getBrandnameNoCheck() {
		return this.brandnameNoCheck;
	}

	public void setBrandnameNoCheck(Boolean brandnameNoCheck) {
		this.brandnameNoCheck = brandnameNoCheck;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Last_Login", length = 23)
	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Last_Modify", length = 23)
	public Date getLastModify() {
		return this.lastModify;
	}

	public void setLastModify(Date lastModify) {
		this.lastModify = lastModify;
	}

	@Column(name = "ModifyID")
	public Integer getModifyId() {
		return this.modifyId;
	}

	public void setModifyId(Integer modifyId) {
		this.modifyId = modifyId;
	}

	@Column(name = "CreateID")
	public Integer getCreateId() {
		return this.createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	@Column(name = "SMPP_Enable")
	public Boolean getSmppEnable() {
		return this.smppEnable;
	}

	public void setSmppEnable(Boolean smppEnable) {
		this.smppEnable = smppEnable;
	}

	@Column(name = "WebSerice_Enable")
	public Boolean getWebSericeEnable() {
		return this.webSericeEnable;
	}

	public void setWebSericeEnable(Boolean webSericeEnable) {
		this.webSericeEnable = webSericeEnable;
	}

	@Column(name = "SessionId", length = 32)
	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Column(name = "Message_Double")
	public Boolean getMessageDouble() {
		return this.messageDouble;
	}

	public void setMessageDouble(Boolean messageDouble) {
		this.messageDouble = messageDouble;
	}

	@Column(name = "Email_statistics")
	public Boolean getEmailStatistics() {
		return this.emailStatistics;
	}

	public void setEmailStatistics(Boolean emailStatistics) {
		this.emailStatistics = emailStatistics;
	}

	@Column(name = "Allow_Type_Msg")
	public Integer getAllowTypeMsg() {
		return this.allowTypeMsg;
	}

	public void setAllowTypeMsg(Integer allowTypeMsg) {
		this.allowTypeMsg = allowTypeMsg;
	}

	@Column(name = "Phonelist", length = 150)
	public String getPhonelist() {
		return this.phonelist;
	}

	public void setPhonelist(String phonelist) {
		this.phonelist = phonelist;
	}

	@Column(name = "Email_alert", length = 80)
	public String getEmailAlert() {
		return this.emailAlert;
	}

	public void setEmailAlert(String emailAlert) {
		this.emailAlert = emailAlert;
	}

	@Column(name = "RoleID", nullable = false)
	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Column(name = "OTP")
	public String getOtp() {
		return this.otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Column(name = "AccessCount", nullable = false)
	public int getAccessCount() {
		return this.accessCount;
	}

	public void setAccessCount(int accessCount) {
		this.accessCount = accessCount;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", password=" + password + ", parentId=" + parentId + ", email=" + email + ", createTime=" + createTime + ", ipAddress="
				+ ipAddress + ", company=" + company + ", fullname=" + fullname + ", address=" + address + ", question=" + question + ", answer=" + answer + ", sharekey=" + sharekey + ", status="
				+ status + ", prepaid=" + prepaid + ", priority=" + priority + ", brandnameNoCheck=" + brandnameNoCheck + ", lastLogin=" + lastLogin + ", lastModify=" + lastModify + ", modifyId="
				+ modifyId + ", createId=" + createId + ", smppEnable=" + smppEnable + ", webSericeEnable=" + webSericeEnable + ", sessionId=" + sessionId + ", messageDouble=" + messageDouble
				+ ", emailStatistics=" + emailStatistics + ", allowTypeMsg=" + allowTypeMsg + ", phonelist=" + phonelist + ", emailAlert=" + emailAlert + ", roleId=" + roleId + ", otp=" + otp
				+ ", accessCount=" + accessCount + "]";
	}

}
