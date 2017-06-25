package com.qfedu.bigweb.persistence;

import java.util.List;

import com.qfedu.bigweb.domain.User;

// DAO = Data Access Object
// Data Accessor + Active Domain Object
// CRUD + Object
public interface UserDao {

	boolean save(User user);
	
	User findByUsername(String username);
	
	List<User> findAll();
}
