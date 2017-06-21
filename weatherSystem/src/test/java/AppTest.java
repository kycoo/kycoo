

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.kycoo.utils.WeatherUtil;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@Test
	public void parserJson(){
		System.out.println(WeatherUtil.getWeatherByIp("182.149.161.97"));
	}
}