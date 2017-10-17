
var rowlength; //每行多少个单元
var spxxTable;
var rowIndex;
var totalPrice=0.0;


//逻辑控制

function choiceAnonymous2() {
	var len = document.getElementById("customerspxxTable").rows.length;
	var returnValue2;
	var i;
	for (i = 1; i < len - 1; i++) {
		if (document.getElementById("customerspxxTable").rows[i].cells[0].innerHTML == "\u221a") {
			returnValue2 = choice2(i);
			setValue2();
			hiddenCustomerDiv();
			return;
		}
	}
	alert("请先选中客户");
	function setValue2() {
		var detailTable = document.getElementById("detailTable");
		var length = detailTable.rows.length;
		var scc = document.getElementById("saleCustomerName");
		scc.value = returnValue2[0];
	}
	document.getElementById("formDiv").style.visibility = "visible";
}

function choiceAnonymous() {
	var len =document.getElementById("spxxTable").rows.length;
	var returnValue;
	var i;
	var length=document.getElementById("detailTable").rows.length;
	var flag2=false;
	for (i = 1; i < len - 1; i++) {
		if (document.getElementById("spxxTable").rows[i].cells[0].innerHTML == "\u221a") {
			returnValue = choice(i);
			flag2=true;
		}
	};
	if(!flag2){
		alert("请先选中商品！");
	};
	setValue();
	hiddenDiv();
	function setValue() {
		var detailTable = document.getElementById("detailTable");
		var length = detailTable.rows.length;
		var spbm = document.getElementsByName("spbm");
		spbm[rowIndex].value = returnValue[0];
		var length=document.getElementById("detailTable").rows.length;
		
	}
}
function selectItem2(tr) {
	clearTable2();
	tr.cells[0].innerHTML = "\u221a";
	var tds = tr.cells;
	for (var j = 0; j < tds.length; j += 1) {
		tds[j].style.backgroundColor = "#C1CDD8";
	}	
}

function selectItem(tr) {
	clearTable();
	tr.cells[0].innerHTML = "\u221a";
	var tds = tr.cells;
	for (var j = 0; j < tds.length; j += 1) {
		tds[j].style.backgroundColor = "#C1CDD8";
	}
	
}

function choice2(k) {
	var row = document.getElementById("customerspxxTable").rows[k];
	var result = new Array(document.getElementById("customerspxxTable").rows[0].cells.length);
	var i;
	for (i = 1; i < 3; i++) {
		result[i - 1] = row.cells[i].innerHTML;
	}
	return result;
}


function choice(index) {
	var row = document.getElementById("spxxTable").rows[index];
	var result = new Array(document.getElementById("spxxTable").rows[0].cells.length);
	var i;
	for (i = 1; i < document.getElementById("spxxTable").rows[0].cells.length; i++) {
		result[i - 1] = row.cells[i].innerHTML;
	}
	return result;
}

function choiceCustomer(){
	document.getElementById("formDiv").style.visibility = "hidden";
	document.getElementById("customerDiv").style.display = "block";
	
}
function choiceSpxx(rowIndex_) {
	showDiv();
	rowIndex = rowIndex_;
}
  //添加一行f
