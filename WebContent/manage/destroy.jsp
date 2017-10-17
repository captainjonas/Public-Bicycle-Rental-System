<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript">
	function destroy(obj){
		var rowUpdate=obj.parentNode.parentNode;
		var id=rowUpdate.cells[0].innerHTML;
		location="scrap.do?id="+id;
		
	}
	</script>
  </head>
  
  <body marginwidth="0" marginheight="0">
  <div class="container">
		<div class="public-nav">您当前的位置：车辆报废></div>
	</div>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">修理失败的车辆</td>
  </tr>
</table>
<table id='info' width="100%"  border="0" align="center" cellspacing="1">

  <tr>
  <td class="title1">车辆ID</td>
    <td class="title1">车辆编号</td>
    <td class="title1">修理日期</td>
    <td class="title1">车辆状态</td>
    <td class="title1">报废</td>
  </tr>

  <c:forEach items="${list }" var="pro">
  <tr align="center">
 	 <td><c:out value="${pro.bicycle_id }"></c:out></td>
 	 <td align="center"><c:out value="${pro.bicycle_code }"></c:out></td>
 	  <td><c:out value="${pro.repair_date }"></c:out></td>
 	  <td align="center">修理失败</td>
      <td><input type="button" value="报废" onClick="destroy(this)" style="margin-right:0px; background-color:#88cefa;"></td>
	</tr>
	</c:forEach>
	</table>


  </body>
</html>