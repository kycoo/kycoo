package com.kycoo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author 张汪
 *	天气数据基本信息
 */
@Entity
@Table(name="tb_weather")
public class Weather implements Comparable<Weather>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; //天气编号
	
	private Integer highTemp;
	private Integer lowTemp;
	
	private Date date; //天气对应的时间
	
	@ManyToOne
	@JoinColumn(name="cid")
	private City city; //天气的时间
	
	private String weather;//天气
	
	private Integer quality; //空气质量
	
	private String windDirection;//风向
	
	private Date upDateTime; //天气更新时间

	private boolean isDay;//是不是某天的天气{t,f}

	public boolean isDay() {
		return isDay;
	}

	public void setDay(boolean isDay) {
		this.isDay = isDay;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHighTemp() {
		return highTemp;
	}

	public void setHighTemp(Integer highTemp) {
		this.highTemp = highTemp;
	}

	public Integer getLowTemp() {
		return lowTemp;
	}

	public void setLowTemp(Integer lowTemp) {
		this.lowTemp = lowTemp;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public Date getUpDateTime() {
		return upDateTime;
	}

	public void setUpDateTime(Date upDateTime) {
		this.upDateTime = upDateTime;
	}

	@Override
	public int compareTo(Weather o) {
		return date.after(o.getDate()) ? 1 : 0;
	}


	
}