function addItems() {
	var detailTable = document.getElementById("detailTable");
	var oRow = detailTable.insertRow(-1);//在表格最后添加一行
	var buyNum=document.getElementById("buy_num").value;
	buyNum=parseInt(buyNum)+1;
	document.getElementById("buy_num").value=buyNum;
	oRow.align = "center";
	oRow.className = "toolbar";
	oCell = oRow.insertCell(0);//添加单元格
	oCell.innerHTML = oRow.rowIndex;
	oCell = oRow.insertCell(1);
	oCell.innerHTML = "<input type='text'  name='spbm' size='10' readonly='readonly'> <span class='LL'><image src='images/selectDate.gif' onClick='choiceSpxx(\"" + (oRow.rowIndex - 1) + "\")'></span>";
	oCell = oRow.insertCell(2);
	oCell.innerHTML = "<input type='text' name='spmc' size='15'>";
	oCell = oRow.insertCell(3);
	oCell.innerHTML = "<input type='text' name='ytsl' size='10'>";
	oCell = oRow.insertCell(4);
	oCell.innerHTML = "<input type='text' name='sptj' size='10' value='0' onchange='addPrice(this)'>";
	oCell = oRow.insertCell(5);
	oCell.innerHTML = "<input type='text' name='spzl' size='10'>";
	oCell = oRow.insertCell(6);
	oCell.innerHTML = "<image src=\"images/delete.gif\" class=\"LL\" onclick=\"delItems(this)\"/>";
}

function addPrice(obj){
	totalPrice=totalPrice+parseFloat(obj.value);
	document.getElementById("buy_price").value=totalPrice;
}


function textChangeNum(obj){
	var num=parseFloat(obj.value);
	var tr=obj.parentNode.parentNode;
	var nowRowIndex=tr.rowIndex;
	var unitPrice=parseFloat(document.getElementsByName("spzl")[nowRowIndex-1].value);

	document.getElementsByName("stsl")[nowRowIndex-1].value=unitPrice*num;
	
	var length=document.getElementById("detailTable").rows.length;
	
	var count=0;
	var stsl=document.getElementsByName("stsl");
	for (var i= 0; i < stsl.length; i++) {
		count=count+parseFloat(stsl[i].value);	
	}
	
	document.getElementById("saleProductTotal").value=parseFloat(count);
}



	//删除行,注意这里的行号全部要重新计算 刷新的
function delItems(obj) {
	var index=obj.parentNode.parentNode.rowIndex;
	var detailTable = document.getElementById("detailTable");
	var pri=parseFloat(detailTable.rows[index].cells[4].childNodes[0].value);
	totalPrice=totalPrice-pri;
	document.getElementById("buy_price").value=totalPrice;
	var buyNum=document.getElementById("buy_num").value;
	buyNum=parseInt(buyNum)-1;
	document.getElementById("buy_num").value=buyNum;
	detailTable.deleteRow(index);
}
function hiddenDiv() {
	document.getElementById("productDiv").style.display = "none";
	clearTable();
	document.getElementById("formDiv").style.visibility = "visible";
}

function hiddenCustomerDiv(){
	document.getElementById("customerDiv").style.display = "none";
	clearTable2();
	document.getElementById("formDiv").style.visibility = "visible";
}
function showDiv(){
	document.getElementById("productDiv").style.display = "block";
	document.getElementById("formDiv").style.visibility = "hidden";
	
}
 

function clearTable() {
	var trs =document.getElementById("spxxTable").rows;
	for (var i = 1; i < trs.length - 1; i += 1) {
		trs[i].cells[0].innerHTML = "";
		var tds = trs[i].cells;
		for (var j = 0; j < tds.length; j += 1) {
			tds[j].style.backgroundColor = "#fff7e5";
		}
	}
	
}
function clearTable2() {
	var trs = document.getElementById("customerspxxTable").rows;
	for (var i = 1; i < trs.length - 1; i += 1) {
		trs[i].cells[0].innerHTML = "";
		var tds = trs[i].cells;
		for (var j = 0; j < tds.length; j += 1) {
			tds[j].style.backgroundColor = "#fff7e5";
		}
	}	
}

