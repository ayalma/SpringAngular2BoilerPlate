/**
 * Created by alimohammadi on 7/13/16.
 */
import { Component } from '@angular/core';
import {NavComponent} from "./shared/nav/nav.component";

@Component({
    selector: 'my-app',
    templateUrl :'app/app.component.html',
    directives: [NavComponent]
})
export class AppComponent{
    constructor() {}
}