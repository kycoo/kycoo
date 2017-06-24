package com.kycoo.po;

import java.io.Serializable;

import com.kycoo.domain.City;
import com.kycoo.domain.Province;
/**
 * 
 * @author 张汪
 *	json数据转换的网络数据对象
 */
public class CityInfo
	implements Serializable,GetCityAble,GetProvinceAble{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String c1; //区域id
	private String c2; //城市英文名称
	private String c3; //城市中文名称
	private String c4; //城市所在英文名
	private String c5; //城市所在中文名
	private String c6; //城市所在英文省名
	private String c7; //城市所在中文省名
	private String c8; //城市所在国家英文名
	private String c9; //城市所在国家中文名
	private String c10; //城市级别
	private String c11; //城市区号
	private String c12; //城市邮编
	private String c15; //海拔
	private String c17; 
	private String c16;//雷达站号

	private Double latitude; //纬度
	private Double longitude; //经度
	public String getC1() {
		return c1;
	}
	public void setC1(String c1) {
		this.c1 = c1;
	}
	public String getC2() {
		return c2;
	}
	public void setC2(String c2) {
		this.c2 = c2;
	}
	public String getC3() {
		return c3;
	}
	public void setC3(String c3) {
		this.c3 = c3;
	}
	public String getC4() {
		return c4;
	}
	public void setC4(String c4) {
		this.c4 = c4;
	}
	public String getC5() {
		return c5;
	}
	public void setC5(String c5) {
		this.c5 = c5;
	}
	public String getC6() {
		return c6;
	}
	public void setC6(String c6) {
		this.c6 = c6;
	}
	public String getC7() {
		return c7;
	}
	public void setC7(String c7) {
		this.c7 = c7;
	}
	public String getC8() {
		return c8;
	}
	public void setC8(String c8) {
		this.c8 = c8;
	}
	public String getC9() {
		return c9;
	}
	public void setC9(String c9) {
		this.c9 = c9;
	}
	public String getC10() {
		return c10;
	}
	public void setC10(String c10) {
		this.c10 = c10;
	}
	public String getC11() {
		return c11;
	}
	public void setC11(String c11) {
		this.c11 = c11;
	}
	public String getC12() {
		return c12;
	}
	public void setC12(String c12) {
		this.c12 = c12;
	}
	public String getC15() {
		return c15;
	}
	public void setC15(String c15) {
		this.c15 = c15;
	}
	public String getC17() {
		return c17;
	}
	public void setC17(String c17) {
		this.c17 = c17;
	}
	public String getC16() {
		return c16;
	}
	public void setC16(String c16) {
		this.c16 = c16;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	@Override
	public City getCity() {
		City city = new City();
    	city.setCityName(getC3());
    	city.setId(getC1());
    	city.setLatitude(getLatitude());
    	city.setLongitude(getLongitude());
    	city.setProvince(getProvince());
		return city;
	}
	
	@Override
	public Province getProvince() {
		//获取省份信息
    	Province province = new Province();
    	province.setName(getC7());
		return province;
	}

	
	
}
