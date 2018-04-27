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
		}
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
			$("#address").val('未登记');
			$("#checkinDate").val('未登记');
		}else{
			$("#address").val(rider.teleporter.address);
			$("#checkinDate").val(rider.checkinDate);
		}
		
		$("#riderId").val(rider.riderId);
	}
	
	
	/**
	 * 处理所有骑手JSON数据
	 */
	function riderResultHanlder(riders){
		var content='<tr><th>姓名</th><th>性别</th><th>电话</th><th>注册日期</th></tr>';
		if(riders.length == 0){
			$('#resultRidersTable').append(content+'<tr><td>还没有骑手登记</td></tr>');
			return;
		}
		
		for(var i = 0 ; i < riders.length; i++){
			var username = riders[i].username;
			var sex;
			if(riders[i].sex ==	1)
				sex = '男';
			else
				sex = '女';
			var tel = riders[i].tel;
			var checkinDate = riders[i].checkinDate;
			content += '<tr><td>'+username+'</td><td>'+sex+'</td><td>'+tel+'</td><td>'+checkinDate+'</td></tr>';
		}
		$('#resultRidersTable').append(content);
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