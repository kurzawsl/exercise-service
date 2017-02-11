package com.jersey.test.repository;

import java.util.ArrayList;
import java.util.List;

import com.jersey.test.model.Activity;
import com.jersey.test.model.User;

public class ActivityRepositoryStub implements ActivityRepository {

	/* (non-Javadoc)
	 * @see com.jersey.test.repository.ActivityRepository#findAllActivities()
	 */
	@Override
	public List<Activity> findAllActivities(){
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity activity1 = new Activity();
		activity1.setDescription("Swimming");
		activity1.setDuration(55);
		
		activities.add(activity1);
		
		Activity activity2 = new Activity();
		activity2.setDescription("Cycling");
		activity2.setDuration(120);
		
		activities.add(activity2);
		
		return activities;
	}

	@Override
	public Activity findActivity(String activityId) {
		
		if(activityId.equals("7777")){
			return null;
		}
		
		Activity activity1 = new Activity();
		activity1.setId("1234");
		activity1.setDescription("Swimming");
		activity1.setDuration(55);
		
		User user = new User();
		user.setId("678");
		user.setName("Lukasz");
		
		activity1.setUser(user);
		
		return activity1;
	}

	@Override
	public void create(Activity activity) {
		
	}
	
}
