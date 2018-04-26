<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
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
	<!-- 顶部-->
	<nav>
		<div style="width:200px;margin:0 auto;">
		   <h2>传送门后天管理</h2>
		</div>
		
		<div style="float:right">
			 <p style="margin-right:20px;">用户名:xxx</p>
			您还没有登入，请先登入<a href="#" class="easyui-linkbutton" data-options="toggle:true">登入</a>
		</div>
		
	</nav>
	
	
	<div style="margin:20px 0;"></div>
	<div class="easyui-layout" style="width:100%;height:450px;">
		
		<!-- 左边 -->	
		<div id="p" data-options="region:'west',iconCls:'icon-ok'" title="xxx" style="width:30%;padding:10px">
			<div style="margin:20px 0 10px 0;">
			</div>
			<!-- xxx -->
			<div class="easyui-accordion" data-options="multiple:true" style="width:80%;height1:80%;">
				<div title="xxx"  style="overflow:auto;padding:10px;">
				<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true,selected:true" onclick="$('#addPorterDlg').dialog('open')">忙路禄氓聤聽盲录聽茅聙聛莽聜鹿</a><br/>
				<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">xxx</a><br/>
				<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true" onclick="$('#deletePorterDlg').dialog('open')" >氓聢聽茅聶陇盲录聽茅聙聛莽聜鹿</a><br/>
				<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">xxx</a><br/>
				</div>
				<div title="xxx" style="padding:10px;">
				<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true,selected:true" onclick="$('#addPorterAdminDlg').dialog('open')">忙路禄氓聤聽莽庐隆莽聬聠氓聭聵</a><br/>
				<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">xxx</a><br/>
				<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true" onclick="$('#deletePorterAdminDlg').dialog('open')">氓聢聽茅聶陇莽庐隆莽聬聠氓聭聵</a><br/>
				<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">xxx</a><br/>
				</div>
			
				
			</div>
		</div>
				<!-- xxx -->
				<div id="addPorterDlg" class="easyui-dialog" title="xxx" style="width:400px;height:200px;padding:10px;"
					data-options="
					closed:true,
					iconCls: 'icon-save',
					buttons: [{
						text:'Ok',
						iconCls:'icon-ok',
						handler:function(){
							alert('ok');
						}
					},{
						text:'Cancel',
						handler:function(){
							alert('cancel');;
						}
					}]
				">
					<div style="padding:10px 60px 20px 60px">
								<table cellpadding="5">
									<tr>
										<td>xxx:</td>
										<td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
									</tr>
									<tr>
										<td>xxx：</td>
										<td><input class="easyui-textbox" type="text" name="email" ></input></td>
									</tr>
								</table>
							</form>
					</div>
				</div>
				
				<!-- xxx -->
				<div id="deletePorterDlg" class="easyui-dialog" title="xxx" style="width:400px;height:200px;padding:10px;"
					data-options="
					closed:true,
					iconCls: 'icon-save',
					buttons: [{
						text:'Ok',
						iconCls:'icon-ok',
						handler:function(){
							alert('ok');
						}
					},{
						text:'Cancel',
						handler:function(){
							alert('cancel');;
						}
					}]
				">
					<div style="padding:10px 60px 20px 60px">
								<table cellpadding="5">
									<tr>
										<td>xxxId:</td>
										<td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
									</tr>
								</table>
							</form>
					</div>
				</div>
				
			
				<!-- xxx-->
				<div id="addPorterAdminDlg" class="easyui-dialog" title="xxx" style="width:600px;height:400px;padding:10px;"
					data-options="
					closed:true,
					iconCls: 'icon-save',
					buttons: [{
						text:'Ok',
						iconCls:'icon-ok',
						handler:function(){
							alert('ok');
						}
					},{
						text:'Cancel',
						handler:function(){
							alert('cancel');;
						}
					}]
				">
					<div style="padding:10px 60px 20px 60px">
								<table cellpadding="5">
									<tr>
										<td>xxx:</td>
										<td><input class="easyui-textbox" type="text" name="username" data-options="required:true"></input></td>
									</tr>
									<tr>
										<td>xxx:</td>
										<td><input class="easyui-textbox" type="text" name="tel" ></input></td>
									</tr>
									<tr>
										<td>xxx:</td>
										<td>
										<select id="cc" class="easyui-combobox" name="teleporterId" style="width:200px;" data-options="required:true">
											<option value="AL">Alabama</option>
											<option value="AK">Alaska</option>
											<option value="AZ">Arizona</option>
											<option value="AR">Arkansas</option>
											<option value="CA">California</option>
											<option value="CO">Colorado</option>
											<option value="CT">Connecticut</option>
											<option value="DE">Delaware</option>
											<option value="FL">Florida</option>
											<option value="GA">Georgia</option>
										
										</select>
										</td>
									</tr>
								</table>
							</form>
					</div>
				</div>
				
				
				<!-- xxx -->
				<div id="deletePorterAdminDlg" class="easyui-dialog" title="xxx" style="width:400px;height:200px;padding:10px;"
					data-options="
					closed:true,
					iconCls: 'icon-save',
					buttons: [{
						text:'Ok',
						iconCls:'icon-ok',
						handler:function(){
							alert('ok');
						}
					},{
						text:'Cancel',
						handler:function(){
							alert('cancel');;
						}
					}]
				">
					<div style="padding:10px 60px 20px 60px">
								<table cellpadding="5">
									<tr>
										<td>xxx:</td>
										<td><input class="easyui-textbox" type="text" name="tel" ></input></td>
									</tr>
								</table>
							</form>
					</div>
				</div>
				
				
				
		<!--xxx -->
		<div data-options="region:'center'" title="xxx" sytle="width:65%;">
			<table class="easyui-datagrid" title="盲录聽茅聙聛莽聜鹿盲驴隆忙聛炉" style="width:100%;height:100%"
						data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
					<thead>
						<tr>
							<th data-options="field:'teleporterId',width:80">xxxId</th>
							<th data-options="field:'createDate',width:100">xxx</th>
							<th data-options="field:'address',width:80,align:'right'">xxx</th>
							<th data-options="field:'remark',width:80,align:'right'">xxx</th>
							<th data-options="field:'xxx',width:250">xxx</th>
							<th data-options="field:'xxx',width:60,align:'center'">莽庐隆莽聬聠氓聭聵莽聰碌猫炉聺</th>
						</tr>
					</thead>
			</table>
			
			
			<table class="easyui-datagrid" title="xxx" style="width:100%;height:100%"
						data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
					<thead>
						<tr>
							<th data-options="field:'telporterAdminId',width:80">xxxId</th>
							<th data-options="field:'username',width:100">xxx</th>
							<th data-options="field:'sex',width:80,align:'right'">xxx</th>
							<th data-options="field:'tel',width:80,align:'right'">xxx</th>
							<th data-options="field:'teleporterAddress',width:80,align:'right'">xxx</th>
						</tr>
					</thead>
			</table>
		</div>

		
	</div>
</body>
</html>