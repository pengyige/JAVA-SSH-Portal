<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>传送门-登入</title>
	
	
    <link href="${pageContext.request.contextPath}/asserts/css/bootstrap/bootstrap.css" rel="stylesheet" />
 
	<link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/font-awesome/font-awesome.css">
	
	<script src="${pageContext.request.contextPath}/asserts/js/jquery/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/asserts/js/bootstrap/bootstrap.js" type="text/javascript"></script>


<style>
#header {
	padding:10px 0;
	background-color:#4f4848;;
	
}

#logo {
	width:80px;
	height:50px;
	margin-left:5px;
}

#title {
	text-align: center;
    padding-top: 15px;
    font-size: 18px;
    color: antiquewhite;
}

.basic-grey {
	float:left;
	width:20%;
	height:40%;
	margin-top:50px;
	margin-right:auto;
	max-width: 500px;
	background: #F7F7F7;

	padding: 25px 15px 25px 10px;
	font: 12px Georgia, "Times New Roman", Times, serif;
	color: #888;
	text-shadow: 1px 1px 1px #FFF;
	border:1px solid #E4E4E4;
	border-radius: 10px;
	background-repeat:no-repeat; 
	background-size:100% 100%;
	-moz-background-size:100% 100%;}
}

/*
 *
 * login-register modal
 * Autor: Creative Tim
 * Web-autor: creative.tim
 * Web script: #
 * 
 */
 
/*  Shake animation  */

@charset "UTF-8";

.animated {
  -webkit-animation-duration: 1s;
	   -moz-animation-duration: 1s;
	     -o-animation-duration: 1s;
	        animation-duration: 1s;
	-webkit-animation-fill-mode: both;
	   -moz-animation-fill-mode: both;
	     -o-animation-fill-mode: both;
	        animation-fill-mode: both;
}

.animated.hinges {
	-webkit-animation-duration: 2s;
	   -moz-animation-duration: 2s;
	     -o-animation-duration: 2s;
	        animation-duration: 2s;
}

.animated.slow {
	-webkit-animation-duration: 3s;
	   -moz-animation-duration: 3s;
	     -o-animation-duration: 3s;
	        animation-duration: 3s;
}

.animated.snail {
	-webkit-animation-duration: 4s;
	   -moz-animation-duration: 4s;
	     -o-animation-duration: 4s;
	        animation-duration: 4s;
}

@-webkit-keyframes shake {
	0%, 100% {-webkit-transform: translateX(0);}
	10%, 30%, 50%, 70%, 90% {-webkit-transform: translateX(-10px);}
	20%, 40%, 60%, 80% {-webkit-transform: translateX(10px);}
}

@-moz-keyframes shake {
	0%, 100% {-moz-transform: translateX(0);}
	10%, 30%, 50%, 70%, 90% {-moz-transform: translateX(-10px);}
	20%, 40%, 60%, 80% {-moz-transform: translateX(10px);}
}

@-o-keyframes shake {
	0%, 100% {-o-transform: translateX(0);}
	10%, 30%, 50%, 70%, 90% {-o-transform: translateX(-10px);}
	20%, 40%, 60%, 80% {-o-transform: translateX(10px);}
}

@keyframes shake {
	0%, 100% {transform: translateX(0);}
	10%, 30%, 50%, 70%, 90% {transform: translateX(-10px);}
	20%, 40%, 60%, 80% {transform: translateX(10px);}
}

.shake {
	-webkit-animation-name: shake;
	-moz-animation-name: shake;
	-o-animation-name: shake;
	animation-name: shake;
}

.login .modal-dialog{
    width: 350px;
}
.login .modal-footer{
    border-top: 0;
    margin-top: 0px;
    padding: 10px 20px 20px;
}
.login .modal-header {
    border: 0 none;
    padding: 15px 15px 15px;
/*     padding: 11px 15px; */
}
.login .modal-body{
/*     background-color: #eeeeee; */
}
.login .division {
    float: none;
    margin: 0 auto 18px;
    overflow: hidden;
    position: relative;
    text-align: center;
    width: 100%;
}
.login .division .line {
    border-top: 1px solid #DFDFDF;
    position: absolute;
    top: 10px;
    width: 34%;
}
.login .division .line.l {
    left: 0;
}
.login .division .line.r {
    right: 0;
}
.login .division span {
    color: #424242;
    font-size: 17px;
}
.login .box .social {
    float: none;
    margin: 0 auto 30px;
    text-align: center;
}

