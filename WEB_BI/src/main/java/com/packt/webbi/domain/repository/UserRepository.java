package com.packt.webbi.domain.repository;


import com.packt.webbi.domain.User;

public interface UserRepository {

	User findByUserName(String name);

	float getUserPoint(String username);

	void saveUserpPoint(String username, Float point);

	void save(User user);
	
	void updateUserRating(int point, String username, String productId );
	
	int getUserRating(String username, String productId);
	
}
