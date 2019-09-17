import { Injectable, Output, EventEmitter } from '@angular/core'

@Injectable()
export class NavMenuService {

  public isLogged = false;

  @Output() change: EventEmitter<boolean> = new EventEmitter();

  toggle(isLoggedIn) {
    this.isLogged = isLoggedIn;
    this.change.emit(this.isLogged);
  }
  getLogged()
  {
    return this.isLogged;
  }


}