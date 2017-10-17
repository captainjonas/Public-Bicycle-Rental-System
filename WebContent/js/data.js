function delCate(obj){
	var sure=window.confirm("确认要删除这个类型吗？");
	if(sure){
	var rowDel=obj.parentNode.parentNode;
	var inde=rowDel.rowIndex;
	var id=rowDel.cells[0].innerHTML;
	var table=document.getElementById("info");
	table.deleteRow(inde);
	location="delcate.do?id="+id;
}
}
	
function updCate(obj){
	var rowUpdate=obj.parentNode.parentNode;
	var id=rowUpdate.cells[0].innerHTML;
	var type=rowUpdate.cells[1].innerHTML;
	var tire=rowUpdate.cells[2].innerHTML;
	var ring=rowUpdate.cells[3].innerHTML;
	var backseat=rowUpdate.cells[4].innerHTML;
	var seat=rowUpdate.cells[5].innerHTML;
	var form=document.getElementById("update");
	document.getElementById("id").value=id;
	document.getElementById("type").value=type;
	document.getElementById("tire").value=tire;
	document.getElementById("ring").value=ring;
	document.getElementById("backseat").value=backseat;
	document.getElementById("seat").value=seat;
	form.submit();
}

function addCate(){
	var type=document.getElementById("tName").value;
	var frame=document.getElementById("tFrame").value;
	var tire=document.getElementById("tTire").value;
	var weight=document.getElementById("tWeight").value;
	var height=document.getElementById("tHeight").value;
	var length=document.getElementById("tLength").value;
	var ring=document.getElementById("tRing").value;
	var basket=document.getElementById("tBasket").value;
	var backseat=document.getElementById("tBackseat").value;
	var seat=document.getElementById("tSeat").value;
	var brake=document.getElementById("tBrake").value;
	var remark=document.getElementById("tRemark").value;
	if(type==null){
		alert("类型名称不能为空！");
	}else{
		var form=document.getElementById("increase");
		document.getElementById("atype").value=type;
		document.getElementById("aframe").value=frame;
		document.getElementById("atire").value=tire;
		document.getElementById("aweight").value=weight;
		document.getElementById("aheight").value=height;
		document.getElementById("alength").value=length;
		document.getElementById("aring").value=ring;
		document.getElementById("abasket").value=basket;
		document.getElementById("abackseat").value=backseat;
		document.getElementById("aseat").value=seat;
		document.getElementById("abrake").value=brake;
		document.getElementById("aremark").value=remark;
		form.submit();
	}
}

function add(){
	window.location.href="station/addCategory.jsp";
}


var strField;
var count=1;
function init() {
	var params = window.dialogArguments;
	strField = "<select id='field' name='field' onChange='shift(this)'>";
	var bm=new Array("","车点名称","车点编号","地址","车桩数量","新建日期","运行日期","负责人","车点ID","经度","纬度");
	var paramsLength = bm.length;
	var i=0;
	for (i=0; i<paramsLength; i++)
		strField += "<option value='"+bm[i]+"'>"+bm[i]+"</option>";
	strField += "</select>";
	}
	
function addItem() {
	var oRow = detailTable.insertRow();
	oRow.align = "center";
	oCell = oRow.insertCell();
	oCell.innerHTML = strField;
	
	oCell = oRow.insertCell();
	oCell.innerHTML = "<select name='operator'>\
	<option value='='>等于</option>\
		 <option value='like' selected>类似</option>\
		<option value='>'>超过</option>\
		 <option value='<'>没到</option>\
</select>";
	oCell = oRow.insertCell();
	oCell.innerHTML = "<input type='text' id='fieldValue' name='text' size='10'>";

	oCell = oRow.insertCell();
	oCell.innerHTML = "<select id='logic' name='logic'>\
<option value='and'>并且</option>\
<option value='or'>或者</option>\
</select>";

	oCell = oRow.insertCell();
	oCell.innerHTML = '<image src="images/delete.gif" class="LL" onclick="delItem('+oRow.rowIndex+')"/>';
}


function delItem(index) {
	detailTable.deleteRow(index);
	var rowNum = detailTable.rows.length;
	var rowlength = detailTable.rows[0].cells.length;
	for (var i=index; i<rowNum; i++) {
		detailTable.rows(i).cells(0).innerHTML = i;
		detailTable.rows(i).cells(rowlength-1).innerHTML = '<image src="images/delete.gif" class="LL" onclick="delItem('+i+')"/>';
	}
}

