package com.endava.school4it.memebook.dao;

import com.endava.school4it.memebook.entity.Comment;
import com.endava.school4it.memebook.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("commentDao")
@Scope("application")
public class CommentDao {
    @Autowired
    private CommentRepository commentRepository;

    public Comment create(
            Long idTopic,
            String author,
            String comment
    ) {
        //TODO
        return null;
    }

    public List<Comment> get(Long idTopic) {
        Comment match = new Comment();
        match.setIdTopic(idTopic);
        Example commentExample = Example.of(match);
        return commentRepository.findAll(commentExample, Sort.by("id"));
    }
}
