package com.qfedu.bigweb.service.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qfedu.bigweb.domain.Message;
import com.qfedu.bigweb.domain.User;
import com.qfedu.bigweb.persistence.MessageDao;
import com.qfedu.bigweb.persistence.UserDao;
import com.qfedu.bigweb.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private MessageDao messageDao;
	
	
	@Override
	public boolean login(String username, String password) {
		User user = userDao.findByUsername(username);
		if (user != null) {
			String md5 = DigestUtils.md5Hex(password);
			return user.getPassword().equals(md5);
		}
		return false;
	}

	@Override
	public boolean register(User user) {
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		return userDao.save(user);
	}
	
	@Override
	public boolean publishMessage(Message message) {
		return messageDao.save(message) != null;
	}
	
	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

}
