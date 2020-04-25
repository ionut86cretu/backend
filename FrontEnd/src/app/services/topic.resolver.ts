import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { TopicModel } from '../model/topic.model';
import { TopicService } from './topic.service';

@Injectable({
    providedIn: 'root'
})
export class TopicResolver implements Resolve<Observable<TopicModel>> {

    constructor(private topicService: TopicService) {
    }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<TopicModel> {
        let topicId: string = route.paramMap.get('topicId');
        console.log('topicId:' + topicId);
        return this.topicService.loadTopic(+topicId);
    }

}
