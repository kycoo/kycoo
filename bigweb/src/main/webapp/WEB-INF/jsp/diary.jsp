<%@ page pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>写日记</title>
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<style>
			.pager { 
				display: inline-block; 
				font-size: 18px;
				width: 92px;
				height: 36px;
				line-height: 36px;
				border: 2px solid white;
				border-radius: 8px 8px 8px 8px;
				color:white;	
			}
			
			#bar a:link, #bar a:visited { 
				color: white; 
			}
			
		</style>
	</head>
	<body>
		<div class="head">
			<ul>
				<c:if test="${not empty username}">
				<li><img src="" class="head_user_icon" /></li>
				<li class="userName">${username}</li>
				</c:if>
				<c:if test="${empty username}">
				<li>
					<a href="toLogin">登录</a>
				</li>
				</c:if>
				<li>
					<img src="images/musicBtnOff.png" id="musicBtn" onclick="PlayPause(this)" /> 
					<audio id="MusicPlayer">
						<source src="mp3/成都.mp3"></source>
					</audio>
				</li>
				<li id="time" class="time">00:00:00</li>
			</ul>
		</div>
		<div class="back"></div>
		
		<c:if test="${not empty username}">
		<form action="pub" method="post" enctype="multipart/form-data">
			<div class="send_content">
				<div class="content">
					<div class="tour_content">
						<textarea id="message" name="message" required placeholder="你想说点啥"></textarea>
						<a>上传图片<input type="file" id="photo" name="photo"  required /></a> 
						<input type="submit" id="publish"value="发表" />
						<a>上传音乐 <input type="file" id="music" name="music"  required /></a>
					</div>
				</div>
			</div>
		</form>
		</c:if>
		
		<c:forEach items="${messageList}" var="message">
		<div class="record">
			<div class="record_history">
				<img src="images/${message.photo}" id="record_img" class="record_img" />
				<div class="record_info">
					<a id="delete" class="delete">×</a>
					<p id="record_descript" class="record_descript">${message.content}</p>
					<div id="record_music" class="record_music">
						<a href="mp3/${message.music}">
						<span id="music" class="music">《${message.songName}》</span>
						</a>
					</div>
					<div class="user_info">
						<img src="" id="user_icon" class="user_icon" />
						<p id="record_time" class="record_time">${message.pubDate}</p>
						<p id="record_userName" class="record_userName">
							<a href="showUserDiary?userid=${message.user.username}">${message.user.realname}</a>
						</p>
					</div>
				</div>
			</div>
			<!-- 
			<input type="text" class="record_comment"  placeholder="有什么需要评论的吗" /> 
			<input type="submit" class="sub_comment" onclick="Send_Comment()" />
			-->
		</div>
		</c:forEach>
		
		<div align="center" id="bar">
		<c:if test="${currentPage > 1}">
		<a href="index?page=${currentPage - 1}"  class="pager">上一页</a>&nbsp;&nbsp;
		</c:if>
		<c:if test="${currentPage < totalPage}">
		<a href="index?page=${currentPage + 1}" class="pager">下一页</a>
		</c:if>
		</div>
			
		<script src="js/tour_music.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/tour_date.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>