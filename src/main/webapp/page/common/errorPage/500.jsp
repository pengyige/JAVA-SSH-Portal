<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
  <title>We're sorry, but something went wrong (500)</title>
  <style type="text/css">
    body { background-color: #fff; color: #666; text-align: center; font-family: arial, sans-serif; }
    div.dialog {
      width: 25em;
      padding: 0 4em;
      margin: 4em auto 0 auto;
      border: 1px solid #ccc;
      border-right-color: #999;
      border-bottom-color: #999;
    }
    h1 { font-size: 100%; color: #f00; line-height: 1.5em; }
    
 
 .txtbox{ width:390px; position:relative; top:30px; left:60px;color:#eee; font-size:13px;}
 
.txtbox p {margin:5px 0; line-height:18px;}
 
.txtbox .paddingbox { padding-top:15px;}
.txtbox p a { color:#eee; text-decoration:none;}
.txtbox p a:hover { color:#FC9D1D; text-decoration:underline;}
 
  </style>
</head>
 
<body>
  <!-- This file lives in public/500.html -->
  <div class="dialog">
    <h1>系统错误.</h1>
    <p>传送门出错了，请重试.</p>
    
     <p>》<a style="cursor:pointer" onclick="history.back()">返回上一页面</a></p>
 
      <p>》<a href="${pageContext.request.contextPath}">返回网站首页</a></p>
 
 
  </div>
  

  </div>
</body>
</html>