import { Component, OnInit, Injectable, Output,EventEmitter } from '@angular/core';
import { NavMenuService } from './navMenu.service';
import { TokenStorageService } from '../auth/token-storage.service';


@Component({
  selector: 'app-nav-menu',
  templateUrl: './nav-menu.component.html',
  styleUrls: ['./nav-menu.component.css']
})
export class NavMenuComponent  implements OnInit  {
  public isLoggedIn = false;
  @Output() change: EventEmitter<boolean> = new EventEmitter();
 constructor(private NavMenuService:NavMenuService,private tokenStorage: TokenStorageService)
 {
   }
  isExpanded = false;
  ngOnInit(){
    this.NavMenuService.change.subscribe(logged => {
      this.isLoggedIn = logged;
    });
    
    console.log(1);
  }
  collapse() {
    this.isExpanded = false;
    
  }

  toggle() {
    this.isExpanded = !this.isExpanded;
  }
  setLoggedIn(value)
  {
    this.isLoggedIn=value;
  }
  fireLogin(value) {
    console.log(value);
  }
  logout() {
    this.tokenStorage.signOut();
    localStorage.clear();
    this.NavMenuService.toggle(false);
    this.isLoggedIn=false;
    this.change.emit(false);

  }
}
