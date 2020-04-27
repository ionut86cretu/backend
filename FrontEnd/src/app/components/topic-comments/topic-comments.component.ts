import { Component, Input, OnInit } from '@angular/core';
import { TopicModel } from '../../model/topic.model';
import {CommentService} from "../../services/comment.service";

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

    deleteComment(id: number) {
      // nu mergea pentru ca nu facea subscribe
      this.commentService.deleteComment(id).subscribe();
    }
}
