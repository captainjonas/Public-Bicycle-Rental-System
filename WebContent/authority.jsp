<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="css/content.css" />
  </head>
  
  <body>
<script type="text/javascript">
    setTimeout("this.parent.location.href='login.jsp'", 2000);
    function relogin(){
    	this.parent.location.href='login.jsp';
    }
</script>

<div class="container">
	对不起，您没有权限进行操作<br>
	如果2秒后未返回<br>
	请点此处<a onclick="relogin()">返回</a>
</div>


  </body>
</html>