import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppHeaderComponent } from './components/app-header/app-header.component';
import { TopicListComponent } from './components/topic-list/topic-list.component';
import { TopicCardComponent } from './components/topic-card/topic-card.component';
import { TopicDetailsComponent } from './components/topic-details/topic-details.component';
import { AppErrorComponent } from './components/app-error/app-error.component';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';
import { MatTooltipModule } from '@angular/material/tooltip';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddCommentComponent } from './components/add-comment/add-comment.component';
import { TopicCommentsComponent } from './components/topic-comments/topic-comments.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';




@NgModule({
  declarations: [
    AppComponent,
    AppHeaderComponent,
    TopicListComponent,
    TopicCardComponent,
    TopicDetailsComponent,
    AppErrorComponent,
    AddCommentComponent,
    TopicCommentsComponent
  ],
  imports: [
    BrowserModule,
    MatToolbarModule,
    HttpClientModule,
    AppRoutingModule,
    InfiniteScrollModule,
    BrowserAnimationsModule,
    MatTooltipModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
