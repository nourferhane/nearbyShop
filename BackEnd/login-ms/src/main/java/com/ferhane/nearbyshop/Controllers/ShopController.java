package com.ferhane.nearbyshop.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferhane.nearbyshop.Entities.Shop;
import com.ferhane.nearbyshop.Repository.ShopRepository;

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
	@GetMapping(value = "/api/Shops")
	public List<Shop> ShopList() {

		List<Shop> shop = shoprepository.findAll();
		return shop;

	}
	@GetMapping(value = "/api/NearbyShop")
	public List<Shop> nearbyShop(){
	List<Shop> shop = shoprepository.findAllByOrderByLocationAsc();


	return shop;
}

	// Get shop by Id
	@GetMapping(value = "/api/Shop/{id}")
	public Optional<Shop> GetShopbyId(@PathVariable int id) {

		Optional<Shop> shop = shoprepository.findById(id);
		return shop;
	}
	@PostMapping(value = "/api/Shop/{id}")
	public void like(@PathVariable int id) {
		
	}
	
}
