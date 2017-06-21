package com.kycoo.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kycoo.po.CityInfo;
import com.kycoo.po.DayWeather;
import com.kycoo.po.HourWeather;

import com.kycoo.domain.City;
import com.kycoo.domain.Weather;

public final class WeatherUtil {
	
	private WeatherUtil() {
		
		throw new AssertionError();
	}
	private static Map<String, String> HEADERS;
	private static final String HOST="http://saweather.market.alicloudapi.com";
	
	private static final String APP_CODE="6b8c74b1ee014586b0dda28a56d487b9";
	private static final String METHORD_GET="GET";
	//private static final String METHORD_POST="POST";
	static{
		HEADERS = new HashMap<>();
		HEADERS.put("Authorization", "APPCODE " +APP_CODE);
	}

	
//	private static final String 
	
	public static List<Weather> listThisWeekWeatherByIp(String ip){
	    List<Weather> weathers = null;
		String path = "/ip-to-weather";
	   	Map<String, String> querys = new HashMap<String, String>();
	    querys.put("ip", ip);
	    querys.put("need3HourForcast", "0");
	    querys.put("needAlarm", "0");
	    querys.put("needHourData", "0");
	    querys.put("needIndex", "0");
	    querys.put("needMoreDay", "1");
	    String jsonString =getJson(path, querys);
	    weathers = parserJson2WeekWeather(jsonString);
	    return weathers;
		
	}
	private static List<Weather> parserJson2WeekWeather(String jsonString){
		List<Weather> weathers = new ArrayList<>();
		JSONObject  jsonObject = JSONObject.parseObject(jsonString);
    	jsonObject = jsonObject.getJSONObject("showapi_res_body");
    	
    	DayWeather dayWeather = null;
    	Weather weather = null;
    	CityInfo cityInfo = jsonObject.getObject("cityInfo", CityInfo.class);
    	
    	//获取城市信息
    	City city = cityInfo.getCity();
    	
    	
    	for(int i=1;i<=7;i++){
    		dayWeather = JSONObject.parseObject(jsonObject.getString("f"+i).toString(),DayWeather.class);
    		weather = dayWeather.getWeatherFormObj();
    		weather.setCity(city);
    		weathers.add(weather);
    	}

    	return weathers;
	}
	/**
	 * 
	 * @param dateString "2017 06 22 00 00 00"
	 * @return
	 */
	public static Date convetString2Date(String dateString){
		for(int i=dateString.length();i<14;i++){
			dateString += "0";
		}
		System.out.println(dateString);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.valueOf(dateString.substring(0, 4)), 
				Integer.valueOf(dateString.substring(4, 6)), 
				Integer.valueOf(dateString.substring(6, 8)), 
				Integer.valueOf(dateString.substring(8, 10)), 
				Integer.valueOf(dateString.substring(10, 12)), 
				Integer.valueOf(dateString.substring(12)));
		return calendar.getTime();
	}

	private static String getJson(String path,Map<String, String> querys){
		return getJson(path, querys, METHORD_GET, HEADERS, HOST);
	}
	private static String getJson( String path, Map<String,String> querys
			, String method 
			,Map<String,String> headers,
			String host){
		String jsonString=null;
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
		    	//获取response的body
		    	jsonString = EntityUtils.toString(response.getEntity());
			} catch (Exception e) {
		    	e.printStackTrace();
		    	return jsonString;
		    }
			return jsonString;
		}
	
	
	
	public static List<Weather> get24HourWeatherByArea(String areaName,String areaId) {
		List<Weather> weathers = new ArrayList<>();
		String path = "/hour24";
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("area", areaName==null?"":areaName);
		querys.put("areaid", areaId==null?"":areaId);
		String jsonString = getJson(path, querys);
		if(jsonString != null){
			JSONObject jsonObject = JSONObject.parseObject(jsonString);
			jsonObject = jsonObject.getJSONObject("showapi_res_body");
	    	City city = new City();
	    	city.setCityName(jsonObject.getString("area"));
	    	city.setId(jsonObject.getString("areaid"));
	    	
	    	JSONArray jsonArray =jsonObject.getJSONArray("hourList");
	    	Weather weather = null;
	    	for (int i = 0; i < jsonArray.size(); i++) {
	    		weather = jsonArray.getObject(i, HourWeather.class)
	    				.getWeatherFormObj();
	    		weather.setCity(city);
				weathers.add(weather);
	    	}
		}	
		return weathers;  
	}
	
}
