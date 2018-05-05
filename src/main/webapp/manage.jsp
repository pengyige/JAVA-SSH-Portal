<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>传送门</title>
		<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
		<script type="text/javascript" src="easyUI/jquery.min.js"></script>
		<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/teleporteradmin.js"></script>
		
		<style type="text/css">
			#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
		</style>
		<script type="text/javascript" src="http://api.map.baidu.com/library/CurveLine/1.5/src/CurveLine.min.js"></script>
        <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=YIRMkVCFvhEwojKsaWTPkoosINMPNQWg"></script>
	</head>
	<body>
		<nav class="navbar navbar-default">
			 <div class="container-fluid">
				<div class="navbar-header">
				  <a class="navbar-brand" href="#">
					<img alt="传送门" src="img/logo.jpg" style="width:60px;height:35px;">
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
		
		
		<!-- 运营管理操作区 -->
		<div style="margin-top:2px;margin-bottom:10px;height:600px;padding:10px 20px;background-color:#EEEEE0">
			<div id="allmap"></div>
			<script type="text/javascript">
			// 百度地图API功能
			  var map = new BMap.Map("allmap");
			  map.centerAndZoom(new BMap.Point(114.269808,30.599749),15);
			  map.enableScrollWheelZoom(true);
			  // 添加带有定位的导航控件
			  var navigationControl = new BMap.NavigationControl({
			    // 靠左上角位置
			    anchor: BMAP_ANCHOR_TOP_LEFT,
			    // LARGE类型
			    type: BMAP_NAVIGATION_CONTROL_LARGE,
			    // 启用显示定位
			    enableGeolocation: true
			  });
			  map.addControl(navigationControl);
			  // 添加定位控件
			  var geolocationControl = new BMap.GeolocationControl();
			  geolocationControl.addEventListener("locationSuccess", function(e){
			    // 定位成功事件
			    var address = '';
			    address += e.addressComponent.province;
			    address += e.addressComponent.city;
			    address += e.addressComponent.district;
			    address += e.addressComponent.street;
			    address += e.addressComponent.streetNumber;
			    alert("当前定位地址为：" + address);
			  });
			  geolocationControl.addEventListener("locationError",function(e){
			    // 定位失败事件
			    alert(e.message);
			  });
			  map.addControl(geolocationControl);
			
			 //获取所有订单并显示在地图上
			 $.ajax({
				 url:'userorder_getAllOrders.action',
				 method:'POST',
				 success:function(result){
					 if(result.state == 1){
						 for(var i = 0; i < result.userOrders.length;i++){
							 var point = new BMap.Point(result.userOrders[i].longitude,result.userOrders[i].latitude);
							/*  var point = new BMap.Point(114.269449,30.599827); */
							 createOrderPoint(point,map, result.userOrders[i]);
						 }
					 }
				 }
			 });
		
			
			</script>
		</div>	

		
		<!-- 左边管理区 -->
		<div style="width:20%;margin-top:1px;background-color:#EEEEE0;float:left;">
			<ul class="nav nav-pills nav-stacked">
				<li role="presentation" class="active"><a id="queryRider" href="#">骑手管理</a></li>
				<li role="presentation" ><a id="operationManagement" href="#">运营管理</a></li>
			</ul>
		</div>
		
		<!-- 右边操作区 -->
		<div style="width:75%;height:400px;margin-top:1px;margin-right:3px;float:right;text-align:center">
			<!-- 骑手管理操作区 -->
			<div style="background-color:#EEEEE0;">
				  <ul class="nav nav-tabs" role="tablist">
				    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">骑手登记或注销</a></li>
				    <li role="presentation"><a href="#queryRiderDiv" aria-controls="queryRiderDiv" role="tab" data-toggle="tab">查询骑手</a></li>
				  </ul>
				
				  <div class="tab-content" >
				    	<!-- 骑手登记注销-->
				    <div role="tabpanel" class="tab-pane active" id="home" style="width:400px;margin:5px auto;padding-bottom:20px;">
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
							  <input id="username" type="text" class="form-control" placeholder="骑手别名" aria-describedby="basic-addon2" readonly>
							</div>
							
							<div class="input-group">
							  <span class="input-group-addon" id="basic-addon3"><span class="glyphicon glyphicon-eye-open" aria-hidden="true" ></span></span>
							  <input id="sex" type="text" class="form-control" placeholder="性别" aria-describedby="basic-addon3" readonly>
							</div>	
							
							<div class="input-group">
							  <span class="input-group-addon" id="basic-addon4"><span class="glyphicon glyphicon-home" aria-hidden="true"></span></span>
							  <input id="realName" type="text" class="form-control" placeholder="真实姓名" aria-describedby="basic-addon4" readonly>
							</div>
							
							<div class="input-group">
							  <span class="input-group-addon" id="basic-addon4"><span class="glyphicon  glyphicon-road" aria-hidden="true"></span></span>
							  <input id="IDNumber" type="text" class="form-control" placeholder="身份证号码" aria-describedby="basic-addon4" readonly>
							</div>
							
							<div class="input-group">
							  <span class="input-group-addon" id="basic-addon4"><span class="glyphicon glyphicon-tags" aria-hidden="true"></span></span>
							  <input id="address" type="text" class="form-control" placeholder="住址" aria-describedby="basic-addon4" readonly>
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
		
		
		<!-- 骑手详细信息对话框 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">骑手工作信息</h4>
		      </div>
		      <div class="modal-body">
		         <div>
		         	<label>周订单总数:</label>
		         	<font>66</font>
		         	
		         	<label>月订单数:</label>
		         	<font>234</font>
				 </div>
				 
				 <div style="margin-top:10px;">
		         	订单信息
				 </div>
		      	  
		 		  <table class="table table-hover" id="orderTable">
					 <tr>
					 	<th>编号</th>
					 	<th>详情</th>
					 </tr>
					 
					 <tr>
					 	<td>201858221524405537562</td>
					 	<td><a>详情</a></td>
					 </tr>
				  </table>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- 骑手派单对话框 -->
		<div class="modal fade" id="SendOrderModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">骑手派单</h4>
		      </div>
		      <div class="modal-body">
		         <div>
		         	<label >订单ID:</label>
		         	<font id="userorderId"></font>
				 </div>
				 
				 <div style="margin-top:10px;">
				 	<label >请输入骑士手机号:</label>
		         	<form class="form-inline" onsubmit="return false;">
						
							<div class="input-group">
							  <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span></span>
							  <input id="sendOrderTelInput" type="text" class="form-control" placeholder="请输入骑手手机号" aria-describedby="basic-addon1">
							</div>
							
						   <button id="sendOrderBtn" class="btn btn-default">派单</button>
						  
						</form>
				 </div>
		      	  
		 		  <table class="table table-hover" id="resultRidersTableForSend">
				  </table>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		      </div>
		    </div>
		  </div>
		</div>
	</body>
</html>