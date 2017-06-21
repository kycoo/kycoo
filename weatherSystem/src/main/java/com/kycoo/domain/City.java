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
 *	城市类，描述城市基本信息
 */

@Entity
@Table(name="tb_city")
public class City {
	
	@Id
	@Column(length=10)
	private String id;//城市id
	
	private String cityName;//城市名称
	
	private Double longitude;//城市经度
	private Double latitude;//城市纬度
	
	@ManyToOne
	@JoinColumn(name="pid")
	private Province province; //省份

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
