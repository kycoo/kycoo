package com.kycoo.po;

import com.kycoo.domain.Weather;

/**
 * 获得天气数据
 * @author 张汪
 *
 */
public interface GetWeatherAble {
	/**
	 * 可以获得weather数据
	 * @return
	 */
	Weather getWeatherFormObj();
}
