package com.jersey.test.client;

import com.jersey.test.model.Activity;
import com.jersey.test.model.ActivitySearch;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

public class ActivitySearchClient {
    private Client client;

    public ActivitySearchClient() {
        this.client = ClientBuilder.newClient();
    }

    public List<Activity> search(String param, List<String> searchValues, String secondParam, int durationFrom, String thirdParam, int durationTo) {
        URI uri = UriBuilder.fromUri("http://localhost:8080/exercise-service/webapi")
                .path("search/activities")
                .queryParam(param, searchValues)
                .queryParam(secondParam, durationFrom)
                .queryParam(thirdParam, durationTo)
                .build();

        WebTarget target = client.target(uri);

        List<Activity> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>(){});

        System.out.println(response);

        return response;
    }

    public List<Activity> search(ActivitySearch searchObject) {
        URI uri = UriBuilder.fromUri("http://localhost:8080/exercise-service/webapi")
                .path("search/activities")
                .build();

        WebTarget target = client.target(uri);

        Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(searchObject, MediaType.APPLICATION_JSON));

        if(response.getStatus()!=200){
            throw new RuntimeException(response.getStatus() + "there was error on the server");
        }


        return response.readEntity(new GenericType<List<Activity>>(){});
    }
}
