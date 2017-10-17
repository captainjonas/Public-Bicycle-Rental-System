//定义弹窗对象
/**
 * 
 * @param width 窗口宽度
 * @param height 窗口高度
 * @param url 窗口打开的url
 * @param title 窗口标题
 * @returns {dialog}
 */
function dialog(width,height,url,title){
	this.width = width;//弹窗的宽
	this.height = height;//弹窗的高
	this.url = url;//弹窗内容路径
	this.open = function(){
		var body = $("body");
		body.append('<div class="dialog_bg" id="dialog_bg" ></div>');
		body.append(
					'<div id="dialog" class="dialog" style="width:'+width+'px;height:'+height+'px;margin-left:-'+width/2+'px;margin-top:-'+height/2+'px;">'+
						'<span class="dialog_title" id="dialog_title" style="width:'+width+'px;display:block;"><span style="float:left;width:'+(width-35)+'px;">'+title+'</span><span class="close_btn" onclick="closeDialog()">×</span></span>'+
						'<div id="loadDiv"></div>'+
					'</div>'
		);
		$("#loadDiv").load(url);
		var dialog = document.getElementById("dialog");
		document.getElementById("dialog_title").onmousedown = function(e){
			var x = e.clientX;
			var y = e.clientY;
			var marginLeft = dialog.style.marginLeft.replace("px","");
			var marginTop = dialog.style.marginTop.replace("px","");
			
			document.onmousemove = function(e){
				dialog.style.marginLeft = (parseFloat(marginLeft)+parseFloat(e.clientX-x))+"px";
				dialog.style.marginTop = (parseFloat(marginTop)+parseFloat(e.clientY-y))+"px";
			};
			document.onmouseup = function(){
				document.onmousemove = null;
	            document.onmouseup = null;
			};
			
		};
	}; 
}

function closeDialog(){
	$("#dialog_bg").remove();
	$("#dialog").remove();
}




