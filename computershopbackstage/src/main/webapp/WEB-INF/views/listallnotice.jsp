<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<title>所有公告</title>
<link href="../css/css.css" type="text/css" rel="stylesheet" />
<link href="../css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="../images/main/favicon.ico" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/js.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#searchmain{ font-size:12px;}
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(images/main/add.jpg) no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
#search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
#main-tab th{ font-size:12px; background:url(images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
#main-tab td{ font-size:12px; line-height:40px;}
#main-tab td a{ font-size:12px; color:#548fc9;}
#main-tab td a:hover{color:#565656; text-decoration:underline;}
.bordertop{ border-top:1px solid #ebebeb}
.borderright{ border-right:1px solid #ebebeb}
.borderbottom{ border-bottom:1px solid #ebebeb}
.borderleft{ border-left:1px solid #ebebeb}
.gray{ color:#dbdbdb;}
td.fenye{ padding:10px 0 0 0; text-align:right;}
.bggray{ background:#f9f9f9}
</style>
</head>
<body>
<%
String basePath="http://localhost:8080/computershop_demo";
%>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：公告管理</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form method="post" action="wordsTime">
	         <span>发布时间：</span>
	         <input type="text" name=wordsTime  class="text-word" style="color:gray">
	         <input  type="submit" value="查询" class="text-but">
	         </form>         
	         <form method="post" action="Querynoticetitle">
	         <span>公告标题：</span>
	         <input type="text" name=wordsTitle  class="text-word" style="color:gray">
	         <input  type="submit" value="查询" class="text-but">
	         </form>
         </td>
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"></td>
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
        <th align="center" valign="middle" class="borderright" style="text-align:center;">公告编号</th>
        <th align="center" valign="middle" class="borderright" style="text-align:center;">公告标题</th>
        <th align="center" valign="middle" class="borderright" style="text-align:center;">公告内容</th>
        <th align="center" valign="middle" class="borderright" style="text-align:center;">公告时间</th>
        <th align="center" valign="middle" style="text-align:center;">操作</th>
      </tr>
      <c:forEach items="${pageInfo.list}" var="listallnotice">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">${listallnotice.noticeId}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${listallnotice.wordsTitle}</td>
        <td align="center" valign="middle" class="borderright borderbottom">
        <textarea style="display: block;width:100%;height: 100%;border:0px;line-height:200%;" readonly="true">
         ${listallnotice.wordsContent} </textarea>
        </td>
        <td align="center" valign="middle" class="borderright borderbottom"><fmt:formatDate value="${listallnotice.wordsTime}" pattern="yyyy-MM-dd" /></td>
        <td align="center" valign="middle" class="borderbottom">&nbsp;
        <a href="Deletenotice?noticeId=${listallnotice.noticeId}" target="mainFrame" onFocus="this.blur()" class="add">删除</a></td>
      </tr>
      </c:forEach>
    </table></td>
    </tr>
<tr><td><h5>总计 ${pageInfo.getTotal()}条数据 当前第${pageInfo.pageNum}页，总共${pageInfo.pages}页&nbsp;&nbsp;</h5></td></tr>
</table>
<div class="col-md-3 col-md-offset-9">
<tr>
  <nav aria-label="Page navigation">
  <ul class="pagination">
     <li><a href="Queryallnotice?pn=1">首页</a></li>
    <li>
      <c:if test="${pageInfo.hasPreviousPage}">
      <a href="Queryallnotice?pn=${pageInfo.pageNum-1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a>
      </c:if>
    </li>
    <li>
    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum" >	
    <a href="Queryallnotice?pn=${pageNum}">${pageNum}</a> 
    </c:forEach>
    </li>
    <li>
    <c:if test="${pageInfo.hasNextPage}">
    <a href="Queryallnotice?pn=${pageInfo.pageNum+1}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
    </c:if>
    </li>
    <li><a href="Queryallnotice?pn=${pageInfo.pages}" target="mainFrame" onFocus="this.blur()">尾页</a></li>
  </ul>
</nav>
 </tr>
 </div>
</body>
</html>