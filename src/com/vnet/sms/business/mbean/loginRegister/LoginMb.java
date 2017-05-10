package com.vnet.sms.business.mbean.loginRegister;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vnet.sms.business.buIf.loginRegister.LoginRegisterBuIf;
import com.vnet.sms.business.mbean.AbstractMb;
import com.vnet.sms.common.constant.VnetConstant;
import com.vnet.sms.dao.model.Users;

@RequestScoped
@ManagedBean(name = "loginMb")
@Component(value = "loginMb")
public class LoginMb extends AbstractMb {
	//You can define your own Spring Services by using @Component. That will be scanned automatically.
	// Dependency Injection via Spring
	@Autowired
	LoginRegisterBuIf loginImpl;

	// @ManagedProperty(value = UserMb.INJECTION_NAME)
	// private UserMb userMb;

	private String username;
	private String password;
	private Users user;

	private String oldPassword;
	private String newPassword;
	private String confirmNewPassword;
	private boolean disableButton = false;
	private int resultLogin;
	
	public void setLoginImpl(LoginRegisterBuIf loginImpl) {
		this.loginImpl = loginImpl;
	}
	
	// public void setUserMb(UserMb userMb) {
	// this.userMb = userMb;
	// }





	/**
	 * Add by TungNS
	 * Updated by BinhNH
	 * Update by nghiavt [2014.11.24]
	 */
	public String login() {
		resultLogin = 0;
		System.out.println("user info login=="+username+"/"+password);
		user = loginImpl.findUser(username,password);
		System.out.println("user infor after=="+user);
		if (user == null) {
			displayErrorMessageToUser("Check your email/password");
			resultLogin = VnetConstant.USER_REJECT;
			return VnetConstant.PAGE_LOGIN + VnetConstant.REDIRECT_TRUE;
		}
		else {
			return VnetConstant.PAGE_WELCOME + VnetConstant.REDIRECT_TRUE;
		}

	}

	/** end update */

	public String logOut() {
		//Method invalidate on session object just clean session data.
		//Method logout on request object establish null as the value returned when getUserPrincipal, getRemoteUser, and getAuthType is called on the request.
		try{
			resultLogin = 0;
			getRequest().getSession().invalidate();
			getRequest().getSession().removeAttribute("user");
			getRequest().logout();
			getRequest().getSession().setMaxInactiveInterval(0);
			System.out.println("logout::"+getRequest().getSession().getAttribute("user"));
			getRespone().setHeader("Set-Cookie", "Expires=" + new Date().getTime() + ";");
			return VnetConstant.HOME_PAGE + VnetConstant.PAGE_REDIRECT;
		}catch (Exception e) {
			e.printStackTrace();
			return VnetConstant.HOME_PAGE + VnetConstant.PAGE_REDIRECT;
		}
	}

	/**
	 * 
	 * @return
	 */
//	public String changePassword() {
//		Users user = (Users) CommonUtils.getInstance().getSessionAttribute("user");
//		//System.out.println("changePassword user " + user);
//		System.out.println("changePassword oldPassword " + oldPassword);
//		System.out.println("changePassword newPassword " + newPassword);
//		System.out.println("changePassword confirmNewPassword " + confirmNewPassword);
//		if (user == null) {
//			return "/public/login.xhtml";
//		}
//		if (newPassword == null || confirmNewPassword == null || newPassword.isEmpty() || confirmNewPassword.isEmpty()) {
//			return VnetConstant.PAGE_CHANGE_PASSWORD;
//		}
//		if (!user.getPassword().equals(CommonUtils.getInstance().encodeMD5(oldPassword).toUpperCase())) {
//			return VnetConstant.PAGE_CHANGE_PASSWORD;
//		}
//		user.setPassword(CommonUtils.getInstance().encodeMD5(newPassword).toUpperCase());
//		user.setStatus(VnetConstant.USER_ACTIVATE);
//		//System.out.println("changePassword user new " + user);
//		user = loginImpl.merge(user);
//		
//		//System.out.println("changePassword user completed: " + user);
//		if(user!=null){
//			return VnetConstant.PAGE_SUCCESS + VnetConstant.REDIRECT_TRUE;
//		}else{
//			return VnetConstant.PAGE_CHANGE_PASSWORD  + VnetConstant.REDIRECT_TRUE;
//		}
//		
//	}

	/**
	 * create by vtnghia
	 * @param event
	 */
	public void checkNewPassWord1(AjaxBehaviorEvent event) {
		System.out.println("checkNewPassWord1()...........");
		if ((newPassword != null && !"".equals(newPassword))) {
			if (user.getPassword().equals(newPassword)) {
				System.out.println("Mật Khẩu giống mật khẩu cũ.");
				disableButton = true;
			} else {
				disableButton = false;
			}
		}
		System.out.println("checkNewPassWord1()...........newPassword/user.getPasswords():::" + newPassword + "/" + user.getPassword() + "///" + disableButton);
		// System.out.println("handleEvent2().....statusEmail=="+statusEmail);
	}

	/**
	 * create by vtnghia
	 * @param event
	 */
	public void checkNewPassWord(AjaxBehaviorEvent event) {
		System.out.println("checkNewPassWord()...........");
		if ((newPassword != null && !"".equals(newPassword))) {
			if (!confirmNewPassword.equals(newPassword)) {
				System.out.println("Mật Khẩu không trùng nhau.");
				disableButton = true;
			} else {
				disableButton = false;
			}
		}
		// System.out.println("handleEvent2().....statusEmail=="+statusEmail);
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}

	public boolean isDisableButton() {
		return disableButton;
	}

	public void setDisableButton(boolean disableButton) {
		this.disableButton = disableButton;
	}

	public int getResultLogin() {
		return resultLogin;
	}

	public void setResultLogin(int resultLogin) {
		this.resultLogin = resultLogin;
	}
	/**
	 * 
	 * @return
	 */
	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
    private HttpServletResponse getRespone(){
    	return (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
    }
}