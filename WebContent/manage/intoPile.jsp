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
	<link rel="stylesheet" type="text/css" href="css/dialog.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/dialog.js"></script>
	<script type="text/javascript" src="js/data.js"></script>
	<script type="text/javascript">
	function openDialog(obj){
		new dialog(1000,600,'manage/choosePile.jsp',"选择车桩").open();
		var bicycle_id=obj.parentNode.parentNode.cells[0].innerHTML;
		document.getElementById("bikeid").value=bicycle_id;
	}

	
	</script>
	
  </head>
  
<body marginwidth="0" marginheight="0">
    <c:if test="${topile=='1' }">
  	<script type="text/javascript">
		alert("成功入桩！");
	</script>
  </c:if>
<div class="container">
	<div class="public-nav">您当前的位置：新车入桩></div>
	</div>
<table  id='info' width="100%"  border="0" cellpadding="0" cellspacing="0">
<caption>未入桩的车辆</caption>
  <tr>
  <td class="title1">车辆ID</td>
    <td class="title1">车辆编号</td>
    <td class="title1">车辆状态</td>
    <td class="title1">入桩</td>
  </tr>
  <c:forEach items="${al }" var="pro">
  <tr align="center">
 	 <td><c:out value="${pro.bicycle_id }"></c:out></td>
 	 <td align="center"><c:out value="${pro.bicycle_code }"></c:out></td>
  	 <td>购入未入桩</td>
     <td align="center"><input type="button" style="background-color:#88cefa;" value="选择站点" onclick="openDialog(this)"/></td>
  </tr>
  </c:forEach>
</table>
<input type="hidden" id="bikeid" name="bicycleID">
  </body>
</html>