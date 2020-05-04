package com.endava.school4it.memebook.dao;

import com.endava.school4it.memebook.entity.Topic;
import com.endava.school4it.memebook.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Component("topicDao")
@Scope("application")
public class TopicDao {
    @Autowired
    private TopicRepository topicRepository;

    public Topic find(Long id) {
        return topicRepository.findById(id).get();
    }

    public Topic upVote(Long id) {
        Topic topic = topicRepository.findById(id).get();
        topic.setUpVote(topic.getUpVote() + 1);
        return topicRepository.saveAndFlush(topic);
    }

    public Topic downVote(Long id) {
        Topic topic = topicRepository.findById(id).get();
        topic.setDownVote(topic.getDownVote() + 1);
        return topicRepository.saveAndFlush(topic);
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }

    public void deleteAllTopics(){
        topicRepository.deleteAll();
    }

    public Topic create(
            String title,
            String mediaUrl,
            String author
    ) {
        Topic newRecord = new Topic();

        newRecord.setTitle(title);
        newRecord.setMediaUrl(mediaUrl);
        newRecord.setAuthor(author);

        newRecord.setTopicDate(new Date());
        newRecord.setUpVote(0L);
        newRecord.setDownVote(0L);

        return topicRepository.saveAndFlush(newRecord);
    }

    public List<Topic> get(int page, int size, String sort) {
        Sort sortBy;
        if (StringUtils.isEmpty(sort)) {
            sortBy = Sort.by("popularity").descending();
        } else {
            sortBy = Sort.by(sort).descending();
        }
        return topicRepository.findAll(
                PageRequest.of(
                        page,
                        size,
                        sortBy
                )).getContent();
    }
}

