package com.kycoo.persistence.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kycoo.domain.City;
import com.kycoo.domain.Province;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:app.xml"})
public class TestPersistence {
	@Autowired
	SessionFactory sessionFactory;
	private Transaction tx;
	private Session session ;
	@Before
	public void startTx(){
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
	}
	@After
	public void commitTx(){
		tx.commit();
		session=null;
		tx = null;
	}
	
	
	@Test
	public void testAddCity(){
		City city = new City();
		city.setId("1100");
		city.setCityName("Äã²Â");
		city.setLatitude(1.0);
		city.setLongitude(1.0);
		session.save(city);
	}
	
	@Test
	public void testAddProv(){
		Province p = new Province();
		p.setId("123");
		p.setName("±±¾©");
		
		session.save(p);
		
	}
	
		
		
}
