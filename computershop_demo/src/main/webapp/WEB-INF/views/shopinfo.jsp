<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<%
	HttpSession s = request.getSession();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="../css/css.css" rel="stylesheet" />
<link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="../css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
<link href="../css/templatemo_style.css" rel="stylesheet" type="text/css">	
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="../js/js.js"></script>
<script src="../js/wb.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/MagicZoom.js" type="text/javascript"></script>


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
		</div>
		<!--top/-->
		<div class="lsg">
			<h1 class="logo">
				<a href="#"><img src="../images/LOGO.png" width="217"height="90" /></a>
			</h1>
			<form action="vagueselect" method="get" class="subBox">
				<div class="subBoxDiv">
					<input type="text"  name="goodsName" class="subLeft" /> <input type="image"
						src="../images/subimg.png" width="63" height="34" class="sub" />
					<div class="hotWord">
						大家都在找：
						<c:forEach items="${alltype}" var="alltype">
						<a href="listshop?typeId=${alltype.typeId}">${alltype.goodsType}</a>&nbsp;
						</c:forEach>
					</div>
					<!--hotWord/-->
				</div>
				<!--subBoxDiv/-->
			</form>
			<!--subBox/-->
			<!--gouwuche/-->
		</div>
		<!--lsg/-->
		<div class="pnt">
			<div class="pntLeft">
				<h2 class="Title">
					所有商品分类
				</h2>
			</div>
			<!--pntLeft/-->
			<div class="pntRight">
				<ul class="nav">
					<li><a href="../NewFile.jsp">商城首页</a></li>
					<li><a href="listnewcomputer?goodsCategory=1">全新电脑</a></li>
					<li><a href="listnewcomputer?goodsCategory=2">二手电脑</a></li>
					<li ><a href="shopneedmessage">需求电脑</a></li>
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
				<!--nav/-->
			</div>
			<!--pntRight/-->
			<div class="clears"></div>
		</div>
		<!--pnt/-->
		<div class="positions">
			当前位置：<a href="#">首页</a> &gt; <a href="#" class="posCur">商品详情</a>
		</div>
		<!--positions/-->
		<div class="cont">
					<div class="contLeft">
				<ul class="leftPorNav">
				    <c:forEach items="${alltype}" var="alltype">
					<li><a href="listshop?typeId=${alltype.typeId}">${alltype.goodsType}</a></li>
					</c:forEach>	
				</ul>
				<!--InPorNav/-->
			</div>
			<!--contLeft/-->
			<%
				String path = request.getContextPath();
				String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
						+ path + "/";
			%>
			<div class="contRight" style="border: 0;" id="shopinfo">
				<div class="proBox">
					<div id="tsShopContainer">
						<div id="tsImgS">
							<a href="<%=basePath%>upload/${phones}" title="Images"
								class="MagicZoom" id="MagicZoom"> <img width="300"
								height="300" src="<%=basePath%>upload/${phones}" />
							</a>
						</div>
						<div id="tsPicContainer">
							<div id="tsImgSArrL" onclick="tsScrollArrLeft()"></div>
							<div id="tsImgSCon">
								<ul>
									<c:forEach items="${phone}" var="phone">
										<li rel="MagicZoom"><img height="42" width="42"
											src="<%=basePath%>upload/${phone}"
											tsImgS="<%=basePath%>upload/${phone}" /></li>
									</c:forEach>
								</ul>
							</div>
							<div id="tsImgSArrR" onclick="tsScrollArrRight()"></div>
						</div>
						<img class="MagicZoomLoading" width="16" height="16"
							src="images/loading.gif" alt="Loading..." />
						<script src="../js/ShopShow.js"></script>
					</div>
					<!--tsShopContainer/-->
					<div class="proBoxRight">
						<h3 class="proTitle">${shopinfo.goodsName}</h3>
						<div>用户帐号：${shopinfo.account}</div>
						<br>
						<div class="cheng">商品原价：¥${shopinfo.goodsOldprice}</div>
						<br>
						<div>
							商品现价：<strong class="red">¥${shopinfo.goodsPrice}</strong>
						</div>
						<br>
						<div>交易方式：${shopinfo.tradeMode}</div>
						<br>
						<div>发布时间：<fmt:formatDate value="${shopinfo.relaseTime}" pattern="yyyy-MM-dd" /></div>
						<br>
						<div id="cart_account" style="display:none">${shopinfo.account}</div>
						<div id="cart_goodsId" style="display:none">${shopinfo.goodsId}</div>
						<div id="cart_accountId" style="display:none"><%=s.getAttribute("member")%></div>
						<div class="gc">
						<c:if test="${empty member}">
						<a onclick="aClick()"><img src="../images/goumai.png"width="117" height="36" /></a>&nbsp;&nbsp;<!--立即购买  -->
                        </c:if>  
				        <c:if test="${not empty member}">
                        <a href="purchase?goodsId=${shopinfo.goodsId}"><img src="../images/goumai.png"width="117" height="36" /></a>&nbsp;&nbsp;<!--立即购买  -->
                        </c:if> 
						<c:if test="${empty member}">	  
                            <a onclick="aClick()"><img src="../images/shoucang.png" width="117" height="36" /></a><!--加入购物车  -->
						 </c:if>  
						 <c:if test="${not empty member}">
						    <a onclick="add();"><img src="../images/shoucang.png" width="117" height="36" /></a><!--加入购物车  -->
						 </c:if> 
						</div>
						<!--gc/-->
					</div>
					<!--proRight/-->
					<div class="clears"></div>
				</div>
				<!--proBox/-->
				
				<ul class="fangyuan">
					<li>商品描述</li>
					<li>商品留言</li>
					<div class="clears"></div>
				</ul>				
				<!--fangyuan/-->
				<div class="fangList">
					<div class="fangPar"><h3>${shopinfo.goodsDescribe}</h3></div>
				</div>		
				<br>
				<!-- 商品评论留言区 -->
				<div class="fangList" id="wordmessage">
				<table >
                </table>
				</div>
				<br><br>		
			</div>
			<div class="clears"></div>
			<div style="margin-left:845px">
			<c:if test="${empty member}">	  
             <a onclick="aClick()"><h3>我要留言</h3></a><!--加入购物车  -->
		   </c:if>  
			 <c:if test="${not empty member}">
			<a href="inwords?goodsId=${shopinfo.goodsId}"><h3>我要留言</h3></a>
			</c:if>
			</div><br>
		</div>
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
					<li><a href="#">会员注册</a></li>
					<li><a href="#">会员登录</a></li>
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
	<!--mianCont/-->
	<a href="#" class="backTop">&nbsp;</a>
