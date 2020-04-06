package com.endava.school4it.memebook.controller;

import com.endava.school4it.memebook.dao.CommentDao;
import com.endava.school4it.memebook.dao.TopicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbInitController {

    @Autowired
    private TopicDao topicDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping(path = "/db/init", method = RequestMethod.POST)
    public void dbInit() {
        topicDao.create("title 1", "url", "author");
        topicDao.create("title 2", "url", "author");
        topicDao.create("title 3", "url", "author");
        topicDao.create("title 4", "url", "author");
        topicDao.create("title 5", "url", "author");

        commentDao.create(1L, "author", "Comment 1");
    }
}
