import { Injectable } from '@angular/core';
import { TopicModel } from '../model/topic.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TopicService {

  constructor(private http: HttpClient) {
  }

  public loadTopics(page: number, size: number): Observable<TopicModel[]> {
    return this.http.get<TopicModel[]>('assets/topics.json').pipe(map(resultList => resultList.slice(page * size, (page + 1) * size)));
  }
}
