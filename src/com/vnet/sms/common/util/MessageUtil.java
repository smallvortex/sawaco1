package com.vnet.sms.common.util;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * MessageUtil
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
public class MessageUtil {

	public static void addInfoMessage(String str) {
		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle bundle = context.getApplication().getResourceBundle(context, "bundle");
		String message = bundle.getString(str);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
	}

	public static void addInfoMessage(String summary, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle bundle = context.getApplication().getResourceBundle(context, "bundle");
		String message = bundle.getString(summary);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail));
	}

	public static void addInfoMessage(String str, Object... args) {
		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle bundle = context.getApplication().getResourceBundle(context, "bundle");
		String message = bundle.getString(str);
		if (args != null) {
			message = MessageFormat.format(message, args);
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
	}

	public static void addInfoMessageWithoutKey(String summary, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
	}

	private static ResourceBundle getBundle() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getApplication().getResourceBundle(context, "bundle");
	}

	public static String getValueByBundleKey(String key) {

		String result = null;
		try {
			result = getBundle().getString(key);
			result = MessageFormat.format(result, "SomeValue");
		} catch (MissingResourceException e) {
			result = "???" + key + "??? not found";
		}

		return result;
	}

	public static String getResourceBundleString(String resourceBundleName, String resourceBundleKey) throws MissingResourceException {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, resourceBundleName);
		return bundle.getString(resourceBundleKey);
	}
}
