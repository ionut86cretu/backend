import { Component, Input, OnInit } from '@angular/core';
import { TopicModel } from '../../model/topic.model';

@Component({
    selector: 'mb-topic-comments',
    templateUrl: './topic-comments.component.html',
    styleUrls: ['./topic-comments.component.scss']
})
export class TopicCommentsComponent implements OnInit {

    @Input() topic: TopicModel;

    constructor() {
    }

    ngOnInit(): void {
    }

}
