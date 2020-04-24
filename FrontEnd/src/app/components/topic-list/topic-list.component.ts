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
  // @todo change page size to input
  public pageSize = 3;
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
          }, error => {
            console.log('topic error' + error);
          }
      );
    }

    this.pageSize = 5;

  }

  public changePagination(event){
    var target = event.target;
    this.pageSize = target.value;
  }

  public getPagination(){
    return this.pageSize;
  }

  public compareWith(t1:any, t2:any){
    return ('' + t1) == ('' + t2);
  }
}
