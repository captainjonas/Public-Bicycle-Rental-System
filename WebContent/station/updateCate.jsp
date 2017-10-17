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
	<script type="text/javascript">
function submitCate(){
	var id=document.getElementById("id").value;
	var type=document.getElementById("type").value;
	var tire=document.getElementById("tire").value;
	var ring=document.getElementById("ring").value;
	var backseat=document.getElementById("backseat").value;
	var seat=document.getElementById("seat").value;
	if(type==null){
		alert("类型名称不能为空！");
	}else{
		var form=document.getElementById("form");
		document.getElementById("uid").value=id;
		document.getElementById("utype").value=type;
		document.getElementById("utire").value=tire;
		document.getElementById("uring").value=ring;
		document.getElementById("ubackseat").value=backseat;
		document.getElementById("useat").value=seat;
		form.submit();
	}
}
</script>
  </head>
  
  <body>
<div class="container">
		<div class="public-nav">您当前的位置：修改车辆类型></div>
	</div>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">修改车辆类型</td>
  </tr>
</table>

<table id="update" width="100%"  border="0" align="center" cellspacing="1" class="c">
  <tr>
    <td class="title1"><font size="2">项目</font></td>
    <td class="title1"><font size="2">内容</font></td>
	</tr>
	<%
	 int no=Integer.valueOf(request.getParameter("id"));
	 String type=request.getParameter("type");
	 String tire=request.getParameter("tire");
	 String ring=request.getParameter("ring");
	 String backseat=request.getParameter("backseat");
	 String seat=request.getParameter("seat");
	 %>
  <tr>
    <td align="center">类型编号</td>
    <td align="center"><input type="text" id="id" readonly="readonly" value=<%=no %>></td>
	</tr>
  <tr>
    <td align="center">类型名称</td>
    <td align="center"><input type="text" id="type"  value='<%=type %>' onchange="note()"><span id="s3"></span></td>
	</tr>
  <tr>
    <td align="center">轮胎类型</td>
    <td align="center"><input type="text" id="tire" value='<%=tire %>' onchange="note()"><span id="s4"></span></td>
  </tr>
  <tr>
    <td align="center">铃铛类型</td>
    <td align="center"><input type="text" id="ring" value='<%=ring %>' onchange="note()"><span id="s5"></span></td>
	</tr>
  <tr>
    <td align="center">有无后座</td>
    <td align="center"><input type="text" id="backseat" value='<%=backseat %>' onchange="note()"><span id="s6"></span></td>
  </tr>
   <tr>
    <td align="center">车座类型</td>
    <td align="center"><input type="text" id="seat" value='<%=seat %>' onchange="note()"><span id="s7"></span></td>
	</tr>
  <tr>
    <td height="18" colspan="2" align="center"><input type="button" value="修改" onClick="submitCate()"/></td>
  </tr>
</table>
<form id="form" method="post" action="updcate.do">
<input type="hidden" name="id" id="uid">
<input type="hidden" name="name" id="utype">
<input type="hidden" name="tire" id="utire">
<input type="hidden" name="ring" id="uring">
<input type="hidden" name="backseat" id="ubackseat">
<input type="hidden" name="seat" id="useat">
</form>

  </body>
</html>