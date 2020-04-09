import { Component, OnInit } from '@angular/core';
import { TopicModel } from '../../model/topic.model';
import { TopicService } from '../../services/topic.service';

@Component({
  selector: 'mb-topic-list',
  templateUrl: './topic-list.component.html',
  styleUrls: ['./topic-list.component.scss']
})
export class TopicListComponent implements OnInit {

  topics: TopicModel[];

  constructor(private topicService: TopicService) {
  }

  ngOnInit() {
    this.topicService.loadTerminals().subscribe(result => {
      this.topics = result;
    });
  }

}
