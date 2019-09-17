package com.ferhane.nearbyshop.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ferhane.nearbyshop.Entities.User;
import com.ferhane.nearbyshop.Repository.UserRepository;

public class UserService implements IUserService {

	//Dependency injection
	@Autowired
    UserRepository userRepository;
	
	@Override
	public Optional<User> getUser(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User AddUser(User newUser) {
		return userRepository.save(newUser);
		}

	

	@Override
	public void deleteUser(Long id) {
		 userRepository.deleteById(id);
	}

	
	@Override
	public Optional<User> findByEmail(String email) {
		return userRepository.findByUsername(email);
	}

	@Override
	public String login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
