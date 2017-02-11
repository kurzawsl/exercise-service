package com.jersey.test.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.jersey.test.model.Activity;

public class ActivityClient {

	private Client client;
	
	public ActivityClient(){
		client = ClientBuilder.newClient();
	}
	
	public Activity get(String id){
		
		WebTarget target = client.target("http://localhost:8080/exercise-service/webapi/");
		
		Activity response = target.path("activities/" + id).request().get(Activity.class);
		
		return response;
	}
	
}
