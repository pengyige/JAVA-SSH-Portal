<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<html>
	<meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0,user-scalable=no"/>
	<title>传送门-总体概况</title>


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
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap-select/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap-select/defaults-zh_CN.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap-datetimepicker/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>


	<script type="text/javascript" src="http://api.map.baidu.com/library/CurveLine/1.5/src/CurveLine.min.js"></script>
	<script type="text/javascript"  src="http://api.map.baidu.com/api?v=2.0&ak=eKfSoepxBKNA7eHrIqtPDmMYIukGaaiG"></script>
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

	    #portalMap {width: 100%;height: 60%;overflow: hidden;margin:0;font-family:"微软雅黑";}

		 [data-id=dispacherRiderSelect] {
			 height:30px;
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
					<div id="portalMap"></div>
		  	</div>
		</div>






		<!-- 派单模态框 -->
		<div class="modal fade" id="dispacherOrderDialog" tabindex="-1" role="dialog"  aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" >派单对话框</h4>
					</div>
					<div class="modal-body">
						<form action="#" class="form-horizontal" role="form">
							<!-- 订单信息 -->
							<div class="form-group">
								<label class="col-sm-3 control-label">订单编号</label>
								<div class="col-sm-9">
									<fieldset disabled>
										<input class="form-control" id="dispacherUserOrderId" type="text" disable value="">
									</fieldset>
								</div>
							</div>



							<!-- 标题 -->
							<div class="form-group">
								<label class="col-sm-3 control-label">用户名</label>
								<div class="col-sm-9">
									<fieldset disabled>
										<input class="form-control" id="dispacherUsername" type="text" value="">
									</fieldset>
								</div>
							</div>

							<!-- 用户手机号-->
							<div class="form-group">
								<label class="col-sm-3 control-label">手机号</label>
								<div class="col-sm-9">
									<fieldset disabled>
										<input class="form-control" id="dispacherTel" type="text" value="">
									</fieldset>
								</div>
							</div>



							<%--骑手--%>
							<div class="form-group">
								<label class="col-sm-3 control-label">骑手</label>
								<div class="col-sm-9">
									<select  id="dispacherRiderSelect" class="selectpicker"  data-live-search="true">

									</select>
								</div>
							</div>




						</form>
					</div>
					<div class="modal-footer">
						<button id="dipacherDialogDiapacherBtn" type="button" class="btn btn-primary">派单</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
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
//当前传送点所有未接单订单
var GET_UN_RECEIVE_ORDER = "${pageContext.request.contextPath}/userOrder_queryUnReceiveOrder.action";
//派单请求
var DISPACHER_ORDER = "${pageContext.request.contextPath}/userOrder_dispacherOrder.action";
//获取当前传送点所有骑手
var GET_RIDER_FOR_TELEPORTER = "${pageContext.request.contextPath}/rider_queryRiderForDispacher.action";
/**地图*/
var map = null;
/**websocket*/
var webSocket = null;
/**骑手*/
var global_riders = null;


$(function (){

	//初始化消息
 	initMessenge();

 	//初始化监听
 	initListener();

 	//初始化地图连接socket
 	initWebSocket();

	//初始化地图
	initPortalMap();

	//初始化所有骑手
	initRiders();

	//获取所有未接单订单
	loadDataForOrder();

});

/**
 * 初始化定位socket
 */
function initWebSocket() {

	if("WebSocket" in window){
		webSocket = new WebSocket(LOCATION_WEB_SOCKET);

	}else if ('MozWebSocket' in window){
		webSocket = new MozWebSocket(webSocketUrl);
	}else {
		$.globalMessenger().post({
			message: "您的浏览器不支持WebSocket",//提示信息
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

	//派单点击
	$("#dipacherDialogDiapacherBtn").click(function () {
		//判断骑手
		var riderId = $("#dispacherRiderSelect").selectpicker('val');
		if (null == riderId || "" == riderId) {
			$.globalMessenger().post({
				message: '请选择骑手',//提示信息
				type: 'error',//消息类型。error、info、success
				hideAfter: 2,//多长时间消失
				showCloseButton: true,//是否显示关闭按钮
				hideOnNavigate: true //是否隐藏导航

			});
			return;
		}else {
			var userOrderId = $("#dispacherUserOrderId").val();
			sendDispacherOrderRequest(userOrderId,riderId);
		}
	});
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

/**
 * 初始化地图
 */
function initPortalMap() {
	// 百度地图API功能
	map = new BMap.Map("portalMap");
	map.enableScrollWheelZoom(true);
	// 创建地址解析器实例
	var myGeo = new BMap.Geocoder();



	// 将地址解析结果显示在地图上，并调整地图视野
	myGeo.getPoint(getParentPortalAddress(), function(point){
				if (point) {
					console.log(point);
					map.centerAndZoom(point, 15);
					map.addOverlay(new BMap.Marker(point));
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
				}else {
					$.globalMessenger().post({
						message: "定位错误",//提示信息
						type: 'error',//消息类型。error、info、success
						hideAfter: 2,//多长时间消失
						showCloseButton:true,//是否显示关闭按钮
						hideOnNavigate: true //是否隐藏导航

					});
				}
			});

}


/**
 * 获取父窗口传送点地址
 * @returns {string}
 */
function getParentPortalAddress() {

	return window.parent.document.getElementById("teleporterAddress").innerText;
}

/**
 * 创建地图订单覆盖物
 * @param point
 * @param map
 * @param orderData
 */
function createOrderPoint(point,map,orderData) {

	//设置订单图片
	var myIcon = new BMap.Icon("${pageContext.request.contextPath}/asserts/img/orderIcon.png", new BMap.Size(32,32));
	var marker = new BMap.Marker(point,{icon:myIcon});
	map.addOverlay(marker);
	//设置订单数据
	marker.z.label = orderData;


	//设置右键菜单
	var markerMenu = new BMap.ContextMenu();
	var clickListenerFunc = function dispacherOrderClickListener(e,ee,marker) {
		console.log(marker);
		//订单ID
		$("#dispacherUserOrderId").val(marker.z.label.userOrderId);
		//用户名
		$("#dispacherUsername").val(marker.z.label.user.username);
		//发件人手机号
		$("#dispacherTel").val(marker.z.label.user.tel);
		$("#dispacherOrderDialog").modal();
	}
	markerMenu.addItem(new BMap.MenuItem('派单',clickListenerFunc.bind(marker)));
	marker.addContextMenu(markerMenu);

	//设置点击提示框
	var infoOpts = {
		width : 250,
		height: 150,
		title:"<h4 style='width:100%;text-align:center'>用户订单</h4>",
		enableMessage:true
	}
	var infoWindow = new BMap.InfoWindow("订单编号:"+orderData.userOrderId+"<br/>发件地址:"+orderData.shipAddress+"<br/>手机号:"+orderData.shipTel+"<br/>下单时间:"+orderData.orderTime,infoOpts);
	marker.addEventListener("click",function () {
		map.openInfoWindow(infoWindow,point);
	})


}

/**
 * 发送派单请求
 * @param userOrderId
 * @param riderId
 */
function sendDispacherOrderRequest(userOrderId, riderId) {

	var requestParam  = {
		"userOrderId":userOrderId,
		"riderId":riderId
	};

	$.ajax({
		url:DISPACHER_ORDER,
		method:'POST',
		dataType:'json',
		data:requestParam,
		beforeSend:sendRequestBeforeHandle(),
		success:function (result) {
			$("#waitDialog").modal('hide');
			if (200 == result.code) {
				$.globalMessenger().post({
					message: result.message,//提示信息
					type: 'error',//消息类型。error、info、success
					hideAfter: 2,//多长时间消失
					showCloseButton: true,//是否显示关闭按钮
					hideOnNavigate: true //是否隐藏导航

				});
				$("#dispacherOrderDialog").modal('hide');
				//清空骑手下拉
				$("#dispacherRiderSelect").selectpicker('val','');
			}else {
				$.globalMessenger().post({
					message: result.message,//提示信息
					type: 'error',//消息类型。error、info、success
					hideAfter: 2,//多长时间消失
					showCloseButton: true,//是否显示关闭按钮
					hideOnNavigate: true //是否隐藏导航

				});
			}
		},
		fail:function () {
			sendRequestFailHandle();
		}
	});
}

/**
 * 初始化所有骑手
 */
function initRiders() {
	$.ajax({
		url:GET_RIDER_FOR_TELEPORTER,
		method:'POST',
		dataType:'json',
		beforeSend:sendRequestBeforeHandle(),
		success:function (result) {
			$("#waitDialog").modal('hide');
			if (200 == result.code) {
				console.log(result.message);
				var riders = result.message;
				//初始化骑手
				for (var i = 0 ; i < riders.length; i ++) {
						var option = $('<option></option>');
						option.attr('value', riders[i].riderId);
						option.text(riders[i].username+"("+riders[i].tel+")");
						$('#dispacherRiderSelect').append(option);




					//默认选中无
					$('#dispacherRiderSelect').selectpicker('val','');

					$('#dispacherRiderSelect').selectpicker('refresh');
					$('#dispacherRiderSelect').selectpicker('render');

				}
			}else {
				$.globalMessenger().post({
					message: result.message,//提示信息
					type: 'error',//消息类型。error、info、success
					hideAfter: 2,//多长时间消失
					showCloseButton: true,//是否显示关闭按钮
					hideOnNavigate: true //是否隐藏导航

				});
			}
		},
		fail:function () {
			sendRequestFailHandle();
		}
	});
}

/**
 * 获取所有订单
 */
function loadDataForOrder() {
	$.ajax({
		url:GET_UN_RECEIVE_ORDER,
		method:'POST',
		dataType:'json',
		beforeSend:sendRequestBeforeHandle(),
		success:function (result) {
			$("#waitDialog").modal('hide');
			if (200 == result.code) {
				console.log(result.message);
				var userOrderArr = result.message;
				//将订单显示在地图上
				for (var i = 0 ; i < userOrderArr.length; i ++) {
					var point = new BMap.Point(userOrderArr[i].longitude,userOrderArr[i].latitude);
					//创建覆盖物
					createOrderPoint(point,map,userOrderArr[i])

				}
			}else {
				$.globalMessenger().post({
					message: result.message,//提示信息
					type: 'error',//消息类型。error、info、success
					hideAfter: 2,//多长时间消失
					showCloseButton: true,//是否显示关闭按钮
					hideOnNavigate: true //是否隐藏导航

				});
			}
		},
		fail:function () {
			sendRequestFailHandle();
		}
	});
}


</script>
