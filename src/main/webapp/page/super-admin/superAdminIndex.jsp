<%@page import="top.yigege.domain.SuperAdmin"%>
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
	 SuperAdmin superAdmin = (SuperAdmin)(request.getSession().getAttribute("top.yigege.session.user")); %>
	
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
		   
		    <!-- 时间 -->
		   	<div class="navbar-text running-text time">
		   		上次登入时间  <span style="padding:0 10px;">|</span> <span class="glyphicon glyphicon-time"></span>  

<fmt:formatDate value="${lastlogintime}" pattern="yyyy-MM-dd hh:mm:ss"/>


		   	</div>
		   
		   <!-- 头像 -->
		    <div class="navbar-text pic-div">
		    	<img class="admin-pic img-circle" src="${pageContext.request.contextPath}/asserts/img/jieshao1.jpg"/>
		    
	    		<!-- 下拉 -->
				<div class="dropdown" style="display:inline;">
				  <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				    <span class="glyphicon glyphicon-user"> </span>&nbsp;&nbsp;<%= superAdmin.getUsername() %>
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
		   	 	<!-- 传送点管理 -->
			    <div class="panel panel-default">
			        <div class="panel-heading">
			            <h4 class="panel-title">
			                <a data-toggle="collapse" data-parent="#accordion" 
			                href="#collapseOne">
			           			<i class="fa fa-cog"></i> 传送点</a>
			                </a>
			            </h4>
			        </div>
			        <div id="collapseOne" class="panel-collapse collapse in">
			            <div class="panel-body">
			                <div class="list-group">
							
							  <a class="list-group-item" href="javascript:;" onclick="intoTeleporterManagerPage();"><i class="fa fa-cog fa-fw"></i>&nbsp; 查询传送点</a>
							</div>
			            </div>
			        </div>
			    </div>
		   
			   <!-- 传送管理员管理 -->
			    <div class="panel panel-default">
			        <div class="panel-heading">
			            <h4 class="panel-title">
			                <a data-toggle="collapse" data-parent="#accordion" 
			                href="#collapseTwo">
			           			<i class="fa fa-cog"></i> 传送管理员</a>
			                </a>
			            </h4>
			        </div>
			        <div id="collapseTwo" class="panel-collapse collapse in">
			            <div class="panel-body">
			                <div class="list-group">
							  <a class="list-group-item" href="#"><i class="fa fa-home fa-fw"></i>&nbsp; Home</a>
							  <a class="list-group-item" href="#"><i class="fa fa-book fa-fw"></i>&nbsp; Library</a>
							  <a class="list-group-item" href="#"><i class="fa fa-pencil fa-fw"></i>&nbsp; Applications</a>
							  <a class="list-group-item" href="#"><i class="fa fa-cog fa-fw"></i>&nbsp; Settings</a>
							</div>
			            </div>
			        </div>
			    </div>
		    
		    
		    	<!-- 系统消息管理 -->
			    <div class="panel panel-default">
			        <div class="panel-heading">
			            <h4 class="panel-title">
			                <a data-toggle="collapse" data-parent="#accordion" 
			                href="#collapseThree">
			           			<i class="fa fa-cog"></i> 系统消息</a>
			                </a>
			            </h4>
			        </div>
			        <div id="collapseThree" class="panel-collapse collapse in">
			            <div class="panel-body">
			                <div class="list-group">
							  <a class="list-group-item" href="#"><i class="fa fa-home fa-fw"></i>&nbsp; Home</a>
							  <a class="list-group-item" href="#"><i class="fa fa-book fa-fw"></i>&nbsp; Library</a>
							  <a class="list-group-item" href="#"><i class="fa fa-pencil fa-fw"></i>&nbsp; Applications</a>
							  <a class="list-group-item" href="#"><i class="fa fa-cog fa-fw"></i>&nbsp; Settings</a>
							</div>
			            </div>
			        </div>
			    </div> 
			    
			    
			    <!-- 用户管理 -->
			   <div class="panel panel-default">
			        <div class="panel-heading">
			            <h4 class="panel-title">
			                <a data-toggle="collapse" data-parent="#accordion" 
			                href="#collapseUser">
			           			<i class="fa fa-cog"></i> 用户消息</a>
			                </a>
			            </h4>
			        </div>
			        <div id="collapseUser" class="panel-collapse collapse in">
			            <div class="panel-body">
			                <div class="list-group">
							  <a class="list-group-item" href="#"><i class="fa fa-home fa-fw"></i>&nbsp; Home</a>
							  <a class="list-group-item" href="#"><i class="fa fa-book fa-fw"></i>&nbsp; Library</a>
							  <a class="list-group-item" href="#"><i class="fa fa-pencil fa-fw"></i>&nbsp; Applications</a>
							  <a class="list-group-item" href="#"><i class="fa fa-cog fa-fw"></i>&nbsp; Settings</a>
							</div>
			            </div>
			        </div>
			    </div>
		    
		    
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
							  <a class="list-group-item" href="#"><i class="fa fa-home fa-fw"></i>&nbsp; Home</a>
							  <a class="list-group-item" href="#"><i class="fa fa-book fa-fw"></i>&nbsp; Library</a>
							  <a class="list-group-item" href="#"><i class="fa fa-pencil fa-fw"></i>&nbsp; Applications</a>
							  <a class="list-group-item" href="#"><i class="fa fa-cog fa-fw"></i>&nbsp; Settings</a>
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
							  <a class="list-group-item" href="#"><i class="fa fa-home fa-fw"></i>&nbsp; Home</a>
							  <a class="list-group-item" href="#"><i class="fa fa-book fa-fw"></i>&nbsp; Library</a>
							  <a class="list-group-item" href="#"><i class="fa fa-pencil fa-fw"></i>&nbsp; Applications</a>
							  <a class="list-group-item" href="#"><i class="fa fa-cog fa-fw"></i>&nbsp; Settings</a>
							</div>
			            </div>
			        </div>
			    </div>
		    
		    
		    </div>
		</div>
	
	</div>
	
	<!-- 内部iframe -->	
	<iframe src="${pageContext.request.contextPath}/superAdmin_queryGeneralSituation.action" id="iframe" frameborder="0" scrolling="yes" marginheight="0" marginwidth="0"  width="85%" height="100%"></iframe>  
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
	            <label for="message-text" class="control-label">确定要退出系统吗？</label>
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
var LOGOUT_URL = "${pageContext.request.contextPath}/superAdmin_logout.action";
var QUERY_GENERAL_SITUATION_URL = "${pageContext.request.contextPath}/superAdmin_queryGeneralSituation.action";
var TELEPORTER_MANAGER_URL = "${pageContext.request.contextPath}/teleporter_intoTeleporterManagerPage.action";

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
 * 查询传送点
 */
function intoTeleporterManagerPage() {
	$("#iframe").attr("src",TELEPORTER_MANAGER_URL);
}
</script>