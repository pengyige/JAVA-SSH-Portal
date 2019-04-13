<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false"%>
<html>
<head>
	<meta charset="utf-8" />
	<title>传送门-传送点</title>

	<link href="${pageContext.request.contextPath}/asserts/css/common.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/asserts/css/font-awesome/font-awesome.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap-table/bootstrap-table.css" rel="stylesheet"type="text/css" />
	<link href="${pageContext.request.contextPath}/asserts/css/messenger/messenger.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap-select/bootstrap-select.min.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/asserts/css/messenger/messenger-theme-ice.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>

	<script src="${pageContext.request.contextPath}/asserts/js/common.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/jquery/jquery-3.3.1.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap/bootstrap.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap-table/bootstrap-table.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap-table/bootstrap-table-zh-CN.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/messenger/messenger.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/messenger/messenger-theme-future.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap-select/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap-select/defaults-zh_CN.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap-datetimepicker/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>

	<style>
		@font-face {
			font-family: 'Glyphicons Halflings';
			src: url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.eot');
			src: url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.eot?#iefix') format('embedded-opentype'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.woff') format('woff'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.ttf') format('truetype'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.svg#glyphicons_halflingsregular') format('svg');
		}

		.fa-sync::before {
			content: "\f021";
		}

		[data-id=queryOrderTypeSelect] {
			height:30px;
		}
	</style>
</head>
<body>
<!-- 导航栏 -->
<ol class="breadcrumb">
	<li><a href="${pageContext.request.contextPath}/superAdmin_queryGeneralSituation.action">首页</a></li>
	<li><a href="#">订单管理</a></li>
	<li class="active">查询订单</li>
</ol>

<!-- 传送点 -->
<div class="panel panel-info">
	<div class="panel-heading"> 订单</div>
	<div class="panel-body">

		<!-- 查询条件 -->
		<div class="panel panel-default">
			<div class="panel-heading"> 查询条件</div>
			<div class="panel-body">

				<form action="#" class="form-horizontal" role="form">

					<div class="form-group">
						<!-- 编号 -->
						<label class="col-sm-3 control-label">编号</label>
						<div class="col-sm-2">
							<input class="form-control" id="queryOrderId" type="text"  value="">
						</div>

						<div  class="form-group" >
							<!--订单状态 -->
							<label class="col-sm-3 control-label" >订单状态</label>
							<div class="col-sm-2">
								<select  id="queryOrderTypeSelect" class="selectpicker"  data-live-search="true">

								</select>
								<button class="btn btn-default" id="clearOrderTypeSelectBtn">
									<span class="glyphicon glyphicon-trash"></span> 清空
								</button>
							</div>

						</div>



					</div>


				</form>

			</div>
		</div>

		<div class="panel-footer" style="text-align:right">
			<button id="queryOrderBtn" type="button" class="btn btn-primary" >
				<span class="glyphicon glyphicon-search"></span> 查询
			</button>

		</div>
	</div>

	<table id="grid"></table>

</div>
<div class="panel-footer">传送门</div>
</div>

<!-- 等待框 -->
<div class="modal fade" id="waitDialog">
	<div class="modal-dialog modal-sm" style="text-align:center">

		<i class="fa fa-spinner fa-pulse fa-5x"></i>
	</div><!-- /.modal-dialog -->
</div>

</body>

