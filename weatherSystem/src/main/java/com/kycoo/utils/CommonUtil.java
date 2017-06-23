package com.kycoo.utils;

import java.util.Calendar;
import java.util.Date;

public final class CommonUtil {

	public static Date getTodayStartDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND,0);
		return formatDate(calendar.getTime());
		
	} 
	/**
	 * 
	 * @param dateString "2017 06 22 00 00 00"
	 * @return
	 */
	public static Date convetString2Date(String dateString){
		StringBuffer sb = new StringBuffer(dateString);
 		for(int i=dateString.length();i<14;i++){
 			sb.append("0");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.valueOf(sb.substring(0, 4)), 
				Integer.valueOf(sb.substring(4, 6)) - 1, 
				Integer.valueOf(sb.substring(6, 8)), 
				Integer.valueOf(sb.substring(8, 10)), 
				Integer.valueOf(sb.substring(10, 12)), 
				Integer.valueOf(sb.substring(12)));
		return formatDate(calendar.getTime());
	}

	/**
	 * 设置整数描述的毫秒数为0
	 * @return
	 */
	public static Date formatDate(Date date){
		return new Date(date.getTime() / 1000 * 1000);
	}
	
	public static Date getCurentHour() {
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.MINUTE, Cla);
		return null;
	}
}
