import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { NavMenuComponent } from './nav-menu/nav-menu.component';
import { HomeComponent } from './home/home.component';
import { ShopComponent } from './shop/shop.component';
import { LoginComponent } from './login/login.component';
import {RegisterComponent} from './register/register.component'
import {likedShopComponent} from './likedShop/likedShop.component'
import { ShopService } from './services/shop.service';
import { NavMenuService } from './nav-menu/navMenu.service';

@NgModule({
  declarations: [
    AppComponent,
    NavMenuComponent,
    HomeComponent,
    ShopComponent,
    LoginComponent,
    RegisterComponent,
    likedShopComponent
  
  ],
  imports: [
    BrowserModule.withServerTransition({ appId: 'ng-cli-universal' }),
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent, pathMatch: 'full' },
      { path: 'shop', component: ShopComponent },
      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegisterComponent },
      { path: 'likedShop', component: likedShopComponent },
    ])
  ],
  providers: [NavMenuComponent,
  LoginComponent,ShopService,NavMenuService],
  bootstrap: [AppComponent]
})
export class AppModule { }
