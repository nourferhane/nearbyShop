package com.ferhane.nearbyshop.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.ferhane.nearbyshop.Entities.*;
import com.ferhane.nearbyshop.Repository.ShopRepository;




public class ShopService implements IShopService {
	//Dependency injection
	@Autowired
	ShopRepository shopRepository;

	@Override
	public List<Shop> findShopByName(String keyword) {
		 return shopRepository.findByNameContainingIgnoreCase(keyword);
	}

	@Override
	public Optional<Shop> getShop(int id) {
		return shopRepository.findById(id);
	}

	@Override
	public List<Shop> getAllShops() {
		return shopRepository.findAll();
	}

	@Override
	public Shop save(Shop shop) {
		return shopRepository.save(shop);
	}

	@Override
	public List<Shop> getNearbyShops() {
		return shopRepository.findAllByOrderByLocationAsc();
	}

	@Override
	public void likeShop() {
		// TODO Auto-generated method stub
		
	}

	

	


}
