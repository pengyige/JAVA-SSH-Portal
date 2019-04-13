<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<html>
	<meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>传送门-登入</title>

	<link href="${pageContext.request.contextPath}/asserts/css/common.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap/bootstrap.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/asserts/css/font-awesome/font-awesome.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/asserts/css/common.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/asserts/css/font-awesome/font-awesome.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap-table/bootstrap-table.css" rel="stylesheet"type="text/css" />
	<link href="${pageContext.request.contextPath}/asserts/css/messenger/messenger.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap-select/bootstrap-select.min.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/asserts/css/messenger/messenger-theme-ice.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>


	<script src="${pageContext.request.contextPath}/asserts/js/jquery/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap/bootstrap.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/echarts/echarts.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/common.js" type="text/javascript"></script>
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
		  		
		  		<ul style="display: inline-block">
		  			<li>
		  			<!-- 用户量 -->
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num" id="userCount">0</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info" >用户人数</span>
		  					</div>
		  				</div>
		  			</li>
		  			<li>
		  			<!-- 骑手量 -->
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num" id="riderCount">0</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info" >骑手人数</span>
		  					</div>
		  				</div>
		  			</li>
		  			<!-- 传送点 -->
		  			<li>
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num" id="teleporterCount">0</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info">传送点总数</span>
		  					</div>
		  				</div>
		  			</li>
		  			<!-- 传送点管理员 -->
		  			<li>
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num" id="teleporterAdminCount">0</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info">管理员人数</span>
		  					</div>
		  				</div>
		  			</li>
					<!-- 超管管理员 -->
					<li>
						<div>
							<i class="fa fa-cog"></i> <span class="num" id="superAdminCount">0</span></a>
							<div style="margin-top:10px;">
								<span class="label label-info">超管人数</span>
							</div>
						</div>
					</li>
		  		</ul>
		  		
		  	
		  		<ul style="display: inline-block">
		  			<li>
		  			<!-- 用户订单量 -->
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num" id="userOrderCount">0</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info">用户订单总数</span>
		  					</div>
		  				</div>
		  			</li>
		  			<li>
		  			<!-- 骑手订单总量 -->
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num" id="riderOrderCount">0</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info">骑手订单总数</span>
		  					</div>
		  				</div>
		  			</li>
		  			<!-- 交易金额 -->
		  			<li>
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num" id="amountCount">0</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info">总交易金额</span>
		  					</div>
		  				</div>
		  			</li>
					<!-- 消息总数 -->
					<li>
						<div>
							<i class="fa fa-cog"></i> <span class="num" id="userMessageCount">0</span></a>
							<div style="margin-top:10px;">
								<span class="label label-info">用户消息</span>
							</div>
						</div>
					</li>
		  			<!-- 消息总数 -->
		  			<li>
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num" id="messageCount">0</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info">消息总数</span>
		  					</div>
		  				</div>
		  			</li>
		  		</ul>
		
		  		<div style="clear:both;">
		  		<!-- 饼图表 -->
		  		<div id="userAndRiderPicChart" style="width: 400px;height:200px;"></div>
		  		
		  	
		  	
		  	
		  		
		  		</div>
		  		<!-- 每日注册量图表 -->
		  		<div class="panel panel-default" style="margin-top:24px;width:40%;float:left;">
				  <div class="panel-heading">
				    <h3 class="panel-title">最近一周用户注册量
				    
					    <span class="btn btn-default" style="float:right;position:relative;top:-5px;">
					    	<span class="glyphicon glyphicon-refresh" id="refreshUserRegister"></span>
					  	</span>
				  	
				  	</h3>
				  </div>
				  <div class="panel-body" >
				  		<div id="userRegisterChart" style="width: 100%;height:100%;"></div>
				  </div>
				</div>
				
				
				<!-- 每日骑手注册图表 -->
		  		<div class="panel panel-default" style="margin-top:24px;width:40%;float:left;margin-left:50px;">
				  <div class="panel-heading">
				    <h3 class="panel-title">最近一周骑手注册量
				    
					    <span class="btn btn-default" style="float:right;position:relative;top:-5px;">
					    	<span class="glyphicon glyphicon-refresh" id="refreshRiderRegister"></span>
					  	</span>
				  	
				  	</h3>
				  </div>
				  <div class="panel-body" >
				  		<div id="riderRegisterChart" style="width: 100%;height:100%;"></div>
				  </div>
				</div>
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
//获取用户注册数量
var GET_USER_REGISTER_TIME_COUNT = "${pageContext.request.contextPath}/user_queryRecentUserRegisterCount.action";
//获取骑手注册数量
var GET_RIDER_REGISTER_TIME_CUONT = "${pageContext.request.contextPath}/rider_queryRecentRiderRegisterCount.action";


$(function (){

	//初始化消息
 	initMessenge();

 	//初始化监听
 	initListener();
 	//初始化数据
	loadDataForCount();

	//加载用户注册数量
	loadDataForUserRegister();

	//加载骑手注册数量
	loadDataForRiderRegister();
});

