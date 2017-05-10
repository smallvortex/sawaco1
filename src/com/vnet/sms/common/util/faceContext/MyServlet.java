package com.vnet.sms.common.util.faceContext;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	// Actions -----------------------------------------------------------------------------------

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doSomething(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doSomething(request, response);
	}

	private void doSomething(HttpServletRequest request, HttpServletResponse response) {

		// Get the FacesContext inside HttpServlet.
		FacesContext facesContext = FacesUtil.getFacesContext(request, response);

		// Now you can do your thing with the facesContext.
	}

}