<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>用户注销测试</h2>
	<form action="user_logout.action" method="post">
		token:<input name="token" type="text"/>
		<input type="submit" value="提交"/>
	</form>
<hr/>
<hr/>
<br/>
<h2>用户注册测试</h2>
	<form action="user_register.action" method="post">
		tel:<input name="tel" type="text"/>
		<input type="submit" value="提交"/>
	</form>
<hr/>
<hr/>
<br/>
	
<h2>用户登入测试</h2>
	<form action="user_login.action" method="post">
		tel:<input name="tel" type="text"/>
		password:<input name="password" type="post"/>
		<input type="submit" value="提交"/>
	</form>
	
<h2>用户手机登入测试</h2>
	<form action="user_loginByTel.action" method="post">
		tel:<input name="tel" type="text"/>
		<input type="submit" value="提交"/>
	</form>
<hr/>
<hr/>
<br/>

<h2>用户修改测试</h2>
	<form action="user_updateUser.action" method="post">
		token:<input name="token" type="text"/>
		userId:<input name="userId" type="text"/>
		password:<input name="password" type="text"/>
		username:<input name="username" type="text"/>
		type:<input name="type" type="text"/>
		<input type="submit" value="提交"/>
	</form>
	
<hr/>
<hr/>
<br/>
<h2>用户名是否存在测试</h2>
	<form action="user_nameIsExist.action" method="post">
		username:<input name="username" type="text"/>
		<input type="submit" value="提交"/>
	</form>
	
<hr/>
<hr/>
<br/>
<h2>用户手机号是否存在测试</h2>
	<form action="user_telIsExist.action" method="post">
		tel:<input name="tel" type="text"/>
		<input type="submit" value="提交"/>
	</form>	
	

<hr/>
<hr/>
<br/>
<h2>添加订单测试</h2>

	<form action="userorder_add.action" method="post">
		token:<input name="token" type="text"/>
		userId:<input name="userId" type="text"/>
		shipAddress:<input name="shipAddress" type="text"/>
		shipName:<input name="shipName" type="text"/>
		shipTel:<input name="shipTel" type="text"/>
		receiveAddress:<input name="receiveAddress" type="text"/>
		receiveName:<input name="receiveName" type="text"/>
		receiveTel:<input name="receiveTel" type="text"/>
		payment:<input name="payment" type="text"/>
		remark:<input name="remark" type="text"/>
		state:<input name="state" type="text"/>
		<input type="submit" value="提交"/>
	</form>

<hr/>
<hr/>
<br/>
<h2>查询订单测试</h2>

	<form action="userorder_query.action" method="post">
		token:<input name="token" type="text"/>
		userId:<input name="userId" type="text"/>
		state:<input name="state" type="text"/>
		<input type="submit" value="提交"/>
	</form>
	
<hr/>
<hr/>
<br/>
<h2>修改用户订单状态测试</h2>

	<form action="userorder_updateState.action" method="post">
		token:<input name="token" type="text"/>
		userOrderId:<input name="userOrderId" type="text"/>
		state:<input name="state" type="text"/>
		<input type="submit" value="提交"/>
	</form>	
	
<hr/>
<hr/>
<br/>
<h2>修改用户订单状态测试</h2>

	<form action="userorder_cancelOrder.action" method="post">
		token:<input name="token" type="text"/>
		userOrderId:<input name="userOrderId" type="text"/>
		<input type="submit" value="提交"/>
	</form>	
	
<hr/>
<hr/>
<br/>
<h2>骑手注册测试</h2>
	<form action="rider_register.action" method="post">
		tel:<input name="tel" type="text"/>
		deviceToken:<input name="deviceToken" tye="text" />
		<input type="submit" value="提交"/>
	</form>
	
	
<hr/>
<hr/>
<br/>
<h2>骑手手机号登入测试</h2>
	<form action="rider_loginByTel.action" method="post">
		tel:<input name="tel" type="text"/>
		<input type="submit" value="提交"/>
	</form>
	
<hr/>
<hr/>
<br/>
<h2>骑手是否已登记测试</h2>
	<form action="rider_isCheckin.action" method="post">
		token:<input name="token" type="text"/><br/>
		tel:<input name="tel" type="text"/><br/>
		<input type="submit" value="提交"/>
	</form>	
		
	
<hr/>
<hr/>
<br/>
<h2>骑手传送点登记测试</h2>
	<form action="rider_checkin.action" method="post">
		teleporterId:<input name="teleporterId" type="text"/><br/>
		riderId:<input name="riderId" type="text"/><br/>
		<input type="submit" value="提交"/>
	</form>
	
	
	
	
<hr/>
<hr/>
<br/>
<h2>骑手信息修改测试</h2>
	<form action="rider_update.action" method="post">
		token:<input name="token" type="text"/><br/>
		riderId:<input name="riderId" type="text"/><br/>
		username:<input name="username" type="text"/><br/>
		password:<input name="password" type="text"/><br/>
		sex:<input name="sex" type="text"/><br/>
		tel:<input name="tel" type="text"/><br/>
		riderState:<input name="riderState" type="text"/><br/>
		<input type="submit" value="提交"/>
	</form>
	
	
<hr/>
<hr/>
<br/>
<h2>骑手接单测试</h2>
	<form action="riderorder_receive.action" method="post">
		token:<input name="token" type="text"/><br/>
		userOrderId:<input name="userOrderId" type="text"/><br/>
		riderId:<input name="riderId" type="text"/><br/>
		<input type="submit" value="提交"/>
	</form>

<hr/>
<hr/>
<br/>
<h2>查询所有骑手订单测试</h2>
	<form action="riderorder_findAll.action" method="post">
		token:<input name="token" type="text"/><br/>
		riderId:<input name="riderId" type="text"/><br/>
		<input type="submit" value="提交"/>
	</form>
	
	
<hr/>
<hr/>
<br/>
<h2>查管理员登入测试</h2>
	<form action="teleporterAdmin_login.action" method="post">
	
		tel:<input name="tel" type="text"/><br/>
		password:<input name="password" type="text"/><br/>
		<input type="submit" value="提交"/>
	</form>
	
</body>
</html>