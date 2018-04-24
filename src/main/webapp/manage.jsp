
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Fluid Layout - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="easyUI/demo.css">
	<script type="text/javascript" src="easyUI/jquery.min.js"></script>
	<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>超级管理员后台管理</h2>
	<p>用户名：xxx</p>
	<div style="margin:20px 0;"></div>
	<div class="easyui-layout" style="width:100%;height:600px;">
		
			<!-- 左边区 -->	
		<div id="p" data-options="region:'west',iconCls:'icon-ok'" title="功能部分" style="width:30%;padding:10px">
		<div style="margin:20px 0 10px 0;"></div>
				<!-- 左边标题区 -->
				<div class="easyui-accordion" data-options="multiple:true" style="width:80%;height1:80%;">
					<div title="传送点管理"  style="overflow:auto;padding:10px;">
					<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true,selected:true" onclick="$('#addPorterDlg').dialog('open')">添加传送点</a><br/>
					<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">查询传送点</a><br/>
					<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">删除传送点</a><br/>
					<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">修改传送点</a><br/>
					</div>
					<div title="管理员管理" style="padding:10px;">
					<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true,selected:true">添加管理员</a><br/>
					<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">查询管理员</a><br/>
					<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">删除管理员</a><br/>
					<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">修改管理员</a><br/>
					</div>
				</div>
				
				<!-- 中间区 -->
				<div data-options="region:'center'" title="显示区域" sytle="width:65%;">
				</div>

		
		</div>	
		
	</div>
</body>
</html>