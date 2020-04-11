package com.endava.school4it.memebook.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_TOPIC", nullable = false)
    private Long idTopic;

    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @Column(name = "COMMENT", nullable = false)
    private String comment;

    @Column(name = "COMMENT_DATE", nullable = false)
    private Date commentDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Long getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Long idTopic) {
        this.idTopic = idTopic;
    }
}
