package com.endava.school4it.steps.backend;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertNotNull;

import com.endava.school4it.memebook.entity.Comment;
import com.endava.school4it.memebook.entity.Topic;
import com.endava.school4it.retrofit.RetrofitService;

import configuration.AppConfiguration;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;
import retrofit2.Response;

@Configurable
@ContextConfiguration(classes = AppConfiguration.class)
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class CommentSteps {

    @Autowired
    private RetrofitService retrofit;

    public String statusCodeVar = "statusCode";

    @Then("^the new comment is added via Comment API$")
    public void theNewCommentIsAddedViaCommentAPI() throws IOException {
        Long topicId = Serenity.sessionVariableCalled("topicId");
        Response<Comment> response = retrofit.getCommentService().addTopicComment(topicId,createComment()).execute();

        assertNotNull("Response body is null !", response.body());

        Serenity.setSessionVariable(statusCodeVar).to(response.code());
        Serenity.setSessionVariable("commentId").to(response.body().getId());
    }

    @Then("^delete the comment from database$")
    public void deleteTheCommentFromDatabase() throws IOException {
        Long topicId = Serenity.sessionVariableCalled("topicId");
        Long commentId = Serenity.sessionVariableCalled("commentId");
        Response<Integer> response = retrofit.getCommentService().deleteTopicComment(topicId,commentId).execute();
        Serenity.setSessionVariable(statusCodeVar).to(response.code());
    }


    private Comment createComment(){
        Comment comment = new Comment();
        comment.setAuthor("Automated Testing");
        comment.setComment("First Comment with Automated Testing API");
        return comment;
    }
}
