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
    
    <title>CategoryManagement</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="css/content.css" />
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/data.js"></script>

  </head>
  
  <body marginwidth="0" marginheight="0">
  <c:if test="${delFlag=='0' }">
  	<script type="text/javascript">
		alert("该车辆类型已被使用过，不可删除！");
	</script>
  </c:if>
   <div class="container">
		<div class="public-nav">您当前的位置：车辆类型信息></div>
	</div>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">车辆类型</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
   <td width="30px" nowrap class="toolbar">&nbsp;</td>
    <td width="70px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="add()"><img src="images/new.gif">新增</td>
    <td width="20px" nowrap class="toolbar">|</td>
	<td nowrap class="toolbar">&nbsp;</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
    <td width="20px" nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>
<table  id='info' width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
  <td class="title1">类型编号</td>
    <td class="title1">类型名称</td>
	<td class="title1">轮胎类型</td>
    <td class="title1">铃铛类型</td>
    <td class="title1">有无后座</td>
    <td class="title1">车座类型</td>
    <td class="title1">操作</td>
  </tr>
  <c:forEach items="${cate }" var="pro">
  <tr align="center">
 	 <td><c:out value="${pro.catagory_id }"></c:out></td>
 	 <td align="center"><c:out value="${pro.catagory_name }"></c:out></td>
  	 <td align="center"><c:out value="${pro.tire_type }"></c:out></td>
  	 <td><c:out value="${pro.ring_type }"></c:out></td>
  	 <td><c:out value="${pro.backseat }"></c:out></td>
     <td><c:out value="${pro.bicycle_seat }"></c:out></td>
     <td align="center"><input type="button" value="修改" onclick="updCate(this)">&nbsp;<input type="button" value="删除" onclick="delCate(this)"></td>
  </tr>
  </c:forEach>
	</table>
<form id="update" method="post" action="station/updateCate.jsp">
<input type="hidden" name="id" id="id">
<input type="hidden" name="type" id="type">
<input type="hidden" name="tire" id="tire">
<input type="hidden" name="ring" id="ring">
<input type="hidden" name="backseat" id="backseat">
<input type="hidden" name="seat" id="seat">
</form>


  </body>
</html>