<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公共自行车管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/public.css">

  </head>
  
  <body>
  <div class="public-header-warrp">
	<div class="public-header">
		<div class="content">
			<div class="public-header-logo"><a href=""><i>LOGO</i>
			<h3>AOWIN</h3></a></div>
			<div class="public-header-admin fr">
				<p class="admin-name">欢迎你，管理员${username}！</p>
				<div class="public-header-fun fr">
					<a href="login.jsp" class="public-header-man">登录</a>
					<a href="logout.do" class="public-header-loginout">安全退出</a>	
				</div>
			</div>
		</div>
	</div>
</div>
<div class="clearfix"></div>
<!-- 内容展示 -->
<div class="public-ifame mt20">
	<div class="content">
	<!-- 内容模块头 -->
		<div class="public-ifame-header">
			<ul>
				<li class="ifame-item logo">
					<div class="item-warrp">
						<a href="#"><i>LOGO</i>
							<h3 class="logo-title">公共自行车管理系统</h3>
							<p class="logo-des">创建于 2016/4/22 22:22:47</p>
						</a>
					</div>
				</li>
				<li class="ifame-item"><div class="item-warrp"><span>杭城江南韵，<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;低碳快乐行！</span></div></li>
				<li class="ifame-item"><div class="item-warrp" style="border:none">网站浏览量：<span id="visits">
				<c:choose><c:when test="${empty no }">1</c:when><c:otherwise>${no }</c:otherwise></c:choose></span></div></li>
				<div class="clearfix"></div>
			</ul>
		</div>
		<div class="clearfix"></div>
		<!-- 左侧导航栏 -->
		<div class="public-ifame-leftnav">
			<div class="public-title-warrp">
				<div class="public-ifame-title ">
					<a href="index.jsp">首页</a>
				</div>
			</div>
			<ul class="left-nav-list">
				<li class="public-ifame-item">
					<a href="javascript:;">车辆信息</a>
					<div class="ifame-item-sub">
						<ul>
							<li class="active"><a href="stations.do?sign=0" target="content">车点车桩信息</a></li>
							<li><a href="cate.do" target="content">车辆类型信息</a></li>
						</ul>
					</div>
				</li>
				<li class="public-ifame-item">
					<a href="javascript:;">车辆业务管理</a>
					<div class="ifame-item-sub">
						<ul>
							<li><a href="vender.do" target="content">车辆购入</a></li>
							<li><a href="newBike.do" target="content">新车入桩</a></li>
							<li><a href="destroy.do" target="content">车辆报废</a></li>
						</ul>
					</div>
				</li>
				<li class="public-ifame-item">
					<a href="javascript:;">统计</a>
					<div class="ifame-item-sub">
						<ul>
							<li><a href="summary.do?index=1" target="content">站点车辆统计</a></li>
							<li><a href="#" target="content">车辆维修统计</a></li>
						</ul>
					</div>
				</li>
				
			</ul>
		</div>
		<!-- 右侧内容展示部分 -->
		<div class="public-ifame-content">
		<iframe name="content" src="main.jsp" frameborder="0" id="mainframe" scrolling="yes" marginheight="0" marginwidth="0" width="100%" style="height: 700px;"></iframe>
		</div>
	</div>
</div>
<script src="js/jquery.min.js"></script>
<script>
$().ready(function(){
	var item = $(".public-ifame-item");

	for(var i=0; i < item.length; i++){
		$(item[i]).on('click',function(){
			$(".ifame-item-sub").hide();
			if($(this.lastElementChild).css('display') == 'block'){
				$(this.lastElementChild).hide()
				$(".ifame-item-sub li").removeClass("active");
			}else{
				$(this.lastElementChild).show();
				$(".ifame-item-sub li").on('click',function(){
					$(".ifame-item-sub li").removeClass("active");
					$(this).addClass("active");
				});
			}
		});
	}
});
</script>


  </body>
</html>