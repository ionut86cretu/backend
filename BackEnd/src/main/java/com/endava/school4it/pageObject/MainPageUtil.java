package com.endava.school4it.pageObject;

import net.serenitybdd.core.pages.WebElementFacade;
import org.springframework.stereotype.Component;

@Component
public class MainPageUtil extends MainPage{



    public boolean verifyEndavaLogo(){
        waitABit(3000);
        if (endavaLogo.isDisplayed())
            return true;
        return false;
    }

    public boolean verifyMatches(String topicAuthor, String topicMediaUrl) {


        //if(findBy(topicAuthor).getValue().equals(topicAuthor)) && (findBy(topicImageField).getValue().equals(topicMediaUrl) )
            if ((topicAuthorField.getText() == topicAuthor) && (topicImageField.getText() == topicMediaUrl) )
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
    public void clickAddComment(){
        addCommentButton.waitUntilVisible().click();
        waitABit(4000);
    }
    public void clickOnTitle(){
        clickOnTopic.waitUntilVisible().click();
        waitABit(4000);
    }

    public void addTopicTitle(String topicTitle){
        topicTitleInput.waitUntilVisible().then().sendKeys(topicTitle);
    }

    public void addCommentAuthor(String commentAuthor){
        commentAuthorInput.waitUntilVisible().then().sendKeys(commentAuthor);

    }

    public void addCommentContent(String commentContent){
        commentContentInput.waitUntilVisible().then().sendKeys(commentContent);
    }

    public void addTopicURL(String topicUrl){
        topicUrlInput.waitUntilVisible().then().sendKeys(topicUrl);
    }

    public void addTopicAuthor(String topicAuthor){
        topicAuthorInput.waitUntilVisible().then().sendKeys(topicAuthor);
    }


/*    public int numberOfTopic() {
        waitABit(3000);
        return topics.size();
    }*/

}
