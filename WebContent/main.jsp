<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/content.css" />


  </head>
  
  <body marginwidth="0" marginheight="0">
  <div class="container">
		<div class="public-nav">您当前的位置：管理首页></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3>网站后台</h3>
			</div>
			<div class="public-content-cont">
				<p style="width: 100%;text-align: center; padding: 50px 0; font-size: 16px; color: #FF0000;">管理员${username},欢迎登陆网站后台！</p>
			</div>
		</div>
	</div>


  </body>
</html>