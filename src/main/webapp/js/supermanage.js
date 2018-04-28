//添加传送点处理
function addTeleporterOkHandle(){
		var address = $("#address").val();
		var remark = $("#remark").val();
		if(address == null || address.trim() == ""){
			alert('地址不能为空!');
			return;
		}
		
		$.ajax({
			url:'teleporter_addTeleporter.action',
			method:'POST',
			data:{"address":address,"remark":remark},
			success:function(result){
				switch(result.state){
					case 0:alert('服务器繁忙!');break;
					case 1:alert('添加成功！');$("#teleporterGrid").datagrid("reload",{ });break;
					case -1:alert('您还没有登入，请先登入!');break;
				}
			}
		});
	}
		

//删除传送点处理
function deleteTeleporterOKHandle(){
	var teleporterId = $("#teleporterId").val();
	if(teleporterId == null){
		alert("传送点Id不能为空!");
		return;
	}
	
	$.ajax({
		url:'teleporter_deleteTeleporter.action',
		method:'POST',
		data:{"teleporterId":teleporterId},
		success:function(result){
			switch(result.state){
				case 0:alert('服务器繁忙!');break;
				case 1:alert('删除成功！');$("#teleporterGrid").datagrid("reload",{ });break;
				case -1:alert('您还没有登入，请先登入!');break;
			}
		}
	});
}


//添加管理员
   function addTeleporterAdminHandle(){
	   var username = $("#username").val();
	   var tel = $("#tel").val();
	   var teleporterId = $('#admin_porter_Id_select').combobox('getValue');
	   if(username == null || username.trim() == ""){
		   alert("姓名不能为空!");
		   return;
	   }
	   if(tel == null || tel.trim() == ""){
		   alert("电话不能为空");
		   return;
	   }
	   if(teleporterId == null || teleporterId.trim() == ""){
		   alert("传送点不能为空!");
		   return;
	   }
	   
	   $.ajax({
		   url:'teleporterAdmin_add.action',
		   method:'POST',
		   data:{"username":username,"tel":tel,"teleporter_admin_Id":teleporterId},
		   success:function(result){
			   switch(result.state){
			   case 0:alert('服务器繁忙!');break;
			   case 1:alert('添加成功!');$("#adminGrid").datagrid("reload",{ });break;
			   case -1:alert('您还没有登入，请先登入');break;
			   }
		   }
	   });
	   
   }
   
//删除管理员 
   function deleteTeleporterAdminHandle(){
	   var teleporterAdminId = $("#teleporterAdminId").val();
	   if(teleporterAdminId == null || teleporterAdminId.trim() == ""){
		   alert('管理员Id不能为空');
		   return;
	   }
	   
	   $.ajax({
		   url:'teleporterAdmin_deleteAdmin.action',
		   method:'POST',
		   data:{'teleporterAdminId':teleporterAdminId},
		   success:function (result){
			   switch(result.state){
			   case 0:alert('删除失败!');break;
			   case 1:alert('删除成功！');$("#adminGrid").datagrid("reload",{ });break;
			   case -1:alert('您还没有登入，请先登入！');break;
			   }
		   }
	   });
   }

$(function (){
	//传送点表格设置
	$("#teleporterGrid").datagrid({
        title:"传送点信息",
        pageNumber:1,
        pageList:[10,20,50],
        nowrap:true,
        striped:true,
        collapsible:true,
        url:'teleporter_queryAll.action',
        method:"POST",
        fitColumns:false,
        remoteSort:false,
        animate:true,
        singleSelect:true,
        loadMsg:"loading...",
        toolbar: [{  
            text: '添加',  
            iconCls: 'icon-add',  
            handler: function() {  
            	$('#addPorterDlg').dialog('open');
            }  
        }, '-', {  
            text: '修改',  
            iconCls: 'icon-edit',  
            handler: function() {  
                  alert('暂未实现');
            }  
        }, '-',{  
            text: '删除',  
            iconCls: 'icon-remove',  
            handler: function(){  
            	$('#deletePorterDlg').dialog('open');
            }  
        }],
        frozenColumns:[[
            {field:'teleporterId',title:'传送点编号',width:88,align:'center'},
            {field:'address',title:'地址',width:200,align:'center'},
            {field:'createDate',title:'创建日期',width:200,align:'center'},
            {field:'remark',title:'备注',width:200,align:'center'},
            {field:'adminUsername', formatter: function (value, row, index) {
            				if(row.teleporterAdmin != null)
            					return row.teleporterAdmin.username;
            				else
            					return "未管理";
            } ,title:'管理员',width:200,align:'center'}
         
        ]],
        pagination:true
    });
	
	
	//管理员表格设置
	$("#adminGrid").datagrid({
        title:"管理员信息",
        pageNumber:1,
        pageList:[10,20,50],
        nowrap:true,
        striped:true,
        collapsible:true,
        url:'teleporterAdmin_queryAll.action',
        method:"POST",
        fitColumns:false,
        remoteSort:false,
        animate:true,
        singleSelect:true,
        loadMsg:"loading...",
        toolbar: [{  
            text: '添加',  
            iconCls: 'icon-add',  
            handler: function() {  
            	$('#admin_porter_Id_select').combobox({
        	        url:'teleporter_getJSONforSelect.action',
        	        valueField:'value',
        	        textField:'address'
        	        	
        	    });
            	$('#addPorterAdminDlg').dialog('open');
            }  
        }, '-', {  
            text: '修改',  
            iconCls: 'icon-edit',  
            handler: function() {  
                  alert('暂未实现');
            }  
        }, '-',{  
            text: '删除',  
            iconCls: 'icon-remove',  
            handler: function(){  
            	$('#deletePorterAdminDlg').dialog('open');
            }  
        }],
        frozenColumns:[[
            {field:'teleporterAdminId',title:'传送点编号',width:300,align:'center'},
            {field:'username',title:'姓名',width:50,align:'center'},
            {field:'sex',title:'性别',width:50,align:'center'},
            {field:'tel',title:'电话',width:100,align:'center'},
            {field:'teleporterName', formatter: function (value, row, index) {
            					return row.teleporter.address;
            } ,title:'传送点',width:300,align:'center'}
         
        ]],
        pagination:true
    });
	
	//点击添加管理员谈对话框
	$("#addTeleporterAdmin").click(function (){
		/*//1.获取所有传送点
		$.ajax({
			url:'teleporter_queryAll.action',
			method:'POST',
			success:function (result){
				if(result.rows.length == 0){
					alert('您还没有添加传送点，请先添加传送点!');
					return;
				}
				
				var options;
				for(var i = 0 ; i < result.rows.length; i++){
					var value = result.rows[i].teleporterId;
					var address = result.rows[i].address;
					var temp = '<option value='+value+' >'+address+'</option>';
					options += temp;
				}
				
				//清空上一次传送点options
				$("#admin_porter_Id_select").empty();
				
				$("#admin_porter_Id_select").append(options);
			}
			
		});*/
		
		//1.远程加载所有传送点到select中
		$('#admin_porter_Id_select').combobox({
	        url:'teleporter_getJSONforSelect.action',
	        valueField:'value',
	        textField:'address'
	        	
	    });
		//url:'teleporter_getJSONforSelect.action',valueField:'value', textField:'address'
		
		$('#addPorterAdminDlg').dialog('open');
	});
	
	
		
});

