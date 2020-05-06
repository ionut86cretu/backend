package com.endava.school4it.steps.frontend;

import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;

import cucumber.api.PendingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;

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
import static org.junit.Assert.*;

@Configurable
@ContextConfiguration(classes = AppConfiguration.class)
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class MemebookFrontend {

    public String topicTitle1;
    public String topicMediaUrl;
    public String topicAuthor;
    public String commentAuthor;

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

    @And("^i verify that the created topic matches$")
    public void iVerifyThatTheCreatedTopicMatches() {
        System.out.println(topicAuthor);
        assertFalse(mainPageUtil.verifyMatches(topicAuthor,topicMediaUrl));

        System.out.println(topicMediaUrl);


    }

    @And("^i add Topic Title \"([^\"]*)\"$")
    public void iAddTopicTitle(String topicTitle) throws Throwable {
        this.topicTitle1 =topicTitle;
        mainPageUtil.addTopicTitle(topicTitle);
    }

    @And("^i add Topic URL \"([^\"]*)\"$")
    public void iAddTopicURL(String topicMediaUrl) throws Throwable {
        this.topicMediaUrl = topicMediaUrl;
        mainPageUtil.addTopicURL(topicMediaUrl);

    }

    @And("^i add Topic Author \"([^\"]*)\"$")
    public void iAddTopicAuthor(String topicAuthor) throws Throwable {
        this.topicAuthor = topicAuthor;
        mainPageUtil.addTopicAuthor(topicAuthor);

    }

    @Then("^i open a topic$")
    public void iOpenATopic() {
        mainPageUtil.clickOnTitle();
    }


    @And("^i add Topic Title '(.*)'$")
    public void iAddTopicTitleAutoTest(String topicTitle) {
        mainPageUtil.addTopicTitle(topicTitle);
    }

    @And("^i add comment author \"([^\"]*)\"$")
    public void iAddCommentAuthor(String commentAuthor) throws Throwable {
        mainPageUtil.addCommentAuthor(commentAuthor);
    }

    @And("^i add comment content \"([^\"]*)\"$")
    public void iAddCommentContent(String commentContent) throws Throwable {
        mainPageUtil.addCommentContent(commentContent);
    }

    @And("^i press Submit Comment Button$")
    public void iPressSubmitCommentButton() {
        mainPageUtil.clickAddComment();
    }

    //    @And("^i add Topic Author '(.*)'$")
//    public void iAddTopicAuthorAutoTest(String topicAuthor) {
//        mainPageUtil.addTopicAuthor(topicAuthor);
//    }
}
