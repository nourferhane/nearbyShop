import { Component, OnInit, Injectable, Output, EventEmitter } from '@angular/core';

import { AuthService } from '../auth/auth.service';
import { TokenStorageService } from '../auth/token-storage.service';
import { AuthLoginInfo } from '../auth/login-info';
import { Shop } from '../models/shop';
import {HttpClient} from '@angular/common/http';
import { ShopService } from '../services/shop.service';
import { NavMenuService } from '../nav-menu/navMenu.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
@Injectable({
  providedIn: 'root',
})

export class LoginComponent implements OnInit {
  private URL = 'http://localhost:9000/api';
  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  private loginInfo: AuthLoginInfo;
  shops :Shop[]=[];
  @Output() fireIsLoggedIn = new EventEmitter();

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService,private http: HttpClient,private NavMenuService:NavMenuService) {
   }

  ngOnInit() {
      this.getAllShops()
    .subscribe(shops => this.shops=shops )
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getAuthorities();
      this.NavMenuService.toggle(true);
      console.log(this.tokenStorage.getUsername());
    }
   
  }

  onSubmit() {
    console.log(this.form);
    this.NavMenuService.toggle(true);
    this.loginInfo = new AuthLoginInfo(
      this.form.username,
      this.form.password,
      );
      

    this.authService.attemptAuth(this.loginInfo).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUsername(data.username);
        this.tokenStorage.saveAuthorities(data.authorities);


        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getAuthorities();
        
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isLoginFailed = true;
      }
    );

  }

  logout() {
    this.tokenStorage.signOut();
    localStorage.clear();
    this.NavMenuService.toggle(false);
    this.isLoggedIn=false;
  }
  getAllShops(){
    return this.http.get<Shop[]>(this.URL + '/NearbyShop');
  }

  likeShop(id)
  {
    //return this.http.post(this.URL);
    console.log(id+this.tokenStorage.getUsername());
  }
  
  getisLoggedIn() {
    return this.isLoggedIn;
  }
 
  getEmitter() {
    return this.fireIsLoggedIn;
  } 
}
