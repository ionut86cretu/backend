import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TopicListComponent } from './components/topic-list/topic-list.component';
import { TopicDetailsComponent } from './components/topic-details/topic-details.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'topic-list'},
  {path: 'topic-list', component: TopicListComponent},
  {path: 'topic-details', component: TopicDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
