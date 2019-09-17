import { Component, OnInit } from '@angular/core';
import { ShopService } from '../services/shop.service';
import { Subscriber } from 'rxjs';
import { Shop } from '../models/shop';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  constructor(private shopService:ShopService) { }
  shops :Shop[]=[];
  ngOnInit() {
    this.getShop();
  }

  getShop()
  {
    this.shopService.getAllShops()
    .subscribe(shops => this.shops=shops )
  }
}
