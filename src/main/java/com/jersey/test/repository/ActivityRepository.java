package com.jersey.test.repository;

import java.util.List;

import com.jersey.test.model.Activity;
import com.jersey.test.model.ActivitySearch;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findActivity(String activityId);

	void create(Activity activity);

	Activity update(Activity activity);

	void delete(String activityId);

	List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo);

	List<Activity> findByConstrains(ActivitySearch search);
}