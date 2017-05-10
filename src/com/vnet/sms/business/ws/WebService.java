package com.vnet.sms.business.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vnet.sms.business.buIf.loginRegister.LoginRegisterBuIf;


@Component
@Path("/ws")
public class WebService {


    @GET
    @Path("/getInfo")
    public Response getInfo() {

	String result = "nghiavt";
	return Response.status(200).entity(result).build();

    }

   
}