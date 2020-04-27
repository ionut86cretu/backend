import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { CommentModel } from '../model/comment.model';
import {catchError} from "rxjs/operators";
import {ERROR} from "@angular/compiler-cli/ngcc/src/logging/console_logger";

@Injectable({
    providedIn: 'root'
})
export class CommentService {

    constructor(private http: HttpClient) {
    }

    public addComment(topicId: number, comment: CommentModel): Observable<CommentModel> {
        return this.http.post<CommentModel>('api/topics/' + topicId + '/comments', comment);
    }

    public deleteComment(commentId: number): Observable<any> {
      return this.http.delete('api/comment/' + commentId);
    }
}
