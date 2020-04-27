import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { TopicModel } from '../../model/topic.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommentService } from '../../services/comment.service';
import { CommentModel } from '../../model/comment.model';

@Component({
    selector: 'mb-add-comment',
    templateUrl: './add-comment.component.html',
    styleUrls: ['./add-comment.component.scss']
})
export class AddCommentComponent implements OnInit {

    @Input() topic: TopicModel;

    @Output('onAdd') addedComment = new EventEmitter<CommentModel>();

    public myForm: FormGroup;

    constructor(private fb: FormBuilder, private commentService: CommentService) {
    }

    ngOnInit(): void {
        this.myForm = this.fb.group({
            author: [undefined, [Validators.required, Validators.minLength(2), Validators.pattern('.*[A-Z\- a-z0-9].*')]],
            comment: [undefined, [Validators.required, Validators.minLength(2)]]
        });

        this.myForm.valueChanges.subscribe(val => {
            console.log('form value', val, this.myForm.valid);
        });
    }

    addComment($event: MouseEvent) {
        console.log('form value', this.myForm.value);
        this.commentService.addComment(this.topic.id, this.myForm.value).subscribe(result => {
            console.log('am adaugat', result);
            this.addedComment.emit(result);
            this.myForm.reset();
        }, error => {
            console.log('topic comment error', error);
        });
    }
}
