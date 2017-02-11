package com.jersey.test;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jersey.test.model.Activity;
import com.jersey.test.repository.ActivityRepository;
import com.jersey.test.repository.ActivityRepositoryStub;

@Path("activities") //http://localhost:8080/exercise-service/webapi/activities
public class ActivityResource {

	private ActivityRepository activityRepository = new ActivityRepositoryStub();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities(){
		return activityRepository.findAllActivities();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("{activityId}") //http://localhost:8080/exercise-service/webapi/activities/1234
	public Activity getActivit(@PathParam("activityId") String activityId){
		return activityRepository.findActivity(activityId);
	}
	
}
