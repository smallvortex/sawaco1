package com.vnet.sms.business.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vnet.sms.business.buIf.loginRegister.LoginRegisterBuIf;


@Component
@Path("/testService")
public class TestService {

    @Autowired
    LoginRegisterBuIf loginRegisterBuIf;
    public void setLoginImpl(LoginRegisterBuIf loginRegisterBuIf) {
		this.loginRegisterBuIf = loginRegisterBuIf;
	}

    @GET
    @Path("/getInfo")
    public Response getInfo() {

	String result = loginRegisterBuIf.getInfo();
	return Response.status(200).entity(result).build();

    }

   
}