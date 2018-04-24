$(function (){
	
	//查询骑手点击事件
	$("#queryRider").click(function (){
		$.ajax({
			url:'rider_loginByTel.action',
			method:'POST',
			dataType:'json',
			data:{},
			success:queryRiderHandle	
		});
	});
	
	
	//骑手登记点击事件
	$("#checkinRider").click(function(){
		
	});
	
	function queryRiderHandle(result){
		alert(result);
	};
});