function increaseItem(){
	var num=parseInt(document.getElementById("bicycle_pile_num").value);
	document.getElementById("bicycle_pile_num").value=num+1;
	var detailTable = document.getElementById("detail");
	var oRow = detailTable.insertRow(-1);//在表格最后添加一行
	oRow.align = "center";
	oRow.className = "toolbar";
	oCell = oRow.insertCell(0);//添加单元格
	oCell.innerHTML = oRow.rowIndex;
	oCell = oRow.insertCell(1);
	oCell.innerHTML = "<input type='text'  name='spbm' size='10'>";
	oCell = oRow.insertCell(2);
	oCell.innerHTML = "<input type='text' name='spmc' size='15' readonly='readonly'> <span class='LL'><image src='images/selectDate.gif' onClick='choiceSpxx(\"" + (oRow.rowIndex - 1) + "\")'></span>";
	oCell = oRow.insertCell(3);
	oCell.innerHTML = "<input type='text' name='ytsl' size='10'>";
	oCell = oRow.insertCell(4);
	oCell.innerHTML = "<input type='text' name='spzl' size='10'>";
	oCell = oRow.insertCell(5);
	oCell.innerHTML = "<image src=\"images/delete.gif\" class=\"LL\" onclick='dele(this)'/>";
}

function dele(obj){
	var num=parseInt(document.getElementById("bicycle_pile_num").value);
	document.getElementById("bicycle_pile_num").value=num-1;
	var index=obj.parentNode.parentNode.rowIndex;
	var table=document.getElementById("detail");
	table.deleteRow(index);
}

function choiceAno() {
	var len =document.getElementById("spxxTable").rows.length;
	var returnValue;
	var i;
	var length=document.getElementById("detail").rows.length;
	var flag2=false;
	for (i = 1; i < len - 1; i++) {
		if (document.getElementById("spxxTable").rows[i].cells[0].innerHTML == "\u221a") {
			returnValue = choice(i);
			flag2=true;
		}
	};
	if(!flag2){
		alert("请先选中供应商！");
	};
	setValue();
	hiddenDiv();
	function setValue() {
		var detailTable = document.getElementById("detail");
		var length = detailTable.rows.length;
		var spbm = document.getElementsByName("spmc");
		spbm[rowIndex].value = returnValue[0];
		var length=document.getElementById("detail").rows.length;
		
	}
}


function submitNew(){
	var station_code=document.getElementById("station_code").value;
	var station_name=document.getElementById("station_name").value;
	var longitude=document.getElementById("longitude").value;
	var latitude=document.getElementById("latitude").value;
	var bicycle_pile_num=document.getElementById("bicycle_pile_num").value;
	var address=document.getElementById("address").value;
	var person_in_charge=document.getElementById("person_in_charge").value;
	var build_time=document.getElementById("build_time").value;
	var run_time=document.getElementById("run_time").value;
	var remark=document.getElementById("remark").value;
	var form=document.getElementById("newstation");
	document.getElementById("ordercode").value=station_code;
	document.getElementById("venderid").value=station_name;
	document.getElementById("buydate").value=longitude;
	document.getElementById("buynum").value=latitude;
	document.getElementById("bicyclepilenum").value=bicycle_pile_num;
	document.getElementById("addr").value=address;
	document.getElementById("personincharge").value=person_in_charge;
	document.getElementById("buildtime").value=build_time;
	document.getElementById("invoiceno").value=run_time;
	document.getElementById("mark").value=remark;
	var table=document.getElementById("detail");
	var codes="";
	var venders="";
	var install_times="";
	var remarks="";
	var statuses="";
	var leng = table.rows.length;
	for(var i=1;i<leng;i++){
		codes+=table.rows[i].cells[1].childNodes[0].value+";";
		venders+=table.rows[i].cells[2].childNodes[0].value+";";
		install_times+=table.rows[i].cells[3].childNodes[0].value+";";
		var dmark=table.rows[i].cells[4].childNodes[0].value;
		if(dmark==null||dmark==""){
			remarks+=0+";";
		}else{
			remarks+=dmark+";";
		}
	}
	document.getElementById("catagoryid").value=codes;
	document.getElementById("createdate").value=venders;
	document.getElementById("status").value=statuses;
	document.getElementById("batchno").value=install_times;
	document.getElementById("dRemark").value=remarks;
	form.submit();
}

