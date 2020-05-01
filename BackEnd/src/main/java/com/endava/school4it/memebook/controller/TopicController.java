package com.endava.school4it.memebook.controller;

import com.endava.school4it.memebook.api.PostTopicPayload;
import com.endava.school4it.memebook.dao.CommentDao;
import com.endava.school4it.memebook.dao.TopicDao;
import com.endava.school4it.memebook.entity.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicDao topicDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping(path = "/topics", method = RequestMethod.POST)
    public Topic addTopic(@RequestBody PostTopicPayload payload) {
        return topicDao.create(payload.getAuthor(), payload.getMediaUrl(), payload.getTitle());
    }

    @RequestMapping(path = "/topics", method = RequestMethod.GET)
    public List<Topic> getTopics(
            @RequestParam(name = "page", required = true) int page,
            @RequestParam(name = "size", required = true) int size,
            @RequestParam(name = "sort", required = false) String sort
    ) {
        return topicDao.get(page, size, sort);
    }

    @RequestMapping(path = "/add-topic", method = RequestMethod.PUT)
    public Topic addTopic(
            @RequestBody PostTopicPayload payload
    ){
        return topicDao.create(payload.getTitle(), payload.getMediaUrl(), payload.getAuthor());
    }

    @RequestMapping(path = "/topics/{id}", method = RequestMethod.GET)
    public Topic getTopic(@PathVariable("id") Long id) {
        Topic topic = topicDao.find(id);
        topic.setComments(commentDao.get(id));
        return topic;
    }

    @RequestMapping(path = "/topics/{id}/upVote", method = RequestMethod.PUT)
    public Topic upVote(@PathVariable("id") Long id) {
        return topicDao.upVote(id);
    }

    @RequestMapping(path = "/topics/{id}/downVote", method = RequestMethod.PUT)
    public Topic downVote(@PathVariable("id") Long id) {
        return topicDao.downVote(id);
    }

    @RequestMapping(path = "/topics/{id}", method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable("id") Long id) {
        topicDao.deleteTopic(id);
    }

}
