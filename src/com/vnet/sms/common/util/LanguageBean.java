package com.vnet.sms.common.util;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "language")
@SessionScoped
public class LanguageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Locale VIETNAMESE = Locale.forLanguageTag("vi");
	// private String localeCode;
	private Locale locale;

	private static Map<String, Object> countries;
	static {
		countries = new LinkedHashMap<String, Object>();
		countries.put("English", Locale.ENGLISH); // label, value
		countries.put("VietNamese", VIETNAMESE);
	}

	@PostConstruct
	public void init() {
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	}

	public Map<String, Object> getCountriesInMap() {
		return countries;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	// public String getSelectedLocale() {
	// return getLocaleCode();
	// }

	public void setSelectedLocale() {
		//System.out.println("setSelectedLocale==="+locale.getCountry()+"/"+locale.getDisplayLanguage()+"/"+locale);
		String newLocaleValue = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("locale");
		//System.out.println("newLocaleValue==="+newLocaleValue);
		for (Map.Entry<String, Object> entry : countries.entrySet()) {
			if (entry.getValue().toString().equals(newLocaleValue)) {
				setLocale((Locale) entry.getValue());
				FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
				FacesContext.getCurrentInstance().getELContext().setLocale(locale);
				FacesContext.getCurrentInstance().getApplication().setDefaultLocale(locale);

			}
		}
	}

}