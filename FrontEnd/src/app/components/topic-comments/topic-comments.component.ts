import { Component, Input, OnInit } from '@angular/core';
import { TopicModel } from '../../model/topic.model';
import { CommentService } from '../../services/comment.service';

@Component({
    selector: 'mb-topic-comments',
    templateUrl: './topic-comments.component.html',
    styleUrls: ['./topic-comments.component.scss']
})
export class TopicCommentsComponent implements OnInit {

    @Input() topic: TopicModel;

    constructor(private commentService: CommentService) {
    }

    ngOnInit(): void {
    }

    deleteComment(idComment: number) {
        this.commentService.deleteComment(this.topic.id, idComment).subscribe(result => {
            this.topic.comments = this.topic.comments.filter(comment => comment.id !== result);
        });
    }
}
