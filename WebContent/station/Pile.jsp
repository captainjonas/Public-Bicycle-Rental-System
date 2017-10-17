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
	<script type="text/javascript">
	function backto(){
		window.location.href="stations.do?sign=0";
	}
	</script>

  </head>
  
  <body marginwidth="0" marginheight="0">
  <div class="container">
		<div class="public-nav">您当前的位置：车桩信息></div>
	</div>
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">车桩信息</td>
  </tr>
</table>
<table  id='info' width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
  <td class="title1">车桩ID</td>
    <td class="title1">车桩编号</td>
	<td class="title1">所属车点</td>
    <td class="title1">状态</td>
    <td class="title1">安装日期</td>
    <td class="title1">车辆ID</td>
     <td class="title1">车桩供应商</td>
    <td class="title1">备注</td>
  </tr>
  <c:forEach items="${pile }" var="pro">
  <tr align="center">
 	 <td><c:out value="${pro.pile_id }"></c:out></td>
 	 <td align="center"><c:out value="${pro.pile_code }"></c:out></td>
  	 <td align="center"><c:out value="${pro.station_id }"></c:out></td>
  	 <td>
  	 <c:if test="${pro.status=='1' }">有车</c:if>
  	 <c:if test="${pro.status=='2' }">无车</c:if>
  	 <c:if test="${pro.status=='9' }">报废</c:if>
  	 </td>
  	 <td><c:out value="${pro.install_time }"></c:out></td>
     <td>
     <c:if test="${pro.bicycle_id==0 }">NG</c:if>
      <c:if test="${pro.bicycle_id!=0 }">${pro.bicycle_id}</c:if>
     </td>
     <td><c:out value="${pro.vender_name }"></c:out></td>
     <td><c:out value="${pro.remark }"></c:out></td>
 	</tr>
  	</c:forEach>
	</table>
	<div align="center">
    <input type="button" id="fh" value="返回"   onClick="backto()"/>
    <input type="button" id="dy" value="打印" onClick="window.print()"/>
</div>
  </body>
</html>