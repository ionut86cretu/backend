package com.endava.school4it.pageObject;

import net.serenitybdd.core.annotations.findby.By;
import org.springframework.stereotype.Component;

@Component
public class MainPageUtil extends MainPage{


    public boolean verifyEndavaLogo(){
        waitABit(3000);
        if (endavaLogo.isDisplayed())
            return true;
        return false;
    }

    public void clickAddTopicButtonHeader(){
        addTopicButtonHeader.waitUntilVisible().click();
    }

    public void clickAddTopic(){
        addTopicButton.waitUntilVisible().click();
        waitABit(4000);
    }

    public void addTopicTitle(String topicTitle){
        topicTitleInput.waitUntilVisible().then().sendKeys(topicTitle);
    }

    public void addTopicURL(String topicUrl){
        topicUrlInput.waitUntilVisible().then().sendKeys(topicUrl);
    }

    public void addTopicAuthor(String topicAuthor){
        topicAuthorInput.waitUntilVisible().then().sendKeys(topicAuthor);
    }

    public boolean verifyTopicAdded(){
        waitABit(3000);
        if (newTopic.isDisplayed())
            return true;
        return false;
    }

    public void clickTopicImage(){
        newTopic.waitUntilVisible().click();
        waitABit(4000);
    }

    public void addCommentAuthor(String commentAuthor) {
        topicCommentAuthor.waitUntilVisible().then().sendKeys(commentAuthor);
    }

    public void addCommentComment(String commentComment) {
        topicCommentComment.waitUntilVisible().then().sendKeys(commentComment);
    }

    public void clickAddComment() {
        addCommentButton.waitUntilVisible().click();
        waitABit(4000);
    }

    public boolean verifyCommetAdded() {
        waitABit(3000);
        if (newComment.isDisplayed())
            return true;
        return false;
    }

    public void clickDeleteComment() {
        deleteCommentbutton.waitUntilVisible().click();
    }

    public boolean verifyCommetDeleted() {
        waitABit(3000);
        return getDriver().findElements(By.xpath("//div[contains(@class, 'pt-2') and contains(.//span, 'Comment Front Test')]")).size() > 0;
    }

/*    public int numberOfTopic() {
        waitABit(3000);
        return topics.size();
    }*/

}
