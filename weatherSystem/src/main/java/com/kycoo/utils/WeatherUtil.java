package com.kycoo.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kycoo.domain.Weather;
import com.kycoo.po.*;
public final class WeatherUtil {
	
	private WeatherUtil() {
		
		throw new AssertionError();
	}
	
	private static final String HOST="http://saweather.market.alicloudapi.com";
	
	private static final String APP_CODE="6b8c74b1ee014586b0dda28a56d487b9";
	
//	private static final String 
	
	public static Weather getWeatherByIp(String ip){
	    String path = "/ip-to-weather";
	    String method = "GET";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + APP_CODE);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("ip", ip);
	    querys.put("need3HourForcast", "0");
	    querys.put("needAlarm", "0");
	    querys.put("needHourData", "0");
	    querys.put("needIndex", "0");
	    querys.put("needMoreDay", "0");
	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doGet(HOST, path, method, headers, querys);
	    	System.out.println(response.toString());
	    	//获取response的body
	    	String jsonString = EntityUtils.toString(response.getEntity());
	    	JSONObject  jsonObject = JSONObject.parseObject(jsonString);
	    	jsonObject = jsonObject.getJSONObject("showapi_res_body");
	    	jsonObject.getJSONObject("now");
	    	System.out.println(jsonObject.getString("f1").toString());
	    	//JSONObject.parseObject(jsonObject.getString("f1").toString(),WeatherDay.class);
//	    	JSONObject.p
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return null;
		
	}
	
	
}