.login .social .circle{
    background-color: #EEEEEE;
    color: #FFFFFF;
    border-radius: 100px;
    display: inline-block;
    margin: 0 17px;
    padding: 15px;
}
.login .social .circle .fa{
    font-size: 16px;
}
.login .social .facebook{
    background-color: #455CA8;
    color: #FFFFFF;
}
.login .social .google{
    background-color: #F74933;
}
.login .social .github{
    background-color: #403A3A;
}
.login .facebook:hover{
    background-color: #6E83CD;
}
.login .google:hover{
    background-color: #FF7566;
}
.login .github:hover{
    background-color: #4D4D4d;;
}
.login .forgot {
    color: #797979;
    margin-left: 0;
    overflow: hidden;
    text-align: center;
    width: 100%;
}
.login .btn-login, .registerBox .btn-register{
    background-color: #00BBFF;
    border-color: #00BBFF;
    border-width: 0;
    color: #FFFFFF;
    display: block;
    margin: 0 auto;
    padding: 15px 50px;
    text-transform: uppercase;
    width: 100%;
}
.login .btn-login:hover, .registerBox .btn-register:hover{
    background-color: #00A4E4;
    color: #FFFFFF;
}
.login .form-control{
    border-radius: 3px;
    background-color: rgba(0, 0, 0, 0.09);
    box-shadow: 0 1px 0px 0px rgba(0, 0, 0, 0.09) inset;
    color: #FFFFFF;
}
.login .form-control:hover{
    background-color: rgba(0,0,0,.16);
}
.login .form-control:focus{
    box-shadow: 0 1px 0 0 rgba(0, 0, 0, 0.04) inset;
    background-color: rgba(0,0,0,0.23);
    color: #FFFFFF;
}
.login .box .form input[type="text"], .login .box .form input[type="password"] {
    border-radius: 3px;
    border: none;
    color: #333333;
    font-size: 16px;
    height: 46px;
    margin-bottom: 5px;
    padding: 13px 12px;
    width: 100%;
}


@media (max-width:400px){
    .login .modal-dialog{
        width: 100%;
    }
}

.big-login, .big-register{
    background-color: #143540;
    color: #827d7d;
    border-radius: 7px;
    border-width: 2px;
    font-size: 13px;
    font-style: normal;
    font-weight: 200;
    padding: 10px 30px;
    text-transform: uppercase;
    transition: all 0.3s ease 0s;
}
.big-login:hover{
    background-color: #00A4E4;
    color: #FFFFFF;
}
.big-register{
    background-color: rgba(0,0,0,.0);
    color: #00bbff;
    border-color: #00bbff;
}
.big-register:hover{
    border-color: #00A4E4;
    color:  #00A4E4;
}
</style>
</head>
<body style="background:rgb(85, 74, 74);">
	<div class="container" id="header">
        <div class="row" >
            <div class="col-sm-2">
            	<img src="${pageContext.request.contextPath}/asserts/img/logo.jpg" id="logo"/>
            </div>
            
            <div class="col-sm-8" id="title">
            	<span>传送门后台管理系统</span>
            </div>
            <div class="col-sm-2" style="float:right;">
                 <a class="btn big-login" id="btnLogin" data-toggle="modal" href="javascript:void(0)" onclick="openLoginModal();">登入</a>
        </div>
       
       </div>
      
       
         
         <!-- 登入模块框 -->
		 <div class="modal fade login" id="loginModal">
		      <div class="modal-dialog login animated">
    		      <div class="modal-content">
    		         <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">传送门</h4>
                    </div>
                    <div class="modal-body">  
                        <div class="box">
                             <div class="content">
                                
                                <div class="division">
                                    <div class="line l"></div>
                                      <span>登入</span>
                                    <div class="line r"></div>
                                </div>
                                
                                <div class="error"></div>
                                <div class="form loginBox">
                                    <form method="post" action="/login" accept-charset="UTF-8">
                                    <input id="username" class="form-control" type="text" placeholder="请输入用户名" name="email">
                                    <input id="password" class="form-control" type="password" placeholder="请输入密码" name="password">
                                    <input id="loginClick" class="btn btn-default btn-login" type="button" value="登入" onclick="loginAjax()">
                                    </form>
                                </div>
                             </div>
                        </div>
                        <div class="box">
                            <div class="content registerBox" style="display:none;">
                             <div class="form">
                                <form method="post" html="{:multipart=>true}" data-remote="true" action="/register" accept-charset="UTF-8">
                                <input id="email" class="form-control" type="text" placeholder="Email" name="email">
                                <input id="password" class="form-control" type="password" placeholder="请输入密码" name="password">
                                <input id="password_confirmation" class="form-control" type="password" placeholder="Repeat Password" name="password_confirmation">
                                <input class="btn btn-default btn-register" type="submit" value="Create account" name="commit">
                                </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <!-- <div class="forgot login-footer">
                            <span>Looking to 
                                 <a href="javascript: showRegisterForm();">create an account</a>
                            ?</span>
                        </div>
                        <div class="forgot register-footer" style="display:none">
                             <span>Already have an account?</span>
                             <a href="javascript: showLoginForm();">Login</a>
                        </div> -->
                    </div>        
    		      </div>
		  	</div>
		  </div>
    </div>
    
    <!-- 介绍区 -->
    <div style="margin-left:12%">
       
	 
	    <div id="leftContent" class="basic-grey" style="	background-image:url(${pageContext.request.contextPath}/asserts/img/jieshao1.jpg); ">
	    	
	    </div>
    
    	<div id="secondContent" class="basic-grey"  style="margin-left:160px;	background-image:url(${pageContext.request.contextPath}/asserts/img/jieshao2.jpg">
	    	
	    </div>
	    
	    <div id="rightContent" class="basic-grey"  style="float:right;margin-right:180px;	background-image:url(${pageContext.request.contextPath}/asserts/img/jieshao3.jpg">
	    	
	    </div>
    </div>
