package com.qfedu.bigweb.service;

import java.util.List;

import com.qfedu.bigweb.domain.Message;
import com.qfedu.bigweb.domain.User;

public interface UserService {

	boolean login(String username, String password);
	
	boolean register(User user);
	
	boolean publishMessage(Message message);
	
	List<User> getAllUsers();
}
