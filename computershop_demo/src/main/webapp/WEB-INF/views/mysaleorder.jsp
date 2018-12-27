<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>校园电脑商品</title>
<link type="text/css" href="../css/css.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/js.js"></script>
<script src="../js/wb.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
 $(function(){
	 $(".vipNav dd:first").show();
	 })
</script>
</head>
<%
	HttpSession s = request.getSession();
%>
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
   <h1 class="logo"><a href="index.html"><img src="../images/LOGO.png" width="217" height="90" /></a></h1>
   <form action="vagueselect" method="get" class="subBox">
    <div class="subBoxDiv">
     <input type="text" name="goodsName" class="subLeft" />
     <input type="image" src="../images/subimg.png" width="63" height="34" class="sub" />
     <div class="hotWord">
     大家都在找：
       <c:forEach items="${alltype}" var="alltype">  
        <a href="listshop?typeId=${alltype.typeId}">${alltype.goodsType}</a>&nbsp;
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
    </div><!--gouCar/-->

   </div><!--gouwuche/-->
  </div><!--lsg/-->
  <div class="pnt">
   <div class="pntLeft">
   
   </div><!--pntLeft/-->
   <div class="pntRight">
    <ul class="nav">
    <li><a href="../NewFile.jsp">商城首页</a></li>
    <li><a href="listnewcomputer?goodsCategory=1">全新电脑</a></li>
	<li><a href="listnewcomputer?goodsCategory=2">二手电脑</a></li>
	<li><a href="shopneedmessage">需求电脑</a></li>
	<li class="navCur"><a href="personal?account=<%=s.getAttribute("member")%>">会员中心</a></li>
     <div class="clears"></div>
     <div class="phone">TEL：021-12345678</div>
    </ul><!--nav/-->
   </div><!--pntRight/-->
   <div class="clears"></div>
  </div><!--pnt/-->
  <div class="positions">
   当前位置：<a href="#">首页</a> &gt; <a href="#">会员中心</a>&gt;
  </div><!--positions/-->
  <div class="cont">
   <div class="contLeft" id="contLeft">
    <h3 class="leftTitle">会员中心</h3>
    <dl class="helpNav vipNav">
     <dt>我的主页</dt>
      <dd>
       <a href="personal?account=<%=s.getAttribute("member")%>" >个人中心</a>
       <a href="vipshopcartinfo?accountId=<%=s.getAttribute("member")%>">我的收藏</a>
       <a href="Myshoping?account=<%=s.getAttribute("member")%>">我的商品</a>
       <a href="querysaleorder?account=<%=s.getAttribute("member")%>" class="vipCur">我的销售订单</a>
       <a href="querybuyorder?accountId=<%=s.getAttribute("member")%>">我的购买订单</a>
      </dd>
     <dt>账户设置</dt>
      <dd>
       <a href="getmember?account=<%=s.getAttribute("member")%>">个人信息修改</a>
      </dd>    
    </dl><!--helpNav/-->
   </div><!--contLeft/-->
   <div class="contRight">
   
    <%
						String path = request.getContextPath();
						String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
								+ path + "/";
					%>
      <table class="orderList">
    <tr>
     <th width="350">商品</th>
     <th width="135">买家</th>
     <th width="135">数量</th>
     <th width="135">交易地址</th>
    </tr>
     <c:forEach items="${pageInfo.list}" var="pageInfo">
    <tr>
     <td>
      <dl>
       <dt><a href="#"><img src="<%=basePath%>upload/${pageInfo.goods.goodsPhone}" width="85" height="85" /></a></dt>
       <dd>${pageInfo.goods.goodsName}<br /></dd>
      </dl>
     </td>
     <td><strong class="red">${pageInfo.accountId}</strong></td>
     <td><strong >${pageInfo.number}</strong></td>
     <td><strong >${pageInfo.address}</strong></td>
    </tr>
    </c:forEach>
   </table><!--orderList/-->
    <br/>
    <br/>
   </div><!--contRight/-->
   <div class="clears"></div>
   <!-- 显示分页信息块 -->
					<div class="scott">
						<!-- 显示分页信息文字 -->
						<div class="inHelp1">
						<h5>当前第${pageInfo.pageNum}页，总共${pageInfo.pages}页</h5>
						</div>
						<br>
						<!-- 显示分页条 -->
						<a href="querysaleorder?account=<%=s.getAttribute("member")%>&pn=1">首页</a>
						<c:if test="${pageInfo.hasPreviousPage}">
						<a href="querysaleorder?account=<%=s.getAttribute("member")%>&pn=${pageInfo.pageNum-1}">&laquo;</a>
						</c:if> 
						<c:forEach items="${pageInfo.navigatepageNums}" var="pageNum" >	
						<a href="querysaleorder?account=<%=s.getAttribute("member")%>&pn=${pageNum}">${pageNum}</a> 
						</c:forEach>
						<c:if test="${pageInfo.hasNextPage}">
						<a href="querysaleorder?account=<%=s.getAttribute("member")%>&pn=${pageInfo.pageNum+1}">&raquo;</a>
						</c:if>  
						<a href="querysaleorder?account=<%=s.getAttribute("member")%>&pn=${pageInfo.pages}">尾页</a>
					</div>
                   <br>
  </div><!--cont/-->
   <div class="inHelp">
   <div class="inHLeft">
    <h4>帮助中心</h4>
   <ul class="inHeList">
     <li><a href="#">购物指南</a></li>
     <li><a href="#">支付方式</a></li>
     <li><a href="#">售后服务</a></li>
     <li><a href="#">企业简介</a></li>
     <div class="clears"></div>
    </ul><!--inHeList/-->
   </div><!--inHLeft/-->
   <div class="inHLeft">
    <h4>会员服务</h4>
   <ul class="inHeList">
     <li><a href="#">会员注册</a></li>
     <li><a href="#">会员登录</a></li>
     <li><a href="#">购物车</a></li>
     <li><a href="#">我的订单</a></li>
     <div class="clears"></div>
    </ul><!--inHeList/-->
   </div><!--inHLeft/-->
   <div class="inHRight">
    <h4>全国统一免费服务热线</h4>
    <div class="telBox">400-0000-0000</div>
    <div class="weibo">
    <wb:follow-button uid="2991975565" type="red_1" width="67" height="24" ></wb:follow-button>
    </div>
   </div><!--inHRight/-->
   <div class="clears"></div>
  </div><!--inHelp/-->
  <div class="footer">
   <p>
   <a href="#">进入17官网</a>&nbsp;|&nbsp;
   <a href="#">商城首页</a>&nbsp;|&nbsp;
   <a href="#">促销中心</a>&nbsp;|&nbsp;
   <a href="#">我的订单</a>&nbsp;|&nbsp;
   <a href="#">新闻动态</a>&nbsp;|&nbsp;
   <a href="#">会员中心</a>&nbsp;|&nbsp;
   <a href="#">帮助中心</a>
   </p>
  </div><!--footer/-->
 </div><!--mianCont/-->
 <a href="#" class="backTop">&nbsp;</a>
</body>
</html>