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
        
       [data-id=queryTeleporterSelect] {
       	height:30px;
       }
       
       [data-id=editTeleporterSelect] {
        height:30px;
       }
	   
	   [data-id=addTeleporterSelect] {
		   height:30px;
	   }
    </style>
</head>
<body>
	<!-- 导航栏 -->
	<ol class="breadcrumb">
	  <li><a href="${pageContext.request.contextPath}/superAdmin_queryGeneralSituation.action">首页</a></li>
	  <li><a href="#">传送点管理员</a></li>
	  <li class="active">查询传送点管理员</li>
	</ol>
	
	<!-- 传送点 -->
	<div class="panel panel-info">
	  <div class="panel-heading"> 传送点管理员</div>
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
				      <input class="form-control" id="queryTeleporterAdminId" type="text"  value="">
				    </div>
				 
				 	 <!-- 登记日期 -->
				 	<label class="col-sm-3 control-label">登记日期</label>
				    <div class='input-group date col-sm-2' id='datetimepicker1'>
	                    <input type='text' class="form-control" disabled="true"/>
	                    <span class="input-group-addon">
	                        <span class="glyphicon glyphicon-calendar"></span>
	                    </span>
	                </div>
	                
	             
	           
				 </div>
				 
				
				 <div  class="form-group" >
					<!-- 区域 -->
					<label class="col-sm-3 control-label" >传送点</label>
					<div class="col-sm-2">
						<select  id="queryTeleporterSelect" class="selectpicker"  data-live-search="true">
													   
						</select>
						<button class="btn btn-default" id="clearQueryTeleporterSelectBtn">
							<span class="glyphicon glyphicon-trash"></span> 清空
						</button>					    
					</div>
					
					<!-- 手机号 -->
				 	<label class="col-sm-3 control-label">手机号</label>
				    <div class='input-group  col-sm-2' >
	                    <input type='text' class="form-control" id="queryPhone"/>
	                    
	                </div>
				</div>
				
			  </form>
			  
		  	</div>
		  </div>
		  
		  <div class="panel-footer" style="text-align:right">
	        <button id="queryTeleporterAdminBtn" type="button" class="btn btn-primary" >
	        	<span class="glyphicon glyphicon-search"></span> 查询
	        </button>
	        
	        <button id="addTeleporterAdminBtn" type="button" class="btn btn-info" >
	        	<span class="glyphicon glyphicon-plus"></span> 登记
	        </button>
		  </div>
		</div>
	   
		<table id="grid"></table>
		
	  </div>
	  <div class="panel-footer">传送门</div>
	</div>
	
	
	<!-- 查看模态框 -->
	<div class="modal fade" id="viewTeleporterAdminDialog" tabindex="-1" role="dialog"  aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">传送点管理员详情</h4>
	            </div>
	            <div class="modal-body">
					<form action="#" class="form-horizontal" role="form">
						<!-- 编号 -->
						 <div class="form-group">
						    <label class="col-sm-3 control-label">编号</label>
						    <div class="col-sm-9">
						     <fieldset disabled>
						      <input class="form-control" id="viewTeleporterAdminId" type="text" disable value="">
						     </fieldset>
						    </div>
						  </div>
						  
						
						 
						 <!-- 传送点 -->
						 <div class="form-group">
						    <label class="col-sm-3 control-label">传送点</label>
						    <div class="col-sm-9">
						     <fieldset disabled>
						      <input class="form-control" id="viewTeleporterAddress" type="text" value="">
						     </fieldset>
						    </div>
						 </div>
						  
						 <!-- 用户名-->
						 <div class="form-group">
						    <label class="col-sm-3 control-label">用户名</label>
						    <div class="col-sm-9">
						   	 <fieldset disabled>
						      <input class="form-control" id="viewTeleporterAdminName" type="text" value="">
						   	 </fieldset>
						    </div>
						 </div>
						 
						 <!-- 手机号 -->
						 <div class="form-group">
						    <label class="col-sm-3 control-label">手机号</label>
						    <div class="col-sm-9">
						   	 <fieldset disabled>
						      <input class="form-control" id="viewTeleporterAdminPhone" type="text" value="">
						   	 </fieldset>
						    </div>
						 </div>
						 
						 <!-- 性别 -->
						 <div class="form-group">
						    <label class="col-sm-3 control-label">性别</label>
						    <div class="col-sm-9">
						     <fieldset disabled>
						      <input class="form-control" id="viewTeleporterAdminSex" type="text" value="">
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
						 
						 <!-- 注册日期 -->
						 <div class="form-group">
						    <label class="col-sm-3 control-label">注册日期</label>
						    <div class="col-sm-9">
						     <fieldset disabled>
						      <input class="form-control" id="viewTeleporterAdminRegisterDate" type="text" value="">
						     </fieldset>
						    </div>
						 </div>
						 
						
						 
						 
					</form>
				</div>
	            <div class="modal-footer">
	                <button id="viewTeleporterAdminDialogOKBtn" type="button" class="btn btn-primary">确定</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>

	
	<!-- 修改传送点模特框 -->
	<div class="modal fade" id="editTeleporterAdminDialog" tabindex="-1" role="dialog"  aria-hidden="true">
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
                                    <input class="form-control" id="editTeleporterAdminId" type="text" disable value="">
                                </fieldset>
                            </div>
                        </div>



                        <!-- 传送点 -->
                        <div class="form-group">
                            <label class="col-sm-3 control-label">传送点</label>
                            <div class="col-sm-9">
                                    <select  id="editTeleporterSelect" class="selectpicker"  data-live-search="true">

                                    </select>
                                    <button id="unBindTeleporterBtn" type="button" class="btn btn-danger">解除绑定</button>
                            </div>
                        </div>

                        <!-- 用户名-->
                        <div class="form-group">
                            <label class="col-sm-3 control-label">用户名</label>
                            <div class="col-sm-9">

                                    <input class="form-control" id="editTeleporterAdminName" type="text" value="">

                            </div>
                        </div>

                        <!-- 手机号 -->
                        <div class="form-group">
                            <label class="col-sm-3 control-label">手机号</label>
                            <div class="col-sm-9">
								<fieldset disabled>
                                    <input class="form-control" id="editTeleporterAdminPhone" type="text" value="">
								</fieldset>
                            </div>
                        </div>

                        <!-- 性别 -->
                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别</label>
                            <div class="col-sm-9">
                                <label class="checkbox-inline">
                                    <input type="radio" name="editTeleporterAdminSex" id="editTeleporterAdminSexMan"
                                           value="1" checked> 男
                                </label>
                                <label class="checkbox-inline">
                                    <input type="radio" name="editTeleporterAdminSex" id="editTeleporterAdminSexWoMan"
                                           value="0"> 女
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

                        <!-- 注册日期 -->
                        <div class="form-group">
                            <label class="col-sm-3 control-label">注册日期</label>
                            <div class="col-sm-9">
                                <fieldset disabled>
                                    <input class="form-control" id="editTeleporterAdminRegisterDate" type="text" value="">
                                </fieldset>
                            </div>
                        </div>
						 
					</form>
				</div>
	            <div class="modal-footer">
	            	<button id="editTeleporterAdminDialogCancelBtn" type="button" class="btn btn-default">取消</button>
	            	
	                <button id="editTeleporterAdminDialogOKBtn" type="button" class="btn btn-primary">更新</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
	
	
	<!-- 删除管理员模块框 -->
	<div class="modal fade" id="deleteTeleporterAdminDialog" tabindex="-1" role="dialog"  aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title">删除管理员</h4>
	            </div>
	            <div class="modal-body">
					您确定删除传送点管理员<label id="deleteTeleporterAdminName"></label>吗?
					<input type="hidden" id="deleteTeleporterAdminId"/>
				</div>
	            <div class="modal-footer">
	            	<button id="deleteTeleporterAdminDialogCancelBtn" type="button" class="btn btn-default">取消</button>
	            	
	                <button id="deleteTeleporterAdminDialogOKBtn" type="button" class="btn btn-danger">删除</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
	
	
	<!-- 新增模态框 -->
	<div class="modal fade" id="addTeleporterAdminDialog" tabindex="-1" role="dialog"  aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" >新增传送点管理员</h4>
	            </div>
	            <div class="modal-body">
					<form action="#" class="form-horizontal" role="form">

						 <!-- 姓名 -->
						 <div class="form-group">
						    <label class="col-sm-3 control-label">姓名</label>
						    <div class="col-sm-9">
						     
						      <input class="form-control" id="addTeleporterAdminUsername" type="text" value="">
						     
						    </div>
						 </div>

						<!-- 手机号 -->
						<div class="form-group">
							<label class="col-sm-3 control-label">手机号</label>
							<div class="col-sm-9">

								<input class="form-control" id="addTeleporterAdminTel" type="text" value="">

							</div>
						</div>

						<!-- 性别 -->
						<div class="form-group">
							<label class="col-sm-3 control-label">性别</label>
							<div class="col-sm-9">
								<label class="checkbox-inline">
									<input type="radio" name="addTeleporterAdminSex"
										   value="1" checked> 男
								</label>
								<label class="checkbox-inline">
									<input type="radio" name="addTeleporterAdminSex"
										   value="0"> 女
								</label>
							</div>
						</div>

						 <!-- 传送点-->
						 <div class="form-group">
						    <label class="col-sm-3 control-label">所属传送点</label>
						    <div class="col-sm-9">
							   	<select  id="addTeleporterSelect" class="addSelectpicker"  data-live-search="true">
														   
								</select>
						    </div>
						 </div>

						 
						 
					</form>
				</div>
	            <div class="modal-footer">
	                <button id="addTeleporterAdminDialogOKBtn" type="button" class="btn btn-primary">保存</button>
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
/**分页查询传送点管理员*/
var QUERY_TELEPORTER_ADMIN_URL = "${pageContext.request.contextPath}/teleporterAdmin_queryAllByPage.action";
/**查看传送点管理员详情*/
var TELEPORTER_ADMIN_DETAIL_URL = "${pageContext.request.contextPath}/teleporterAdmin_getTeleporterAdminDetailById.action";
/**获取全部传送点*/
var QUERY_TELEPORTER_URL = "${pageContext.request.contextPath}/teleporter_queryAllTelporter.action";
/**更新传送点管理员信息*/
var UPDATE_TELEPORTER_ADMIN_URL = "${pageContext.request.contextPath}/teleporterAdmin_updateTeleporterAdmin.action";
/**删除传送点管理员*/
var DELETE_TELEPORTER_ADMIN_URL = "${pageContext.request.contextPath}/teleporterAdmin_deleteTeleporterAdmin.action";
/**添加传送点管理员*/
var ADD_TELEPORTER_ADMIN_URL = "${pageContext.request.contextPath}/teleporterAdmin_addTeleporterAdmin.action";
/**解绑传送点*/
var UN_BIND_TELEPRTER_URL = "${pageContext.request.contextPath}/teleporterAdmin_unBindTeleporter.action";


