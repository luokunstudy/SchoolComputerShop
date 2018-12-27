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
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
</head>
<body class="templatemo-bg-gray">
	<div class="container" id="goodsale">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">发 布 需 求 信 息</h1>
			<form class="form-horizontal templatemo-payment-form templatemo-container" role="form" action="shop/needmessage" method="post"  id="tf" >	
				<hr>
				<div class="form-group">
		        	<label class="col-sm-3 control-label"></label>
		          	<div class="col-sm-9 templatemo-card-details">
		          		<div class="col-md-12 form-group">
		          			<label for="card_name" class="control-label">会员账号</label>
			            	<input type="text" class="form-control" id="card_name" name="account"
			            	 value=<%=s.getAttribute("member")%> readonly="readonly" style="border: 0px"/>
		          		</div>
		          		<div class="col-md-12 form-group">
				            <label for="card_number" class="control-label">商品名称</label>
				            <input type="text" class="form-control" id="card_number" placeholder="请填入商品名称" name="goodsName">	            
				         </div>		         
			         </div>			                        
		        </div>
					
		        <div class="form-group">
		        	<label class="col-sm-3 control-label"></label>
		          	<div class="col-sm-9 templatemo-card-details">
				         <div class="form-group">
					
					
				</div>
				         <div class="col-md-12 form-group">
				            <label for="card_number" class="control-label">发布时间</label>
				            <input type="text" class="form-control" id="getBookTime" name="relaseTime"  readonly="readonly" style="border: 0px">	            
				         </div>
                         <div class="col-md-12 form-group">
				            <label for="card_number" class="control-label">商品描述</label>
				            <textarea name="goodsDescribe" class="form-control" id="card_number" placeholder="请填入商品描述内容"></textarea>            
				         </div>		
				         <div class="col-md-12 form-group">
				            <label for="card_number" class="control-label">联系方式</label>
				            <input type="text" class="form-control" id="card_number" placeholder="请填入联系方式" name="contact">            
				         </div>			         
			         </div>			                        
		        </div>
		        <div class="form-group">
					<label class="col-sm-3 control-label"></label>
					<div class="col-sm-9">
						<div class="templatemo-radio-container">
							<label >
			          			<input type="radio" name="tradeMode" id="optionsRadios1" value="线上交易">线上交易
			          			<input type="radio" name="tradeMode" id="optionsRadios1" value="线下交易">线下交易
			          			<input type="radio" name="tradeMode" id="optionsRadios1" value="线上交易/线下交易">线上交易/线下交易
			          			
			          		</label>
						</div>
			          	
			          </div> 
				</div>	
		        <div class="form-group">
			          <div class="col-sm-9 col-sm-offset-3">
			            <input type="submit" value="Submit" onclick="test();" class="btn btn-success btn-round">
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