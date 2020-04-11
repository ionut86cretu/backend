import { Component, Input, OnInit } from '@angular/core';
import { TopicModel } from '../../model/topic.model';

@Component({
  selector: 'mb-topic-card',
  templateUrl: './topic-card.component.html',
  styleUrls: ['./topic-card.component.scss']
})
export class TopicCardComponent implements OnInit {
  @Input() topic: TopicModel;

  constructor() {
  }

  ngOnInit() {
  }

}
