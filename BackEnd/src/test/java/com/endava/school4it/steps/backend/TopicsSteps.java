package com.endava.school4it.steps.backend;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.endava.school4it.memebook.api.PostTopicPayload;
import com.endava.school4it.memebook.entity.Topic;
import com.endava.school4it.retrofit.RetrofitService;

import configuration.AppConfiguration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import retrofit2.Response;

@Configurable
@ContextConfiguration(classes = AppConfiguration.class)
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class TopicsSteps {

    @Autowired
    public RetrofitService retrofit;

    private String statusCodeVar = "statusCode";

    @Given("^the new topic is created via Topic API$")
    public void theNewTopicIsCreatedViaTopicAPI() throws IOException {
        Response<Topic> response = retrofit.getTopicService().createTopic(createTopic()).execute();

        assertNotNull("Response is null !", response);
        assertNotNull("Response body is null !", response.body());

        Serenity.setSessionVariable(statusCodeVar).to(response.code());
        Serenity.setSessionVariable("topicId").to(response.body().getId());
    }

    @Then("^the response status code should be '(.*)'$")
    public void theResponseStatusCodeShouldBe(int statusCode) throws Throwable {
        int responseCode = Serenity.sessionVariableCalled(statusCodeVar);
        assertEquals(statusCode, responseCode, "Status code not OK !");
    }

    @Then("^delete the topic from database$")
    public void deleteTheTopicFromDatabase() throws IOException {
        Long topicId = Serenity.sessionVariableCalled("topicId");
        Response<Topic> response = retrofit.getTopicService().deleteTopicsById(topicId).execute();
        Serenity.setSessionVariable(statusCodeVar).to(response.code());
    }

    @When("^get the Topic by id via Topics API$")
    public void getTheTopicByIdViaTopicsAPI() throws IOException {
        Long topicId = Serenity.sessionVariableCalled("topicId");
        Response<Topic> response = retrofit.getTopicService().getTopicsById(topicId).execute();
        Serenity.setSessionVariable(statusCodeVar).to(response.code());
    }

    @Then("^I voted up topic via Topic API$")
    public void iVotedUpTopicViaTopicAPI() throws IOException {
        Long topicId = Serenity.sessionVariableCalled("topicId");
        Response<Topic> response = retrofit.getTopicService().upVoteTopic(topicId).execute();
        Serenity.setSessionVariable(statusCodeVar).to(response.code());
        Serenity.setSessionVariable("topicResponse").to(response.body());
    }

    @And("^the number of votes up equals with '(.*)'$")
    public void theNumberOfVotesUpEqualsWith(int upVotes) {
        Topic topic = Serenity.sessionVariableCalled("topicResponse");
        assertEquals(upVotes, topic.getUpVote(), "Number of up votes is not OK !");
    }

    private PostTopicPayload createTopic() {
        PostTopicPayload postTopicPayload = new PostTopicPayload();
        postTopicPayload.setTitle("Topic Automated Testing");
        postTopicPayload.setAuthor("Automated Testing");
        postTopicPayload.setMediaUrl("https://i.pinimg.com/564x/c5/fe/03/c5fe037aecdf011e307a05cdb810f25e.jpg");
        return postTopicPayload;
    }

    @When("^get the Topics via Topics API page '(\\d+)' size '(\\d+)'$")
    public void getTheTopicsViaTopicsAPIPageSize(int page, int size) throws IOException {
        Response<List<Topic>> response = retrofit.getTopicService().getTopics(page, Integer.toString(size), "id").execute();
        List<Topic> allTopics = response.body();
        Assertions.assertNotNull(allTopics, "Lista este nula - "+ response);
        Serenity.setSessionVariable("allTopicsCount").to(allTopics.size());
    }

    @And("^the number of topics greater than '(\\d+)'$")
    public void theNumberOfTopicsUpEqualsWith(int arg0) {
        Integer topicsCount = Serenity.sessionVariableCalled("allTopicsCount");
        assertNotEquals(topicsCount, 0, "Number of topics should be greater than 0 !");
    }

    @When("^I voted down topic via Topic API$")
    public void iVotedDownTopicViaTopicAPI() throws IOException {
        Long topicId = Serenity.sessionVariableCalled("topicId");
        Response<Topic> response = retrofit.getTopicService().downVoteTopic(topicId).execute();
        Serenity.setSessionVariable(statusCodeVar).to(response.code());
        Serenity.setSessionVariable("topicResponse").to(response.body());
    }

    @Then("^the number of votes down equals with '(\\d+)'$")
    public void theNumberOfVotesDownEqualsWith(int downVotes) {
        Topic topic = Serenity.sessionVariableCalled("topicResponse");
        assertEquals(downVotes, topic.getDownVote(), "Number of down votes is not OK !");
    }

    @And("^the new topic exists$")
    public void theNewTopicExists() throws IOException {
        Long topicId = Serenity.sessionVariableCalled("topicId");
        Response<Topic> response = retrofit.getTopicService().getTopicsById(topicId).execute();

        assertNotNull("Response is null !", response);
        assertNotNull("Response body is null !", response.body());
    }
}
