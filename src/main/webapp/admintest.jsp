<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>超级管理员页面</title>
</head>
<body>
<h2>添加传送点测试</h2>
<form action="teleporter_addTeleporter.action" method="post">
	address:<input type="text" name="address"/><br/>
	remark:<input type="text" name="remark"/><br/>
	<input type="submit" value="提交"/>
</form>

<hr/>
<hr/>
<h2>删除传送点测试</h2>
<form action="teleporter_deleteTeleporter.action" method="post">
	teleporterId:<input type="text" name="teleporterId"/><br/>
	<input type="submit" value="提交"/>
</form>

<hr/>
<hr/>
<h2>查询传送点测试</h2>
<form action="teleporter_queryAll.action" method="post">
	<input type="submit" value="提交"/>
</form>

<hr/>
<hr/>
<h2>添加管理员测试</h2>
<form action="teleporterAdmin_add.action" method="post">
	admin_porter_Id:<input type="text" name="teleporter_admin_Id"/><br/>
	username:<input type="text" name="username"/><br/>
	password:<input type="text" name="password"/><br/>
	tel:<input type="text" name="tel"/><br/>
	sex:<input type="text" name="sex"/><br/>
	<input type="submit" value="提交"/>
</form>


<hr/>
<hr/>
<h2>删除管理员测试</h2>
<form action="teleporterAdmin_deleteAdmin.action" method="post">
	telporterAdminId:<input type="text" name="telporterAdminId"/><br/>
	<input type="submit" value="提交"/>
</form>

<hr/>
<hr/>
<h2>查询管理员测试</h2>
<form action="teleporterAdmin_queryAll.action" method="post">
	<input type="submit" value="提交"/>
</form>




</body>
</html>