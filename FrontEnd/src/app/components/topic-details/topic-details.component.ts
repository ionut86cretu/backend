import { Component, OnInit } from '@angular/core';
import { TopicModel } from '../../model/topic.model';
import { ActivatedRoute, Router } from '@angular/router';
import { CommentModel } from '../../model/comment.model';

@Component({
    selector: 'mb-topic-details',
    templateUrl: './topic-details.component.html',
    styleUrls: ['./topic-details.component.scss']
})
export class TopicDetailsComponent implements OnInit {

    public topic: TopicModel = null;

    constructor(protected router: Router,
                private route: ActivatedRoute) {
    }

    ngOnInit(): void {
        this.topic = this.route.snapshot.data['topic'];
        console.log('topic details loaded with id:' + this.topic.id);
    }

    onAddNewComment(comment: CommentModel) {
        this.topic.comments.unshift(comment);
    }
}
