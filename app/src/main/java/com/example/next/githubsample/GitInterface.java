package com.example.next.githubsample;

import com.example.next.githubsample.models.GithubRepoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by next on 10/3/17.
 */
public interface GitInterface {

    @GET("repos/{user}/{repositoryName}/commits")
        //list return type
        //The return value wraps the response in a Call object with the type of the expected result.
        // The @Path annotation’s value is a relative URI path indicating where the Java class will be hosted:
//The @GET annotation is a request method designator and corresponds to the similarly named HTTP method
    Call<List<GithubRepoModel>> reposeforuser(@Path("user") String user, @Path("repositoryName") String repository);
}