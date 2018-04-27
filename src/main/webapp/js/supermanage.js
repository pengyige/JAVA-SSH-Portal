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
					case 1:alert('添加成功！');break;
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
				case 1:alert('添加成功！');break;
				case -1:alert('您还没有登入，请先登入!');break;
			}
		}
	});
}


//添加管理员
   function addTeleporterAdminHandle(){
	   
   }
   
//删除管理员 
   function deleteTeleporterAdminHandle(){
	   
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
	})
		
});

