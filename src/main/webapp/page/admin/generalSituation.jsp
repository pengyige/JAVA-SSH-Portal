<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<html>
	<meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>传送门-登入</title>

	<link href="${pageContext.request.contextPath}/asserts/css/common.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap/bootstrap.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/asserts/css/font-awesome/font-awesome.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/asserts/css/font-awesome/font-awesome.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap-table/bootstrap-table.css" rel="stylesheet"type="text/css" />
	<link href="${pageContext.request.contextPath}/asserts/css/messenger/messenger.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap-select/bootstrap-select.min.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/asserts/css/messenger/messenger-theme-ice.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>


	<script src="${pageContext.request.contextPath}/asserts/js/common.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/jquery/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap/bootstrap.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/echarts/echarts.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/messenger/messenger.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/messenger/messenger-theme-future.js" type="text/javascript"></script>

	<style type="text/css">
	 @font-face {
            font-family: 'Glyphicons Halflings';
            src: url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.eot');
            src: url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.eot?#iefix') format('embedded-opentype'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.woff') format('woff'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.ttf') format('truetype'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.svg#glyphicons_halflingsregular') format('svg');
        }
	
		.panel-body > ul > li {
			width:200px;
			padding:10px 10px;
			float:left;
			display:inline-block;
			text-align:center;
			margin-left:30px;
			margin-top:12px;
			background-color: #e7d6b8;
			border-radius:5px;
		}
		
		.num {
			font-size: 25px;
	   		color: darkorange;
	   		padding-left: 10px;
		}
	</style>
	
	<body>
		<!-- 导航栏 -->
		<ol class="breadcrumb">
		  <li><a href="">首页</a></li>
		  <li class="active">总体概况</li>
		</ol>
		
		<div class="panel panel-info">
			<div class="panel-heading" style="border-radius:0;">
		  	  <h5 class="panel-title">
		  		 <i class="fa fa-cog"></i> 概况</a>
		  	  </h5>
		  	</div>
		  	
		  	<div class="panel-body" style=" background-color: cornsilk;text-align: center">
		  		<%--地图--%>

		  	</div>
		</div>

		</div>

		<!-- 等待框 -->
		<div class="modal fade" id="waitDialog">
			<div class="modal-dialog modal-sm" style="text-align:center">

				<i class="fa fa-spinner fa-pulse fa-5x"></i>
			</div><!-- /.modal-dialog -->
		</div>
	</body>
</html>

<script>
//全局请求路径
//获取数量
var GET_PORTAL_COUNT = "${pageContext.request.contextPath}/user_queryTotalCount.action";
//websocket请求
//var LOCATION_WEB_SOCKET_URL = ROOT_PROTOCOL+"://"+ROOT_HOST+":"+ROOT_PORT+"${pageContext.request.contextPath}/locationWebSocket";

var webSocket = null;


$(function (){

	//初始化消息
 	initMessenge();

 	//初始化监听
 	initListener();

 	//初始化地图连接socket
 	initWebSocket();

});

/**
 * 初始化定位socket
 */
function initWebSocket() {
	alert(LOCATION_WEB_SOCKET);
	if("WebSocket" in window){
		webSocket = new WebSocket(LOCATION_WEB_SOCKET);

	}else if ('MozWebSocket' in window){
		webSocket = new MozWebSocket(webSocketUrl);
	}else {
		$.globalMessenger().post({
			user: "您的浏览器不支持WebSocket",//提示信息
			type: 'error',//消息类型。error、info、success
			hideAfter: 5,//多长时间消失
			showCloseButton:true,//是否显示关闭按钮
			hideOnNavigate: true //是否隐藏导航

		});
		return ;
	}

	webSocket.onopen = connWebSocketEvent;
	webSocket.onmessage = messWebSocketEvent;
	webSocket.onclose = closeWeBSocketEvent;
}

/**
 * 监听
 */
function initListener() {

}


/**
 * 连接事件
 */
function connWebSocketEvent(){
	/*var messageJson = JSON.stringify({
		username : "游客",
		imageUrl : imageUrl,
		type : "1"
	});

	webSocket.send(messageJson);*/
}

/**
 * 收到消息事件
 */
function messWebSocketEvent(ev){
	/*var message = ev.data;
	/!*alert("服务器返回的数据为:"+message);*!/
	var messageJson = eval("("+message+")");
	//1:表达新用户连接到服务器,更新列表
	if(messageJson.type == "1")
	{
		addUserInfo(messageJson);
		return;
	}

	if(messageJson.type == "2"){
		alert("系统消息");
		sendLeaveMessage(messageJson);
		return;
	}

	addChatList(messageJson);*/
	console.log(ev.data);

}

/**
 * 关闭事件
 */
function closeWeBSocketEvent(){
	/*alert("退出连接");*/
	/*var messageJson = JSON.stringify({
        username : username,
        type : "2"
    });
    webSocket.send(messageJson);*/
}

</script>
