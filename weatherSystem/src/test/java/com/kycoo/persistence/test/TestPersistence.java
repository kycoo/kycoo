package com.kycoo.persistence.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.kycoo.domain.Weather;
import com.kycoo.persistence.WeatherDao;
import com.kycoo.utils.CommonUtil;
import com.kycoo.utils.WeatherUtil;

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
		city.setCityName("你猜");
		city.setLatitude(1.0);
		city.setLongitude(1.0);
		session.save(city);
	}
	
	@Test
	public  void addWeather(){
		List<Weather> weathers = WeatherUtil.listHalfMonthweather("成都", "");
		List<Weather> ws = WeatherUtil.list24HourWeatherByArea("成都", "");
		for(Weather w : weathers){
//			session.save(w.getCity());
			session.save(w);
		}
		for(Weather w : ws){
			session.save(w);
			
		}
	}
	
	@Test
	public void testAddProv(){
		Province p = new Province();
		p.setId("123");
		p.setName("北京");
		
		session.save(p);
		
	}
	
	
	@Autowired
	WeatherDao weatherDao;
	
	@Test
	public void getWeekWeatherByCity(){
		City city = new City();
		city.setId("101270101");
		city.setCityName("成都");
		Date date=CommonUtil.getTodayStartDate();
		
		List<Weather> weathers = session
			.createQuery("from Weather as w where w.isDay = 1 and w.date >= ? and w.city = ?",Weather.class)
			.setParameter(0, date)
			.setParameter(1, city)
			.setMaxResults(7)
			.getResultList();
		for(Weather w : weathers){
			System.out.println(w.getDate().getTime());
		}
	}
		
}
