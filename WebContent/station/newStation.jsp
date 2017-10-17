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
	<script type="text/javascript" src="js/productDiv.js" ></script>

  </head>
  
  <body marginwidth="0" marginheight="0">
    <c:if test="${addstation=='1' }">
  	<script type="text/javascript">
		alert("成功新增车点！");
	</script>
  </c:if>
  <div class="container">
		<div class="public-nav">您当前的位置：新增车点></div>
  </div>
  <div id="productDiv" style="display: none;" class="product">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="30px" nowrap="nowrap" class="toolbar">&nbsp;</td>
	    <td width="60px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="choiceAno('productDiv')"><img src="images/confirm.gif">确定</td>
	    <td width="20px" nowrap="nowrap" class="toolbar">|</td>
	    <td width="60px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="hiddenDiv()"><img src="images/cancel.gif">取消</td>
		<td align="center" valign="middle" nowrap="nowrap" class="toolbar">&nbsp;</td>
	  </tr>
	</table>
	<table width="100%"  border="0" align="center" cellspacing="1" class="a1" id="spxxTable">
	  <tr>
	    <td class="title1">选择</td>
	    <td class="title1">供应商ID</td>
	    <td class="title1">供应商名称</td>
	  </tr>
	  <c:forEach items="${cz }" var="customer">
			<tr align="center" onClick="selectItem(this)" onMouseOver="OMO1(event)" onClick="choice(this)">
				<td>&nbsp;</td>
				<td>${customer.vender_id }</td>
				<td>${customer.vender_name }</td>
			</tr>
		</c:forEach>
	   <tr>
	    <td class="title2"></td>
	  </tr>
	</table>
</div>

<div id="formDiv">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
    <td width="120px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="increaseItem()"><img src="images/add.gif">添加车桩信息</td>
	<td nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>

<table id="headTable" width="100%"  border="0" align="center" class="a1">
  <tr align="justify">
    <td>车点编号</td>
    <td><input type="text"  size="15" id="station_code"/>
      <span class="requred_symbol">*</span></td>
    <td>车点名称</td>
    <td><input type="text" size="15"  id="station_name"/>
    </td>
      <td>车点经度</td>
    <td><input type="text" size="15" id="longitude"/>
    </td>
    <td>车点纬度</td>
    <td><input name="textfield" type="text" size="15" id="latitude"></td>
     <td>车桩数量</td>
    <td><input type="text" size="15" id="bicycle_pile_num" value="0" readonly="readonly"/></td>
  </tr>
  <tr align="justify">
    <td>地址</td>
    <td><input type="text" size="15" id="address"/></td>
    <td>负责人</td>
    <td >
 		<input type="text" size="15" id="person_in_charge"/>
    </td>
    <td>新建日期</td>
    <td >
 		<input name='cr' type='text' size='15' readonly='readonly' id='build_time'> <span class='requred_symbol'>*</span><a href='javascript:void(0)' onClick='gfPop.fPopCalendar(document.all.cr);return false;'><img name='popcal'  src='images/selectDate.gif' width='15' height='12' border='0' alt=''></a>
    </td>
    <td>运行日期</td>
    <td >
 		<input name='jct' type='text' size='15' readonly='readonly' id='run_time'> <span class='requred_symbol'>*</span><a href='javascript:void(0)' onClick='gfPop.fPopCalendar(document.all.jct);return false;'><img name='popcal'  src='images/selectDate.gif' width='15' height='12' border='0' alt=''></a>
    </td>
    <td>备注：</td>
    <td><input name="text" type="text" size="15" id="remark"/></td>
   </tr>
  <tr>
    <td class="title2"></td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1" id="detail">
  <tr>
    <td class="toolbar">序列</td>
    <td class="toolbar">车桩编号</td>
    <td class="toolbar">车桩供应商</td>
    <td class="toolbar">安装日期(格式YYYY-MM-DD)</td>
    <td class="toolbar">备注</td>
    <td class="toolbar">&nbsp;</td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title2"></td>
  </tr>
</table>
<br>
<div align="center">
    <input type="button" id="bc" value="提交"   onClick="submitNew()"/>
    <input type="button" id="dy" value="打印" onClick="window.print()"/>
</div>
</div>

<form id="newstation" method="post" action="newstation.do">
<input type="hidden" name="station_code" id="ordercode">
<input type="hidden" name="station_name" id="venderid">
<input type="hidden" name="longitude" id="buydate">
<input type="hidden" name="latitude" id="buynum">
<input type="hidden" name="bicycle_pile_num" id="bicyclepilenum">
<input type="hidden" name="address" id="addr">
<input type="hidden" name="person_in_charge" id="personincharge">
<input type="hidden" name="build_time" id="buildtime">
<input type="hidden" name="run_time" id="invoiceno">
<input type="hidden" name="remark" id="mark">
<input type="hidden" name="codes" id="catagoryid">
<input type="hidden" name="venders" id="createdate">
<input type="hidden" name="statuses" id="status">
<input type="hidden" name="install_times" id="batchno">
<input type="hidden" name="bikeids" id="price">
<input type="hidden" name="remarks" id="dRemark">
</form>

<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
  </body>
</html>