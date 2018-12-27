<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	HttpSession s = request.getSession();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>17商城</title>
<link type="text/css" href="../css/css.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/js.js"></script>
<script src="../s/wb.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
 <div class="mianCont">
  <div class="top">
  <span>您好！欢迎来到校园电脑商城 请&nbsp; <a href="../login.jsp">[登录]</a>&nbsp;
			<a href="../register.jsp">[注册]</a>&nbsp;		
			</span>
		    <span class="topRight"> 
		     <a href="personal?account=<%=s.getAttribute("member")%>">我的校园电脑商城</a>&nbsp;|
		     <a href="personal?account=<%=s.getAttribute("member")%>">会员中心</a>&nbsp;|
			</span>
  </div><!--top/-->
  <div class="lsg">
   <h1 class="logo"><a href="#"><img src="../images/LOGO.png" width="217" height="90" /></a></h1>
	<form action="vagueselect"  name="goodsName" method="post" class="subBox">
				<div class="subBoxDiv">
					<input type="text" class="subLeft" /> <input type="image"
						src="../images/subimg.png" width="63" height="34" class="sub" />
     <div class="hotWord">
    	大家都在找：
						<c:forEach items="${alltype}" var="alltype">
					    <a href="listnewshop?goodsCategory=1&typeId=${alltype.typeId}">${alltype.goodsType}</a>
				        </c:forEach>
     </div><!--hotWord/-->
    </div><!--subBoxDiv/-->
   </form><!--subBox/-->
   <div class="gouwuche">
    <div class="gouCar">
     <c:if test="${empty member}">
					 <a  onclick="aClick()">我要卖&nbsp;|</a>
                </c:if>  
				<c:if test="${not empty member}">
                    <a href="../sale.jsp">我要卖&nbsp;|</a>
                </c:if>  
                <c:if test="${empty member}">
					 <a  onclick="aClick()">我要买&nbsp;|</a>
                </c:if>  
				<c:if test="${not empty member}">
                    <a href="../shopneed.jsp">我要买&nbsp;|</a>
                </c:if>  
   </div><!--gouwuche/-->
  </div><!--lsg/-->
  <div class="pnt">
   <div class="pntLeft">
    <h2 class="Title">所有商品分类
    </h2>
   </div><!--pntLeft/-->
   <div class="pntRight">
   <ul class="nav">
		<li><a href="../NewFile.jsp">商城首页</a></li>
		<li class="navCur"><a href="listnewcomputer?goodsCategory=1">全新电脑</a></li>
		<li><a href="listnewcomputer?goodsCategory=2">二手电脑</a></li>
		<li><a href="shopneedmessage">需求电脑</a></li>
		<li>
		<c:if test="${empty member}">
		<a  onclick="aClick()">会员中心</a>
         </c:if>  
		<c:if test="${not empty member}">
          <a href="personal?account=<%=s.getAttribute("member")%>">会员中心</a>
         </c:if>  
        </li>
		<div class="clears"></div>
		<div class="phone">TEL：021-12345678</div>
	</ul>
   </div><!--pntRight/-->
   <div class="clears"></div>
  </div><!--pnt/-->
  <div class="positions">
   当前位置：<a href="#">首页</a> &gt; <a href="#" class="posCur">购物车</a>
  </div><!--positions/-->
  <div class="cont">
   <div class="chenggong">
    <h3>已成功上架商品！</h3>
    <div class="jiesuan">
  
    <div class="clears"></div>
   </div><!--jiesuan/-->
   <div class="clears"></div>
  </div><!--cont/-->
   </div><!--chenggong/-->
  </div><!--cont/-->
 	<!--cont/-->
		<div class="inHelp">
			<div class="inHLeft">
				<h4>帮助中心</h4>
				<ul class="inHeList">
					<li><a href="#">购物指南</a></li>
					<li><a href="#">支付方式</a></li>
					<li><a href="#">售后服务</a></li>
					<li><a href="#">企业简介</a></li>
					<div class="clears"></div>
				</ul>
				<!--inHeList/-->
			</div>
			<!--inHLeft/-->
			<div class="inHLeft">
				<h4>会员服务</h4>
				<ul class="inHeList">
					<li><a href="../register.jsp">会员注册</a></li>
					<li><a href="../login.jsp">会员登录</a></li>
					<li><a href="#">购物车</a></li>
					<li><a href="#">我的订单</a></li>
					<div class="clears"></div>
				</ul>
				<!--inHeList/-->
			</div>
			<!--inHLeft/-->
			<div class="inHRight">
				<h4>全国统一免费服务热线</h4>
				<div class="telBox">400-0000-0000</div>
				<div class="weibo">
					<wb:follow-button uid="2991975565" type="red_1" width="67"
						height="24"></wb:follow-button>
				</div>
			</div>
			<!--inHRight/-->
			<div class="clears"></div>
		</div>
		<!--inHelp/-->
		<div class="footer">
			<p>
				<a href="#">进入17官网</a>&nbsp;|&nbsp; <a href="#">商城首页</a>&nbsp;|&nbsp;
				<a href="#">促销中心</a>&nbsp;|&nbsp; <a href="#">我的订单</a>&nbsp;|&nbsp;
				<a href="#">新闻动态</a>&nbsp;|&nbsp; <a href="#">会员中心</a>&nbsp;|&nbsp;
				<a href="#">帮助中心</a>
			</p>
		</div>
		<!--footer/-->
	</div>
 <a href="#" class="backTop">&nbsp;</a>
</body>
<script type="text/javascript"> 
	    function aClick () {  
	    	
	         alert("请先登录！");
	    }  
	</script>
</html>
