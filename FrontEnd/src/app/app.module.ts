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




@NgModule({
  declarations: [
    AppComponent,
    AppHeaderComponent,
    TopicListComponent,
    TopicCardComponent,
    TopicDetailsComponent
  ],
  imports: [
    BrowserModule,
    MatToolbarModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
