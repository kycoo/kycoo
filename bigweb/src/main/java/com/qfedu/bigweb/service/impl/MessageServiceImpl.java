package com.qfedu.bigweb.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfedu.bigweb.domain.Message;
import com.qfedu.bigweb.domain.PageModel;
import com.qfedu.bigweb.persistence.MessageDao;
import com.qfedu.bigweb.service.MessageService;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageDao messageDao;
	
	@Override
	public PageModel<Message> getMessagesByPage(int page, int size) {
		return messageDao.findByPage(page, size);
	}

}
