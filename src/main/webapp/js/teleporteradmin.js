//创建订单点
function createOrderPoint(point,map,orderData){
	var removeMarker = function(e,ee,marker){
		//map.removeOverlay(marker);
		/* var tel=prompt("订单ID:"+marker.z.title+"<br/>请输入骑手手机号:");
		 if(tel == null || tel.trim() == ""){
			 alert('手机号不能为空!');
			 return;
		 }
		
		 alert('派单成功！');*/
		$("#userorderId").html(marker.z.title);
		$("#SendOrderModal").modal('show');
	}

	//创建右键菜单
	var markerMenu=new BMap.ContextMenu();
	markerMenu.addItem(new BMap.MenuItem('派单',removeMarker.bind(marker)));
	
	//通过点创建覆盖物
	var marker = new BMap.Marker(point);
	map.addOverlay(marker);
	marker.addContextMenu(markerMenu);
	marker.z.title = orderData.userOrderId;
	
	//创建点击查看订单详情
	var opts = {
	  width : 250,     // 信息窗口宽度
	  height: 100,     // 信息窗口高度
	  title : "<h3 style=\"width:100px;margin:0 auto;\">用户订单</h3>" , // 信息窗口标题
	  enableMessage:true,//设置允许信息窗发送短息
	  message:"订单详细信息"
	}
	var infoWindow = new BMap.InfoWindow("订单编号:"+orderData.userOrderId+"<br/>取件地址:"+orderData.shipAddress+"<br/>送件地址:"+orderData.receiveAddress, opts);  // 创建信息窗口对象 
	marker.addEventListener("click", function(){          
		map.openInfoWindow(infoWindow,point); //开启信息窗口
	}); 
};

