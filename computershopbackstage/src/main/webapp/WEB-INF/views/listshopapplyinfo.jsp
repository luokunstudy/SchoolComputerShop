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
<title>商品申请信息</title>
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
<!--模态框部分  -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">商品信息审核</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
        <!--图片  -->
                        <div class="form-group">
							<label class="col-sm-3 control-label"></label>
							<div class="col-sm-9">
								<!--input里的name要与bean的一致  -->
								<input type="text" class="form-control"
									 placeholder="这里是图片" width="85" height="85"> 
									 <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">申请账号：</label>
							<div class="col-sm-9">
								<!--input里的name要与bean的一致  -->
								<input type="text" name="email" class="form-control"
									 placeholder="请填入邮箱"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">商品名称：</label>
							<div class="col-sm-9">
								<!--input里的name要与bean的一致  -->
								<input type="text" name="email" class="form-control"
									 placeholder="请填入邮箱"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">申请时间：</label>
							<div class="col-sm-9">
								<!--input里的name要与bean的一致  -->
								<input type="text" name="email" class="form-control"
									id="email_update_input" placeholder="请填入邮箱"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">申请描述：</label>
							<div class="col-sm-9">
								<!--input里的name要与bean的一致  -->
								<textarea type="text" name="email" class="form-control" 
								style="overflow:hidden;width:200px;white-space:nowrap;text-overflow:ellipsis;table-layout: fixed;"
									placeholder="请填入邮箱"></textarea>
									 <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">状态：</label>
							<div class="col-sm-9">
								<!--input里的name要与bean的一致  -->
								<input type="text" name="email" class="form-control"
									id="email_update_input" placeholder="请填入邮箱"> <span
									class="help-block"></span>
							</div>
						</div>
					</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default btn-lg" data-dismiss="modal">关闭</button>        
        <button type="button" class="btn btn-primary btn-lg active">保存</button>
      </div>
    </div>
  </div>
</div>
<!--模态框部分  -->
<%
String basePath="http://localhost:8080/computershop_demo";
%>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：商品申请信息管理</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form method="post" action="QueryapplygoodsName">
	         <span>申请商品名称：</span>
	         <input type="text" name="goodsName"  class="text-word" style="color:gray">
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
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab" style="table-layout:fixed">
      <tr>
        <th align="center" valign="middle" class="borderright" style="text-align:center;">申请信息编号</th>
        <th align="center" valign="middle" class="borderright" style="text-align:center;">申请者账号</th>
        <th align="center" valign="middle" class="borderright" style="text-align:center;">申请商品名称</th>
        <th align="center" valign="middle" class="borderright" style="text-align:center;">申请商品图片</th>
        <th align="center" valign="middle" class="borderright" style="text-align:center;">申请时间</th>
        <th align="center" valign="middle" class="borderright" style="text-align:center;">申请描述</th>       
        <th align="center" valign="middle" class="borderright" style="text-align:center;">状态码</th>
        <th align="center" valign="middle" style="text-align:center;">操作</th>
      </tr>
      <c:forEach items="${pageInfo.list}" var="listallapplyinfo">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">${listallapplyinfo.applyId}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${listallapplyinfo.account}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${listallapplyinfo.goods.goodsName}</td>
        <td align="center" valign="middle" class="borderright borderbottom"><img src="<%=basePath%>/upload/${listallapplyinfo.goods.goodsPhone}" width="85" height="85" /></td>
        <td align="center" valign="middle" class="borderright borderbottom"><fmt:formatDate value="${listallapplyinfo.applyTime}" pattern="yyyy-MM-dd" /></td>
        <td align="center" valign="middle" class="borderright borderbottom" style="text-overflow:ellipsis">
         <textarea style="display: block;width:100%;height: 100%;border:0px;line-height:200%;" readonly="true">
        ${listallapplyinfo.applyDescribe}</textarea></td>
        <td align="center" valign="middle" class="borderright borderbottom">${listallapplyinfo.status}</td>  
        <td align="center" valign="middle" class="borderbottom">&nbsp;</span>
        <a href="deleteapply?applyId=${listallapplyinfo.applyId}" target="mainFrame" onFocus="this.blur()" class="add">删除</a> &nbsp;|&nbsp;
        <a href="applyinfo?applyId=${listallapplyinfo.applyId}" target="mainFrame" onFocus="this.blur()" class="add" >审核</a>
       <!--href="applyinfo?applyId=${listallapplyinfo.applyId}"  -->
        </td>
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
     <li><a href="Queryallapply?pn=1">首页</a></li>
    <li>
      <c:if test="${pageInfo.hasPreviousPage}">
      <a href="Queryallapply?pn=${pageInfo.pageNum-1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a>
      </c:if>
    </li>
    <li>
    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum" >	
    <a href="Queryallapply?pn=${pageNum}">${pageNum}</a> 
    </c:forEach>
    </li>
    <li>
    <c:if test="${pageInfo.hasNextPage}">
    <a href="Queryallapply?pn=${pageInfo.pageNum+1}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
    </c:if>
    </li>
    <li><a href="Queryallapply?pn=${pageInfo.pages}" target="mainFrame" onFocus="this.blur()">尾页</a></li>
  </ul>
</nav>
 </tr>
 </div>

</body>
</html>