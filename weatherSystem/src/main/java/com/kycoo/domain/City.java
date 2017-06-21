package com.kycoo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author 张汪
 *
 *	city基本数据信息
 */

@Entity
@Table(name="tb_city")
public class City {
	
	@Id
	@Column(length=10)
	private String id;//鍩庡競id
	
	private String cityName;//鍩庡競鍚嶇О
	
	private Double longitude;//鍩庡競缁忓害
	private Double latitude;//鍩庡競绾害
	
	@ManyToOne
	@JoinColumn(name="pid")
	private Province province; //鐪佷唤

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	
	
	
}