/**全局传送点*/
var global_teleporter = null;

$(function (){
	//初始化表格
	initMainTable();
	
	//初始化提示
	initMessenge();
	
	//初始化传送点数据
	initTeleporterData();

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
    $("#viewTeleporterAdminDialogOKBtn").click(function (){
        $("#viewTeleporterAdminDialog").modal('hide');
    });

    $("#editTeleporterAdminDialogCancelBtn").click(function (){
        $("#editTeleporterAdminDialog").modal('hide');
    });

    $("#deleteTeleporterAdminDialogCancelBtn").click(function (){
        $("#deleteTeleporterAdminDialog").modal('hide');
    })

    $("#deleteTeleporterAdminDialogOKBtn").click(function (){
        deleteTeleporterAdmin();
    });

    $("#queryTeleporterAdminBtn").click(function (){
        queryTeleporterAdmin();
    });

    $("#clearQueryTeleporterSelectBtn").click(function (){
        $('#queryTeleporterSelect').selectpicker('val','');
    });


    $("#addTeleporterDialogOKBtn").click(function (){
        addTeleporter();
    });

    $("#unBindTeleporterBtn").click(function (){
        unBindTeleporter();
    });

    $("#editTeleporterAdminDialogOKBtn").click(function (){
        updateTeleporterAdmin();
    });

    $("#addTeleporterAdminBtn").click(function (){
    	$("#addTeleporterAdminDialog").modal();
	});

    $("#addTeleporterAdminDialogOKBtn").click(function (){
		addTeleporterAdmin();
	});
}


//初始化bootstrap-table的内容
function initMainTable () {
    //记录页面bootstrap-table全局变量$table，方便应用
    $table = $('#grid').bootstrapTable({
        url: QUERY_TELEPORTER_ADMIN_URL,                      //请求后台的URL（*）
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
        uniqueId: "teleporterAdminId",                     //每一行的唯一标识，一般为主键列
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
        	var teleporterAdminId = $("#queryTeleporterAdminId").val();
        	var inputDate = $("#datetimepicker1").find("input").val();
        	var teleporter = $("#queryTeleporterSelect").selectpicker('val');
            var phone = $("#queryPhone").val();
			
        	temp['teleporterAdminQueryCondition.ids'] = teleporterAdminId;
        	temp['teleporterAdminQueryCondition.date'] = inputDate;
        	temp['teleporterAdminQueryCondition.teleporter'] = teleporter;
			temp['teleporterAdminQueryCondition.phone'] = phone;
            return temp;
        },
        columns: [{
            checkbox: true,  
            visible: true                  //是否显示复选框  
        }, {
            field: 'teleporterAdminId',
            title: '编号',
            align: 'center',
            valign: 'middle',
           
        }, {
        	  field: 'teleporter.address',
              title: '传送点',
              align: 'center',
              valign: 'middle',
             
        }, {
            field: 'username',
            title: '用户名',
            align: 'center',
            valign: 'middle',
            
        }, {
            field: 'sex',
            title: '性别',
            align: 'center',
            valign: 'middle',
			formatter:sexFormatter
       
        }, {
            field: 'tel',
            title: '电话',
            align: 'center',
            valign: 'middle',
            
        },{
			field: 'superAdmin.username',
			title: '录入人',
			align: 'center',
			valign: 'middle',

		},{
			field: 'registerDate',
			title: '登记日期',
			align: 'center',
			valign: 'middle',

		}, {
            field:'teleporterAdminId',
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
            var id = row.teleporterAdminId;
            
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


//操作栏的格式化
function actionFormatter(value, row, index) {
    var id = value;
    var result = "";
    result += "<a href='javascript:;' class='btn btn-xs green' onclick=\"viewById('" + id + "')\" title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"editViewById('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"deleteById('" + id + "','" + row.username + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";

    return result;
}

/**
 * 获取所有传送点数据
 */
function initTeleporterData(){
	$.ajax({
		url:QUERY_TELEPORTER_URL,
		type:'POST',
		dataType:'json',
		beforeSend:function (){
			$("#waitDialog").modal();
		},
		success:function (result) {
			$("#waitDialog").modal('hide');
			
			if (200 == result.code) {
				global_teleporter = result.message;
				
				//初始化查询传送点区域
			 	for (var i = 0 ; i < global_teleporter.length; i++){
                    var option = $('<option></option>');
                    option.attr('value', global_teleporter[i].teleporterId);
                    option.text(global_teleporter[i].address);
                    $('#queryTeleporterSelect').append(option);

                }


				//默认选中无
			 	$('#queryTeleporterSelect').selectpicker('val','');
				
				$('#queryTeleporterSelect').selectpicker('refresh');  
			    $('#queryTeleporterSelect').selectpicker('render');

			    //初始化修改传送点区域
                for (var i = 0 ; i < global_teleporter.length; i++){
                    var option = $('<option></option>');
                    option.attr('value', global_teleporter[i].teleporterId);
                    option.text(global_teleporter[i].address);
					$('#editTeleporterSelect').append(option);
                }
                $('#editTeleporterSelect').selectpicker('val','');
                $('#editTeleporterSelect').selectpicker('refresh');
                $('#editTeleporterSelect').selectpicker('render');

                //初始化新增传送点区域
				for (var i = 0 ; i < global_teleporter.length; i++){
					var option = $('<option></option>');
					option.attr('value', global_teleporter[i].teleporterId);
					option.text(global_teleporter[i].address);
					$('#addTeleporterSelect').append(option);
				}
				$('#addTeleporterSelect').selectpicker('val','');
				$('#addTeleporterSelect').selectpicker('refresh');
				$('#addTeleporterSelect').selectpicker('render');
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
 * 查看传送点管理员详情
 */
function viewById(id) {
    if (null == id || "" == id) {
        $.globalMessenger().post({
            message: "传送点管理员ID不能为空",//提示信息
            type: 'error',//消息类型。error、info、success
            hideAfter: 5,//多长时间消失
            showCloseButton:true,//是否显示关闭按钮
            hideOnNavigate: true //是否隐藏导航

        });
        return;
    }

	var requestParam = {
			"teleporterAdmin.teleporterAdminId":id
	};
	$.ajax({
		url:TELEPORTER_ADMIN_DETAIL_URL,
		type:'POST',
		data:requestParam,
		dataType:'json',
		beforeSend:sendRequestBeforeHandle(),
		success:function (result){
			$("#waitDialog").modal('hide');
			if (200 == result.code){
				//填充数据
				var teleporterAdmin = result.message;
				//编号
				$("#viewTeleporterAdminId").val(teleporterAdmin.teleporterAdminId);
				if (null != teleporterAdmin.teleporter) {
				    //传送点
				    $("#viewTeleporterAddress").val(teleporterAdmin.teleporter.address);
                }else {
                    $("#viewTeleporterAddress").val('未绑定');
                }
				//用户名
				$("#viewTeleporterAdminName").val(teleporterAdmin.username);
				//性别
				if (0 == teleporterAdmin.sex) {
					$("#viewTeleporterAdminSex").val('女');
				}else {
					$("#viewTeleporterAdminSex").val('男');
				}
				//电话
				$("#viewTeleporterAdminPhone").val(teleporterAdmin.tel);
				//录入人
				$("#viewInputUserName").val(teleporterAdmin.superAdmin.username);
				//登记日期
				$("#viewTeleporterAdminRegisterDate").val(teleporterAdmin.registerDate);

				//显示对话框
				$("#viewTeleporterAdminDialog").modal();
					
				
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
 * 编辑传送门
 */
function editViewById(id) {
	
	if (null == global_teleporter) {
        initTeleporterData();
	}else {
        editEleporterAdminHandle(id);
    }
	
	
} 

/**
 * 编辑传送点处理方法
 */
function editEleporterAdminHandle(id){
    if (null == id || "" == id) {
        $.globalMessenger().post({
            message: "传送点管理员ID不能为空",//提示信息
            type: 'error',//消息类型。error、info、success
            hideAfter: 5,//多长时间消失
            showCloseButton:true,//是否显示关闭按钮
            hideOnNavigate: true //是否隐藏导航

        });
        return;
    }


    var requestParam = {
			"teleporterAdmin.teleporterAdminId":id
	}
	$.ajax({
		url:TELEPORTER_ADMIN_DETAIL_URL,
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
                var teleporterAdmin = result.message;
                //编号
                $("#editTeleporterAdminId").val(teleporterAdmin.teleporterAdminId);
                //传送点
                if (null != teleporterAdmin.teleporter) {
                    $('#editTeleporterSelect').selectpicker('val',teleporterAdmin.teleporter.teleporterId);
                }else {
                    $('#editTeleporterSelect').selectpicker('val',['noneSelectedText'])
                    $("#editTeleporterSelect").selectpicker('refresh');
                    $('#editTeleporterSelect').selectpicker('render');
                }

                //用户名
                $("#editTeleporterAdminName").val(teleporterAdmin.username);
                //性别
                if (1 == teleporterAdmin.sex) {
                    $("#editTeleporterAdminSexMan").attr("checked",'checked');
                }else {
                    $("#editTeleporterAdminSexWoMan").attr("checked",'checked');
                }
                //电话
                $("#editTeleporterAdminPhone").val(teleporterAdmin.tel);
                //录入人
                $("#editInputUserName").val(teleporterAdmin.superAdmin.username);
                //登记日期
                $("#editTeleporterAdminRegisterDate").val(teleporterAdmin.registerDate);


				$("#editTeleporterAdminDialog").modal();
				
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
function deleteById(id,teleporterAdminName){
	$("#deleteTeleporterAdminId").val(id);
	$("#deleteTeleporterAdminName").html(teleporterAdminName);
	
	//显示删除框
	$("#deleteTeleporterAdminDialog").modal();
}


/**
 *解绑传送点
 */
function unBindTeleporter() {
    //获取管理员ID
    var teleporterAdminId = $("#editTeleporterAdminId").val();
    if (null == teleporterAdminId || "" == teleporterAdminId) {
        $.globalMessenger().post({
            message: "传送点管理员ID不能为空",//提示信息
            type: 'error',//消息类型。error、info、success
            hideAfter: 5,//多长时间消失
            showCloseButton:true,//是否显示关闭按钮
            hideOnNavigate: true //是否隐藏导航

        });
        return;
    }

    var requestParam = {"teleporterAdmin.teleporterAdminId":	teleporterAdminId,}
    $.ajax({
        url:UN_BIND_TELEPRTER_URL,
        method:'POST',
        data:requestParam,
        dataType:'json',
        beforeSend:sendRequestBeforeHandle(),
        success:function (result){

            $("#waitDialog").modal('hide');
            if (200 == result.code){
                $.globalMessenger().post({
                    message: '解绑成功',//提示信息
                    type: 'success',//消息类型。error、info、success
                    hideAfter: 5,//多长时间消失
                    showCloseButton:true,//是否显示关闭按钮
                    hideOnNavigate: true //是否隐藏导航

                });

                var teleporterAdmin = result.message;
                //更新传送点信息
                if (null != teleporterAdmin.teleporter) {
                    $('#editTeleporterSelect').selectpicker('val',teleporterAdmin.teleporter.teleporterId);
                }else {
                    $('#editTeleporterSelect').selectpicker('val',['noneSelectedText'])
                    $("#editTeleporterSelect").selectpicker('refresh');
                    $('#editTeleporterSelect').selectpicker('render');
                }
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

/*******增删改查请求区*********/
/**
 * 查询传送点
 */
function queryTeleporterAdmin(){
	//获取查询条件
	//获取查询条件
	var teleporterAdminId = $("#queryTeleporterAdminId").val();
	var inputDate = $("#datetimepicker1").find("input").val();
	var teleporter = $("#queryTeleporterSelect").selectpicker('val');
	var phone = $("#queryPhone").val();

	var requestParam = {
			"teleporterAdminQueryCondition.ids":	teleporterAdminId,
			"teleporterAdminQueryCondition.date":inputDate,
			"teleporterAdminQueryCondition.teleporter":teleporter,
			"teleporterAdminQueryCondition.phone" :phone.trim(),
			"page":1,
			"rows":5
	}
	$.ajax({
		url:QUERY_TELEPORTER_ADMIN_URL,
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
 * 更新传送点信息
 */
function updateTeleporterAdmin(){

	//传送点id
	var teleporterAdminId = $("#editTeleporterAdminId").val();
	//传送点
	var teleporterId = $("#editTeleporterSelect").selectpicker('val');
	//用户名
    var teleporterAdminName = $("#editTeleporterAdminName").val();
    /*//手机号
	var tel = $("#editTeleporterAdminPhone").val();*/
	//性别
	var sex = $("input[name='editTeleporterAdminSex']:checked").val();
	console.log( sex);
	if (null == teleporterAdminId || teleporterAdminId == "") {
		$.globalMessenger().post({
            message: "传送点管理员ID不能为空",//提示信息
            type: 'error',//消息类型。error、info、success
            hideAfter: 5,//多长时间消失
            showCloseButton:true,//是否显示关闭按钮
            hideOnNavigate: true //是否隐藏导航

		});
		return;
	}

	var requestParam = {
		"teleporterAdmin.teleporterAdminId":	teleporterAdminId,
		"teleporterAdmin.teleporter.teleporterId":teleporterId,
		"teleporterAdmin.username":teleporterAdminName,
	/*	"teleporterAdmin.tel":tel,*/
		"teleporterAdmin.sex":sex
	};
	
	$.ajax({
		url:UPDATE_TELEPORTER_ADMIN_URL,
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
				$("#editTeleporterAdminDialog").modal('hide');
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
function deleteTeleporterAdmin(){
	//传送点id
	var teleporterAdminId = $("#deleteTeleporterAdminId").val();
	
	//校验id
	if (null == teleporterAdminId || "" == teleporterAdminId.trim()) {
		$.globalMessenger().post({
            message: "传送点管理员ID不能为空!",//提示信息
            type: 'error',//消息类型。error、info、success
            hideAfter: 5,//多长时间消失
            showCloseButton:true,//是否显示关闭按钮
            hideOnNavigate: true //是否隐藏导航

		});
		return;
	}
	
	var requestParam = {
		"teleporterAdmin.teleporterAdminId":	teleporterAdminId
	};
	$.ajax({
		url:DELETE_TELEPORTER_ADMIN_URL,
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
				$("#deleteTeleporterAdminDialog").modal('hide');
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
 * 添加传送点
 */
function addTeleporterAdmin(){
	//用户名
	var username = $("#addTeleporterAdminUsername").val();
	//手机号
	var tel = $("#addTeleporterAdminTel").val();
	//性别
	var sex = $("input[name='addTeleporterAdminSex']:checked").val();
	//传送点
	var teleporterId = $("#addTeleporterSelect").selectpicker('val');
	if (null == teleporterId || "" == teleporterId) {
		$.globalMessenger().post({
			message: "传送点不能为空!",//提示信息
			type: 'error',//消息类型。error、info、success
			hideAfter: 5,//多长时间消失
			showCloseButton:true,//是否显示关闭按钮
			hideOnNavigate: true //是否隐藏导航

		});
		return;
	}

	
	if (null == username || "" == username.trim()) {
		$.globalMessenger().post({
			message: "用户名不能为空!",//提示信息
			type: 'error',//消息类型。error、info、success
			hideAfter: 5,//多长时间消失
			showCloseButton:true,//是否显示关闭按钮
			hideOnNavigate: true //是否隐藏导航

		});
		return;
	}

	if (null == tel || "" == tel.trim()) {
		$.globalMessenger().post({
			message: "手机号不能为空!",//提示信息
			type: 'error',//消息类型。error、info、success
			hideAfter: 5,//多长时间消失
			showCloseButton:true,//是否显示关闭按钮
			hideOnNavigate: true //是否隐藏导航

		});
		return;
	}
	
	var requestParam = {
		"teleporterAdmin.username" : username,
		"teleporterAdmin.tel" : tel,
		"teleporterAdmin.sex":sex,
		"teleporterAdmin.teleporter.teleporterId":teleporterId
	};
	
	$.ajax({
		url:ADD_TELEPORTER_ADMIN_URL,
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
				$("#addTeleporterAdminDialog").modal('hide');
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