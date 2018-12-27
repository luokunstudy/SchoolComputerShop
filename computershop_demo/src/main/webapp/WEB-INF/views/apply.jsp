<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	HttpSession s = request.getSession();
%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<title>申请进入首页</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
<link href="../css/templatemo_style.css" rel="stylesheet" type="text/css">
<!--引入jquery  -->
<script type="text/javascript" src="../static/js/jquery-1.12.4.min.js"></script>
</head>
<body class="templatemo-bg-gray">
	<div class="container" id="goodsale">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">申请商品</h1>
			<form
				class="form-horizontal templatemo-payment-form templatemo-container"
				role="form" action="addapply" method="post">
				<p class="text-center">
					<br> <br>Please enter your goods information below.
				</p>
				<hr>
				<div class="form-group">
					<label class="col-sm-3 control-label">Apply Shopping</label>
					<div class="col-sm-9 templatemo-card-details">
						<div id="tsImgS">
							<a href="<%=basePath%>upload/${phones}" title="Images"
								class="MagicZoom" id="MagicZoom"> <img width="300"
								height="300" src="<%=basePath%>upload/${phones}" />
							</a>
						</div>
						
						<div class="col-md-12 form-group">
							<label for="card_name" class="control-label">Account</label> <input
								type="text" class="form-control"  name="account"
								value="${Apply.account}" readonly="readonly"
								style="border: 0px" />
						</div>
						
						<div class="col-md-12 form-group">
							<label for="card_name" class="control-label">GoodsId</label> <input
								type="text" class="form-control"  name="goodsId"
								value="${Apply.goodsId}" readonly="readonly"
								style="border: 0px" />
						</div>
						<div class="col-md-12 form-group">
							<label for="card_number" class="control-label">GoodsName</label>
							<input type="text" class="form-control"
								value="${Apply.goodsName}" readonly="readonly"
								style="border: 0px">
						</div>
						<div class="col-md-12 form-group">
							<label for="card_name" class="control-label">GoodsPrice</label> <input
								type="text" class="form-control" 
								value="${Apply.goodsPrice}" readonly="readonly"
								style="border: 0px">
						</div>
						
						<div class="col-md-12 form-group">
							<label for="card_name" class="control-label">Time</label> <input
								type="text" class="form-control"  name="applyTime"
								 readonly="readonly" id="getBookTime"
								style="border: 0px">
						</div>
						<div class="col-md-12 form-group">
				            <label for="card_number" class="control-label">GoodsDescribe</label>
				            <textarea name="applyDescribe" class="form-control"  placeholder="请填入商品描述内容"></textarea>            
				         </div>	
						<div class="col-md-12 form-group">
							<input type="text" class="form-control" id="card_name"
							 name="status"  readonly="readonly" value="0">
							 <!--  style="display:none" -->
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-9 col-sm-offset-3">
						<input type="submit" value="Submit" class="btn btn-success btn-round">
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
		window.onload = function() {
			function getDate() {
				debugger;
				var today = new Date();
				var date;
				date = (today.getFullYear()) + "-" + (today.getMonth() + 1)
						+ "-" + today.getDate();
				return date;
			}
			window.setInterval(function() {
				document.getElementById("getBookTime").value = getDate();
			}, 1000);
		}
	</script>
</body>
</html>