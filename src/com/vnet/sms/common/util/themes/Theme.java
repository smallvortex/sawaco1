package com.vnet.sms.common.util.themes;

import java.io.Serializable;

/**
 * Theme
 */
public class Theme implements Serializable {

	private static final long serialVersionUID = 20120517L;

	private String name;
	private String image;

	public Theme(String name, String image) {
		this.name = name;
		this.image = image;
	}

	public final String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}
}
