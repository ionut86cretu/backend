package com.endava.school4it.retrofit;

import com.endava.school4it.memebook.api.PostCommentPayload;
import com.endava.school4it.memebook.entity.Comment;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitCommentService {

    @POST("/topics/{idTopic}/comments")
    Call<Comment> addTopicComment(
            @Path("idTopic") Long idTopic,
            @Body Comment payload
    );

    @DELETE("/topics/{idTopic}/comments/{idComment}")
    Call<Integer> deleteTopicComment(
            @Path("idTopic") Long idTopic,
            @Path ("idComment") Long idComment
    );

}
