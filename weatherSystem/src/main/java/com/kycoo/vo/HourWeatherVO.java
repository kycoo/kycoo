package com.kycoo.vo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.kycoo.domain.Weather;
import com.mysql.fabric.xmlrpc.base.Array;

public class HourWeatherVO {
	private String hour;
	private Integer highTemp;
	private Integer lowTemp;
	
	public HourWeatherVO() {
		// TODO Auto-generated constructor stub
	}
	
	public HourWeatherVO(Weather w){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(w.getDate());
		hour = calendar.get(Calendar.HOUR_OF_DAY)+"";
		highTemp = w.getHighTemp();
		lowTemp = w.getLowTemp();
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
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
	
	
}
