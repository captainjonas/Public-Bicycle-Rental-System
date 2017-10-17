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
  	<script type="text/javascript">
  	var id=${id};
  	function newPile(){
			var detailTable = document.getElementById("pileInfo");
			var oRow = detailTable.insertRow(-1);
			var index= oRow.rowIndex;
			var name="status"+index;
			oRow.align = "center";  oRow.className = "toolbar";
			oCell = oRow.insertCell(0);
			oCell.innerHTML = "<input type='text'  name='spbd' size='10' style='text-align:center' value="+id+" readonly='readonly'>";
			oCell = oRow.insertCell(1);
			oCell.innerHTML = "<input type='text'  name='spbt' size='10' style='text-align:center'>";
			oCell = oRow.insertCell(2);
			oCell.innerHTML = "<input type='hidden'><input type='text'  name='spbt' size='10' style='text-align:center'>";
			oCell = oRow.insertCell(3);
			oCell.innerHTML = "<input type='text'  style='text-align:center' name='spbd' size='15'>";
			oCell = oRow.insertCell(4);
			oCell.innerHTML = "<input type='hidden'><input type='text'  name='spcd' size='10' style='text-align:center'>";
			oCell = oRow.insertCell(5);
			oCell.innerHTML = "<input type='text' style='text-align:center' name='spmc' size='22' readonly='readonly'> <span class='LL'><image src='images/selectDate.gif' onClick='choiceSpxx(\"" + (oRow.rowIndex - 1) + "\")'></span>";
			oCell = oRow.insertCell(6);
			oCell.innerHTML = "<input type='text'  style='text-align:center' name='sprd' size='10'>";
			oCell = oRow.insertCell(7);
			oCell.innerHTML = "<image src=\"images/delete.gif\" class=\"LL\" onclick='del(this)'/>";
			var num=parseInt(document.getElementById("bicycle_pile_num").value);
			document.getElementById("bicycle_pile_num").value=num+1;
			id+=1;
  	}
		
	</script>
  </head>
  <body marginwidth="0" marginheight="0">
    <c:if test="${alterstation=='1' }">
  	<script type="text/javascript">
		alert("修改成功！");
	</script>
  </c:if>
   <c:if test="${bikePile=='0' }">
  	<script type="text/javascript">
		alert("该车目前无法入桩，请重新修改！");
	</script>
  </c:if>
  
  <div class="container">
		<div class="public-nav">您当前的位置：修改车点车桩></div>
  </div>
  <div id="productDiv" style="display: none;" class="product">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="30px" nowrap="nowrap" class="toolbar">&nbsp;</td>
	    <td width="60px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="choiceMod('productDiv')"><img src="images/confirm.gif">确定</td>
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
    <td width="120px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="newPile()"><img src="images/add.gif">新增车桩</td>
	<td nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>
  <table id="headTable" width="100%"  border="0" align="center" class="a1">
  <tr align="justify">
    <td>车点ID</td>
    <td><input type="text"  size="15" id="station_id" readonly="readonly" value="${station.station_id }"/>
      <span class="requred_symbol">*</span></td>
    <td>车点编号</td>
    <td><input type="text"  size="15" id="station_code" value="${station.station_code }"/>
    </td>
    <td>车点名称</td>
    <td><input type="text" size="15"  id="station_name" value="${station.station_name }"/>
    </td>
      <td>车点经度</td>
    <td><input type="text" size="15" id="longitude" value="${station.longitude }"/>
    </td>
    <td>车点纬度</td>
    <td><input name="textfield" type="text" size="15" id="latitude" value="${station.latitude }"></td>
  </tr>
  <tr align="justify">
   <td>车桩数量</td>
    <td><input type="text" size="15" id="bicycle_pile_num" value="${station.bicycle_pile_num }" readonly="readonly"/></td>
    <td>地址</td>
    <td><input type="text" size="15" id="address" value="${station.address }"/></td>
    <td>负责人</td>
    <td >
 		<input type="text" size="15" id="person_in_charge" value="${station.person_in_charge }"/>
    </td>
    <td>运行日期</td>
    <td >
 		<input name='jct' type='text' size='15' readonly='readonly' id='run_time' value="${station.run_time }"> <span class='requred_symbol'>*</span><a href='javascript:void(0)' onClick='gfPop.fPopCalendar(document.all.jct);return false;'><img name='popcal'  src='images/selectDate.gif' width='15' height='12' border='0' alt=''></a>
    </td>
    <td>备注：</td>
    <td><input name="text" type="text" size="15" id="remark" value="${station.remark }"/></td>
   </tr>
  <tr>
    <td class="title2"></td>
  </tr>
</table>

<table width="100%"  border="0" align="center" cellspacing="1" id="pileInfo">
  <tr>
    <td class="toolbar">车桩ID</td>
    <td class="toolbar">车桩编号</td>
    <td class="toolbar">状态(有车/无车/报废)</td>
    <td class="toolbar">安装日期("YYYY-MM-DD")</td>
    <td class="toolbar">车辆ID</td>
     <td class="toolbar">车桩供应商</td>
    <td class="toolbar">备注</td>
    <td class="toolbar">&nbsp;</td>
  </tr>
  <c:forEach items="${piles }" var="pro" varStatus="status">
  <tr align="center">
     <td align="center"><input type="text"  size="10" value="${pro.pile_id }" style="text-align:center" readonly="readonly"/></td>
 	 <td align="center"><input type="text"  size="10" value="${pro.pile_code }" style="text-align:center"/></td>
  	 <td>
  	 <c:if test="${pro.status=='2' }"><input type="text"  size="10" value="无车" style="text-align:center"/></c:if>
     <c:if test="${pro.status=='1' }"><input type="text"  size="10" value="有车" style="text-align:center"/></c:if>
  	 <c:if test="${pro.status=='9' }"><input type="text"  size="10" value="报废" style="text-align:center"/></c:if>
  	 </td>
  	 <td><input type="text"  size="15" value="${pro.install_time }" style="text-align:center"/></td>
     <td>
     <c:if test="${empty pro.bicycle_id }"><input type="text"  size="10" value="NG" style="text-align:center"/></c:if>
      <c:if test="${not empty pro.bicycle_id }"><input type="text"  size="10" value="${pro.bicycle_id }" style="text-align:center"/></c:if>
     </td>
     <td><input type='text' name='spmc' size='22' style='text-align:center' readonly='readonly' value="${pro.vender_name }"> <span class='LL'><img src='images/selectDate.gif' onClick="choiceSpxx(${status.index})"></span></td>
     <td><input type="text"  size="10" value="${pro.remark }" style="text-align:center"/></td>
     <td><img src="images/delete.gif" onclick="del(this)"/></td>
 	</tr>
  	</c:forEach>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title2"></td>
  </tr>
</table>
<br>
<div align="center">
    <input type="button" id="bc" value="提交"   onClick="alter()"/>
    <input type="button" id="dy" value="打印" onClick="window.print()"/>
</div>
</div>

<form id="change" method="post" action="changeStation.do">
<input type="hidden" name="station_id" id="stationid">
<input type="hidden" name="station_code" id="stationcode">
<input type="hidden" name="station_name" id="stationname">
<input type="hidden" name="longitude" id="long">
<input type="hidden" name="latitude" id="lat">
<input type="hidden" name="bicycle_pile_num" id="bicyclepilenum">
<input type="hidden" name="address" id="addr">
<input type="hidden" name="person_in_charge" id="personincharge">
<input type="hidden" name="run_time" id="runtime">
<input type="hidden" name="remark" id="mark">
<input type="hidden" name="ids" id="pileid">
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