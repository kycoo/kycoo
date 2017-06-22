package com.kycoo.persistence.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.kycoo.persistence.BaseDao;


@SuppressWarnings("unchecked")
public abstract class BaseDaoHibernateAdapter<E, K extends Serializable> implements BaseDao<E, K> {
	@Autowired
	protected SessionFactory sessionFactory;
	
	protected Class<E> entityType;
	protected String entityTypeName;
	
	public BaseDaoHibernateAdapter() {
		ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
		entityType = (Class<E>) pt.getActualTypeArguments()[0];
		entityTypeName = entityType.getSimpleName();
	}
	
	
	@Override
	public K save(E entity) {
		return (K) sessionFactory.getCurrentSession().save(entity);
	}

	
	@Override
	public E findById(K id) {
		return sessionFactory.getCurrentSession().get(entityType, id);
	}
	
}