function del(obj){
	var num=parseInt(document.getElementById("bicycle_pile_num").value);
	document.getElementById("bicycle_pile_num").value=num-1;
	var index=obj.parentNode.parentNode.rowIndex;
	var table=document.getElementById("pileInfo");
	table.deleteRow(index);
}


function hidID(obj){
	var input=obj.parentNode.parentNode.cells[4].childNodes[0];
	input.value="";
	input.readOnly=true;
}

function display(obj){
	var input=obj.parentNode.parentNode.cells[4].childNodes[0];
	input.readOnly=false;
}

function choiceMod(){
var len =document.getElementById("spxxTable").rows.length;
var returnValue;
var i;
var length=document.getElementById("pileInfo").rows.length;
var flag2=false;
for (i = 1; i < len - 1; i++) {
	if (document.getElementById("spxxTable").rows[i].cells[0].innerHTML == "\u221a") {
		returnValue = choice(i);
		flag2=true;
	}
};
if(!flag2){
	alert("请先选中供应商！");
};
setValue();
hiddenDiv();
function setValue() {
	var detailTable = document.getElementById("pileInfo");
	var length = detailTable.rows.length;
	var spbm = document.getElementsByName("spmc");
	spbm[rowIndex].value = returnValue[1];
}	
}

function alter(){
	var station_id=document.getElementById("station_id").value;
	var station_code=document.getElementById("station_code").value;
	var station_name=document.getElementById("station_name").value;
	var longitude=document.getElementById("longitude").value;
	var latitude=document.getElementById("latitude").value;
	var bicycle_pile_num=document.getElementById("bicycle_pile_num").value;
	var address=document.getElementById("address").value;
	var person_in_charge=document.getElementById("person_in_charge").value;
	var run_time=document.getElementById("run_time").value;
	var remark=document.getElementById("remark").value;
	var form=document.getElementById("change");
	document.getElementById("stationid").value=station_id;
	document.getElementById("stationcode").value=station_code;
	document.getElementById("stationname").value=station_name;
	document.getElementById("long").value=longitude;
	document.getElementById("lat").value=latitude;
	document.getElementById("bicyclepilenum").value=bicycle_pile_num;
	document.getElementById("addr").value=address;
	document.getElementById("personincharge").value=person_in_charge;
	document.getElementById("runtime").value=run_time;
	document.getElementById("mark").value=remark;
	var table=document.getElementById("pileInfo");
	var ids="";
	var codes="";
	var statuses="";
	var install_times="";
	var bikeids="";
	var venders="";
	var remarks="";
	var leng = table.rows.length;
	for(var i=1;i<leng;i++){
		ids+=table.rows[i].cells[0].childNodes[0].value+";";
		codes+=table.rows[i].cells[1].childNodes[0].value+";";
		var status=table.rows[i].cells[2].childNodes[1].value;
		var bid=table.rows[i].cells[4].childNodes[1].value;
		if(bid=="NG"){
			bikeids+="0;";
		}else{
			bikeids+=bid+";";
		}
		if(status=="无车"){
			statuses+="2;";
		}else{
			if(status=="有车"){
				statuses+="1;";
			}else{
				statuses+="9;";
			}
		}
		
		install_times+=table.rows[i].cells[3].childNodes[0].value+";";
		venders+=table.rows[i].cells[5].childNodes[0].value+";";
		var dmark=table.rows[i].cells[6].childNodes[0].value;
		if(dmark==null||dmark==""){
			remarks+=0+";";
		}else{
			remarks+=dmark+";";
		}
	}
	document.getElementById("pileid").value=ids;
	document.getElementById("catagoryid").value=codes;
	document.getElementById("createdate").value=venders;
	document.getElementById("status").value=statuses;
	document.getElementById("batchno").value=install_times;
	document.getElementById("price").value=bikeids;
	document.getElementById("dRemark").value=remarks;
	form.submit();
}


