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

		[data-id=queryMessageTypeSelect] {
			height:30px;
		}

		[data-id=editMessageTypeSelect] {
			height:30px;
		}

		[data-id=addMessageTypeSelect] {
			height:30px;
		}
	</style>
</head>
<body>
<!-- 导航栏 -->
<ol class="breadcrumb">
	<li><a href="${pageContext.request.contextPath}/superAdmin_queryGeneralSituation.action">首页</a></li>
	<li><a href="#">系统消息</a></li>
	<li class="active">查询系统消息</li>
</ol>

<!-- 传送点 -->
<div class="panel panel-info">
	<div class="panel-heading"> 系统消息</div>
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
							<input class="form-control" id="queryMessageId" type="text"  value="">
						</div>

						<!-- 创建日期 -->
						<label class="col-sm-3 control-label">创建日期</label>
						<div class='input-group date col-sm-2' id='datetimepicker1'>
							<input type='text' class="form-control" disabled="true"/>
							<span class="input-group-addon">
	                        <span class="glyphicon glyphicon-calendar"></span>
	                    </span>
						</div>



					</div>


					<div  class="form-group" >
						<!--消息类型 -->
						<label class="col-sm-3 control-label" >消息类别</label>
						<div class="col-sm-2">
							<select  id="queryMessageTypeSelect" class="selectpicker"  data-live-search="true">

							</select>
							<button class="btn btn-default" id="clearQueryMessageTypeSelectBtn">
								<span class="glyphicon glyphicon-trash"></span> 清空
							</button>
						</div>

					</div>

				</form>

			</div>
		</div>

		<div class="panel-footer" style="text-align:right">
			<button id="queryMessageBtn" type="button" class="btn btn-primary" >
				<span class="glyphicon glyphicon-search"></span> 查询
			</button>

			<button id="addMessageBtn" type="button" class="btn btn-info" >
				<span class="glyphicon glyphicon-plus"></span> 新增
			</button>
		</div>
	</div>

	<table id="grid"></table>

</div>
<div class="panel-footer">传送门</div>
</div>


<!-- 查看模态框 -->
<div class="modal fade" id="viewMessageDialog" tabindex="-1" role="dialog"  aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">消息详情</h4>
			</div>
			<div class="modal-body">
				<form action="#" class="form-horizontal" role="form">
					<!-- 编号 -->
					<div class="form-group">
						<label class="col-sm-3 control-label">编号</label>
						<div class="col-sm-9">
							<fieldset disabled>
								<input class="form-control" id="viewMessageId" type="text" disable value="">
							</fieldset>
						</div>
					</div>



					<!-- 标题 -->
					<div class="form-group">
						<label class="col-sm-3 control-label">标题</label>
						<div class="col-sm-9">
							<fieldset disabled>
								<input class="form-control" id="viewMessageTitle" type="text" value="">
							</fieldset>
						</div>
					</div>

					<!-- 内容-->
					<div class="form-group">
						<label class="col-sm-3 control-label">内容</label>
						<div class="col-sm-9">
							<fieldset disabled>
								<input class="form-control" id="viewMessageContent" type="text" value="">
							</fieldset>
						</div>
					</div>

					<!-- 图片 -->
					<%--<div class="form-group">
						<label class="col-sm-3 control-label">手机号</label>
						<div class="col-sm-9">
							<fieldset disabled>
								<input class="form-control" id="viewMessageImgPath" type="text" value="">
							</fieldset>
						</div>
					</div>--%>

					<!-- 类型 -->
					<div class="form-group">
						<!--消息类型 -->
						<label class="col-sm-3 control-label">消息类型</label>
						<div class="col-sm-9">
							<fieldset disabled>
								<div class="form-control" id="viewMessageType" type="text" value="">
								</div>
							</fieldset>
						</div>
					</div>


					<!-- 状态 -->
					<div class="form-group">
						<label class="col-sm-3 control-label">状态</label>
						<!--消息状态 -->
						<div class="col-sm-9">
							<fieldset disabled>
								<div class="form-control" id="viewMessageState" type="text" value="">
								</div>
							</fieldset>
						</div>
					</div>

					<!-- 录入人 -->
					<div class="form-group">
						<label class="col-sm-3 control-label">录入人</label>
						<div class="col-sm-9">
							<fieldset disabled>
								<input class="form-control" id="viewInputUserName" type="text" value="">
							</fieldset>
						</div>
					</div>

					<!-- 创建日期 -->
					<div class="form-group">
						<label class="col-sm-3 control-label">创建日期</label>
						<div class="col-sm-9">
							<fieldset disabled>
								<input class="form-control" id="viewMessageCreateDate" type="text" value="">
							</fieldset>
						</div>
					</div>




				</form>
			</div>
			<div class="modal-footer">
				<button id="viewMessageDialogOKBtn" type="button" class="btn btn-primary">确定</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