$(function (){
	//1.第二次访问使用cookie自动登入
	autoLogin();
	

	//通过手机号查询骑手信息
	$("#queryBtn").click(queryRider);
	
	
	//登记点击事件
	$("#checkinBtn").click(function (){
		var riderId = $("#riderId").val();
		var teleporterId = $("#teleporterId").val();
		if(teleporterId == null){
			alert('您还没有登入或还没有在传送点登记!');
			return;
		}
		
		if(riderId == null){
			alert('请先查询骑手!');
			return;
		}
		
		
		$.ajax({
			url:'rider_checkin.action',
			method:'POST',
			data:{"riderId":riderId,"teleporterId":teleporterId},
			success:function(result){
				switch(result.state){
				case 0:alert('服务器繁忙!');break;
				case 1:alert('登记成功!');queryRider();break;
				case -1:alert('您还没有登入，请先登入！');break;
				case -2:alert('该骑手已在传送点登记，请先到其传送点解除登记！');break;
				}
			}
		});
	});
	
	
	//注销登记事件
	$("#logoutCheckinBtn").click(function (){
		var riderId = $("#riderId").val();
		var teleporterId = $("#teleporterId").val();
		if(teleporterId == null){
			alert('您还没有登入或还没有在传送点登记!');
			return;
		}
		
		if(riderId == null){
			alert('请先查询骑手!');
			return;
		}
		
		$.ajax({
			url:'rider_logoutCheckin.action',
			method:'POST',
			data:{"riderId":riderId},
			success:function (result){
				switch(result.state){
				case 0:alert('服务器繁忙!');break;
				case 1:alert('注销骑手登记成功!');queryRider();break;
				case -1:alert('您还没有登入，请先登入!');break;
				case -2:alert('该骑手还未登记!');break;
				case -3:alert('权限不足!');break;
				}
			}
		});
	});
	

	//查询当前传送点所有骑手信息
	$('a[data-toggle="tab"]').on('show.bs.tab', function (e) {
		 /* e.target // 激活的标签页
		  e.relatedTarget // 前一个激活的标签页
		  */
		var activeTab = $(e.target).text();
		if(activeTab == "查询骑手"){
			var teleporterId = $("#teleporterId").val();
			if(teleporterId == null){
				alert('您还没有登入或还没有在传送点登记!');
				return;
			}
			
			//1.清除原先内容
			$("#resultRidersTable").empty();
			
			//2.获取所有骑手信息
			$.ajax({
				url:'rider_findAllByTeleporter.action',
				method:'POST',
				data:{"teleporterId":teleporterId},
				success:function (result){
					switch(result.state){
					case 0:alert('服务器繁忙！');break;
					case 1:riderResultHanlder(result.result);break;
					case -1:alert('您还没有登入，请先登入!');break;
					}
				}
			});
		};
		
	});

	//添加派单点击事件
	$("#sendOrderBtn").click(function (){
		var userOrderId = $("#userorderId").html();
		var sendOrderTel = $("#sendOrderTelInput").val();
		$.ajax({
			url:'rider_pushOrder.action',
			method:'POST',
			data:{"userOrderId":userOrderId,"tel":sendOrderTel},
			success:function (){
				alert('推送成功!');
			}
		});
	});
	
	
	
	/*******************函数定义***********/
	

	/*
	 * 通过cookie自动登入
	 */
	function autoLogin(){
		var usernameLabel = $("#usernameLabel")[0];
		//如用户未登入，则采用cookie登入
		if(usernameLabel == undefined){	
			$.ajax({
				url:'teleporterAdmin_loginByCookie.action',
				method:'POST',
				success:function (response){
					if(response.state == 1){
						window.location.reload();
					}else{
						alert('您还没有登入，请先登入!');
					}
				}
			});
		}
	}
	
	/**
	 * 处理骑手JSON数据
	 */
	function queryRiderByTelHandler(rider){
		$("#username").val(rider.username);
		var sex ;
		if(rider.sex == 1){
			sex = '男';
		}else{
			sex = '女';
		}
	
		$("#sex").val(sex);
		if(rider.teleporter == null){
			//$("#address").val('未登记');
			$("#checkinDate").val('未登记');
		}else{
			//$("#address").val(rider.teleporter.address);
			$("#checkinDate").val(rider.checkinDate);
		}
		
		$("#realName").val(rider.realName);
		$("#IDNumber").val(rider.IDNumber);
		$("#address").val(rider.address);
		
		$("#riderId").val(rider.riderId);
	}
	
	
	/**
	 * 处理所有骑手JSON数据
	 */
	function riderResultHanlder(riders){
		var content='<tr><th>所属传送点</th><th>手机号</th><th>住址</th><th>身份证号码</th><th>注册日期</th><th>详细信息</th></tr>';
		if(riders.length == 0){
			$('#resultRidersTable').append(content+'<tr><td>还没有骑手登记</td></tr>');
			return;
		}
		
		for(var i = 0 ; i < riders.length; i++){
			/*var username = riders[i].username;
			var sex;
			if(riders[i].sex ==	1)
				sex = '男';
			else
				sex = '女';
			var tel = riders[i].tel;*/
			var teleporterName = riders[i].teleporter.address;
			var tel = riders[i].tel;
			var address = riders[i].address;
			var IDNumber = riders[i].IDNumber;
			var checkinDate = riders[i].checkinDate;
			var detail = "<button class=\"btn btn-primary\" value=\""+riders[i].riderId+"\" >详细</button>"
			content += '<tr><td>'+teleporterName+'</td><td>'+tel+'</td><td>'+address+'</td><td>'+IDNumber+'</td><td>'+checkinDate+'</td><td>'+detail+'</td></tr>';
		}
		$('#resultRidersTable').append(content);
		
		$("table button").click(function (){
			$('#myModal').modal('show');
		});
	}
	
	
	/**
	 * 通过手机号查询骑手
	 */
	function queryRider(){
			var tel = $("#telInput").val();
			if(tel == null || tel.trim() == ""){
				alert("手机号不能为空");
				return 0;
			}
			
			$.ajax({
				url:"rider_queryByTel.action",
				method:"POST",
				data:{"tel":tel},
				success:function(result){
					switch(result.state){
					case 0:alert('服务器繁忙！');break;
					case 1:queryRiderByTelHandler(result.result);break;
					case -1:alert('您还没有登入,请先登入!');break;
					case -2:alert('输入的手机号不存在！');break;
					}
				}
			});
	}
	
});