<script>
	var $table;
	/**分页查询骑手*/
	var QUERY_ORDER_URL = "${pageContext.request.contextPath}/userOrder_queryAllByPage.action";
	/**获取所有类型*/
	var QUERY_ORDER_TYPE_URL = "${pageContext.request.contextPath}/userOrder_getAllOrderType.action";

	$(function (){
		//初始化表格
		initMainTable();

		//初始化提示
		initMessenge();

		//监听绑定
		initListener();

		//初始化订单状态
		initOrderState();


		//初始化日期格式化
		$('#datetimepicker1').datetimepicker({
			format : 'yyyy-mm-dd',
			language : 'zh-CN'
		});


	});


	/*
     * 监听绑定
     */
	function initListener(){

		//查询
		$("#queryOrderBtn").click(function (){
			queryOrder();
		});
		$("#clearOrderTypeSelectBtn").click(function (){
			$("#queryOrderTypeSelect").selectpicker('val','');
		})


	}


	//初始化bootstrap-table的内容
	function initMainTable () {
		//记录页面bootstrap-table全局变量$table，方便应用
		$table = $('#grid').bootstrapTable({
			url: QUERY_ORDER_URL,                      //请求后台的URL（*）
			method: 'GET',                      //请求方式（*）
			//toolbar: '#toolbar',              //工具按钮用哪个容器
			striped: false,                      //是否显示行间隔色
			cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,                   //是否显示分页（*）
			sortable: true,                     //是否启用排序
			sortOrder: "asc",                   //排序方式
			sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
			pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
			pageSize: 5,                     //每页的记录行数（*）
			pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
			search: false,                      //是否显示表格搜索
			strictSearch: true,
			showColumns: true,                  //是否显示所有的列（选择显示的列）
			showRefresh: true,                  //是否显示刷新按钮
			minimumCountColumns: 2,             //最少允许的列数
			clickToSelect: true,                //是否启用点击选中行
			height: 500,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId: "userOrderId",                     //每一行的唯一标识，一般为主键列
			showToggle: true,                   //是否显示详细视图和列表视图的切换按钮
			cardView: false,                    //是否显示详细视图
			detailView: false,                  //是否显示父子表
			//得到查询的参数
			queryParams : function (params) {
				//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
				var temp = {
					rows: params.limit,                         //页面大小
					page: (params.offset / params.limit) + 1,

				};

				//获取查询条件
				var ids = $("#queryOrderId").val();
				var state = $("#queryOrderTypeSelect").selectpicker('val');

				temp['orderQueryCondition.ids'] = ids;
				temp['orderQueryCondition.state'] = state;
				return temp;
			},
			columns: [{
				checkbox: true,
				visible: true                  //是否显示复选框
			}, {
				field: 'userOrderId',
				title: '编号',
				align: 'center',
				valign: 'middle',

			}, {
				field: 'shipAddress',
				title: '发件人地址',
				align: 'center',
				valign: 'middle',

			}, {
				field: 'shipName',
				title: '发件人姓名',
				align: 'center',
				valign: 'middle',

			},{
				field: 'shipTel',
				title: '发件人电话',
				align: 'center',
				valign: 'middle',

			},{
				field: 'receiveAddress',
				title: '收件人地址',
				align: 'center',
				valign: 'middle',

			},{
				field: 'receiveName',
				title: '收件人姓名',
				align: 'center',
				valign: 'middle',

			},{
				field: 'receiveTel',
				title: '收件人电话',
				align: 'center',
				valign: 'middle'

			},{
				field: 'orderTime',
				title: '创建日期',
				align: 'center',
				valign: 'middle',

			},{
				field: 'payment',
				title: '金额',
				align: 'center',
				valign: 'middle',

			},
				{
					field: 'state',
					title: '订单状态',
					align: 'center',
					valign: 'middle',
					formatter:stateFormatter

				},
				{
					field: 'user.username',
					title: '用户名',
					align: 'center',
					valign: 'middle',

				}
			],
			onLoadSuccess: function () {
			},
			onLoadError: function () {
				$.globalMessenger().post({
					user: "数据加载失败",//提示信息
					type: 'info',//消息类型。error、info、success
					hideAfter: 5,//多长时间消失
					showCloseButton:true,//是否显示关闭按钮
					hideOnNavigate: true //是否隐藏导航

				});
			},
			onDblClickRow: function (row, $element) {
				var id = row.userId;

				viewById(id, 'view');
			},
			rowStyle: function (row, index) {
				var classesArr = ['success', 'info'];
				var strclass = "";
				if (index % 2 === 0) {//偶数行
					strclass = classesArr[0];
				} else {//奇数行
					strclass = classesArr[1];
				}
				return { classes: strclass };
			},//隔行变色
		});
	};


	/**
	 * 消息类型格式化
	 */
	function userTypeFormatter(value) {
		var result = "";
		switch (value) {
			case 1:result = "<span class=\"label label-default\">普通用户</span>";break;
			case 2:result = "<span class=\"label label-info\">商业用户</span>";break;
			default:break;
		}
		return result;

	}

	/**
	 * 状态格式化
	 */
	function stateFormatter(value) {
		var result = "";
		switch (value) {
			case 1:result = "<span class=\"label label-default\">待接单</span>";break;
			case 2:result = "<span class=\"label label-success\">已接单</span>";break;
			case 3:result = "<span class=\"label label-info\">已取货</span>";break;
			case 4:result = "<span class=\"label label-warning\">已送达</span>";break;
			case 5:result = "<span class=\"label label-danger\">已取消</span>";break;
			default:break;
		}
		return result;
	}

	//操作栏的格式化
	function actionFormatter(value, row, index) {
		var id = value;
		var result = "";
		result += "<a href='javascript:;' class='btn btn-xs green' onclick=\"viewById('" + id + "')\" title='查看'><span class='glyphicon glyphicon-search'></span></a>";
		result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"editViewById('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
		result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"deleteById('" + id + "','" + row.title + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";

		return result;
	}

	/**
	 * 初始化所有订单状态
	 */
	function initOrderState() {
		$.ajax({
			url:QUERY_ORDER_TYPE_URL,
			type:'POST',
			dataType:'json',
			beforeSend:sendRequestBeforeHandle(),
			success:function (result) {
				$("#waitDialog").modal('hide');

				if (200 == result.code) {
					var orderState = result.message;

					//初始化查询传送点区域
					for (var i = 0 ; i < orderState.length; i++){
						var option = $('<option></option>');
						option.attr('value', orderState[i].value);
						option.text(orderState[i].desc);
						$('#queryOrderTypeSelect').append(option);

					}


					//默认选中无
					$('#queryOrderTypeSelect').selectpicker('val','');

					$('#queryOrderTypeSelect').selectpicker('refresh');
					$('#queryOrderTypeSelect').selectpicker('render');


				}else {
					$.globalMessenger().post({
						message: result.message,//提示信息
						type: 'error',//消息类型。error、info、success
						hideAfter: 2,//多长时间消失
						showCloseButton:true,//是否显示关闭按钮
						hideOnNavigate: true //是否隐藏导航

					});
				}
			},
			fail:function (){
				sendRequestFailHandle()
			}
		});

	}

	/*******增删改查请求区*********/
	/**
	 * 查询消息
	 */
	function queryOrder(){
		//获取查询条件
		//获取查询条件
		var ids = $("#queryOrderId").val();
		var state = $("#queryOrderTypeSelect").selectpicker('val');


		var requestParam = {
			"orderQueryCondition.ids":	ids,
			"orderQueryCondition.state":state,
			"page":1,
			"rows":5
		}
		$.ajax({
			url:QUERY_ORDER_URL,
			method:'POST',
			data:requestParam,
			dataType:'json',
			beforeSend:sendRequestBeforeHandle(),
			success:function (result){
				$("#waitDialog").modal('hide');
				if (200 == result.code){
					$("#grid").bootstrapTable('load',result);
				}else {
					$.globalMessenger().post({
						user: result.message,//提示信息
						type: 'error',//消息类型。error、info、success
						hideAfter: 5,//多长时间消失
						showCloseButton:true,//是否显示关闭按钮
						hideOnNavigate: true //是否隐藏导航

					});
				}
			},
			error:function () {
				sendRequestFailHandle()
			}
		});

	}

</script>