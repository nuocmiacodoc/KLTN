package com.packt.webbi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webbi.domain.User;
import com.packt.webbi.domain.repository.UserRepository;
import com.packt.webbi.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUserName(username);
	}
	
	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public float getUserPoint(String username) {
		try {
			return userRepository.getUserPoint(username);
		}
		catch(Exception e) {
			return 0;
		}
	}

	@Override
	public void saveUserpPoint(String username, Float point) {

		userRepository.saveUserpPoint(username, point);
	}

	@Override
	public void updateUserRating(int point, String username, String productId) {
		userRepository.updateUserRating(point, username, productId);
	}

	@Override
	public int getUserRating(String username, String productId) {
		return userRepository.getUserRating(username, productId);
	}
}
