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

	</style>
</head>
<body>
<!-- 导航栏 -->
<ol class="breadcrumb">
	<li><a href="${pageContext.request.contextPath}/superAdmin_queryGeneralSituation.action">首页</a></li>
	<li><a href="#">骑手管理</a></li>
	<li class="active">查询骑手</li>
</ol>

<!-- 传送点 -->
<div class="panel panel-info">
	<div class="panel-heading"> 骑手</div>
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
							<input class="form-control" id="queryRiderId" type="text"  value="">
						</div>

						<!-- 注册日期 -->
						<label class="col-sm-3 control-label">注册日期</label>
						<div class='input-group date col-sm-2' id='datetimepicker1'>
							<input type='text' class="form-control" disabled="true"/>
							<span class="input-group-addon">
	                        <span class="glyphicon glyphicon-calendar"></span>
	                    </span>
						</div>



					</div>


				</form>

			</div>
		</div>

		<div class="panel-footer" style="text-align:right">
			<button id="queryRiderBtn" type="button" class="btn btn-primary" >
				<span class="glyphicon glyphicon-search"></span> 查询
			</button>

			<button id="checkInRiderBtn" type="button" class="btn btn-primary" >
				<span class="glyphicon  glyphicon-ok-sign"></span> 登记
			</button>

			<button id="logoutRiderBtn" type="button" class="btn btn-danger" >
				<span class="glyphicon glyphicon-trash"></span> 注销
			</button>

		</div>
	</div>

	<table id="grid"></table>

</div>
<div class="panel-footer">传送门</div>
</div>

