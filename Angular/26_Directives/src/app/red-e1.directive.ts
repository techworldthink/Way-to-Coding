import { Directive,ElementRef } from '@angular/core';

@Directive({
  selector: '[appRedE1]'
})
export class RedE1Directive {

  constructor(el:ElementRef) {
    el.nativeElement.style.color="red";
   }

}
