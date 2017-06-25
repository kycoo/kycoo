<%@ page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<h1>注册成功, 3秒以后自动跳转到登录界面.</h1>
		<script>
			setTimeout(function() {
				location.href = "login.jsp";
			}, 3000);
		</script>
	</body>
</html>