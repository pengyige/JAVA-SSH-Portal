<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员登录</title>
		<style type="text/css">
			.mydiv1{
				height:160px;
				background-color:white;
				
			}
			.mydiv2{
				padding-left: 900px;
				
			}
		</style>
		<style type="text/css">
        .logMethod {
            float: right;
            margin-right: 38px;
            color: #ff6a00;
            font-size: 12px;
        }

        a.logMethod {
            text-decoration: none;
        }

            a.logMethod:hover {
                text-decoration: underline;
            }

        .login-box .login-panel .login-notice {
            min-height: 1px;
        }

        .SMScodes {
            float: left;
        }

        .email_autocomplete1, .phoneNum, .SMScodes {
            position: relative;
            display: inline-block;
        }

            .email_autocomplete1 input, .phoneNum input, .SMScodes input {
                width: 267px;
                height: 40px;
                padding: 10px;
                border: 1px solid #d2d2d2;
            }

            .SMScodes input {
                width: 145px;
            }

        .btnSend, #prompt_info {
            height: 40px;
            margin-left: 7px;
            width: 115px;
            border: 0;
            background: #FFAD0D;
            border-radius: 5px;
            color: #fff;
            margin-left: 3px\9;
        }

        .btnSend {
            vertical-align: middle;
        }

            .btnSend:hover {
                background: #faa500;
            }

        #prompt_info {
            line-height: 40px;
            text-align: center;
            display: inline-block;
            float: right;
            background: #bbb;
        }

        .email_autocomplete1 ul {
            margin: 0;
            padding: 0;
            position: absolute;
            left: 0px;
            border: #ddd0d0 1px solid;
            background-color: #fefefe;
            overflow: hidden;
            z-index: 999;
        }

            .email_autocomplete1 ul .curr {
                background-color: #e7f4fd;
            }

            .email_autocomplete1 ul .note {
                color: #777777;
                cursor: auto;
            }

            .email_autocomplete1 ul li {
                margin: 0;
                padding: 0;
                height: 20px;
                line-height: 20px;
                list-style: none;
                padding-left: 5px;
                cursor: pointer;
            }
            .login-box .login-panel .btn{margin-top: 31px;}
            .other-login-ways{margin: 20px 38px 0;}
            .other-login-ways ul{list-style: none;font-size: 12px;overflow: hidden;padding: 0;}
            .other-login-ways li{float: left;}
            .other-login-ways .line{padding: 0 10px;}
            .csqh{
                margin-top: -9px;
                font-size: 26px;
                color: #444;
            }
            .login_q span{
                display: inline-block;
                border: 1px solid #fe6600;
                border-radius: 2px;
                font-size: 12px;
                color: #fe6600;
                display: none;
                position: relative;
                padding: 0 2px;
            }
            .login_q span:before{
                content: '';
                display: inline-block;
                border-left: 5px solid transparent;
                border-right: 5px solid transparent;
                border-bottom: 9px solid #fe6600;
                position: absolute;
                top: -9px;
                left: 5px;
            }
            .login_q span:after{
                content: '';
                display: inline-block;
                border-left: 5px solid transparent;
                border-right: 5px solid transparent;
                border-bottom: 9px solid #fff;
                position: absolute;
                top: -8px;
                left: 5px;
            }
            .login_q .qq_kuaijie:before{
                left: 52px;
            }
            .login_q .qq_kuaijie:after{
                left: 52px;
            }
            .login_q .zfb_kuaijie:before{
                left: 101px;
            }
            .login_q .zfb_kuaijie:after{
                left: 101px;
            }
    </style>
	    <link rel="icon" href="/favicon.ico" mce_href="/favicon.ico" type="image/x-icon">
	    
	    <link type="text/css" rel="stylesheet" href="//img02.hua.com/pc/assets/css/common.css">
	    <link type="text/css" rel="stylesheet" href="//img02.hua.com/pc/assets/css/public.css">
	    <link type="text/css" rel="stylesheet" href="//img02.hua.com/pc/assets/css/mbar.css" />
	    <style>
        body {
            min-width: 1200px;
        }

        .categorys .dropdown-cate {
            height: 440px;
        }

        .beian {
            width: 16px;
            height: 16px;
            background: url(//img02.hua.com/pc/pimg/beian.png) no-repeat;
            background-size: 16px;
            margin: -3px 2px 0;
        }
    </style>
    
    <script type="text/javascript">
    	function clearCoookie(){
    	/* 	//1.清除cookie；
    		delCookie('cookie_tel');
    		delCookie('cookie_password'); */
    		return true;
    	}
    	
    	function delCookie($name){    
            var myDate=new Date();    
            myDate.setTime(-1000);//设置时间    
            document.cookie=$name+"=''; expires="+myDate.toGMTString();                
      }    
    </script>
	</head>
	<body style="background-color:#FAA500;">
		<div class="mydiv1">
			<p style="padding-left: 180px; font-size: 40px; font-family: '楷体'; color: orange; padding-top: 20px;">传送门</p>
			<p style="color: orange; text-align: center; font: '微软雅黑'; font-size: 28px;">亲爱的管理员您好，请登录</p>
		</div>
		<div class="mydiv2">
			 <div class="container">
        <div class="login-box">
            <!-- 登录/注册tab -->
            <ul class="login-tabs">
                <li class="active"><a href="javascript:void(0)">登录</a></li>
            </ul>
            <!-- 登录/注册tab End -->
            
            <form name="myForm" id="myForm" action="teleporterAdmin_login.action"  method="post" onsubmit="return clearCoookie();" style="display:block;"> 
                <div class="tab-content">
                    <!-- 普通登录 -->
                    <div id="loginPane" class="tab-pane login-panel fade in active">
                        <!--登录信息提示区begin-->
                        <div class="login-notice" id="Enr">
                        </div>
                        <!--登录信息提示区 end-->
                        <div class="form-group">
                            <label class="sr-only" for="InputUser">用户名</label>
                            <div class="input-group">
                                <div class="input-group-addon"><span class="ico ico-user"></span></div>
                                <div class="email_autocomplete1">
                                    <input name="tel" autocomplete="off" placeholder="手机号" nodetype="email" type="text" id="UserName" config="{width:267,height:40}" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="InputPassword">密码</label>
                            <div class="input-group">
                                <div class="input-group-addon"><span class="ico ico-lock"></span></div>
                                <div class="email_autocomplete1"><input name="password" autocomplete="off" placeholder="用户密码" type="password" id="PassWord" /></div>
                            </div>
                        </div>
							<div>
								      <c:if test="${!empty error }">
					               			${error}
					                 </c:if>
							</div>
                            <input id="ValidCode" name="ValidCode" value="" type="hidden" />

                        <div class="checkbox">
                            <input type="hidden" name="DoIt" value="ok" />
                            <input type="hidden" id="backUrl" name="backUrl" value="/" />
                            <label style="display:none;">
                                <input type="checkbox" name="autologin" id="autologin" onClick="ShowAutoLogin()" value="1"> 一个月内自动登录
                            </label>
                            <a class="pull-right" href="/Member/Password/Forgot" target="_blank">忘记密码？</a>
                        </div>

                        <input class="btn btn-primary btn-lg btn-block" type="submit"  id="dosubmit" value="登　录"/>
                        <button class="btn btn-primary btn-lg btn-block" type="button" disabled="disabled" style="display:none;" id="submiting">登录中...</button>
                    </div>
                    <!-- 普通登录 End -->
                </div>
            </form>
        </div>
    </div>
		</div>
		
	</body>
</html>