function shift(obj){
var sel=obj.value;
var input=obj.parentNode;
input=input.nextSibling;
input=input.nextSibling;
if(sel=="新建日期"||sel=="运行日期"){
	if(count==1){
		input.innerHTML="<input name='jzrq' type='text' size='15' readonly='readonly'> <span class='requred_symbol'>*</span><a href='javascript:void(0)' onClick='gfPop.fPopCalendar(document.all.jzrq);return false;'><img name='popcal'  src='images/selectDate.gif' width='15' height='12' border='0' alt=''></a>";
		count++;
	}else if(count==2){
		input.innerHTML="<input name='jzr' type='text' size='15' readonly='readonly'> <span class='requred_symbol'>*</span><a href='javascript:void(0)' onClick='gfPop.fPopCalendar(document.all.jzr);return false;'><img name='popcal'  src='images/selectDate.gif' width='15' height='12' border='0' alt=''></a>";
		count++;
	}else if (count==3){
		input.innerHTML="<input name='jz' type='text' size='15' readonly='readonly'> <span class='requred_symbol'>*</span><a href='javascript:void(0)' onClick='gfPop.fPopCalendar(document.all.jz);return false;'><img name='popcal'  src='images/selectDate.gif' width='15' height='12' border='0' alt=''></a>";
	}else if(count==4){
		input.innerHTML="<input name='jdate' type='text' size='15' readonly='readonly'> <span class='requred_symbol'>*</span><a href='javascript:void(0)' onClick='gfPop.fPopCalendar(document.all.jdate);return false;'><img name='popcal'  src='images/selectDate.gif' width='15' height='12' border='0' alt=''></a>";
	}else{
		input.innerHTML="<input name='jda' type='text' size='15' readonly='readonly'> <span class='requred_symbol'>*</span><a href='javascript:void(0)' onClick='gfPop.fPopCalendar(document.all.jda);return false;'><img name='popcal'  src='images/selectDate.gif' width='15' height='12' border='0' alt=''></a>";
	}
}
}

function query() {
   var sql="select * from bicycle_station where";
   var leng=detailTable.rows.length;
   var field=document.getElementsByName("field");
   var operators=document.getElementsByName("operator");
   var logics=document.getElementsByName("logic");
  	var content="";
   var reg1=/[\w||\u4e00-\u9fa5]+/;
   for(var i=1;i<leng;i++){
   	 var choice=field[i-1].value;
   	 var operator=operators[i-1].value;
   	var table=document.getElementById("detailTable");
   	var text=table.rows[i].cells[2].childNodes[0].value;
   	var flag1=true,flag2=true,flag3=true;
   	
   	 if(choice=="新建日期"){
   		content="build_time";
   	   //	text="to_date('"+text+"','yyyy-mm-dd')";
   	 }else{
   		 if(choice=="运行日期"){
   			content="run_time";
   	   	 //  	text="to_date('"+text+"','yyyy-mm-dd')";
   		 }else{
   			 if(!reg1.test(text)){
   				flag3=false;
   	   			alert("请输入正确格式，汉字、字母、数字或下划线");
   			 	}
   			 if(choice=="车点名称")
   		   		 content="station_name"; 
   			 if(choice=="车点编号")
   		   		 content="station_code"; 
   			 if(choice=="地址")
   		   		 content="address"; 
   			 if(choice=="车桩数量")
  		   		 content="bicycle_pile_num"; 
   			 if(choice=="负责人")
 		   		 content="person_in_charge"; 
   			 if(choice=="车点ID")
 		   		 content="station_id"; 
   			 if(choice=="经度")
 		   		 content="longitude"; 
   			 if(choice=="纬度")
		   		 content="latitude"; 
   			 } 
   	 }
   	 sql+=" "+content;
   	 
   	  if(operator=="like"){
   	  		sql+=" "+operator+" "+"'%"+text+"%'";		 
   	  	}else{
   	  			  sql+= " "+operator+" '"+text+"'";
   	  	}
   	  	
   	  var logic=logics[i-1].value;
   	  if(i!=leng-1){
   	  	sql+=" "+logic;
   	  }	
   }
	var hidden=document.getElementById("sql");
	hidden.value=sql;
	if(field!=null&flag1&flag2&flag3){
		
		document.getElementById("stationForm").submit();
	}
}

function cancel(obj){
	var rowUpdate=obj.parentNode.parentNode;
	var id=rowUpdate.cells[0].innerHTML;
	window.location.href="cancelStation.do?id="+id;
}

