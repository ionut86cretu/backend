import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'mb-app-header',
    templateUrl: './app-header.component.html',
    styleUrls: ['./app-header.component.scss']
})
export class AppHeaderComponent implements OnInit {

    constructor() {
    }

    ngOnInit(): void {
    }

    goToLink(url: string) {
        window.open(url, 'https://www.endava.com/');
    }
}
