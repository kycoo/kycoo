package com.kycoo.persistence;

import java.io.Serializable;
import java.util.List;
public interface BaseDao <E, K extends Serializable>{

	K save(E entity);
	
	E findById(K id);
	
	void delete(E entity);
	
	List<E> findAll();
}