function submitOrder(){
	var order_code=document.getElementById("saleSOID").value;
	var vender_id=document.getElementById("saleCustomerName").value;
	var buy_date=document.getElementById("buy_date").value;
	var buy_num=document.getElementById("buy_num").value;
	var person_in_charge=document.getElementById("person_in_charge").value;
	var buy_price=document.getElementById("buy_price").value;
	var invoice_no=document.getElementById("invoice").value;
	var remark=document.getElementById("remark").value;
	var form=document.getElementById("order");
	document.getElementById("ordercode").value=order_code;
	document.getElementById("venderid").value=vender_id;
	document.getElementById("buydate").value=buy_date;
	document.getElementById("buynum").value=buy_num;
	document.getElementById("personincharge").value=person_in_charge;
	document.getElementById("buyprice").value=buy_price;
	document.getElementById("invoiceno").value=invoice_no;
	document.getElementById("mark").value=remark;
	var table=document.getElementById("detailTable");
	var ids="";
	var dates="";
	var batches="";
	var prices="";
	var remarks="";
	for(var i=1;i<=buy_num;i++){
		ids+=table.rows[i].cells[1].childNodes[0].value+";";
		dates+=table.rows[i].cells[2].childNodes[0].value+";";
		batches+=table.rows[i].cells[3].childNodes[0].value+";";
		prices+=table.rows[i].cells[4].childNodes[0].value+";";
		var dmark=table.rows[i].cells[5].childNodes[0].value;
		if(dmark==""||dmark==null){
			remarks+=0+";";
		}else{
			remarks+=dmark+";";
		}
	}
	document.getElementById("catagoryid").value=ids;
	document.getElementById("createdate").value=dates;
	document.getElementById("batchno").value=batches;
	document.getElementById("price").value=prices;
	document.getElementById("dRemark").value=remarks;
	form.submit();
}


function modify(obj){
	var rowUpdate=obj.parentNode.parentNode;
	var station_id=rowUpdate.cells[0].innerHTML;
	window.location.href="getStation.do?station_id="+station_id;
}


$("#cx").click(function(){
		ajaxRequest();	
	});
	function ajaxRequest(){
		$.ajax({
			url:"search/ajax.do",
			type:"POST",
			dataType:"json",
			data:{
				"station_name":$("#name").val(),
				"address":$("#address").val(),
				"station_id":$("#id").val(),
				"station_code":$("#code").val(),
				"bicycle_pile_num":$("#pile_num").val(),
				"person_in_charge":$("#person").val()
			},
			async:true,
			success:function(data){
				  for(i=0;i<data.length;i++){  
                        $("#sele").append("<tr align='center'><td>"+data[i].station_id+"</td><td>"+data[i].station_code+"</td>"
                        		+"<td>"+data[i].station_name+"</td><td>"+data[i].longitude+"</td><td>"+data[i].latitude+"</td>"
                        		+"<td>"+data[i].bicycle_pile_num+"</td><td>"+data[i].address+"</td>"
                        		+"<td>"+data[i].person_in_charge+"</td><td>"+data[i].build_time+"</td><td>"+data[i].run_time+"</td>"
                        		+"<td align='center'><input type='button' style='background-color:#88cefa;' value='选择车桩' onclick='seek(this)'></td></tr>");  
                    }  
			},
			error:function(data){
				alert("AJAX交互失败!");
			}
		});
}
	
	function seek(obj){
		var row=obj.parentNode.parentNode;
		var id=row.cells[0].innerHTML;
		$.ajax({
			url:"search/seekPile.do",
			type:"POST",
			dataType:"json",
			data:{
				"station_id":id
			},
			async:true,
			success:function(data){
				  for(i=0;i<data.length;i++){  
                        $("#vacant").append("<tr align='center'><td>"+data[i].pile_id+"</td><td>"+data[i].pile_code+"</td>"
                        		+"<td>"+data[i].install_time+"</td><td>"+data[i].vender_name+"</td>"
                        		+"<td align='center'><input type='button' style='background-color:#88cefa;' value='入桩' onclick='come(this)'></td></tr>");  
                    }  
			},
			error:function(data){
				alert("AJAX交互失败!");
			}
		});
}
	

function sum(){
		var year=document.getElementById("year").value;
		var month=document.getElementById("month").value;
		location="sum.do?year="+year+"&month="+month;
		}

function come(obj){
	var row=obj.parentNode.parentNode;
	var pile_id=row.cells[0].innerHTML;
	var bicycle_id=document.getElementById("bikeid").value;
	window.location.href="toPile.do?pid="+pile_id+"&bid="+bicycle_id;
}

