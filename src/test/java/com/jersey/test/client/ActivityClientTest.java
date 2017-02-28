package com.jersey.test.client;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jersey.test.model.Activity;

public class ActivityClientTest {

	@Test
	public void testSearch(){
		ActivitySearchClient client = new ActivitySearchClient();

		String param = "description";
		List<String> searchValues = new ArrayList<String>();

		searchValues.add("swimming");
		searchValues.add("running");

		List<Activity> activities = client.search(param,searchValues);

		System.out.println(activities);

		assertNotNull(activities);
	}

	@Test
	public void testDelete(){
		ActivityClient client = new ActivityClient();
		
		client.delete("1234");
		
	}
	
	@Test
	public void testPut(){
		Activity activity = new Activity();
		
		activity.setId("3456");
		activity.setDescription("Bikram Yoga");
		activity.setDuration(90);
		
		ActivityClient client = new ActivityClient();
		
		activity = client.update(activity);
		
		assertNotNull(activity);
	}
	
	@Test
	public void testCreate(){
		ActivityClient client = new ActivityClient();
		
		Activity activity = new Activity();
		activity.setDescription("swimming");
		activity.setDuration(90);
		
		activity = client.create(activity);
		
		assertNotNull(activity);
	}

	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		
		Activity activity = client.get("1234");
		
		System.out.println(activity);
		
		assertNotNull(activity);
	}
	
	@Test
	public void testGetList(){
		ActivityClient client = new ActivityClient();
		
		List<Activity> activities = client.get();
		
		System.out.println(activities);
		
		assertNotNull(activities);
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetWithBadRequest(){
		ActivityClient client = new ActivityClient();
		
		client.get("123");
		
	}

	@Test(expected=RuntimeException.class)
	public void testGetWithNotFound(){
		ActivityClient client = new ActivityClient();
		
		client.get("7777");
		
	}
	
}
