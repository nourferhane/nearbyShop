import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Shop } from '../models/shop';


@Injectable()
export class ShopService {
  private URL = 'http://localhost:8001';

  constructor(private http: HttpClient) {

  }

  getAllShops(){
    return this.http.get<Shop[]>(this.URL + '/Shops');
  }

  likeShop(shopId){
    return this.http.post(this.URL + 'api/nearbyshop/likestate/like/'+shopId, {});
  }

  getLikedShops() {
    return this.http.get(this.URL + 'api/nearbyshop/likestate/like');
  }

  removeLike(shopId) {
    return this.http.delete(this.URL + 'api/nearbyshop/likestate/like/'+shopId);
  }
}
