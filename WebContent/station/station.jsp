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
	<script type="text/javascript" src="js/data.js"></script>
	<script type="text/javascript">
		function query(){
			window.location.href="station/queryStation.jsp";
		}
		function addStation(){
			window.location.href="new.do";
		}
		function seekPile(obj){
			var row=obj.parentNode.parentNode;
			var station_id=row.cells[0].innerHTML;
			location="pile.do?station_id="+station_id;
		}
	
	</script>

  </head>
  
  <body  marginwidth="0" marginheight="0">
  <div class="container">
		<div class="public-nav">您当前的位置：车点车桩信息></div>
	</div>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">站点信息</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="70px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="query()"><img src="images/search.gif">查询</td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="70px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="addStation()"><img src="images/new.gif">新增</td>
    <td width="20px" nowrap class="toolbar">|</td>
	<td nowrap class="toolbar">&nbsp;</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
    <td width="20px" nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>
<table  id='info' width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
  <td class="title1">站点ID</td>
    <td class="title1">编号</td>
	<td class="title1">名称</td>
    <td class="title1">经度</td>
    <td class="title1">纬度</td>
    <td class="title1">车桩数量</td>
    <td class="title1">地址</td>
    <td class="title1">负责人</td>
    <td class="title1">新建日期</td>
    <td class="title1">运行日期</td>
    <td class="title1">操作</td>
  </tr>
  <c:forEach items="${page.dataList }" var="pro">
  <tr align="center">
 	 <td><c:out value="${pro.station_id }"></c:out></td>
 	 <td align="center"><c:out value="${pro.station_code }"></c:out></td>
  	 <td align="center"><c:out value="${pro.station_name }"></c:out></td>
  	 <td><c:out value="${pro.longitude }"></c:out></td>
  	 <td><c:out value="${pro.latitude }"></c:out></td>
     <td><c:out value="${pro.bicycle_pile_num }"></c:out></td>
     <td><c:out value="${pro.address }"></c:out></td>
     <td><c:out value="${pro.person_in_charge }"></c:out></td>
      <td><c:out value="${pro.build_time }"></c:out></td>
      <td><c:out value="${pro.run_time }"></c:out></td>
     <td align="center"><input type="button" value="查看车桩"  style="background-color:#88cefa;" onclick="seekPile(this)"></td>
  </tr>
  </c:forEach>
</table>

<div class="page">
	<center>
		<c:choose>
			<c:when test="${page.currentPage==1}">
			当前第${page.currentPage }页/共${page.totalPage }页
			<a href="stations.do?sign=0&page=${page.currentPage+1 }">下一页</a>
			<a href="stations.do?sign=0&page=${page.totalPage }">末页</a>
			</c:when>
			<c:when test="${page.currentPage==page.totalPage }">
    			<a href="stations.do?sign=0&page=1">首页</a>
    			<a href="stations.do?sign=0&page=${page.currentPage-1 }">上一页</a>
    			当前第${page.currentPage }页/共${page.totalPage }页
    		</c:when>
    		<c:otherwise>
    			<a href="stations.do?sign=0&page=1">首页</a>
    			<a href="stations.do?sign=0&page=${page.currentPage-1 }">上一页</a>
    			当前第${page.currentPage }页/共${page.totalPage }页
		    	<a href="stations.do?sign=0&page=${page.currentPage+1 }">下一页</a>
		    	<a href="stations.do?sign=0&page=${page.totalPage }">末页</a>
    		</c:otherwise>
		</c:choose>
	</center>
	</div>
  </body>
</html>