<%--登记骑手--%>
<div id="checkInRiderDialog" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" >登记骑手</h4>
			</div>
			<div class="modal-body">
				<form action="#" class="form-horizontal" role="form">

					<!-- 手机号 -->
					<div class="form-group">
						<label class="col-sm-3 control-label" style="">手机号</label>
						<div class="col-sm-5">
							<input class="form-control" id="checkInRiderTel" type="text" value="" >

						</div>
					</div>

					<!-- 注册名 -->
					<div class="form-group">
						<label class="col-sm-3 control-label">注册名</label>
						<div class="col-sm-5">
							<fieldset disabled>
								<input class="form-control" id="checkInRiderUsername" type="text" value="" >
							</fieldset>
						</div>
					</div>

					<div style="width: 100%;background-color: #eeeaea;text-align: center;height: 20px;line-height: 20px;font-size:10px;color: #6e6e4b;">
						实名认证
					</div>

					<%-- 真实姓名 --%>
					<div class="form-group" style="margin-top: 10px;">
						<label class="col-sm-3 control-label" >真实姓名</label>
						<div class="col-sm-5">

							<input class="form-control" id="checkInRiderRealname" type="text" value="" >

						</div>
					</div>

					<%-- 身份证号码--%>
					<div class="form-group">
						<label class="col-sm-3 control-label">身份证号码</label>
						<div class="col-sm-5">

							<input class="form-control" id="checkInRiderIDNumber" type="text" value="" >

						</div>
					</div>



				</form>
			</div>
			<div class="modal-footer">
				<button id="checkInRiderDialogOKBtn" type="button" class="btn btn-primary">确定</button>
			</div>
		</div><!-- /.modal-content -->
	</div><
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
	var QUERY_RIDER_BY_TELEPORTER_URL = "${pageContext.request.contextPath}/rider_queryAllByPageAndTeleporter.action";
	/**登记骑手*/
	var CHECKIN_RIDER_URL = "${pageContext.request.contextPath}/rider_checkIn.action";
	/**查询骑手详情通过手机号*/
	var QUERY_RIDER_BY_TEL_URL = "${pageContext.request.contextPath}/rider_queryRiderDetailByTel.action";

	$(function (){
		//初始化表格
		initMainTable();

		//初始化提示
		initMessenge();

		//监听绑定
		initListener();


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
		$("#queryRiderBtn").click(function (){
			queryRider();
		});

		$("#checkInRiderBtn").click(function () {
			$("#checkInRiderDialog").modal();
		})

		$("#checkInRiderTel").blur(function () {
			var tel = $("#checkInRiderTel").val();
			if (null == tel || "" == tel.trim()) {
				$.globalMessenger().post({
					message: "手机号不能为空",//提示信息
					type: 'error',//消息类型。error、info、success
					hideAfter: 5,//多长时间消失
					showCloseButton:true,//是否显示关闭按钮
					hideOnNavigate: true //是否隐藏导航
				});
				return;
			}

			//查询骑手详情
			queryRiderDetail(tel);
		});

		$("#checkInRiderDialogOKBtn").click(function () {
			//手机号
			var tel = $("#checkInRiderTel").val();
			if (null == tel || "" == tel.trim()) {
				$.globalMessenger().post({
					message: "手机号不能为空",//提示信息
					type: 'error',//消息类型。error、info、success
					hideAfter: 5,//多长时间消失
					showCloseButton:true,//是否显示关闭按钮
					hideOnNavigate: true //是否隐藏导航
				});
				return;
			}

			//真实姓名
			var realname = $("#checkInRiderRealname").val();
			if (null == realname || "" == realname.trim()) {
				$.globalMessenger().post({
					message: "真实姓名不能为空",//提示信息
					type: 'error',//消息类型。error、info、success
					hideAfter: 5,//多长时间消失
					showCloseButton:true,//是否显示关闭按钮
					hideOnNavigate: true //是否隐藏导航
				});

				return;
			}
			//身份证号码
			var IDNumber = $("#checkInRiderIDNumber").val();
			if (null == IDNumber || "" == IDNumber.trim()) {
				$.globalMessenger().post({
					message: "手机号不能为空",//提示信息
					type: 'error',//消息类型。error、info、success
					hideAfter: 5,//多长时间消失
					showCloseButton:true,//是否显示关闭按钮
					hideOnNavigate: true //是否隐藏导航
				});

				return;
			}

			sendCheckInRiderRequest(tel,realname,IDNumber);
		});


	}


	//初始化bootstrap-table的内容
	function initMainTable () {
		//记录页面bootstrap-table全局变量$table，方便应用
		$table = $('#grid').bootstrapTable({
			url: QUERY_RIDER_BY_TELEPORTER_URL,                      //请求后台的URL（*）
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
			uniqueId: "riderId",                     //每一行的唯一标识，一般为主键列
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
				var ids = $("#queryRiderId").val();
				var inputDate = $("#datetimepicker1").find("input").val();

				temp['riderQueryCondition.ids'] = ids;
				temp['riderQueryCondition.date'] = inputDate;
				return temp;
			},
			columns: [{
				checkbox: true,
				visible: true                  //是否显示复选框
			}, {
				field: 'riderId',
				title: '编号',
				align: 'center',
				valign: 'middle',

			}, {
				field: 'username',
				title: '骑手名',
				align: 'center',
				valign: 'middle',

			}, {
				field: 'tel',
				title: '手机号',
				align: 'center',
				valign: 'middle',

			},{
				field: 'sex',
				title: '性别',
				align: 'center',
				valign: 'middle',
				formatter:sexFormatter

			},{
				field: 'address',
				title: '地址',
				align: 'center',
				valign: 'middle',

			},{
				field: 'teleporter.address',
				title: '所属传送点',
				align: 'center',
				valign: 'middle',

			},{
				field: 'riderState',
				title: '状态',
				align: 'center',
				valign: 'middle',
				formatter:riderStateFormatter

			},{
				field: 'registerDate',
				title: '注册日期',
				align: 'center',
				valign: 'middle',

			},{
				field: 'balance',
				title: '余额',
				align: 'center',
				valign: 'middle',

			},
				{
					field: 'realName',
					title: '真实姓名',
					align: 'center',
					valign: 'middle',

				},
				{
					field: 'IDNumber',
					title: '证件信息',
					align: 'center',
					valign: 'middle',

				}
			],
			onLoadSuccess: function () {
			},
			onLoadError: function () {
				$.globalMessenger().post({
					message: "数据加载失败",//提示信息
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
	 * 骑手状态格式化
	 */
	function riderStateFormatter(value) {
		var result = "";
		switch (value) {
			case 1:result = "<span class=\"label label-default\">休息中</span>";break;
			case 2:result = "<span class=\"label label-info\">工作中</span>";break;
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
			case 0:result = "<span class=\"label label-danger\">无效</span>";break;
			case 1:result = "<span class=\"label label-success\">有效</span>";break;
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


	/*******增删改查请求区*********/
	/**
	 * 查询消息
	 */
	function queryRider(){
		//获取查询条件
		//获取查询条件
		var ids = $("#queryRiderId").val();
		var inputDate = $("#datetimepicker1").find("input").val();


		var requestParam = {
			"riderQueryCondition.ids":	ids,
			"riderQueryCondition.date":inputDate,
			"page":1,
			"rows":5
		}
		$.ajax({
			url:QUERY_RIDER_BY_TELEPORTER_URL,
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
						message: result.message,//提示信息
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

	/**
	 * 发送登记请求
	 * @param tel
	 * @param realname
	 * @param IDNumber
	 */
	function sendCheckInRiderRequest(tel, realname, IDNumber) {
		var requestParam = {
			"rider.tel" : tel,
			"rider.realName" :realname,
			"rider.IDNumber" : IDNumber
		};

		$.ajax({
			url:CHECKIN_RIDER_URL,
			method:'POST',
			data:requestParam,
			dataType:'json',
			beforeSend:sendRequestBeforeHandle(),
			success:function (result) {
				$("#waitDialog").modal('hide');
				if (200 == result.code){
					$.globalMessenger().post({
						message: result.message,//提示信息
						type: 'error',//消息类型。error、info、success
						hideAfter: 5,//多长时间消失
						showCloseButton:true,//是否显示关闭按钮
						hideOnNavigate: true //是否隐藏导航

					});

					//关闭对话框并清空数据
					$("#checkInRiderDialog").modal('hide');
					$("#checkInRiderTel").val('');
					$("#checkInRiderRealname").val('');
					$("#checkInRiderIDNumber").val('');
					$("#checkInRiderUsername").val('');
					//刷新表格
					queryRider();
				}else {
					$.globalMessenger().post({
						message: result.message,//提示信息
						type: 'error',//消息类型。error、info、success
						hideAfter: 5,//多长时间消失
						showCloseButton:true,//是否显示关闭按钮
						hideOnNavigate: true //是否隐藏导航

					});
				}
			},
			error:function () {
				sendRequestFailHandle();
			}

		});
	}

	/**
	 * 查询骑手详情
	 * @param tel
	 */
	function queryRiderDetail(tel) {
		var requestParam = {
			"rider.tel" : tel

		};

		$.ajax({
			url:QUERY_RIDER_BY_TEL_URL,
			method:'POST',
			data:requestParam,
			dataType:'json',
			beforeSend:sendRequestBeforeHandle(),
			success:function (result) {
				$("#waitDialog").modal('hide');
				if (200 == result.code){
					//设置用户名
					$("#checkInRiderUsername").val(result.message.username);

				}else {
					$.globalMessenger().post({
						message: result.message,//提示信息
						type: 'error',//消息类型。error、info、success
						hideAfter: 5,//多长时间消失
						showCloseButton:true,//是否显示关闭按钮
						hideOnNavigate: true //是否隐藏导航

					});
				}
			},
			error:function () {
				sendRequestFailHandle();
			}
		});
	}
</script>