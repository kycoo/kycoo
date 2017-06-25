<%@page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户注册</title>
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
  </head>

  <body>
    <div class="container">
      <form class="form-signin" action="reg" method="post">
        <h2 class="form-signin-heading">用户注册</h2>
        <label for="username" class="sr-only">请输入用户名</label>
        <span class="err">&nbsp;${hint}</span>
        <input type="text" id="username"  name="username" class="form-control" placeholder="请输入用户名" required autofocus>
        <label for="passwrod" class="sr-only">请输入密码</label>
        <input type="password" id="password"  name="password" class="form-control" placeholder="请输入密码" required>
        <label for="repasswrod" class="sr-only">请输入确认密码</label>
        <input type="password" id="repassword" class="form-control" placeholder="请输入确认密码" required>
        <label for="nickname" class="sr-only">请输入昵称</label>
        <input type="text" id="realname"  name="realname" class="form-control" placeholder="请输入昵称" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me">同意<a href="">"服务条款"</a>和<a href="">"隐私权相关政策"</a>
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
      </form>
      <div style="margin:0 auto; max-width:330px; padding: 20px 20px;">
      	<a href="toLogin">返回登录</a>
      </div>
    </div>
  </body>
</html>
