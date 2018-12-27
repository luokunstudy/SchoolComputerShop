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

<!--引入jquery  -->
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
<title>发布商品</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">	
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
</head>
<body class="templatemo-bg-gray">
	<div class="container" id="goodsale">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">发 布 商 品</h1>
			<div class="container">
			<form class="form-horizontal templatemo-payment-form templatemo-container" 
			role="form" action="computer/sale" method="post" id="tf"  onsubmit="return check();">	
				<hr>
				<div class="form-group">
		          		<div class="col-md-6">
		          			<label for="card_name" class="control-label">账号</label>
			            	<input type="text" class="form-control" id="card_account" name="account"
			            	 value=<%=s.getAttribute("member")%> readonly="readonly" style="border: 0px"/>
		          		</div>
		          		<div class="col-md-6">
				            <label for="card_number" class="control-label">商品名</label>
				            <input type="text" class="form-control" id="card_goodsName" placeholder="请填入商品名称" 
				            name="goodsName" onchange="checkaccount()">	   
				            <span id="checktext1" style="color:red"></span>          
				         </div>
				         </div>
				         <div class="form-group">
				         <div class="col-md-6">
				            <label for="card_number" class="control-label">商品图片</label>
				            <input type="file"  placeholder="" name="goodsPhone"
				            multiple="multiple"   >   	            
				         </div>
				         <div class="col-md-6">				         				         
					         <div class="templatemo-inline-group">
					         	<label class="control-label">商品类型</label>
					         	<div class="col-sm-12 templatemo-select-container">
					         		<select name="typeId" id="selecttype">
									</select> 
					         	</div>
							</div>
				         </div>				         
		          </div>          
				<div class="form-group">
					<div class="col-md-6">
						 <label for="card_number" class="control-label">发布时间</label>
				            <input type="text" class="form-control" id="getBookTime" name="relaseTime"  readonly="readonly" style="border: 0px">	            
			          </div> 
				</div>		
		        <div class="form-group">
		      
		          		<div class="col-md-6">
		          			<label for="card_name" class="control-label">商品现价</label>
			            	<input type="text" class="form-control" id="card_newprice" name="goodsPrice" 
			            	placeholder="请填入商品现价" onchange="checknewprice()">
			            	<span id="checktext2" style="color:red"></span>  
		          		</div>
		          		<div class="col-md-6">
				            <label for="card_number" class="control-label">商品原价</label>
				            <input type="text" class="form-control" id="card_oldprice" name="goodsOldprice" 
				            placeholder="请填入商品原价" onchange="checkoldprice()" >  
				            <span id="checktext3" style="color:red"></span>            
				         </div>
				         <div class="form-group">	
				</div>
				         <div class="col-md-6">
				         <div class="templatemo-radio-container">
							<label >
			          			<input type="radio" name="goodsCategory"  value="二手电脑" >二手电脑	
			          			<input type="radio" name="goodsCategory"  value="全新电脑" >全新电脑
			          		</label>
			          		<span id="checktext4" style="color:red"></span>  
						</div> 	
				           
				         </div>
                         <div class="col-md-6">
				                  <label >
			          			<input type="radio" name="tradeMode"  value="线上交易" >线上交易
			          			<input type="radio" name="tradeMode"  value="线下交易" >线下交易
			          			<input type="radio" name="tradeMode"  value="线上交易/线下交易" >线上交易/线下交易
			          			
			          		</label>   
			          		<span id="checktext5" style="color:red"></span>   
				         </div>				         
			       		                        
		        </div>
		        <div class="form-group">
					<div class="col-sm-12">
						
						 <label for="card_number" class="control-label">商品描述</label>
				            <textarea name="goodsDescribe" class="form-control" id="card_describe" 
				            placeholder="请填入商品描述内容" onchange="checkdescribe()"></textarea> 
							<span id="checktext6" style="color:red"></span>  
						
		          </div> 
				</div>	
				 <hr>
		        <div class="form-group">
			          <div class="col-md-5">
			            <input type="submit" value="Submit"   onclick="test();" class="btn btn-success btn-round">
			          </div>
			          <div class="col-md-5">
			            <input type="reset" value="reset"  class="btn btn-success btn-round">
			          </div>
			           <div class="col-md-2">
			           <div><a href="NewFile.jsp" style="height:35px">result</a></div>
			          </div>
			        </div>	
			       
		      </form>
		      </div>
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

	<script type="text/javascript">	
	/* 进入页面就执行 */
	$(function(){
	/* 	alert(789); */
		$.ajax({
			url : "${APP_PATH}/shop",
			type : "GET",
			success :function(result) {
				$("#goodsale select").children().remove();
				//测试	
				//console.log(result);
				//显示部门信息在下拉列表
				//如果有多个select可以使用id区分
				//   $("#empAddModal select").append("");					 
				$.each(result.extend.shop, function() {		
					/*  alert("12346");  */
					
					var optionEle = $("<option></option>").append(this.goodsType).attr("value", this.typeId);

					optionEle.appendTo("#goodsale select");
				});
			}
	});
	});
		function test(){
            var form = new FormData(document.getElementById("tf"));
//             var req = new XMLHttpRequest();
//             req.open("post", "${pageContext.request.contextPath}/public/testupload", false);
//             req.send(form);
            $.ajax({
                url:"${pageContext.request.contextPath}/computer/upload",
                type:"post",
                data:form,
                processData:false,  //processData 默认为false，当设置为true的时候,jquery ajax 提交的时候不会序列化 data，而是直接使用data
                contentType:false,
                success:function(data){
              //      window.clearInterval(timer);//clearInterval() 方法可取消由 setInterval() 函数设定的定时执行操作。
              //      console.log("over..");
                },
               /*  error:function(e){
                    alert("错误！！");
                    window.clearInterval(timer);
                } */
            });        
            get();//此处为上传文件的进度条
        }	    
	</script>
