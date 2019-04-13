<%@page import="top.yigege.domain.SuperAdmin"%>
<%@ page import="top.yigege.domain.TeleporterAdmin" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html>
<head>
	<meta charset="utf-8" />
	<title>传送门-首页</title>
	
	<link href="${pageContext.request.contextPath}/asserts/css/common.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap/bootstrap.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/asserts/css/font-awesome/font-awesome.css" rel="stylesheet" />
	
	<script src="${pageContext.request.contextPath}/asserts/js/jquery/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap/bootstrap.js" type="text/javascript"></script>
		
	<style>
        @font-face {
            font-family: 'Glyphicons Halflings';
            src: url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.eot');
            src: url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.eot?#iefix') format('embedded-opentype'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.woff') format('woff'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.ttf') format('truetype'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.svg#glyphicons_halflingsregular') format('svg');
        }
        
		#logo{
			width:80px;
			height:50px;
		}
		
		.title {
			padding:15px 0;
			font-size: 17px;
		    color: #999999;
		    font-weight: bold;
		}
		
		.logout {
			padding:15px 0;
		}
		
		.running-text {

		    background: none repeat scroll 0 0 rgba(0, 0, 0, 0.2);
		    border: 1px solid rgba(0, 0, 0, 0.2);
		    border-radius: 30px;
		    box-shadow: 0 1px 0 rgba(255, 255, 255, 0.1);
		    color: #FFFFFF;
		    margin: 6px;
		    padding: 5px 5px;
		    width: 30%;
		
		}
		
		
		.digital {

		    border-right: 1px solid rgba(0, 0, 0, 0.4);
		    box-shadow: 1px 0 0 rgba(255, 255, 255, 0.1);
		    float: left;
		    margin-left: -25px;
		    margin-right: -25px;
		    padding-right: 15px;
		
		}
		
		.time {
			margin-top: 25px;
		    margin-left: 100px;
		    text-align: center;
		    font-size: 12px;
		}
		
		.admin-pic {

		    border: 2px solid rgba(255, 255, 255, 0.8);
		    display: inline-block;
		    float: left;
		    height: 45px;
		    margin-left: -15px;
		    margin-right: 19px;
		    margin-top: -12px;
		    width: 45px;
		
		}
		
		.pic-div {
		    padding-top: 15px;
   			float:right;
     	 }
	</style>
