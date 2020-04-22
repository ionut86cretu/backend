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

}
