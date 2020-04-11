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

  loadTerminals(): Observable<TopicModel[]> {
    return this.http.get<TopicModel[]>('assets/topics.json');
  }
}
