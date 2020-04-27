import { Injectable } from '@angular/core';
import { TopicModel } from '../model/topic.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class TopicService {

    constructor(private http: HttpClient) {
    }

    public loadTopics(page: number, size: number): Observable<TopicModel[]> {
        return this.http.get<TopicModel[]>('api/topics?page=' + page + '&size=' + size);
    }

    public loadTopic(topicId: number): Observable<TopicModel> {
        return this.http.get<TopicModel>('api/topics/' + topicId);
    }

    public addTopic(topic: TopicModel): Observable<TopicModel> {
        return this.http.post<TopicModel>('api/topics/', topic);
    }

    public voteTopic(topicId: number, up: boolean): Observable<TopicModel> {
        return this.http.put<TopicModel>('api/topics/' + topicId + '/' + (up ? 'upVote' : 'downVote'), null);
    }

}
