<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
 <html>
<head>
	<meta charset="utf-8" />
	<title>传送门-传送点</title>
	
	<link href="${pageContext.request.contextPath}/asserts/css/common.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap/bootstrap.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/asserts/css/font-awesome/font-awesome.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap-table/bootstrap-table.css" rel="stylesheet" />
	
	<script src="${pageContext.request.contextPath}/asserts/js/jquery/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap/bootstrap.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap-table/bootstrap-table.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap-table/bootstrap-table-zh-CN.js" type="text/javascript"></script>
		
	<style>
        @font-face {
            font-family: 'Glyphicons Halflings';
            src: url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.eot');
            src: url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.eot?#iefix') format('embedded-opentype'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.woff') format('woff'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.ttf') format('truetype'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.svg#glyphicons_halflingsregular') format('svg');
        }
    </style>
</head>
<body>
	<!-- 导航栏 -->
	<ol class="breadcrumb">
	  <li><a href="${pageContext.request.contextPath}/superAdmin_queryGeneralSituation.action">首页</a></li>
	  <li><a href="#">传送点</a></li>
	  <li class="active">查询传送点</li>
	</ol>
	
	<!-- 传送点 -->
	<div class="panel panel-info">
	  <div class="panel-heading"> 传送点管理</div>
	  <div class="panel-body">
	   
	  </div>
	  <div class="panel-footer">传送门</div>
	</div>
</body>

<script>
var $table;
var QUERY_TELEPORTER_URL = "${pageContext.request.contextPath}/teleporter_queryAllByPage.action";
$(function (){
	//查询传送点
	initMainTable();
});


//初始化bootstrap-table的内容
function initMainTable () {
    //记录页面bootstrap-table全局变量$table，方便应用
    $table = $('#grid').bootstrapTable({
        url: QUERY_TELEPORTER_URL,                      //请求后台的URL（*）
        method: 'POST',                      //请求方式（*）
        //toolbar: '#toolbar',              //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
        pageSize: 5,                     //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: true,                      //是否显示表格搜索
        strictSearch: true,
        showColumns: true,                  //是否显示所有的列（选择显示的列）
        showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        //height: 500,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
        showToggle: true,                   //是否显示详细视图和列表视图的切换按钮
        cardView: true,                    //是否显示详细视图
        detailView: false,                  //是否显示父子表
        //得到查询的参数
        queryParams : function (params) {
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {   
                rows: params.limit,                         //页面大小
                page: (params.offset / params.limit) + 1,   //页码
                sort: params.sort,      //排序列名  
                sortOrder: params.order //排位命令（desc，asc） 
            };
            return temp;
        },
        columns: [{
            checkbox: true,  
            visible: true                  //是否显示复选框  
        }, {
            field: 'teleporterId',
            title: '编号',
            sortable: true
        }, {
        	  field: 'areaName',
              title: '区域',
              sortable: true
        }, {
            field: 'address',
            title: '地址',
            sortable: true
        }, {
            field: 'inputUserName',
            title: '录入人',
       
        }, {
            field: 'createDate',
            title: '创建日期',
            formatter: dateFormatter
        }, {
            field:'teleporterId',
            title: '操作',
            width: 120,
            align: 'center',
            valign: 'middle',
            formatter: actionFormatter
        }, ],
        onLoadSuccess: function () {
        },
        onLoadError: function () {
            showTips("数据加载失败！");
        },
        onDblClickRow: function (row, $element) {
            var id = row.ID;
            EditViewById(id, 'view');
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

//连接字段格式化
function linkFormatter(value, row, index) {                
    return "<a href='" + value + "' title='单击打开连接' target='_blank'>" + value + "</a>";
}
//Email字段格式化
function emailFormatter(value, row, index) {
    return "<a href='mailto:" + value + "' title='单击打开连接'>" + value + "</a>";
}

//性别字段格式化
function sexFormatter(value) {
    if (value == "女") { color = 'Red'; }
    else if (value == "男") { color = 'Green'; }
    else { color = 'Yellow'; }

    return '<div  style="color: ' + color + '">' + value + '</div>';
}

//操作栏的格式化
function actionFormatter(value, row, index) {
    var id = value;
    var result = "";
    result += "<a href='javascript:;' class='btn btn-xs green' onclick=\"EditViewById('" + id + "', view='view')\" title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"EditViewById('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"DeleteByIds('" + id + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";

    return result;
}
</script>