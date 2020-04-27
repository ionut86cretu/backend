package com.endava.school4it.memebook.controller;

import com.endava.school4it.memebook.api.PostCommentPayload;
import com.endava.school4it.memebook.dao.CommentDao;
import com.endava.school4it.memebook.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    private CommentDao commentDao;

    @RequestMapping(path = "/topics/{idTopic}/comments", method = RequestMethod.POST)
    public Comment addComment(
            @PathVariable("idTopic") Long idTopic,
            @RequestBody PostCommentPayload payload
    ) {
        return commentDao.create(idTopic, payload.getAuthor(), payload.getComment());
    }

}
