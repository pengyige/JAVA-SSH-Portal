<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>传送门-登入</title>
	
	<link href="${pageContext.request.contextPath}/asserts/css/bootstrap/bootstrap.css" rel="stylesheet" />
		
	<style>
        @font-face {
            font-family: 'Glyphicons Halflings';
            src: url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.eot');
            src: url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.eot?#iefix') format('embedded-opentype'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.woff') format('woff'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.ttf') format('truetype'), url('${pageContext.request.contextPath}/asserts/font/bootstrap/glyphicons-halflings-regular.svg#glyphicons_halflingsregular') format('svg');
        }
	
		#logo{
			width:80px;
			height:50px;
		}
	</style>
</head>
<body>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">
	        <img id="logo" alt="Brand" src="${pageContext.request.contextPath}/asserts/img/logo.jpg">
	      </a>
	      <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
	    </div>
	  </div>
	</nav>
</body>