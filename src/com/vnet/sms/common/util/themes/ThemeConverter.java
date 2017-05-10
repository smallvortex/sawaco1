package com.vnet.sms.common.util.themes;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * ThemeConverter
 *
 */
@FacesConverter("com.vnet.sms.common.util.themes.ThemeConverter")
public class ThemeConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return AvailableThemes.instance().getTheme(value);
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return ((Theme) value).getName();
	}
}