<!-- 修改传送点模特框 -->
<div class="modal fade" id="editMessageDialog" tabindex="-1" role="dialog"  aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" >传送点管理员详情</h4>
			</div>
			<div class="modal-body">
				<form action="#" class="form-horizontal" role="form">
					<!-- 编号 -->
					<div class="form-group">
						<label class="col-sm-3 control-label">编号</label>
						<div class="col-sm-9">
							<fieldset disabled>
								<input class="form-control" id="editMessageId" type="text" disable value="">
							</fieldset>
						</div>
					</div>



					<!-- 标题 -->
					<div class="form-group">
						<label class="col-sm-3 control-label">标题</label>
						<div class="col-sm-9">

								<input class="form-control" id="editMessageTitle" type="text" value="">

						</div>
					</div>

					<!-- 内容-->
					<div class="form-group">
						<label class="col-sm-3 control-label">内容</label>
						<div class="col-sm-9">

								<input class="form-control" id="editMessageContent" type="text" value="">

						</div>
					</div>

					<!-- 图片 -->
					<%--<div class="form-group">
						<label class="col-sm-3 control-label">手机号</label>
						<div class="col-sm-9">
							<fieldset disabled>
								<input class="form-control" id="viewMessageImgPath" type="text" value="">
							</fieldset>
						</div>
					</div>--%>

					<!-- 类型 -->
					<div class="form-group">
						<label class="col-sm-3 control-label">消息类型</label>
						<div class="col-sm-9">
							<select  id="editMessageTypeSelect" class="selectpicker"  data-live-search="true">

							</select>
						</div>
					</div>


					<!-- 状态 -->
					<div class="form-group">
						<label class="col-sm-3 control-label">状态</label>
						<div class="col-sm-9">
							<label class="checkbox-inline">
								<input type="radio" name="editMessageState" id="editMessageStateValid"
									   value="1" checked> 有效
							</label>
							<label class="checkbox-inline">
								<input type="radio" name="editMessageState" id="editMessageStateInvalid"
									   value="0"> 无效
							</label>
						</div>
					</div>

					<!-- 录入人 -->
					<div class="form-group">
						<label class="col-sm-3 control-label">录入人</label>
						<div class="col-sm-9">
							<fieldset disabled>
								<input class="form-control" id="editInputUserName" type="text" value="">
							</fieldset>
						</div>
					</div>

					<!-- 创建日期 -->
					<div class="form-group">
						<label class="col-sm-3 control-label">创建日期</label>
						<div class="col-sm-9">
							<fieldset disabled>
								<input class="form-control" id="editMessageCreateDate" type="text" value="">
							</fieldset>
						</div>
					</div>




				</form>
			</div>
			<div class="modal-footer">
				<button id="editMessageDialogCancelBtn" type="button" class="btn btn-default">取消</button>

				<button id="editMessageDialogOKBtn" type="button" class="btn btn-primary">更新</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


<!-- 删除管理员模块框 -->
<div class="modal fade" id="deleteMessageDialog" tabindex="-1" role="dialog"  aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">删除消息</h4>
			</div>
			<div class="modal-body">
				您确定删除消息<label id="deleteMessageName"></label>吗?
				<input type="hidden" id="deleteMessageId"/>
			</div>
			<div class="modal-footer">
				<button id="deleteMessageDialogCancelBtn" type="button" class="btn btn-default">取消</button>

				<button id="deleteMessageDialogOKBtn" type="button" class="btn btn-danger">删除</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