</head>
<body>

	<%
	 TeleporterAdmin teleporterAdmin = (TeleporterAdmin)(request.getSession().getAttribute("top.yigege.session.user"));

	%>
	
	<nav class="navbar navbar-inverse" style="margin-bottom:0;border-radius:0;">
	  <div class="container-fluid">
	      <a class="navbar-brand" href="#">
	        <img id="logo" alt="Brand" src="${pageContext.request.contextPath}/asserts/img/logo.jpg">
	      </a>
		   
		    <p class="navbar-text title">传送门后台管理系统</p>
		   
		    <p class="navbar-right navbar-text logout">
		    <button type="button" class="btn btn-danger  " id="logout">
		  		<span class="glyphicon  glyphicon-off" aria-hidden="true"></span> 注销</button>
		    </p>
		   
		    <!-- 传送点 -->
		   	<div class="navbar-text running-text time">
		   		当前传送点  <span style="padding:0 10px;">|</span> <span class="glyphicon glyphicon-map-marker"></span>

				<span id="teleporterAddress"><%=teleporterAdmin.getTeleporter().getAddress()%></span>

		   	</div>
		   
		   <!-- 头像 -->
		    <div class="navbar-text pic-div">
		    	<img class="admin-pic img-circle" src="${pageContext.request.contextPath}/asserts/img/jieshao1.jpg"/>
		    
	    		<!-- 下拉 -->
				<div class="dropdown" style="display:inline;">
				  <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				    <span class="glyphicon glyphicon-user"> </span>&nbsp;&nbsp;<%= teleporterAdmin.getUsername() %>
				    <!-- <span class="caret"></span> -->
				  </button>
				  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				    <li><a href="#">个人资料</a></li>
				    <li><a href="#">修改密码</a></li>
				    <li><a href="#">关于我们</a></li>
				    <li role="separator" class="divider"></li>
				    <li><a href="#">帮助</a></li>
				  </ul>
				</div>
		    </div>
		   
		  
		    
		    
	    
		</div>
	</nav>

	<div class="panel panel-primary" style="width:15%;height:100%;float:left;border-radius:0;">
		<div class="panel-heading" style="border-radius:0;">
	  	  <h3 class="panel-title">
	  		 <i class="fa fa-cog"></i> 菜单列表</a>
	  	  </h3>
	  	</div>
	  	<!-- 内容 -->
	  	<div class="panel-body">
	  		 <!--  -->
	  		 <div id="generalSituation">
	  		 	<a class="btn btn-danger" href="#" style="width: 100%;margin-bottom: 20px;font-size: 12px;">
	  <i class="fa fa-font-awesome" ></i> 总体概况</a>
	  		 </div>
	  	
		   	 <div class="panel-group" id="accordion">

		    	<!-- 骑手管理 -->
			    <div class="panel panel-default">
			        <div class="panel-heading">
			            <h4 class="panel-title">
			                <a data-toggle="collapse" data-parent="#accordion" 
			                href="#collapseFive">
			           			<i class="fa fa-cog"></i> 骑手管理</a>
			                </a>
			            </h4>
			        </div>
			        <div id="collapseFive" class="panel-collapse collapse in">
			            <div class="panel-body">
			                <div class="list-group">
							  <a class="list-group-item" href="#" onclick="intoRiderManagerPage();"><i class="fa fa-home fa-fw"></i>&nbsp; 查询骑手</a>

							</div>
			            </div>
			        </div>
			    </div>
		    
		    	<!-- 订单管理 -->
			    <div class="panel panel-default">
			        <div class="panel-heading">
			            <h4 class="panel-title">
			                <a data-toggle="collapse" data-parent="#accordion" 
			                href="#collapseSix">
			           			<i class="fa fa-cog"></i> 订单管理</a>
			                </a>
			            </h4>
			        </div>
			        <div id="collapseSix" class="panel-collapse collapse in">
			            <div class="panel-body">
			                <div class="list-group">
							  <a class="list-group-item" href="#" onclick="intoOrderManagerPage();"><i class="fa fa-home fa-fw"></i>&nbsp; 查询订单</a>
							</div>
			            </div>
			        </div>
			    </div>
		    
		    
		    </div>
		</div>
	
	</div>
	
	<!-- 内部iframe -->	
	<iframe src="${pageContext.request.contextPath}/teleporterAdmin_queryGeneralSituation.action" id="iframe" frameborder="0" scrolling="yes" marginheight="0" marginwidth="0"  width="85%" height="100%"></iframe>
	<!-- 确认框 -->
	<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
	        <h4 class="modal-title" id="exampleModalLabel">传送门</h4>
	      </div>
	      <div class="modal-body">
	        <form>
	       	<div class="form-group">
	            <label class="control-label">确定要退出系统吗？</label>
	          </div>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal" id="cancel">取消</button>
	        <button type="button" class="btn btn-danger" id="ok">确认</button>
	      </div>
	    </div>
	  </div>
	</div>

</body>

<script>
var LOGOUT_URL = "${pageContext.request.contextPath}/teleporterAdmin_logout.action";
/**总体概况*/
var QUERY_GENERAL_SITUATION_URL = "${pageContext.request.contextPath}/teleporterAdmin_queryGeneralSituation.action";

/**骑手管理*/
var RIDER_MANAGER_URL = "${pageContext.request.contextPath}/rider_intoRiderManagerPageForTeleporterAdmin.action";
/**订单管理*/
var ORDER_MANAGER_URL = "${pageContext.request.contextPath}/userOrder_intoOrderManagerPage.action";

$(function() {
	$("#logout").click(function (){
		$("#confirmModal").modal();
	});
	
	$("#ok").click(function (){
		window.location.href = LOGOUT_URL;
	});
	
	$("#cancel").click(function (){
		$("#confirmModal").hide();
	})
	
	/*总体概述  */
	$("#generalSituation").click(function (){
		$("#iframe").attr("src",QUERY_GENERAL_SITUATION_URL);
	});
	
	
});



/**
 * 查询骑手
 */
function intoRiderManagerPage() {
	$("#iframe").attr("src",RIDER_MANAGER_URL);
}

/**
 * 查询订单
 */
function intoOrderManagerPage() {
	$("#iframe").attr("src",ORDER_MANAGER_URL);
}


</script>