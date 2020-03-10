package com.endava.school4it.memebook.entity.controller;

import com.endava.school4it.memebook.entity.Topic;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class commentController {
    @RequestMappign(path = "/topics/{id}/{idComment}",method = RequestMethod.POST)
    public Topic getComments(@PathVariable {long id, long idTopic}){
        return null;
    }
}