<!-- 新增模态框 -->
<div class="modal fade" id="addMessageDialog" tabindex="-1" role="dialog"  aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" >新增消息</h4>
			</div>
			<div class="modal-body">
				<form action="#" class="form-horizontal" role="form">

					<!-- 标题 -->
					<div class="form-group">
						<label class="col-sm-3 control-label">标题</label>
						<div class="col-sm-9">

							<input class="form-control" id="addMessageTitle" type="text" value="">

						</div>
					</div>

					<!-- 内容-->
					<div class="form-group">
						<label class="col-sm-3 control-label">内容</label>
						<div class="col-sm-9">

							<input class="form-control" id="addMessageContent" type="text" value="">

						</div>
					</div>

					<!-- 图片 -->
					<%--<div class="form-group">
						<label class="col-sm-3 control-label">手机号</label>
						<div class="col-sm-9">
							<fieldset disabled>
								<input class="form-control" id="viewMessageImgPath" type="text" value="">
							</fieldset>
						</div>
					</div>--%>

					<!-- 类型 -->
					<div class="form-group">
						<label class="col-sm-3 control-label">消息类型</label>
						<div class="col-sm-9">
							<select  id="addMessageTypeSelect" class="selectpicker"  data-live-search="true">

							</select>
						</div>
					</div>


					<!-- 状态 -->
					<div class="form-group">
						<label class="col-sm-3 control-label">状态</label>
						<div class="col-sm-9">
							<label class="checkbox-inline">
								<input type="radio" name="addMessageState" id="addMessageStateValid"
									   value="1" checked> 有效
							</label>
							<label class="checkbox-inline">
								<input type="radio" name="addMessageState" id="addMessageStateInvalid"
									   value="0"> 无效
							</label>
						</div>
					</div>


				</form>
			</div>
			<div class="modal-footer">
				<button id="addMessageDialogOKBtn" type="button" class="btn btn-primary">保存</button>
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

