<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML  HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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


  </head>
  
  <body>
  <div class="container">
		<div class="public-nav">您当前的位置：增加车辆类型></div>
	</div>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">增加车辆类型</td>
  </tr>
</table>
<div id="add" >
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
  <tr>
    <td class="title1"><font size="2">项目</font></td>
    <td class="title1"><font size="2">内容</font></td>
	</tr>
	<tr>
    <td align="center">类型名称</td>
    <td align="center"><input type="text" id="tName" onchange="note1()"><span id="s1"></span></td>
	</tr>
  <tr>
    <td align="center">车架类型</td>
    <td align="center"><select id="tFrame"><option value="钛合金">钛合金</option><option value="镁合金">镁合金</option><option value="钪合金">钪合金</option></select></td>
	</tr>
  <tr>
    <td align="center">车胎类型</td>
    <td align="center"><select id="tTire"><option value="空心胎" selected>空心胎</option><option value="实心胎">实心胎</option></select></td>
	</tr>
  <tr>
    <td align="center">车重(kg)</td>
    <td align="center"><input type="text" id="tWeight" onchange="note4()"/><span id="s4"></span></td>
  </tr>
  <tr>
    <td align="center">车高(cm)</td>
    <td align="center"><input type="text" id="tHeight" onchange="note5()"/><span id="s5"></span></td>
  </tr>
  <tr>
    <td align="center">车长(cm)</td>
    <td align="center"><input type="text" id="tLength" onchange="note6()"/><span id="s6"></span></td>
  </tr>
  <tr>
    <td align="center">铃铛类型</td>
    <td align="center"><select id="tRing"><option value="拨动式">拨动式</option><option value="塑胶按压式">塑胶按压式</option><option value="其他样式">其他样式</option></select></td>
  </tr>
  <tr>
    <td align="center">前篮</td>
    <td align="center"><select id="tBasket"><option value="不锈钢" selected>不锈钢</option><option value="塑料框">塑料筐</option></select></td>
  </tr>
  <tr>
    <td align="center">后座</td>
    <td align="center"><select id="tBackseat"><option value="无">无</option><option value="有">有</option></select></td>
  </tr>
  <tr>
    <td align="center">车座</td>
    <td align="center"><select id="tSeat"><option value="不可调" selected>不可调</option><option value="可调节">可调节</option></select></td>
  </tr>
  <tr>
    <td align="center">手刹</td>
    <td align="center"><select id="tBrake"><option value="悬臂式" selected>悬臂式</option><option value="碟刹">碟刹</option><option value="V刹">V刹</option></select></td>
  </tr>
  <tr>
    <td align="center">备注</td>
    <td align="center"><input type="text" id="tRemark" onchange="note12()"/><span id="s12"></span></td>
  </tr>
  <tr>
    <td height="18" colspan="2" align="center"><input type="button" value="增加" onClick="addCate()"/></td>
  </tr>
  </table>
</div>
<form id="increase" method="post" action="increase.do">
<input type="hidden" name="name" id="atype">
<input type="hidden" name="frame" id="aframe">
<input type="hidden" name="tire" id="atire">
<input type="hidden" name="weight" id="aweight">
<input type="hidden" name="height" id="aheight">
<input type="hidden" name="length" id="alength">
<input type="hidden" name="ring" id="aring">
<input type="hidden" name="basket" id="abasket">
<input type="hidden" name="backseat" id="abackseat">
<input type="hidden" name="seat" id="aseat">
<input type="hidden" name="brake" id="abrake">
<input type="hidden" name="remark" id="aremark">
</form>
  </body>
</html>