package com.endava.school4it.memebook.entity.controller;

import com.endava.school4it.memebook.entity.Topic;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class topicController {
    @RequestMapping(path = "/topics/{id}",method = RequestMethod.GET)
    public Topic getTopic(@PathVariable String id){
        return null;
    }

}
