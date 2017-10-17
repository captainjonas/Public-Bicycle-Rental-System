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
	<script type="text/javascript" src="js/data.js"></script>

  </head>
  
  <body marginwidth="0" marginheight="0">
  <c:if test="${addorder=='1' }">
  	<script type="text/javascript">
		alert("购入成功！");
	</script>
  </c:if>
  <div class="container">
		<div class="public-nav">您当前的位置：车辆购入></div>
  </div>
  <div id="customerDiv" style="display: none;" class="product">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="30px" nowrap="nowrap" class="toolbar">&nbsp;</td>
	    <td width="60px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="choiceAnonymous2('customerDiv')"><img src="images/confirm.gif">确定</td>
	    <td width="20px" nowrap="nowrap" class="toolbar">|</td>
	    <td width="60px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="hiddenCustomerDiv()"><img src="images/cancel.gif">取消</td>
		<td align="center" valign="middle" nowrap="nowrap" class="toolbar">&nbsp;</td>
	  </tr>
	</table>
	<table width="100%"  border="0" align="center" cellspacing="1" class="a1" id="customerspxxTable">
	  <tr>
	    <td class="title1">选择</td>
	    <td class="title1">供应商ID</td>
	    <td class="title1">供应商名称</td>
	  </tr>
	  <c:forEach items="${cl }" var="customer">
			<tr align="center" onClick="selectItem2(this)" onMouseOver="OMO1(event)" onClick="choice2(this)">
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
<div id="productDiv" style="display:none;" class="product">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="30px" nowrap="nowrap" class="toolbar">&nbsp;</td>
	    <td width="60px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="choiceAnonymous('productDiv')"><img src="images/confirm.gif">确定</td>
	    <td width="20px" nowrap="nowrap" class="toolbar">|</td>
	    <td width="60px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="hiddenDiv()"><img src="images/cancel.gif">取消</td>
		<td align="center" valign="middle" nowrap="nowrap" class="toolbar">&nbsp;</td>
	  </tr>
	</table>
	<table width="100%"  border="0" align="center" cellspacing="1" class="a1" id="spxxTable">
	  <tr>
	    <td class="title1">选择</td>
	    <td class="title1">类型编号</td>
	    <td class="title1">类型名称</td>
	    <td class="title1">轮胎类型</td>
	    <td class="title1">铃铛类型</td>
	    <td class="title1">有无后座</td>
	    <td class="title1">车座类型</td>
	  </tr> 
	  <c:forEach items="${bikes }" var="product">
			<tr align="center" onClick="selectItem(this)" onMouseOver="OMO1(event)" onDblClick="choice(this)">
				<td>&nbsp;</td>
				<td>${product.catagory_id }</td>
				<td>${product.catagory_name }</td>
				<td>${product.tire_type }</td>
				<td>${product.ring_type }</td>
				<td>${product.backseat }</td>
				<td>${product.bicycle_seat }</td>
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
    <td width="90px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="addItems()"><img src="images/add.gif">增加明细</td>
	<td nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>

<table id="headTable" width="100%"  border="0" align="center" class="a1">
  <tr align="justify">
    <td>单据编号</td>
    <td><input type="text"  size="15" id="saleSOID"/>
      <span class="requred_symbol">*</span></td>
    <td>供应商ID</td>
    <td><input type="text" size="15"  id="saleCustomerName"/>
    <span class="LL"><img  src="images/selectDate.gif" onClick="choiceCustomer()"></span>
    </td>
      <td>购入日期</td>
    <td><input name='jcr' type='text' size='15' readonly='readonly' id='buy_date'> <span class='requred_symbol'>*</span><a href='javascript:void(0)' onClick='gfPop.fPopCalendar(document.all.jcr);return false;'><img name='popcal'  src='images/selectDate.gif' width='15' height='12' border='0' alt=''></a>
    </td>
    <td>购入数量</td>
    <td><input name="textfield" type="text" size="15" id="buy_num" value="0" readonly="readonly"></td>
  </tr>
  <tr align="justify">
    <td>购入负责人</td>
    <td><input type="text" size="15" id="person_in_charge"/></td>
    <td>购入总金额(元)</td>
    <td><input type="text" size="15" id="buy_price" value="0" readonly="readonly"/></td>
    <td>发票号码</td>
    <td >
 		<input type="text" size="15" id="invoice"/>
    </td>
    <td>备注：</td>
    <td><input name="text" type="text" size="15" id="remark"/></td>
   </tr>
  <tr>
    <td class="title2"></td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1" id="detailTable">
  <tr>
    <td class="toolbar">序列</td>
    <td class="toolbar">车类型编号</td>
    <td class="toolbar">出厂日期(格式"YYYYMMDD")</td>
    <td class="toolbar">批次号</td>
    <td class="toolbar">价格（元）</td>
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
    <input type="button" id="bc" value="提交"   onClick="submitOrder()"/>
    <input type="button" id="dy" value="打印" onClick="window.print()"/>
</div>
</div>


 
 <form id="order" method="post" action="order.do">
<input type="hidden" name="order_code" id="ordercode">
<input type="hidden" name="vender_id" id="venderid">
<input type="hidden" name="buy_date" id="buydate">
<input type="hidden" name="buy_num" id="buynum">
<input type="hidden" name="buy_price" id="buyprice">
<input type="hidden" name="person_in_charge" id="personincharge">
<input type="hidden" name="invoice_no" id="invoiceno">
<input type="hidden" name="remark" id="mark">
<input type="hidden" name="catagory_id" id="catagoryid">
<input type="hidden" name="create_date" id="createdate">
<input type="hidden" name="batch_no" id="batchno">
<input type="hidden" name="price" id="price">
<input type="hidden" name="dRemark" id="dRemark">
</form>
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>


  </body>
</html>