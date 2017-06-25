<%@page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户登录</title>
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
  </head>

  <body>
    <div class="container">
      <form id="loginForm" class="form-signin" action="login" method="post">
        <h2 class="form-signin-heading">用户登录</h2>
        <label for="username" class="sr-only">请输入用户名</label>
        <span class="err">&nbsp;${hint}</span>
        <input type="text" id="username" name="username" class="form-control" placeholder="请输入用户名" required autofocus>
        <label for="passwrod" class="sr-only">请输入密码</label>
      	<span class="err">&nbsp;</span>
        <input type="password" id="password"  name="password" class="form-control" placeholder="请输入密码" required>
        <span class="err">&nbsp;</span>
        <img id="code" src="code" />
        <input type="text" id="vc"  name="vc" class="form-control" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me">两周以内自动登录
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>
      <div style="margin:0 auto; max-width:330px; padding: 20px 20px;">
      	<a href="toReg">马上注册</a>
      </div>
    </div>
    <script src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#code').on('click', function() {
				$(this).attr('src', 'code?' + Math.random());
			});
			
			$('#loginForm').on('submit', function(evt) {
				evt.preventDefault();
				if (checkUsername() & checkPassword()) {
					this.submit();
				}
			});
			
			function checkUsername() {
				if (/^\w{4,20}$/.test($('#username').val())) {
					$('#username').prev().html('&nbsp;');
					return true;
				} else {
					$('#username').prev().text('必须是字母数字下划线且长度为4-20个字符');
					return false;
				}
			}
			
			function checkPassword() {
				if (/^.{6,}$/.test($('#password').val())) {
					$('#password').prev().html('&nbsp;');
					return true;
				} else {
					$('#password').prev().text('密码至少6个字符');
					return false;
				}
			}
		});
		
	</script>
  </body>
</html>