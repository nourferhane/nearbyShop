import { Component, Injectable, EventEmitter, Output, Input } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Shop } from '../models/shop';
import { LoginComponent } from '../login/login.component';
import {TokenStorageService} from '../auth/token-storage.service'
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  
})

export class HomeComponent {
  private URL = 'http://localhost:9000/api';
  shops :Shop[]=[];
  test:string="e";
  isLoggedIn = false;
  constructor(private http: HttpClient,private login:LoginComponent,private token:TokenStorageService) {
   }
 
  ngOnInit() {
    this.getAllShops()
    .subscribe(shops => this.shops=shops )
  }
  getAllShops(){
    return this.http.get<Shop[]>(this.URL + '/Shops');
  }

  


}
  


