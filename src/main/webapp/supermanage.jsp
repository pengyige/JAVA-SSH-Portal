<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>传送门</title>
	<link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="easyUI/demo.css">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<script type="text/javascript" src="easyUI/jquery.min.js"></script>
	<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/supermanage.js"></script>
</head>
<body>
	<!-- 顶部-->
	<nav class="navbar navbar-default">
			 <div class="container-fluid">
				<div class="navbar-header">
				  <a class="navbar-brand" href="#">
					<img alt="传送门" src="...">
				  </a>
				</div>
				<p class="navbar-text" style="font-size:20px;margin-left:450px"s>传送门后台管理</p>	
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${!empty superuser }">
							<p class="navbar-text">欢迎,<label id="usernameLabel">${superuser.getUsername()} &nbsp;&nbsp;</label><a href="teleporterAdmin_logout.action" style="margin-top:14px">注销</a></p>
						</c:when>
						
						<c:otherwise>
							<p class="navbar-text">您还没有登入,请先<a href="superad_login.jsp" style="color:blue;">登入</a></p>
							
						</c:otherwise>
					</c:choose>
					
				</ul>
			 </div>
		</nav>
	
	
	<div style="margin:20px 0;"></div>
	<div class="easyui-layout" style="width:100%;height:450px;">
		
		<!-- 左边操作区 -->	
		<div id="p" data-options="region:'west',iconCls:'icon-ok'" title="功能区" style="width:30%;padding:10px">
			<div style="margin:20px 0 10px 0;">
			</div>
			<!-- 功能区 -->
			<div class="easyui-accordion" data-options="multiple:true" style="width:80%;height1:80%;">
				<div title="传送点管理"  style="overflow:auto;padding:10px;">
				<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true,selected:true" onclick="$('#addPorterDlg').dialog('open')">添加传送点</a><br/>
				<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true" onclick="$('#deletePorterDlg').dialog('open')" >删除传送点</a><br/>
				<a id="queryAllTeleporter" href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">查询所有传送点</a><br/>
				</div>
				<div title="管理员管理" style="padding:10px;">
				<a id="addTeleporterAdmin" href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true,selected:true">添加管理员</a><br/>
				<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true" onclick="$('#deletePorterAdminDlg').dialog('open')">删除管理员</a><br/>
				<a id="queryAllAdmin" href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">查询所有管理员</a><br/>
				</div>
			
				
			</div>
		</div>
				<!-- 添加传送点对话框 -->
				<div id="addPorterDlg" class="easyui-dialog" title="添加传送点" style="width:400px;height:200px;padding:10px;"
					data-options="
					closed:true,
					iconCls: 'icon-save',
					buttons: [{
						text:'Ok',
						iconCls:'icon-ok',
						handler:addTeleporterOkHandle
					
					},{
						text:'Cancel',
						handler:function(){
							$('#addPorterDlg').dialog('close');
						}
					}]
				">
					<div style="padding:10px 60px 20px 60px">
								<table cellpadding="5">
									<tr>
										<td>地址:</td>
										<td><input id="address" class="easyui-textbox" type="text" name="address" data-options="required:true"></input></td>
									</tr>
									<tr>
										<td>备注:</td>
										<td><input id="remark" class="easyui-textbox" type="text" name="remark" ></input></td>
									</tr>
								</table>
							</form>
					</div>
				</div>
				
				<!-- 删除传送点 -->
				<div id="deletePorterDlg" class="easyui-dialog" title="删除传送点" style="width:400px;height:200px;padding:10px;"
					data-options="
					closed:true,
					iconCls: 'icon-save',
					buttons: [{
						text:'Ok',
						iconCls:'icon-ok',
						handler:deleteTeleporterOKHandle
			
					},{
						text:'Cancel',
						handler:function(){
							$('#deletePorterDlg').dialog('close')
						}
					}]
				">
					<div style="padding:10px 60px 20px 60px">
								<table cellpadding="5">
									<tr>
										<td>传送点Id:</td>
										<td><input id="teleporterId" class="easyui-textbox" type="text" name="teleporterId" data-options="required:true"></input></td>
									</tr>
								</table>
							</form>
					</div>
				</div>
				
			
				<!-- 管理员管理对话框-->
				<div id="addPorterAdminDlg" class="easyui-dialog" title="添加管理员" style="width:600px;height:400px;padding:10px;"
					data-options="
					closed:true,
					iconCls: 'icon-save',
					buttons: [{
						text:'Ok',
						iconCls:'icon-ok',
						handler:function(){
							addTeleporterAdminHandle();
						}
					},{
						text:'Cancel',
						handler:function(){
							$('#addPorterAdminDlg').dialog('close')
						}
					}]
				">
					<div style="padding:10px 60px 20px 60px">
								<table cellpadding="5">
									<tr>
										<td>姓名:</td>
										<td><input id="username" class="easyui-textbox" type="text" name="username" data-options="required:true"></input></td>
									</tr>
									<tr>
										<td>电话:</td>
										<td><input id="tel" class="easyui-textbox" type="text" name="tel" ></input></td>
									</tr>
									<tr>
										<td>传送点:</td>
										<td>
										<select id="admin_porter_Id_select" class="easyui-combobox" style="width:200px;" data-options="required:true">				
										</select>
										</td>
									</tr>
								</table>
							</form>
					</div>
				</div>
				
				
				<!-- 删除管理员 -->
				<div id="deletePorterAdminDlg" class="easyui-dialog" title="删除管理员" style="width:400px;height:200px;padding:10px;"
					data-options="
					closed:true,
					iconCls: 'icon-save',
					buttons: [{
						text:'Ok',
						iconCls:'icon-ok',
						handler:function(){
							deleteTeleporterAdminHandle();
						}
					},{
						text:'Cancel',
						handler:function(){
							$('#deletePorterAdminDlg').dialog('close')
						}
					}]
				">
					<div style="padding:10px 60px 20px 60px">
								<table cellpadding="5">
									<tr>
										<td>管理员Id:</td>
										<td><input id="teleporterAdminId" class="easyui-textbox" type="text" name="teleporterAdminId" ></input></td>
									</tr>
								</table>
							</form>
					</div>
				</div>
				
				
				
		<!--显示区 -->
		<div data-options="region:'center'" title="结果区" sytle="width:65%;">
			<table id="teleporterGrid"  class="easyui-datagrid" title="传送点所有信息" style="width:100%;height:100%">
			</table>
			
			<table id="adminGrid" class="easyui-datagrid" title="管理员所有信息" style="width:100%;height:100%">
				
			</table>
		</div>

		
	</div>
</body>
</html>