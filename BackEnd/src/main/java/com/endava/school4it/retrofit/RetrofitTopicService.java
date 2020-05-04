package com.endava.school4it.retrofit;

import java.util.List;

import com.endava.school4it.memebook.api.PostTopicPayload;
import com.endava.school4it.memebook.entity.Topic;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitTopicService {

    @POST("/topics")
    Call<Topic> createTopic(
            @Body PostTopicPayload postTopicPayload
    );

    @GET("/topics")
    Call<List<Topic>> getAllTopics(
            @Query("page") int page,
            @Query("size") String size,
            @Query("sort") String sort);

    @GET("/topics/{id}")
    Call<Topic> getTopicsById(
            @Path("id") Long id
    );

    @DELETE("/topics/{id}")
    Call<Topic> deleteTopicsById(
            @Path("id") Long id
    );

    @DELETE("/topics/")
    Call<Topic> deleteAllTopics(
    );

    @PUT("/topics/{id}/upVote")
    Call<Topic> upVoteTopic(
            @Path("id") Long id
    );

    @PUT("/topics/{id}/downVote")
    Call<Topic> downVoteTopic(
            @Path("id") Long id
    );
}
