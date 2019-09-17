package com.ferhane.nearbyshop.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ferhane.nearbyshop.Entities.Role;
import com.ferhane.nearbyshop.Entities.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
    
}