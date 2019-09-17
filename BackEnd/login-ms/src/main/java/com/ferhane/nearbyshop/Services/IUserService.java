package com.ferhane.nearbyshop.Services;

import java.util.Optional;

import com.ferhane.nearbyshop.Entities.User;


public interface IUserService {
		Optional<User> getUser(Long id);
	    User AddUser(User newUser);
	    void deleteUser(Long id);
	    Optional<User> findByEmail(String email);
	    String login(String email, String password);


}
