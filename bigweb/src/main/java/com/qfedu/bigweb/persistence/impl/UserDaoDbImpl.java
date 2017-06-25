package com.qfedu.bigweb.persistence.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qfedu.bigweb.domain.User;
import com.qfedu.bigweb.persistence.UserDao;

@Repository
public class UserDaoDbImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(User user) {
		return sessionFactory.getCurrentSession().save(user) != null;
	}

	@Override
	public User findByUsername(String username) {
		return sessionFactory.getCurrentSession().get(User.class, username);
	}
	
	@Override
	public List<User> findAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from User").getResultList();
	}

}
