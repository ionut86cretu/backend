package com.endava.school4it.retrofit;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class RetrofitService extends RetrofitFactory {

    @Autowired
    private Environment environment;

    public RetrofitTopicService getTopicService () {
        return new Builder(environment.getProperty("topic.url"))
                .headers(Map.of(
                        "Content-Type", "application/json"))
                .build()
                .create(RetrofitTopicService.class);
    }

    public RetrofitCommentService getCommentService () {
        return new Builder(environment.getProperty("topic.url"))
                .headers(Map.of(
                        "Content-Type", "application/json"))
                .build()
                .create(RetrofitCommentService.class);
    }
}