function initListener() {
	$("#refreshUserRegister").click(function () {
		loadDataForUserRegister();
	});

	$("#refreshRiderRegister").click(function () {
		loadDataForRiderRegister();
	});
}

/**
 * 加载数据
 */
function  loadDataForCount() {
	$.ajax({
		url:GET_PORTAL_COUNT,
		method:'POST',
		dataType:'json',
		beforeSend:sendRequestBeforeHandle(),
		success:function (result) {
			$("#waitDialog").modal('hide');
			if (200 == result.code) {
				var countArr = result.message;

				$("#userCount").html(countArr[0]);
				$("#riderCount").html(countArr[1]);
				$("#teleporterCount").html(countArr[2]);
				$("#teleporterAdminCount").html(countArr[3]);
				$("#superAdminCount").html(countArr[4]);

				$("#userOrderCount").html(countArr[5]);
				$("#riderOrderCount").html(countArr[6]);
				$("#amountCount").html(countArr[7]);
				$("#userMessageCount").html(countArr[8]);
				$("#messageCount").html(countArr[9]);


				//用户与骑手分析图
				var userAndRiderOption =
						{
							tooltip : {
								trigger: 'item',
								formatter: "{b} : {c} ({d}%)"
							},
							series : [
								{
									name: '用户与骑手',
									type: 'pie',
									radius: '55%',
									data:[
										{value:countArr[0], name:'用户注册人数'},
										{value:countArr[1], name:'骑手注册人数'},
										{value:countArr[3], name:'管理员人数'},
									]
								}
							]
						}
				var userAndRiderPicChart = echarts.init(document.getElementById('userAndRiderPicChart'));
				userAndRiderPicChart.setOption(userAndRiderOption);

			}else {
				$.globalMessenger().post({
					user: result.message,//提示信息
					type: 'error',//消息类型。error、info、success
					hideAfter: 2,//多长时间消失
					showCloseButton:true,//是否显示关闭按钮
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
 * 获取用户注册数量
 */
function loadDataForUserRegister() {
	$.ajax({
		url:GET_USER_REGISTER_TIME_COUNT,
		method:'POST',
		dataType:'json',
		beforeSend:sendRequestBeforeHandle(),
		success:function (result) {
			$("#waitDialog").modal('hide');
			if (200 == result.code) {
				var typeVos = result.message;
				var dateArr = []
				var countArr = [];
				if (null == typeVos) {
					return;
				}

				for (var i = 0 ; i < typeVos.length; i++) {
					dateArr[i] = typeVos[i].desc;
					countArr[i] = typeVos[i].value;
				}
				console.log(dateArr);

				// 基于准备好的dom，初始化echarts实例
				var userRegisterChart = echarts.init(document.getElementById('userRegisterChart'));
				// 指定图表的配置项和数据
				var option = {
					title: {
						text: '最近一周用户注册量'
					},
					tooltip: {},
					legend: {
						data:['人数']
					},
					xAxis: {
						data: dateArr
					},
					yAxis: {},
					series: [{
						name: '人数',
						type: 'bar',
						data: countArr
					}]
				};

				userRegisterChart.setOption(option);


			}else {
				$.globalMessenger().post({
					user: result.message,//提示信息
					type: 'error',//消息类型。error、info、success
					hideAfter: 2,//多长时间消失
					showCloseButton:true,//是否显示关闭按钮
					hideOnNavigate: true //是否隐藏导航

				});
			}
		},
		fail:function (){
			sendRequestFailHandle();
		}
	});
}

/**
 * 查询骑手注册数量
 */
function loadDataForRiderRegister() {
	$.ajax({
		url:GET_RIDER_REGISTER_TIME_CUONT,
		method:'POST',
		dataType:'json',
		beforeSend:sendRequestBeforeHandle(),
		success:function (result) {
			$("#waitDialog").modal('hide');
			if (200 == result.code) {
				var typeVos = result.message;
				var dateArr = []
				var countArr = [];
				if (null == typeVos) {
					return;
				}

				for (var i = 0 ; i < typeVos.length; i++) {
					dateArr[i] = typeVos[i].desc;
					countArr[i] = typeVos[i].value;
				}
				console.log(dateArr);

				// 基于准备好的dom，初始化echarts实例
				var riderRegisterChart = echarts.init(document.getElementById('riderRegisterChart'));
				// 指定图表的配置项和数据
				var riderOption = {
					title: {
						text: '最近一周骑手注册量'
					},
					tooltip: {},
					legend: {
						data:['人数']
					},
					xAxis: {
						data: dateArr
					},
					yAxis: {},
					series: [{
						name: '人数',
						type: 'bar',
						data:  countArr
					}]
				};

				// 使用刚指定的配置项和数据显示图表。
				riderRegisterChart.setOption(riderOption);


			}else {
				$.globalMessenger().post({
					user: result.message,//提示信息
					type: 'error',//消息类型。error、info、success
					hideAfter: 2,//多长时间消失
					showCloseButton:true,//是否显示关闭按钮
					hideOnNavigate: true //是否隐藏导航

				});
			}
		},
		error:function (){
			sendRequestFailHandle();
		}
	});
}

</script>
