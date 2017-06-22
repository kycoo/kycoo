<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<!-- Head -->

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>欢迎使用</title>

		<!--利用meta标签对viewport(显示窗口)进行控制-->
		<!--也就是 显示窗口 宽度 是 客户端的 屏幕 宽度 （就是 满屏 ！），显示的文字和图形的初始比例 是 1.0-->
		<meta name="viewport" content="width=device-width,initial-scale=1" />

		<!-- Style -->
		<link rel="stylesheet" type="text/css" href="css/style.css" />

	</head>

	<!-- Body -->

	<body onload="startTime()">

		<!-- Heading -->
		<h1>Kycoo天气</h1>
		<!-- //Headng -->

		<!-- Container -->
		<div class="container">

			<!-- City -->
			<div class="city">
				<div class="title">
					<h2>北京市</h2>
					<h3>北京</h3>
				</div>
				<div class="date-time">
					<div class="dmy">
						<div id="txt"></div>
					</div>
					<div class="temperature">
						<p>20<span>℃</span></p>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<!-- //City -->

			<!-- Forecast -->
			<div class="forecast">
				<!--temperature：图片显示-->
				<div class="forecast-icon">
					<img src="images/forecast.png" alt="New York Weather Widget">
				</div>
				<div class="today-weather">
					<!--temperature-->
					<h3>天气情况</h3>
					<ul>
						<li>今天 <span> 20°C</span></li>
						<li>09:00 <span> 22°C</span></li>
						<li>12:00 <span> 24°C</span></li>
						<li>15:00 <span> 23°C</span></li>
						<li>18:00 <span> 20°C</span></li>
					</ul>
				</div>
			</div>
			<!-- //Forecast -->
			<div class="clear"></div>
		</div>
		<!-- //Container -->

		<!--app网页加载时响应-->
		<!--`type="application/x-javascript"` 中的 “x” 是“实验”的意思，这种声明有点老，但和 `type="application/javascript"` 一样，只是支持的浏览器更多一点-->
		<script type="text/javascript">
			addEventListener("load", function() {
				//setTimeout() 方法用于在指定的毫秒数后调用函数或计算表达式。
				setTimeout(hideURLbar, 0);
			}, false);

			function hideURLbar() {
				//定义和用法 scrollTo() 方法可把内容滚动到指定的坐标。 
				window.scrollTo(0, 1);
			}
		</script>

		<!-- Time-JavaScript -->
		<script>
			function startTime() {
				//Date 对象用于处理日期和时间。
				//Date 对象会自动把当前日期和时间保存为其初始值。
				var today = new Date();
				//获取时间
				var h = today.getHours();
				var m = today.getMinutes();
				var s = today.getSeconds();
				m = checkTime(m);
				s = checkTime(s);
				document.getElementById('txt').innerHTML =
					h + ":" + m + ":" + s;
				var t = setTimeout(startTime, 500);
			}

			function checkTime(i) {
				if(i < 10) {
					i = "0" + i
				}; // add zero in front of numbers < 10
				return i;
			}
		</script>

	</body>

</html>