</body>


<script>
/**系统管理员登入*/
var SUPER_ADMIN_LOGIN_URL = "${pageContext.request.contextPath}/superAdmin_login.action";
/**管理页*/
var SUPER_ADMIN_INDEX_URL = "${pageContext.request.contextPath}/superAdmin_index.action"

function showRegisterForm(){
   $('.loginBox').fadeOut('fast',function(){
       $('.registerBox').fadeIn('fast');
       $('.login-footer').fadeOut('fast',function(){
           $('.register-footer').fadeIn('fast');
       });
       $('.modal-title').html('Register with');
   }); 
   $('.error').removeClass('alert alert-danger').html('');
      
}

/**
 * 显示登入框
 */
function showLoginForm(){
   $('#loginModal .registerBox').fadeOut('fast',function(){
       $('.loginBox').fadeIn('fast');
       $('.register-footer').fadeOut('fast',function(){
           $('.login-footer').fadeIn('fast');    
       });
       
       $('.modal-title').html('传送门');
   });
   //清空错误信息
   $('.error').removeClass('alert alert-danger').html(''); 
}

/**
 * 打开登入框
 */
function openLoginModal(){
   showLoginForm();
   setTimeout(function(){
       $('#loginModal').modal('show');    
   }, 230);  
}

/**
 * 打开注册框
 */
function openRegisterModal(){
   showRegisterForm();
   setTimeout(function(){
       $('#loginModal').modal('show');    
   }, 230);
   
}


/**
 * 发送登入请求
 */
function loginAjax(){
   	//获取用户名、密码
   	var username = $('#username').val();
   	var password = $('#password').val();
   	console.log(username+"|"+password);
   	if (null == username || "" == username.trim()) {
   		shakeModal("用户名不能为空");
   		return;
   	}
   	
   	if (null == password || "" == password.trim()) {
   		shakeModal("密码不能为空");
   		return;
   	}
   	
   	
   	var requestParam = {
   		"username":username,
   		"password":password
   	};
   	
   	$.ajax({
   		"url":SUPER_ADMIN_LOGIN_URL,
   		"type":"post",
   		"dataType":"json",
   		"data":requestParam,
   		beforeSend:function (){
   			$('#loginClick').attr("disabled", true); 
   		},
   		success:function (result){
   			if ("200" != result.code){
   				shakeModal(result.message);
   			}else {
   				//登入成功
   				//调整到首页
   			 window.location.href = SUPER_ADMIN_INDEX_URL;
   			}
   			console.log(result);
   			$('#loginClick').attr("disabled", false); 
   		},
   		error:function (){
   			$('#loginClick').attr("disabled", false); 
   		}
   	});
    
}

/**
 * 显示错误消息
 */
function shakeModal(errorMsg){
   $('#loginModal .modal-dialog').addClass('shake');
            $('.error').addClass('alert alert-danger').html(errorMsg);
            $('input[type="password"]').val('');
            setTimeout( function(){ 
               $('#loginModal .modal-dialog').removeClass('shake'); 
   }, 1000 ); 
}

  
</script>