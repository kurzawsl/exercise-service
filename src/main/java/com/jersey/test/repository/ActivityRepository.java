package com.jersey.test.repository;

import java.util.List;

import com.jersey.test.model.Activity;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findActivity(String activityId);

}