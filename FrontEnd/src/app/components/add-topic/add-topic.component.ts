import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TopicService} from "../../services/topic.service";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'mb-add-topic',
  templateUrl: './add-topic.component.html',
  styleUrls: ['./add-topic.component.scss']
})
export class AddTopicComponent implements OnInit {

  public addTopicForm: FormGroup;

  constructor(private snackBar: MatSnackBar, private tfb: FormBuilder, private topicService: TopicService, protected router: Router) {
  }

  ngOnInit(): void {
    this.addTopicForm = this.tfb.group({
      title: [undefined, [Validators.required, Validators.minLength(2), Validators.pattern('.*[A-Z\- a-z0-9].*')]],
      mediaUrl: [undefined, [Validators.required, Validators.minLength(2)]],
      author: [undefined, [Validators.required, Validators.minLength(2), Validators.pattern('.*[A-Z\- a-z0-9].*')]],
    });
  }

  addTopic($event: MouseEvent) {
    this.topicService.addTopic(this.addTopicForm.value).subscribe(result => {
      this.openSnackBar('Topic Added', 'success', result.id);

      console.log('am adaugat topic ', result);
      this.router.navigateByUrl('/topic-list');
    }, error => {
      console.log('add topic error', error);
    });
  }

  openSnackBar(message: string, action: string, topicId: number) {
    this.snackBar.open(message, action, {
      duration: 8000,
    }).onAction().subscribe(() => {
      this.router.navigateByUrl('/topic-details/' + topicId);
      console.log('The snack-bar action was triggered!');
    });
  }
}
