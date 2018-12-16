<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>传送门登入</title>

	<!-- css引入 -->
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/ad_login.css"/>
	
	<!-- js引入 -->
	<script type="text/javascript" src="easyUI/jquery.min.js"></script>
</head>
<body>
	<form action="teleporterAdmin_login.action" method="post">
		<!-- 用户名 -->
		<div>
			<label>用户名:</label>
			<input type="text" name="username" placeholder="请输入用户名"/>
		</div>
		
		<!-- 密码 -->
		<div>
			<label>密码:</label>
			<input type="text" name="password" placeholder="请输入密码"/>
		</div>
		
		<!-- 登入 -->
		<div>
			<input type="submit" class="btn btn-primary" value="登      入"/>       
		</div>
		
		<span>${error}</span>
	</form>
</body>
</html>