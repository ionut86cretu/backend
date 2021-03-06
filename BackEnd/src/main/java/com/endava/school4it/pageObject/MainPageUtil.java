package com.endava.school4it.pageObject;

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

/*    public int numberOfTopic() {
        waitABit(3000);
        return topics.size();
    }*/

}
