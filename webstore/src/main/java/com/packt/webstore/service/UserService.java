package com.packt.webstore.service;

import com.packt.webstore.domain.User;

public interface UserService {
	
    void save(User user);

    float getUserPoint(String username);
    
    void saveUserpPoint(String username, Float point);
    
    User findByUsername(String username);
    
    void updateUserRating(int point, String username, String productId );
    
    int getUserRating(String username, String productId);
}
