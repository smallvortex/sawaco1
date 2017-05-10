package com.vnet.sms.common.filter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.vnet.sms.common.constant.VnetConstant;
import com.vnet.sms.common.util.MessageUtil;

@FacesValidator("com.vnet.sms.common.filter.ValidatorPhone")
public class ValidatorPhone implements Validator{

	@Override
	public void validate(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		boolean checkFlag = false;
		String phoneNumber  = (String)value;
		String listPhoneError="";
		if(phoneNumber.length() >0){
	    	if(phoneNumber.indexOf(";")<0){
	    		if (!phoneNumber.matches(VnetConstant.PATTERN1) &&  !phoneNumber.matches(VnetConstant.PATTERN2)
	    				&& !phoneNumber.matches(VnetConstant.PATTERN3) && !phoneNumber.matches(VnetConstant.PATTERN4)){
	    			 checkFlag = true;
	    		}
	    	}else{
	    		if (phoneNumber.indexOf(";", phoneNumber.length() - 1) != -1){
			    	phoneNumber = phoneNumber.substring(0,phoneNumber.length() - 1);
			    }
			    String phoneStr[] = phoneNumber.split(";");
			    for (int i =0; i < phoneStr.length; i++){
			        if (!phoneStr[i].matches(VnetConstant.PATTERN1) &&  !phoneStr[i].matches(VnetConstant.PATTERN2)
			        		&& !phoneStr[i].matches(VnetConstant.PATTERN4) &&  !phoneStr[i].matches(VnetConstant.PATTERN4)){
			            if(listPhoneError.length() == 0){
			                listPhoneError = phoneStr[i];
			            }else{
			              listPhoneError  = listPhoneError +';'+ phoneStr[i];
			            }
			            checkFlag = true;
			            break;
			        }
			    }
	    	}
	    }
		if(checkFlag){
			FacesMessage msg = new FacesMessage(MessageUtil.getValueByBundleKey("FormatPhone"),MessageUtil.getValueByBundleKey("FormatPhone"));
        	msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        	throw new ValidatorException(msg);
		}
	}
}
