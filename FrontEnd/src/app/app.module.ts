import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppHeaderComponent } from './components/app-header/app-header.component';
import { TopicListComponent } from './components/topic-list/topic-list.component';
import { TopicCardComponent } from './components/topic-card/topic-card.component';

@NgModule({
  declarations: [
    AppComponent,
    AppHeaderComponent,
    TopicListComponent,
    TopicCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
