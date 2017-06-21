package com.kycoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kycoo.utils.WeatherUtil;

@Controller
public class Test {

	@GetMapping(name="/test")
	@ResponseBody
	public String test(){
		//WeatherUtil.getThisWeekWeatherByIp("182.149.163.34");
		return "hellosdas";
	}
}
