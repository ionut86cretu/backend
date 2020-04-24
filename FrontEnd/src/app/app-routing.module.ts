import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TopicListComponent } from './components/topic-list/topic-list.component';
import { TopicDetailsComponent } from './components/topic-details/topic-details.component';
import { AppErrorComponent } from './components/app-error/app-error.component';
import { TopicResolver } from './services/topic.resolver';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'topic-list'},
  {path: 'topic-list', component: TopicListComponent},
  {path: 'topic-details/:topicId', component: TopicDetailsComponent, resolve: {topic: TopicResolver}},
  {path: '**', component: AppErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
