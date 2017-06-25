package com.qfedu.bigweb.persistence.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qfedu.bigweb.domain.Message;
import com.qfedu.bigweb.domain.PageModel;
import com.qfedu.bigweb.persistence.MessageDao;

@Repository
public class MessageDaoDbImpl implements MessageDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer save(Message message) {
		return (Integer) sessionFactory.getCurrentSession().save(message);
	}

	@Override
	public PageModel<Message> findByPage(int page, int size) {
		List<Message> dataList = sessionFactory.getCurrentSession()
				.createQuery("from Message as m order by m.id desc", Message.class)
				.setFirstResult((page - 1) * size)
				.setMaxResults(size)
				.getResultList();
		int totalCount = sessionFactory.getCurrentSession()
				.createQuery("select count(m) from Message as m", Long.class)
				.getSingleResult().intValue();
		int totalPage = (totalCount - 1) / size + 1;
		return new PageModel<>(dataList, page, size, totalPage);
	}
}
