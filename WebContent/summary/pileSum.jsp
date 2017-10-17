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
	<script type="text/javascript" src="js/data.js"></script>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<%Calendar c=Calendar.getInstance();
	  int year=c.get(Calendar.YEAR);
	 %>
<script type="text/javascript">
	function addoption(id,start,end){
			var id=document.getElementById(id);
			for(var i=start;i<=end;i++){
				var opt=document.createElement("option");
				opt.innerHTML=i;
				id.add(opt);
			}
		}
		function inition(){
			addoption("year",2010,<%=year%>);        //从2010年到今年
			addoption('month',1,12);
		}

</script>
  </head>
  <body onLoad="inition()">
  <div class="container">
		<div class="public-nav">您当前的位置：站点车辆统计></div>
	</div>
<div style="width:1500px;height:800px;overflow:auto;overflow-x:auto" >
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
	<caption>截止月份</caption>
	 <tr>
    <td class="title1">查询月份</td>
    <td class="title1"><select id="year"></select>年<select id="month"></select>月</td>
	</tr>
	<tr>
	<td height="18" colspan="2" align="center"><input type="button" style="background-color:#88cefa;" value="统计" onClick="sum()"/></td>
	</tr>
	</table>
<input type="hidden" id="hyear" value="${time }">
<table width="100%"  border="0" align="center" cellspacing="1" class="c">
	<caption>租车统计</caption>
	<tr align="center">
	 <td class="title1">项目</td>
	 <td class="title1">数据</td>
	 </tr>
	 <tr align="center">
    <td>车辆总数</td>
    <td><input type="text" value="${bikeNum }" style="text-align:center" /></td>
	</tr>
	<!--  <tr align="center">
    <td>借还次数</td>
    <td><input type="text" value="" style="text-align:center" /></td>
	</tr>
	<tr align="center">
    <td>平均借还时间</td>
    <td><input type="text" value="" style="text-align:center" /></td>
	</tr>
	<tr align="center">
    <td>租车总时间</td>
    <td><input type="text" value="" style="text-align:center" /></td>
	</tr>
	<tr align="center">
    <td>租车收入费用</td>
    <td><input type="text" value="" style="text-align:center" /></td>
	</tr>
	<tr align="center">
    <td>总租车收入费用</td>
    <td><input type="text" value="" style="text-align:center" /></td>
	</tr>-->
</table>
<table width="100%"  border="0" align="center" cellspacing="1" class="c">
<caption>站点车桩明细</caption>
<tr>
    <td class="title1">站点ID</td>
    <td class="title1">编号</td>
	<td class="title1">名称</td>
    <td class="title1">经度</td>
    <td class="title1">纬度</td>
    <td class="title1">车桩数量</td>
    <td class="title1">地址</td>
    <td class="title1">新建日期</td>
    <td class="title1">运行日期</td>
    <td class="title1">车桩ID</td>
    <td class="title1">车桩编号</td>
    <td class="title1">安装日期</td>
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
      <td><c:out value="${pro.build_time }"></c:out></td>
      <td><c:out value="${pro.run_time }"></c:out></td>
      <td><c:out value="${pro.pile_id }"></c:out></td>
      <td><c:out value="${pro.pile_code }"></c:out></td>
      <td><c:out value="${pro.install_time }"></c:out></td>
  </tr>
 </c:forEach>
</table>
<div class="page">
	<center>
		<c:choose>
			<c:when test="${page.currentPage==1}">
			当前第${page.currentPage }页/共${page.totalPage }页
			<a href="sum.do?page=${page.currentPage+1 }">下一页</a>
			<a href="sum.do?page=${page.totalPage }">末页</a>
			</c:when>
			<c:when test="${page.currentPage==page.totalPage }">
    			<a href="sum.do?&page=1">首页</a>
    			<a href="sum.do?&page=${page.currentPage-1 }">上一页</a>
    			当前第${page.currentPage }页/共${page.totalPage }页
    		</c:when>
    		<c:otherwise>
    			<a href="sum.do?&page=1">首页</a>
    			<a href="sum.do?&page=${page.currentPage-1 }">上一页</a>
    			当前第${page.currentPage }页/共${page.totalPage }页
		    	<a href="sum.do?&page=${page.currentPage+1 }">下一页</a>
		    	<a href="sum.do?&page=${page.totalPage }">末页</a>
    		</c:otherwise>
		</c:choose>
	</center>
	</div>
 <div align="center">
 	<input type="button" id="export" value="导出EXCEL" style="background-color:#88cefa;" onClick="exportEXCEL()"/>
    <input type="button" id="dy" value="打印" style="background-color:#88cefa;" onClick="window.print()"/>
</div>
</div>	

  </body>
</html>