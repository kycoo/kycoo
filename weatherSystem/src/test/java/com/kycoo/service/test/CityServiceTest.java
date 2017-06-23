package com.kycoo.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kycoo.service.CityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:app.xml"})
public class CityServiceTest {
	
	@Autowired
	CityService cityService;
	
	@Test
	public void testGetCityById(){
		System.out.println(cityService.getCityById("101270101").getCityName());
	}
	
	@Test
	public void testGetCityByName(){
		
		cityService.getCityByName("³É¶¼");
	}
}
