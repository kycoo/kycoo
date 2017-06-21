package com.kycoo.service.Impl;

import com.kycoo.domain.Province;
import com.kycoo.persistence.ProvinceDao;
import com.kycoo.service.ProvinceService;

public class ProvinceServiceImpl implements ProvinceService {
	
	private ProvinceDao provinceDao;
	@Override
	public String getProvince(Province pro) {
		return provinceDao.save(pro);
	}
}