<script language="javascript">
function checkaccount() {  
    var check = false;  
    var goodsName = document.getElementById("card_goodsName").value;  
    if (goodsName=="") {  
        document.getElementById("checktext1").innerHTML = "  × 商品名不能为空";  
        check = false;  
    } else {  
        document.getElementById("checktext1").innerHTML = "  √";  
        check = true;  
    }  
    return check;  
}
function checknewprice() {  
    var check = false;  
    var goodsnewprice = document.getElementById("card_newprice").value;  
    if (goodsnewprice=="") {  
        document.getElementById("checktext2").innerHTML = "  × 商品原价不能为空";  
        check = false;  
    } else {  
        document.getElementById("checktext2").innerHTML = "  √";  
        check = true;  
    }  
    return check;  
}
function checkoldprice() {  
    var check = false;  
    var goodsoldprice = document.getElementById("card_oldprice").value;  
    if (goodsoldprice=="") {  
        document.getElementById("checktext3").innerHTML = "  × 商品现价不能为空";  
        check = false;  
    } else {  
        document.getElementById("checktext3").innerHTML = "  √";  
        check = true;  
    }  
    return check;  
}
/* function checkCategory() {  
    var check = false  
    if (!document.getElementsByName("goodsCategory").checked) {  
        document.getElementById("checktext4").innerHTML = "  × 请选择电脑类型";  
        check = false;  
    } else {  
        document.getElementById("checktext4").innerHTML = "";  
        check = true;  
  
    }  
    return check;  
  
}  */ 

/* function checkmode() {  
    var check = false  
    if (!document.getElementsByName("tradeMode").checked) {  
        document.getElementById("checktext5").innerHTML = "  × 请选择交易方式";  
        check = false;  
    }else {  
        document.getElementById("checktext5").innerHTML = "";  
        check = true;  
    }  
    return check;  
  
} */
function checkdescribe() {  
    var check = false;  
    var goodsoldprice = document.getElementById("card_describe").value;  
    if (goodsoldprice=="") {  
        document.getElementById("checktext6").innerHTML = "  × 请填写商品描述内容";  
        check = false;  
    } else {  
        document.getElementById("checktext6").innerHTML = "  √";  
        check = true;  
    }  
    return check;  
}
function check() {  
    var check = checkaccount()&&checknewprice()&& checkoldprice()&&checkCategory()&&checkmode()&&checkdescribe() ;  
    return check;  
  
}  

</script>
</body>
</html>