package com.endava.school4it.pageObject;

import java.util.List;

import org.springframework.stereotype.Component;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

@Component
public class MainPage extends PageObject {

    @FindBy(xpath = "//div[@id='endava_logo']")
    WebElementFacade endavaLogo;



    @FindBy(xpath = "//a[@id='add_topic']")
    WebElementFacade addTopicButtonHeader;

    @FindBy(xpath = "//button[@id='add_topic_button']")
    WebElementFacade addTopicButton;



    @FindBy(xpath = "//input[@id='add_topic_title']")
    WebElementFacade topicTitleInput;

    @FindBy(xpath = "//textarea[@id='add_topic_url']")
    WebElementFacade topicUrlInput;

    @FindBy(xpath = "//textarea[@id='add_topic_author']")
    WebElementFacade topicAuthorInput;


    @FindBy(xpath = "//div[@class='container topic-card']//a//div")
    WebElementFacade topicAuthorField;

    @FindBy(xpath  = "//div//img[contains(@alt,'topic image for')]")
    WebElementFacade topicImageField;

/*
    @FindBy(xpath = "//div/mb-topic-ca  rd")
    List<WebElementFacade> topics;
*/

    @FindBy(xpath  = "//div[@class='container topic-card']//img[contains(@src,'front_test=1')]")
    WebElementFacade newTopic;

    @FindBy(xpath  = "//input[@id='add_comment_author']")
    WebElementFacade topicCommentAuthor;

    @FindBy(xpath  = "//textarea[@id='add_comment_text']")
    WebElementFacade topicCommentComment;

    @FindBy(xpath  = "//button[@id='add_comment_button']")
    WebElementFacade addCommentButton;

    @FindBy(xpath  = "//div[contains(@class, 'pt-2') and contains(.//span, 'Comment Front Test')]")
    WebElementFacade newComment;

    @FindBy(xpath  = "//div[position()=1 and contains(@class, 'ng-star-inserted')]//div[contains(@class, 'pt-2')]//span[@class='delete-comment']")
    WebElementFacade deleteCommentbutton;
}
