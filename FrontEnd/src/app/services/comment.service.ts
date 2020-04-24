import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { CommentModel } from '../model/comment.model';

@Injectable({
    providedIn: 'root'
})
export class CommentService {

    constructor(private http: HttpClient) {
    }

    public addComment(topicId: number, comment: CommentModel): Observable<CommentModel> {
        return this.http.post<CommentModel>('api/topics/' + topicId + '/comments', comment);
    }

}
