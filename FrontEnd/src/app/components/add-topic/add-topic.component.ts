import { Component, OnInit } from '@angular/core';
import { TopicModel } from '../../model/topic.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TopicService } from '../../services/topic.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
    selector: 'mb-add-topic',
    templateUrl: './add-topic.component.html',
    styleUrls: ['./add-topic.component.scss']
})
export class AddTopicComponent implements OnInit {

    public myForm: FormGroup;

    constructor(private snackBar: MatSnackBar,
                private fb: FormBuilder,
                protected router: Router,
                private topicService: TopicService) {
    }

    ngOnInit(): void {
        this.myForm = this.fb.group({
            title: [undefined, [Validators.required, Validators.minLength(2), Validators.pattern('.*[A-Z\- a-z0-9].*')]],
            author: [undefined, [Validators.required, Validators.minLength(2), Validators.pattern('.*[A-Z\- a-z0-9].*')]],
            mediaUrl: [undefined, [Validators.required, Validators.minLength(2)]]
        });

    }

    addTopic($event: MouseEvent) {
        this.topicService.addTopic(this.myForm.value).subscribe(result => {
            this.openSnackBar('Topic added successfully', 'View Details', result);

            this.router.navigateByUrl('/topic-list');
        }, error => {
            console.log('topic comment error', error);
        });

    }

    openSnackBar(message: string, action: string, topic: TopicModel) {
        this.snackBar.open(message, action, {
            duration: 5000,
        }).onAction().subscribe(result => {
            this.router.navigateByUrl('/topic-details/' + topic.id);
        });
    }

}
