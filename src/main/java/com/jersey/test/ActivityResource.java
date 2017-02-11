package com.jersey.test;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.jersey.test.model.Activity;
import com.jersey.test.model.User;
import com.jersey.test.repository.ActivityRepository;
import com.jersey.test.repository.ActivityRepositoryStub;

@Path("activities") //http://localhost:8080/exercise-service/webapi/activities
public class ActivityResource {

	private ActivityRepository activityRepository = new ActivityRepositoryStub();
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Activity createActivityParams(MultivaluedMap<String, String> formParams){
		
		System.out.println(formParams.getFirst("description"));
		System.out.println(formParams.getFirst("duration"));
		
		Activity activity = new Activity();
		
		activity.setDescription(formParams.getFirst("description"));
		activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));
		
		activityRepository.create(activity);
		
		return activity;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities(){
		return activityRepository.findAllActivities();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("{activityId}") //http://localhost:8080/exercise-service/webapi/activities/1234
	public Activity getActivity(@PathParam("activityId") String activityId){
		return activityRepository.findActivity(activityId);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("{activityId}/user") //http://localhost:8080/exercise-service/webapi/activities/1234/user
	public User getActivityUser(@PathParam("activityId") String activityId){
		return activityRepository.findActivity(activityId).getUser();
	}
	
}
