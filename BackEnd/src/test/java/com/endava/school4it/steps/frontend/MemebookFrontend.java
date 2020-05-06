package com.endava.school4it.steps.frontend;

import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.endava.school4it.memebook.entity.Topic;
import com.endava.school4it.pageObject.MainPageUtil;
import com.endava.school4it.retrofit.RetrofitService;

import configuration.AppConfiguration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import retrofit2.Response;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@Configurable
@ContextConfiguration(classes = AppConfiguration.class)
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class MemebookFrontend {


    @Autowired
    public RetrofitService retrofit;

    private String statusCodeVar = "statusCode";
    @Autowired
    private MainPageUtil mainPageUtil;

    @Autowired
    private Environment env;

    @Given("^access the application landing url$")
    public void accessTheApplicationLandingUrl() {
        getDriver().get(env.getProperty("memebook.url"));
    }

    @Then("^i verify that page is open$")
    public void iVerifyThatPageIsOpen() {
        assertTrue(mainPageUtil.verifyEndavaLogo());
    }

    @Then("^i click to add topic button$")
    public void iClickToAddTopicButton() {
        mainPageUtil.clickAddTopicButtonHeader();
    }

    @And("^i add Topic Title '(.*)'$")
    public void iAddTopicTitleAutoTest(String topicTitle) {
        mainPageUtil.addTopicTitle(topicTitle);
    }

    @And("^i add Topic URL '(.*)'$")
    public void iAddTopicURL(String topicUrl) {
        mainPageUtil.addTopicURL(topicUrl);
    }

    @And("^i add Topic Author '(.*)'$")
    public void iAddTopicAuthorAutoTest(String topicAuthor) {
        mainPageUtil.addTopicAuthor(topicAuthor);
    }

    @And("^i press Submit Button$")
    public void iPressSubmitButton() throws InterruptedException {
        mainPageUtil.clickAddTopic();
    }


    @Then("^delete all topics from database$")
    public void deleteTheTopicFromDatabase() throws IOException {
        Response<Topic> response = retrofit.getTopicService().deleteAllTopics().execute();
        Serenity.setSessionVariable(statusCodeVar).to(response.code());
    }

    @And("^refresh page$")
    public void refreshPage() throws InterruptedException {
        getDriver().navigate().refresh();
    }

    @When("^number of topic is equals with '(.*)'$")
    public void numberOfTopicIsEqualsWith(int expectedResult) {
/*
        assertEquals(mainPageUtil.numberOfTopic(),expectedResult );
*/
    }

    @And("^chek if topic is added$")
    public void chekIfTopicIsAdded() {
        assertTrue(mainPageUtil.verifyTopicAdded());
    }

    @And("^i press on topic image$")
    public void iPressOnTopicImage() {
        mainPageUtil.clickTopicImage();
    }

    @And("^i add Comment Author '(.*)'$")
    public void iAddCommentAuthorAuthorFrontTest(String commentAuthor) {
        mainPageUtil.addCommentAuthor(commentAuthor);
    }

    @And("^i add Comment Comment '(.*)'$")
    public void iAddCommentCommentCommentFrontTest(String commentComment) {
        mainPageUtil.addCommentComment(commentComment);
    }

    @And("^i press Submit Comment$")
    public void iPressSubmitComment() {
        mainPageUtil.clickAddComment();
    }

    @And("^chek if comment is added$")
    public void chekIfCommentIsAdded() {
        assertTrue(mainPageUtil.verifyCommetAdded());
    }

    @And("^delete comment from database$")
    public void deleteCommentFromDatabase() {
        mainPageUtil.clickDeleteComment();
    }
}
