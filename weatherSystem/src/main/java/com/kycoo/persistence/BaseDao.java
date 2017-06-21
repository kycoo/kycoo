package com.kycoo.persistence;

import java.io.Serializable;
public interface BaseDao <E, K extends Serializable>{

	K save(E entity);
	
	E findById(K id);
}