<script>
	var $table;
	/**分页查询消息*/
	var QUERY_MESSAGE_URL = "${pageContext.request.contextPath}/systemMessage_queryAllByPage.action";
	/**查看消息详情*/
	var MESSAGE_DETAIL_URL = "${pageContext.request.contextPath}/systemMessage_getMessageDetailById.action";
	/**获取全部消息类型*/
	var QUERY_MESSAGE_TYPE_URL = "${pageContext.request.contextPath}/systemMessage_queryAllMessageType.action";
	/**更新消息信息*/
	var UPDATE_MESSAGE_URL = "${pageContext.request.contextPath}/systemMessage_updateMessage.action";
	/**删除传送点管理员*/
	var DELETE_MESSAGE_URL = "${pageContext.request.contextPath}/systemMessage_deleteMessage.action";
	/**添加消息*/
	var ADD_MESSAGE_URL = "${pageContext.request.contextPath}/systemMessage_addMessage.action";


	/**全局传送点*/
	var global_message_type= null;

	$(function (){
		//初始化表格
		initMainTable();

		//初始化提示
		initMessenge();

		//初始化消息类型数据
		initMessageTypeData();

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
		//查看
		$("#viewMessageDialogOKBtn").click(function (){
			$("#viewMessageDialog").modal('hide');
		});


		//修改
		$("#editMessageDialogOKBtn").click(function (){
			updateMessage();
		});
		$("#editMessageDialogCancelBtn").click(function (){
			$("#editMessageDialog").modal('hide');
		});

		//删除
		$("#deleteMessageDialogCancelBtn").click(function (){
			$("#deleteMessageDialog").modal('hide');
		})
		$("#deleteMessageDialogOKBtn").click(function (){
			deleteMessage();
		});


		//查询
		$("#queryMessageBtn").click(function (){
			queryMessage();
		});
		$("#clearQueryMessageTypeSelectBtn").click(function (){
			$('#queryMessageTypeSelect').selectpicker('val','');
		});


		//新增
		$("#addMessageBtn").click(function (){
			$("#addMessageDialog").modal();
		});
		$("#addMessageDialogOKBtn").click(function (){
			addMessage();
		});
	}


	//初始化bootstrap-table的内容
	function initMainTable () {
		//记录页面bootstrap-table全局变量$table，方便应用
		$table = $('#grid').bootstrapTable({
			url: QUERY_MESSAGE_URL,                      //请求后台的URL（*）
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
			uniqueId: "messageId",                     //每一行的唯一标识，一般为主键列
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
				var messageId = $("#querymMessageId").val();
				var inputDate = $("#datetimepicker1").find("input").val();
				var type = $("#queryMessageTypeSelect").selectpicker('val');

				temp['systemMessageQueryCondition.ids'] = messageId;
				temp['systemMessageQueryCondition.date'] = inputDate;
				temp['systemMessageQueryCondition.teleporter'] = type;

				return temp;
			},
			columns: [{
				checkbox: true,
				visible: true                  //是否显示复选框
			}, {
				field: 'messageId',
				title: '编号',
				align: 'center',
				valign: 'middle',

			}, {
				field: 'title',
				title: '标题',
				align: 'center',
				valign: 'middle',

			}, {
				field: 'content',
				title: '内容',
				align: 'center',
				valign: 'middle',

			}, {
				field: 'type',
				title: '消息类型',
				align: 'center',
				valign: 'middle',
				formatter:messageTypeFormatter

			}, {
				field: 'state',
				title: '状态',
				align: 'center',
				valign: 'middle',
				formatter:stateFormatter

			},{
				field: 'superAdmin.username',
				title: '录入人',
				align: 'center',
				valign: 'middle',

			},{
				field: 'createTime',
				title: '创建日期',
				align: 'center',
				valign: 'middle',

			}, {
				field:'messageId',
				title: '操作',
				width: 120,
				align: 'center',
				valign: 'middle',
				formatter: actionFormatter
			}, ],
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
				var id = row.MessageId;

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
	function messageTypeFormatter(value) {
		var result = "";
		switch (value) {
			case 1:result = "<span class=\"label label-default\">传送点</span>";break;
			case 2:result = "<span class=\"label label-info\">用户</span>";break;
			case 3:result = "<span class=\"label label-primary\">骑手</span>";break;
			case 4:result = "<span class=\"label label-warning\">全部</span>";break;
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

	/**
	 * 获取所有消息类型数据
	 */
	function initMessageTypeData(){
		$.ajax({
			url:QUERY_MESSAGE_TYPE_URL,
			type:'POST',
			dataType:'json',
			beforeSend:function (){
				$("#waitDialog").modal();
			},
			success:function (result) {
				$("#waitDialog").modal('hide');

				if (200 == result.code) {
					global_message_type = result.message;

					//初始化消息类型区域
					for (var i = 0 ; i < global_message_type.length; i++){
						var option = $('<option></option>');
						option.attr('value', global_message_type[i].messageTypeValue);
						option.text(global_message_type[i].messageTypeDescription);
						$('#queryMessageTypeSelect').append(option);

					}


					//默认选中无
					$('#queryMessageTypeSelect').selectpicker('val','');

					$('#queryMessageTypeSelect').selectpicker('refresh');
					$('#queryMessageTypeSelect').selectpicker('render');

					//初始化修改消息区域
					for (var i = 0 ; i < global_message_type.length; i++){
						var option = $('<option></option>');
						option.attr('value', global_message_type[i].messageTypeValue);
						option.text(global_message_type[i].messageTypeDescription);
						$('#editMessageTypeSelect').append(option);
					}
					$('#editMessageTypeSelect').selectpicker('val','');
					$('#editMessageTypeSelect').selectpicker('refresh');
					$('#editMessageTypeSelect').selectpicker('render');

					//初始化新增消息区域
					for (var i = 0 ; i < global_message_type.length; i++){
						var option = $('<option></option>');
						option.attr('value', global_message_type[i].messageTypeValue);
						option.text(global_message_type[i].messageTypeDescription);
						$('#addMessageTypeSelect').append(option);
					}
					$('#addMessageTypeSelect').selectpicker('val','');
					$('#addMessageTypeSelect').selectpicker('refresh');
					$('#addMessageTypeSelect').selectpicker('render');
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
			error:function (){
				$.globalMessenger().post({
					message: "操作失败",//提示信息
					type: 'error',//消息类型。error、info、success
					hideAfter: 5,//多长时间消失
					showCloseButton:true,//是否显示关闭按钮
					hideOnNavigate: true //是否隐藏导航

				});
				$("#waitDialog").modal('hide');
			}
		});

	}

	/**
	 * 查看消息详情
	 */
	function viewById(id) {
		if (null == id || "" == id) {
			$.globalMessenger().post({
				message: "消息ID不能为空",//提示信息
				type: 'error',//消息类型。error、info、success
				hideAfter: 5,//多长时间消失
				showCloseButton:true,//是否显示关闭按钮
				hideOnNavigate: true //是否隐藏导航

			});
			return;
		}

		var requestParam = {
			"message.messageId":id
		};
		$.ajax({
			url:MESSAGE_DETAIL_URL,
			type:'POST',
			data:requestParam,
			dataType:'json',
			beforeSend:sendRequestBeforeHandle(),
			success:function (result){
				$("#waitDialog").modal('hide');
				if (200 == result.code){
					//填充数据
					var message = result.message;
					//编号
					$("#viewMessageId").val(message.messageId);
					//标题
					$("#viewMessageTitle").val(message.title);
					//内容
					$("#viewMessageContent").val(message.content);
					//消息类型
					$("#viewMessageType").html(messageTypeFormatter(message.type));
					//消息状态
					$("#viewMessageState").html(stateFormatter(message.state));
					//录入人
					$("#viewInputUserName").val(message.superAdmin.username);
					//创建时间
					$("#viewMessageCreateDate").val(message.createTime);


					//显示对话框
					$("#viewMessageDialog").modal();


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
			error:function (){
				sendRequestFailHandle();
			}
		});

	}

	/**
	 * 编辑消息
	 */
	function editViewById(id) {

		if (null == global_message_type) {
			initMessageTypeData();
		}else {
			editMessageHandle(id);
		}


	}

	/**
	 * 编辑传送点处理方法
	 */
	function editMessageHandle(id){
		if (null == id || "" == id) {
			$.globalMessenger().post({
				message: "消息ID不能为空",//提示信息
				type: 'error',//消息类型。error、info、success
				hideAfter: 5,//多长时间消失
				showCloseButton:true,//是否显示关闭按钮
				hideOnNavigate: true //是否隐藏导航

			});
			return;
		}


		var requestParam = {
			"message.messageId":id
		}
		$.ajax({
			url:MESSAGE_DETAIL_URL,
			type:'POST',
			data:requestParam,
			dataType:'json',
			async : false,
			beforeSend:function (){
				sendRequestBeforeHandle();
			},
			success:function (result){
				$("#waitDialog").modal('hide');
				if (200 == result.code){
					//填充数据
					var message = result.message;
					//编号
					$("#editMessageId").val(message.messageId);
					//标题
					$("#editMessageTitle").val(message.title);
					//内容
					$("#editMessageContent").val(message.content);
					//消息类型
					if (0 != message.Type) {
						$('#editMessageTypeSelect').selectpicker('val',message.type);
					}else {
						$('#editMessageTypeSelect').selectpicker('val',['noneSelectedText'])
						$("#editMessageTypeSelect").selectpicker('refresh');
						$('#editMessageTypeSelect').selectpicker('render');
					}

					//状态
					if (1 == message.state) {
						$("#editMessageStateValid").attr("checked",'checked');
					}else {
						$("#editMessageStateInvalid").attr("checked",'checked');
					}

					//录入人
					$("#editInputUserName").val(message.superAdmin.username);
					//登记日期
					$("#editMessageCreateDate").val(message.createTime);

					$("#editMessageDialog").modal();

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
			error:function (){
				sendRequestFailHandle();
			}
		});

	}

	/**
	 * 通过id删除传送点点击事件
	 */
	function deleteById(id,messageName){
		$("#deleteMessageId").val(id);
		$("#deleteMessageName").html(messageName);

		//显示删除框
		$("#deleteMessageDialog").modal();
	}



	/*******增删改查请求区*********/
	/**
	 * 查询消息
	 */
	function queryMessage(){
		//获取查询条件
		var messageId = $("#querymMessageId").val();
		var inputDate = $("#datetimepicker1").find("input").val();
		var type = $("#queryMessageTypeSelect").selectpicker('val');


		var requestParam = {
			"systemMessageQueryCondition.ids":	messageId,
			"systemMessageQueryCondition.date.date":inputDate,
			"systemMessageQueryCondition.type":type,
			"page":1,
			"rows":5
		}
		$.ajax({
			url:QUERY_MESSAGE_URL,
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
	 * 更新消息信息
	 */
	function updateMessage(){

		//传送点id
		var messageId = $("#editMessageId").val();
		//标题
		var title = $("#editMessageTitle").val();
		//内容
		var content = $("#editMessageContent").val();
		//消息类型
		var type = $("#editMessageTypeSelect").selectpicker('val');
		//状态
		var state = $("input[name=\"editMessageState\"]:checked").val();

		if (null == messageId || "" == messageId) {
			$.globalMessenger().post({
				message: "消息ID不能为空",//提示信息
				type: 'error',//消息类型。error、info、success
				hideAfter: 5,//多长时间消失
				showCloseButton:true,//是否显示关闭按钮
				hideOnNavigate: true //是否隐藏导航

			});
			return;
		}

		if (null == title || "" == title) {
			$.globalMessenger().post({
				message: "标题不能为空",//提示信息
				type: 'error',//消息类型。error、info、success
				hideAfter: 5,//多长时间消失
				showCloseButton:true,//是否显示关闭按钮
				hideOnNavigate: true //是否隐藏导航

			});
			return;
		}

		if (null == content || "" == content) {
			$.globalMessenger().post({
				message: "内容不能为空",//提示信息
				type: 'error',//消息类型。error、info、success
				hideAfter: 5,//多长时间消失
				showCloseButton:true,//是否显示关闭按钮
				hideOnNavigate: true //是否隐藏导航

			});
			return;
		}

		var requestParam = {
			"message.messageId":	messageId,
			"message.title":title,
			"message.content":content,
			"message.type":type,
			"message.state":state
		};

		$.ajax({
			url:UPDATE_MESSAGE_URL,
			method:'POST',
			data:requestParam,
			dataType:'json',
			beforeSend:sendRequestBeforeHandle(),
			success:function (result){
				console.log(result);
				$("#waitDialog").modal('hide');
				if (200 == result.code){
					$.globalMessenger().post({
						message: result.message,//提示信息
						type: 'success',//消息类型。error、info、success
						hideAfter: 5,//多长时间消失
						showCloseButton:true,//是否显示关闭按钮
						hideOnNavigate: true //是否隐藏导航

					});
					//关闭当前对话框
					$("#editMessageDialog").modal('hide');
					//刷新当前页
					$('#grid').bootstrapTable('refresh');
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
	 * 删除传送点
	 */
	function deleteMessage(){
		//传送点id
		var messageId = $("#deleteMessageId").val();

		//校验id
		if (null == messageId || "" == messageId.trim()) {
			$.globalMessenger().post({
				message: "消息ID不能为空!",//提示信息
				type: 'error',//消息类型。error、info、success
				hideAfter: 5,//多长时间消失
				showCloseButton:true,//是否显示关闭按钮
				hideOnNavigate: true //是否隐藏导航

			});
			return;
		}

		var requestParam = {
			"message.messageId":	messageId
		};
		$.ajax({
			url:DELETE_MESSAGE_URL,
			method:'POST',
			data:requestParam,
			dataType:'json',
			beforeSend:sendRequestBeforeHandle(),
			success:function (result){

				$("#waitDialog").modal('hide');
				if (200 == result.code){
					$.globalMessenger().post({
						message: result.message,//提示信息
						type: 'success',//消息类型。error、info、success
						hideAfter: 5,//多长时间消失
						showCloseButton:true,//是否显示关闭按钮
						hideOnNavigate: true //是否隐藏导航

					});
					//关闭当前对话框
					$("#deleteMessageDialog").modal('hide');
					//刷新当前页
					$('#grid').bootstrapTable('refresh');
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
	 * 添加消息
	 */
	function addMessage(){
		//用户名
		var title = $("#addMessageTitle").val();
		//内容
		var content = $("#addMessageContent").val();
		//消息类型
		var type = $("#addMessageTypeSelect").selectpicker('val');
		//消息状态
		var state = $("input[name='addMessageState']:checked").val();


		if (null == title || "" == title) {
			$.globalMessenger().post({
				message: "标题不能为空",//提示信息
				type: 'error',//消息类型。error、info、success
				hideAfter: 5,//多长时间消失
				showCloseButton:true,//是否显示关闭按钮
				hideOnNavigate: true //是否隐藏导航

			});
			return;
		}

		if (null == content || "" == content) {
			$.globalMessenger().post({
				message: "内容不能为空",//提示信息
				type: 'error',//消息类型。error、info、success
				hideAfter: 5,//多长时间消失
				showCloseButton:true,//是否显示关闭按钮
				hideOnNavigate: true //是否隐藏导航

			});
			return;
		}


		var requestParam = {
			"message.title":title,
			"message.content":content,
			"message.type":type,
			"message.state":state
		};

		$.ajax({
			url:ADD_MESSAGE_URL,
			type:'POST',
			data:requestParam,
			dataType:'json',
			beforeSend:sendRequestBeforeHandle(),
			success:function (result){
				$("#waitDialog").modal('hide');
				if (200 == result.code){
					$.globalMessenger().post({
						message: result.message,//提示信息
						type: 'success',//消息类型。error、info、success
						hideAfter: 5,//多长时间消失
						showCloseButton:true,//是否显示关闭按钮
						hideOnNavigate: true //是否隐藏导航

					});
					//关闭当前对话框
					$("#addMessageDialog").modal('hide');
					//刷新当前页
					$('#grid').bootstrapTable('refresh');
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
</script>