</body>
<script>
/* 进入页面就执行 */
$(function(){
	$.ajax({
		url : "words?goodsId=${shopinfo.goodsId}",
		type : "GET",
		success :function(result) {
		//	$("#shopinfo table").children().remove();					 
			$.each(result.extend.words, function() {
				var d = new Date(this.wordsTime);
			  	youWant =d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate();
				//yyyy-MM-dd hh:mm:ss
			//	alert(this.wordsContent);				
				var optionEle = $("<tr></tr>")
				    .append("<h3>"+this.account+"</h3>")
				    .append("<h3>"+this.wordsContent+"</h3>")
				    .append("<h3>"+youWant+"</h3>")
				    .append("-----------------------------------------------------------------------------------------------------------------------------------------------")
				    .attr("value", this.goodsId);
				     optionEle.appendTo("#shopinfo table");   
			});
		}
});
});
//加入收藏
function add(){
	//发送Ajax请求添加
	var account = $("#cart_account").html();
    var goodsId = $("#cart_goodsId").html();
	var accountId = $("#cart_accountId").html();
	 $.ajax({
		 url:"addshopcart",
		 type:"post",
		 data : {	 
			 "account" : account,
			 "goodsId" : goodsId,
			 "accountId" : accountId,	  
			 },
			 success:function(result){
				alert("已成功收藏!");
			}
	 });
	} 
function aClick () {  
	
    alert("请先登录！");
}  
</script>
</html>