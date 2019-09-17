package com.mshops.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mshops.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
	List<Shop> findByNameContainingIgnoreCase(@Param("k") String keyword);
	List<Shop> findAllByOrderByLocationAsc();

}
