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
	<script type="text/javascript" src="js/data.js" ></script>
	<script type="text/javascript" src="js/jquery.min.js"></script>


  </head>
  
<body>
<table id="selec" width="100%"  border="0" align="center" cellspacing="1">
<caption>站点查询</caption>
<tr align="justify">
    <td>车点名称</td>
    <td><input type="text" size="15"  id="name"/>
    </td>
    <td>地址</td>
    <td><input type="text" size="15" id="address"/></td>
    <td>车点ID</td>
    <td><input type="text"  size="15" id="id"/></td>
  <tr align="justify">
      <td>车点编号</td>
    <td><input type="text"  size="15" id="code"/>   </td> 
   <td>车桩数量</td>
    <td><input type="text" size="15" id="pile_num"/></td>
    <td>负责人</td>
    <td >
 		<input type="text" size="15" id="person"/>
    </td>
  </tr>
  <tr>
    <td class="title2"></td>
  </tr>
</table>
<div align="center">
    <input type="button" id="cx" value="查询"/>
</div>
<br>
<div class="add" id="stock" style="visibility:visible">
<table id="sele" width="100%"  border="0" align="center" cellspacing="1">
<caption>搜索结果</caption>
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
</table>
</div>
<br>
<div class="add" id="pile" style="visibility:visible">
<table id="vacant" width="100%"  border="0" align="center" cellspacing="1">
<caption>空置的车桩</caption>
  <tr>
  <td class="title1">车桩ID</td>
    <td class="title1">编号</td>
	<td class="title1">安装日期</td>
    <td class="title1">车桩供应商</td>
    <td class="title1">操作</td>
  </tr>
</table>
</div>
</body>
</html>