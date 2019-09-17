package com.ferhane.nearbyshop.Services;

import java.util.List;
import java.util.Optional;

import com.ferhane.nearbyshop.Entities.*;
public interface IShopService {
	    List<Shop> findShopByName(String keyword);
	    Optional<Shop> getShop(int id);
	    List<Shop> getAllShops();
	    Shop save(Shop shop);
	    List<Shop> getNearbyShops();
	    void likeShop();
}
