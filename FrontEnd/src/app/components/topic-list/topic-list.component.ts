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
  private pageSize = 3;
  private page = 0;

  private lastPageReached = false;

  constructor(private topicService: TopicService) {
  }

  ngOnInit() {
    this.topics = [];
    this.page = -1;
    this.onScrollDown();
  }

  onScrollDown() {
    console.log('on scroll down');
    if ( !this.lastPageReached ) {
      this.topicService.loadTopics(++this.page, this.pageSize).subscribe(result => {
        if ( !result || result.length === 0 ) {
          this.lastPageReached = true;
          return;
        }
        console.log('result:', result);
        const topicsExtended = this.topics.concat(result);
        this.topics = topicsExtended;
      });
    }
  }

}