function exportEXCEL(){
	$.ajax({
		url:"put/export.do",
		type:"POST",
		dataType:"json",
		data:{
			"time":$("#hyear").val(),
		},
		async:true,
		success:function(data){
			  alert("成功导出！")
		},
		error:function(data){
			alert("导出失败!");
		}
	});
}	


function note1(){
		var sp = document.getElementById("s1");
		var e = document.getElementById("tName");
		var reg=/^[a-zA-Z0-9\u4e00-\u9fa5]+$/;
		if(reg.test(e.value)){
			sp.innerHTML="√";
			sp.style="color:green;font-size:13px"
		}
		else{
			sp.innerHTML="× 请输入汉字、字母或数字";
			sp.style="color:red;font-size:13px"
		}
}
function note2(){
	var reg=/^[a-zA-Z0-9\u4e00-\u9fa5]+$/;
	var s2 = document.getElementById("s2");
	var frame=document.getElementById("tFrame");
	if(reg.test(frame.value)){
		s2.innerHTML="√";
		s2.style="color:green;font-size:13px"
	}
	else{
		s2.innerHTML="× 请输入汉字、字母或数字";
		s2.style="color:red;font-size:13px"
	}
	
}
function note4(){
	var regNum=/^\d+$/;
	var weight=document.getElementById("tWeight");
	var s4 = document.getElementById("s4");
	if(regNum.test(weight.value)){
		s4.innerHTML="√";
		s4.style="color:green;font-size:13px"
	}
	else{
		s4.innerHTML="× 请输入数字";
		s4.style="color:red;font-size:13px"
	}
}
function note5(){
	var regNum=/^\d+$/;
	var s5 = document.getElementById("s5");
	var height=document.getElementById("tHeight");
	if(regNum.test(height.value)){
		s5.innerHTML="√";
		s5.style="color:green;font-size:13px"
	}
	else{
		s5.innerHTML="× 请输入数字";
		s5.style="color:red;font-size:13px"
	}
}
function note6(){
	var regNum=/^\d+$/;
	var s6 = document.getElementById("s6");
	var length=document.getElementById("tLength");
	if(regNum.test(length.value)){
		s6.innerHTML="√";
		s6.style="color:green;font-size:13px"
	}
	else{
		s6.innerHTML="× 请输入数字";
		s6.style="color:red;font-size:13px"
	}
}

function note8(){
	var reg=/^[a-zA-Z0-9\u4e00-\u9fa5]+$/;
	var s8 = document.getElementById("s8");
	var basket=document.getElementById("tBasket");
	if(reg.test(basket.value)){
		s8.innerHTML="√";
		s8.style="color:green;font-size:13px"
	}
	else{
		s8.innerHTML="× 请输入汉字、字母或数字";
		s8.style="color:red;font-size:13px"
	}
}
function note9(){
	var reg=/^[a-zA-Z0-9\u4e00-\u9fa5]+$/;
	var s9 = document.getElementById("s9");
	var tBackseat=document.getElementById("tBackseat");
	if(reg.test(tBackseat.value)){
		s9.innerHTML="√";
		s9.style="color:green;font-size:13px"
	}
	else{
		s9.innerHTML="× 请输入汉字、字母或数字";
		s9.style="color:red;font-size:13px"
	}
}
function note10(){
	var reg=/^[a-zA-Z0-9\u4e00-\u9fa5]+$/;
	var s10 = document.getElementById("s10");
	var seat=document.getElementById("tSeat");
	if(reg.test(seat.value)){
		s10.innerHTML="√";
		s10.style="color:green;font-size:13px"
	}
	else{
		s10.innerHTML="× 请输入汉字、字母或数字";
		s10.style="color:red;font-size:13px"
	}
}
function note11(){
	var reg=/^[a-zA-Z0-9\u4e00-\u9fa5]+$/;
	var s11 = document.getElementById("s11");
	var brake=document.getElementById("tBrake");
	if(reg.test(brake.value)){
		s11.innerHTML="√";
		s11.style="color:green;font-size:13px"
	}
	else{
		s11.innerHTML="× 请输入汉字、字母或数字";
		s11.style="color:red;font-size:13px"
	}
}
function note12(){
	var reg=/^[a-zA-Z0-9\u4e00-\u9fa5]+$/;
	var s12 = document.getElementById("s12");
	var remark=document.getElementById("tRemark");
	if(reg.test(remark.value)){
		s12.innerHTML="√";
		s12.style="color:green;font-size:13px"
	}
	else{
		s12.innerHTML="× 请输入汉字、字母或数字";
		s12.style="color:red;font-size:13px"
	}	
}



	
	
