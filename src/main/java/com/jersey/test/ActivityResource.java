package com.jersey.test;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jersey.test.model.Activity;
import com.jersey.test.repository.ActivityRepository;
import com.jersey.test.repository.ActivityRepositoryStub;

@Path("activities")
public class ActivityResource {

	private ActivityRepository activityRepository = new ActivityRepositoryStub();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activity> getAllActivities(){
		return activityRepository.findAllActivities();
	}
	
}
