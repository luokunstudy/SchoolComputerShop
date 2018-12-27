<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧导航menu</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/sdmenu.js"></script>
<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	// ]]>
</script>
<style type=text/css>
html{ SCROLLBAR-FACE-COLOR: #538ec6; SCROLLBAR-HIGHLIGHT-COLOR: #dce5f0; SCROLLBAR-SHADOW-COLOR: #2c6daa; SCROLLBAR-3DLIGHT-COLOR: #dce5f0; SCROLLBAR-ARROW-COLOR: #2c6daa;  SCROLLBAR-TRACK-COLOR: #dce5f0;  SCROLLBAR-DARKSHADOW-COLOR: #dce5f0; overflow-x:hidden;}
body{overflow-x:hidden; background:url(images/main/leftbg.jpg) left top repeat-y #f2f0f5; width:194px;}
</style>
</head>
<body onselectstart="return false;" ondragstart="return false;" oncontextmenu="return false;">
<div id="left-top">
	<div><img src="images/main/member.gif" width="44" height="44" /></div>
    <span>用户：admin<br>角色：超级管理员</span>
</div>
    <div style="float: left" id="my_menu" class="sdmenu">
      <div>
        <span>商品管理</span>
        <a href="backstage/Queryallshop" target="mainFrame" onFocus="this.blur()">商品信息</a>
        <a href="shopneedmessage/Queryallshopneedinfo" target="mainFrame" onFocus="this.blur()">商品需求信息</a>
        <a href="shopapplymessage/Queryallapply" target="mainFrame" onFocus="this.blur()">商品申请信息</a>
      </div>
      <div>
        <span>商品类型管理</span>
         <a href="addshoptype.jsp" target="mainFrame" onFocus="this.blur()">添加商品类型</a>
         <a href="goodstype/qureryalltype" target="mainFrame" onFocus="this.blur()">查看商品类型</a>
      </div>
      <div>
        <span>会员管理</span>
        <a href="member/queryallmember" target="mainFrame" onFocus="this.blur()">会员信息</a>
      </div>
      <div>
        <span>公告管理</span>
        <a href="addnotice.jsp" target="mainFrame" onFocus="this.blur()">发布公告</a>
        <a href="notice/Queryallnotice" target="mainFrame" onFocus="this.blur()">查看公告</a>
      </div>
        <div>
        <span>留言管理</span>
        <a href="Words/Queryallwords" target="mainFrame" onFocus="this.blur()">留言信息</a>
      </div>
    </div>
</body>
</html>