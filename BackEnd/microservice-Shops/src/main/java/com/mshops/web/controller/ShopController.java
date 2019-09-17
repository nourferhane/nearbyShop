package com.mshops.web.controller;

import com.mshops.Repository.ShopRepository;
import com.mshops.Service.ShopService;
import com.mshops.model.Shop;
import com.mshops.web.exceptions.ShopNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*") 
public class ShopController implements HealthIndicator {

	@Autowired
	ShopRepository shoprepository;
	
	//if there is no shops we can set the health of the ms to DOWN 
	@Override
	public Health health() {

		List<Shop> shops = shoprepository.findAll();

		if (shops.isEmpty()) {
			return Health.down().build();
		}
		return Health.up().build();
	}

	// GEt list of all shop
	@GetMapping(value = "/Shops")
	public List<Shop> ShopList() {

		List<Shop> shop = shoprepository.findAll();

		if (shop.isEmpty())
			throw new ShopNotFoundException("there is not Shops :(");

		return shop;

	}
	@GetMapping(value = "/NearbyShop")
	public List<Shop> nearbyShop(){
	List<Shop> shop = shoprepository.findAllByOrderByLocationAsc();
	if (shop.isEmpty())
		throw new ShopNotFoundException("there is not Shops :(");

	return shop;
}

	// Get shop by Id
	@GetMapping(value = "/Shop/{id}")
	public Optional<Shop> GetShopbyId(@PathVariable int id) {

		Optional<Shop> shop = shoprepository.findById(id);

		if (!shop.isPresent())
			throw new ShopNotFoundException("Shop with the id : " + id + " not founded ");

		return shop;
	}
	@PostMapping(value = "/Shop/{id}")
	public void like(@PathVariable int id) {
		
	}
	
}
