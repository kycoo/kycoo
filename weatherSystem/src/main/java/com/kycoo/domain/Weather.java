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
 * @author ����
 *	�������ݻ�����Ϣ
 */
@Entity
@Table(name="tb_weather")
public class Weather implements Comparable<Weather>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; //�������
	
	private Integer highTemp;
	private Integer lowTemp;
	
	private Date date; //������Ӧ��ʱ��
	
	@ManyToOne
	@JoinColumn(name="cid")
	private City city; //������ʱ��
	
	private String weather;//����
	
	private Integer quality; //��������
	
	private String windDirection;//����
	
	private Date upDateTime; //��������ʱ��

	private boolean isDay;//�ǲ���ĳ�������{t,f}

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
