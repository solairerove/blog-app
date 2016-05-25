import {Component} from 'angular2/core';

@Component({
    selector: 'my-header',
    templateUrl: '/app/components/header/header.component.html'
})

export class HeaderComponent {
    image:string;
    
    constructor() {
        this.image = '../../../resources/img/header.jpg';
    }

    setImage(image:string) {
        this.image = image;
    }
}
