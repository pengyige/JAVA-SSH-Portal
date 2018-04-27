<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Fluid Layout - jQuery EasyUI Demo</title>
		<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
		<script type="text/javascript" src="easyUI/jquery.min.js"></script>
		<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/teleporteradmin.js"></script>
	</head>
	<body>
		<nav class="navbar navbar-default">
			 <div class="container-fluid">
				<div class="navbar-header">
				  <a class="navbar-brand" href="#">
					<img alt="传送门" src="...">
				  </a>
				</div>
				<p class="navbar-text" style="font-size:20px;margin-left:450px"s>传送门骑手管理</p>	
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${!empty teleporterAdmin }">
							<p class="navbar-text">欢迎,<label id="usernameLabel">${teleporterAdmin.getUsername()} &nbsp;&nbsp;</label><a href="teleporterAdmin_logout.action" style="margin-top:14px">注销</a></p>
							 <p class="navbar-text">${teleporterAdmin.getTeleporter().getAddress() }</p> 
						</c:when>
						
						<c:otherwise>
							<p class="navbar-text">您还没有登入,请先<a href="ad_login.jsp" style="color:blue;">登入</a></p>
							
						</c:otherwise>
					</c:choose>
					
				</ul>
			 </div>
		</nav>
		
		<!-- 左边管理区 -->
		<div style="width:20%;margin-top:1px;background-color:#E0EEE0;float:left;">
			<ul class="nav nav-pills nav-stacked">
				<li role="presentation" class="active"><a id="queryRider" href="#">骑手管理</a></li>
				<li role="presentation" ><a id="queryRider" href="#">XX</a></li>
			</ul>
		</div>
		
		<!-- 右边操作区 -->
		<div style="width:75%;height:400px;margin-top:1px;margin-right:3px;background-color:#E0EEE0;float:right;text-align:center">
			<div>
				  <ul class="nav nav-tabs" role="tablist">
				    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">骑手登记或注销</a></li>
				    <li role="presentation"><a href="#queryRiderDiv" aria-controls="queryRiderDiv" role="tab" data-toggle="tab">查询骑手</a></li>
				  </ul>
				
				  <div class="tab-content">
				    	<!-- 骑手登记注销-->
				    <div role="tabpanel" class="tab-pane active" id="home" style="width:400px;margin:5px auto;">
				    	<form class="form-inline" onsubmit="return false;">
						
							<div class="input-group">
							  <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span></span>
							  <input id="telInput" type="text" class="form-control" placeholder="请输入手机号" aria-describedby="basic-addon1">
							</div>
							
						   <button id="queryBtn" class="btn btn-default">查询</button>
						  
						</form>
						
						 <div style="margin-top:10px;margin-left:-10px;">
						   <div class="input-group">
							  <span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
							  <input id="username" type="text" class="form-control" placeholder="骑手姓名" aria-describedby="basic-addon2" readonly>
							</div>
							
							<div class="input-group">
							  <span class="input-group-addon" id="basic-addon3"><span class="glyphicon glyphicon-eye-open" aria-hidden="true" ></span></span>
							  <input id="sex" type="text" class="form-control" placeholder="性别" aria-describedby="basic-addon3" readonly>
							</div>	
							
							<div class="input-group">
							  <span class="input-group-addon" id="basic-addon4"><span class="glyphicon glyphicon-home" aria-hidden="true"></span></span>
							  <input id="address" type="text" class="form-control" placeholder="登记地址" aria-describedby="basic-addon4" readonly>
							</div>
							
							
							<div class="input-group">
							  <span class="input-group-addon" id="basic-addon5"><span class="glyphicon glyphicon-time" aria-hidden="true" ></span></span>
							  <input id="checkinDate" type="text" class="form-control" placeholder="登记时间" aria-describedby="basic-addon5" readonly>
							</div>
							<!-- 保存其他信息 -->
							<input id="riderId" type="hidden"/>
							<input id="teleporterId" type="hidden" value="${teleporterAdmin.getTeleporter().getTeleporterId() }"/>
						</div>
						
						<!-- 登记注销按钮 -->
						<div style="margin-top:10px;">
							<button id="checkinBtn" class="btn btn-primary" style="width:100px;">登&nbsp;&nbsp;记</button>
							<button id="logoutCheckinBtn" class="btn btn-danger" style="width:100px;margin-left:20px;">注&nbsp;&nbsp;销</button>
						</div>
				    </div>
				    	<!-- 查询骑手 -->
				    <div role="tabpanel" class="tab-pane" id="queryRiderDiv">
				    	<table id="resultRidersTable" class="table table-hover">
						</table>
				    </div>
				  </div>

			</div>
			
		</div>
		
	</body>
</html>