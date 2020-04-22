import { Component, Input, OnInit } from '@angular/core';
import { TopicModel } from '../../model/topic.model';
import { Router } from '@angular/router';
import { TopicService } from '../../services/topic.service';

@Component({
  selector: 'mb-topic-card',
  templateUrl: './topic-card.component.html',
  styleUrls: ['./topic-card.component.scss']
})
export class TopicCardComponent implements OnInit {
  @Input() topic: TopicModel;
  @Input() topicLinksActive: boolean = true;

  constructor(protected router: Router,
              private topicService: TopicService) {
  }

  ngOnInit() {
  }

  goToDetailsPage() {
    if (this.topicLinksActive) {
      this.router.navigateByUrl('/topic-details/' + this.topic.id);
    }
  }

  vote(upVote: boolean) {
    this.topicService.voteTopic(this.topic.id, upVote).subscribe(result => {
      console.log('upVote:', upVote);
      this.topic = result;
    }, error => {
      console.log('topic vote error', error);
    }
    );
  }
}
