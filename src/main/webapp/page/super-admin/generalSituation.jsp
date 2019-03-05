<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<html>
	<meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>传送门-登入</title>
	
	<link href="${pageContext.request.contextPath}/asserts/css/common.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap/bootstrap.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/asserts/css/font-awesome/font-awesome.css" rel="stylesheet" />
	
	<script src="${pageContext.request.contextPath}/asserts/js/jquery/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap/bootstrap.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/echarts/echarts.min.js" type="text/javascript"></script>
 
	<style type="text/css">
	 @font-face {
            font-family: 'Glyphicons Halflings';
            src: url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.eot');
            src: url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.eot?#iefix') format('embedded-opentype'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.woff') format('woff'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.ttf') format('truetype'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.svg#glyphicons_halflingsregular') format('svg');
        }
	
		.panel-body > ul > li {
			width:200px;
			padding:10px 10px;
			float:left;
			display:inline-block;
			text-align:center;
			margin-left:30px;
			margin-top:12px;
			background-color: #e7d6b8;
			border-radius:5px;
		}
		
		.num {
			font-size: 25px;
	   		color: darkorange;
	   		padding-left: 10px;
		}
	</style>
	
	<body>
		<!-- 导航栏 -->
		<ol class="breadcrumb">
		  <li><a href="">首页</a></li>
		  <li class="active">总体概况</li>
		</ol>
		
		<div class="panel panel-info">
			<div class="panel-heading" style="border-radius:0;">
		  	  <h5 class="panel-title">
		  		 <i class="fa fa-cog"></i> 概况</a>
		  	  </h5>
		  	</div>
		  	
		  	<div class="panel-body" style=" background-color: cornsilk;">
		  		
		  		<ul>
		  			<li>
		  			<!-- 用户量 -->
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num">999,99,9</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info">用户人数</span>
		  					</div>
		  				</div>
		  			</li>
		  			<li>
		  			<!-- 骑手量 -->
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num">999,99,9</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info">骑手人数</span>
		  					</div>
		  				</div>
		  			</li>
		  			<!-- 传送点 -->
		  			<li>
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num">999,99,9</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info">传送点总数</span>
		  					</div>
		  				</div>
		  			</li>
		  			<!-- 传送点管理员 -->
		  			<li>
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num">999,99,9</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info">管理员人数</span>
		  					</div>
		  				</div>
		  			</li>
		  			<!-- 消息总数 -->
		  			<li>
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num">999,99,9</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info">消息总数</span>
		  					</div>
		  				</div>
		  			</li>
		  		</ul>
		  		
		  	
		  		<ul>
		  			<li>
		  			<!-- 用户订单量 -->
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num">999,99,9</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info">用户订单总数</span>
		  					</div>
		  				</div>
		  			</li>
		  			<li>
		  			<!-- 骑手订单总量 -->
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num">999,99,9</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info">骑手订单总数</span>
		  					</div>
		  				</div>
		  			</li>
		  			<!-- 交易金额 -->
		  			<li>
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num">999,99,9</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info">总交易金额</span>
		  					</div>
		  				</div>
		  			</li>
		  			<!-- 传送点管理员 -->
		  			<li>
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num">999,99,9</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info">超管人数</span>
		  					</div>
		  				</div>
		  			</li>
		  			<!-- 消息总数 -->
		  			<li>
		  				<div>
		  					<i class="fa fa-cog"></i> <span class="num">999,99,9</span></a>
		  					<div style="margin-top:10px;">
		  						<span class="label label-info">消息总数</span>
		  					</div>
		  				</div>
		  			</li>
		  		</ul>
		
		  		<div style="clear:both;">
		  		<!-- 饼图表 -->
		  		<div id="userAndRiderPicChart" style="width: 400px;height:200px;"></div>
		  		
		  	
		  	
		  	
		  		
		  		</div>
		  		<!-- 每日注册量图表 -->
		  		<div class="panel panel-default" style="margin-top:24px;width:40%;float:left;">
				  <div class="panel-heading">
				    <h3 class="panel-title">最近一周用户注册量
				    
					    <span class="btn btn-default" style="float:right;position:relative;top:-5px;">
					    	<span class="glyphicon glyphicon-refresh"></span>
					  	</span>
				  	
				  	</h3>
				  </div>
				  <div class="panel-body" >
				  		<div id="userRegisterChart" style="width: 100%;height:100%;"></div>
				  </div>
				</div>
				
				
				<!-- 每日骑手注册图表 -->
		  		<div class="panel panel-default" style="margin-top:24px;width:40%;float:left;margin-left:50px;">
				  <div class="panel-heading">
				    <h3 class="panel-title">最近一周骑手注册量
				    
					    <span class="btn btn-default" style="float:right;position:relative;top:-5px;">
					    	<span class="glyphicon glyphicon-refresh"></span>
					  	</span>
				  	
				  	</h3>
				  </div>
				  <div class="panel-body" >
				  		<div id="riderRegisterChart" style="width: 100%;height:100%;"></div>
				  </div>
				</div>
		  	</div>
		</div>

		</div>
	</body>
</html>

<script>
$(function (){
	 // 基于准备好的dom，初始化echarts实例
    var userRegisterChart = echarts.init(document.getElementById('userRegisterChart'));
	var riderRegisterChart = echarts.init(document.getElementById('riderRegisterChart'));
    var userAndRiderPicChart = echarts.init(document.getElementById('userAndRiderPicChart'));
	// 指定图表的配置项和数据
    var option = {
        title: {
            text: '最近一周用户注册量'
        },
        tooltip: {},
        legend: {
            data:['人数']
        },
        xAxis: {
            data: ["2019","201","2019","20","201","2019","201"]
        },
        yAxis: {},
        series: [{
            name: '人数',
            type: 'bar',
            data: [4, 20, 36, 10, 10, 24,4]
        }]
    };
    
    
    // 指定图表的配置项和数据
    var riderOption = {
        title: {
            text: '最近一周骑手注册量'
        },
        tooltip: {},
        legend: {
            data:['人数']
        },
        xAxis: {
            data: ["2019","201","2019","20","201","2019","201"]
        },
        yAxis: {},
        series: [{
            name: '人数',
            type: 'bar',
            data: [4, 20, 36, 10, 10, 24,4]
        }]
    };
    
    //用户与骑手分析图
    var userAndRiderOption = 
	    {
    	    tooltip : { 
    	        trigger: 'item', 
    	        formatter: "{b} : {c} ({d}%)" 
    	    }, 
	    series : [
	        {
	            name: '用户与骑手',
	            type: 'pie',
	            radius: '55%',
	            data:[
	                {value:235, name:'用户注册人数'},
	                {value:274, name:'骑手注册人数'},
	                {value:310, name:'骑手登记人数'},
	            ]
	        }
	    ]
	}
    
 // 使用刚指定的配置项和数据显示图表。
    userRegisterChart.setOption(option);
 	riderRegisterChart.setOption(riderOption);
 	userAndRiderPicChart.setOption(userAndRiderOption);
 	
}); 


</script>
