<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!--ZCZSN  20180926194747-->
<t:base type="jquery"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />

<script type="text/javascript"
	src="webpage/com/shanyang/alertJs/sweetalert/sweetalert-dev.js"></script>
<script type="text/javascript" src="plug-in/idcard/myidcard.js"></script>

<link rel="stylesheet" type="text/css"
	href="webpage/com/shanyang/alertJs/sweetalert/sweetalert.css">
<title>物业缴费</title>
<style type="text/css">
body {
	margin: 0px;
	background-image: url("images/sb.png");
	 background-size: 100% 100%;
}

.a{
	background-color: #cccccc;
}
.c{
	background-color: #cccccc;
}

.span1{
	color:#cccccc;display:inline-block;padding-left:2%;
	font-size: 16px;
}
.span2{
	display:block;padding-right: 2%;font-weight: bold;float: right;
	font-size: 16px;
}
.div1{
	height:40px;
	line-height: 40px;
}
</style>

<script type="text/javascript">
/* function gopay(){
	
	
	

	//房间号+小区+每月价格
	var STATE = ${hoursemodel.hourseno }+","+${hoursemodel.gardenid }+","+${yue};
 
	
	//跨域（可跨所有域名） 
	
	
	
	 $.ajax({
		type:"get",
		url:url,
		dataType:"jsonp",
		jsonp:"callback",
		success: function(data){
			alert(data.appid);
		},
		error:function(data){
			alert(1);
			alert(JSON.stringify(data));
		}
		
	}); 
	
	 window.location.href=url; 
} */

function onBridgeReady(){
	
	var appid = $("#appid").val();
	var timeStamp = $("#timeStamp").val();
	var nonceStr = $("#nonceStr").val();
	var Package1 = $("#package1").val();
	var paySign = $("#paySign").val();
	
	   WeixinJSBridge.invoke(
	       'getBrandWCPayRequest', {
	           "appId":appid,     //公众号名称，由商户传入     
	           "timeStamp":timeStamp,         //时间戳，自1970年以来的秒数     
	           "nonceStr":nonceStr, //随机串     
	           "package":Package1,     
	           "signType":"MD5",         //微信签名方式     
	           "paySign":paySign //微信签名 
	       },
	       function(res){     
	           if(res.err_msg == "get_brand_wcpay_request:ok" ) {
	        	   	//支付之后的页面跳转	
	        	  	 $.ajax({
	        	   		cache:false,
	        	   		type:"post",
	        	   		url:"payController.do?addRecord",
	        	   		data:$('#formId').serialize(),
	        	   		dataType:"text",
	        	   		success:function(data){
	        	   		 alert("支付成功");
	        	   		},
	        	   		error:function(data){
	        	   			alert(JSON.stringify(data));
	        	   			alert("保存出错！");
	        	   		}
	        	   	});  
	        	   	
	        	   	//回调URL
	        	   /* 	window.location.href="payController.do?callback";  */
	           }else{
	        	   var msg = "支付失败，是否重新支付";
	        	/*  if(confirm(msg)==true){
	        		 pay();
	        	 } */
	        	   
	        	   alert("支付失败");
	           }
	           
	       } // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
	   ); 
	}

function pay(){
	if (typeof WeixinJSBridge == "undefined"){
		   if( document.addEventListener ){
		       document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
		   }else if (document.attachEvent){
		       document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
		       document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
		   }
	}else{
		onBridgeReady();
	}
}



</script>
</head>
<body>
	 <!-- zczforreturn --> 
 <link href="plug-in/mystick/style.css" rel="stylesheet" type="text/css" />
 <div id="rightArrow" style="width:40px;height:25px;background:url(plug-in/mystick/online_arrow.png)  no-repeat;background-size:40px 25px;
 		position:fixed;top:1%;left:0px;  "><a href="javascript:window.history.go(-1);  "  ></a></div>
		<!-- width:50px;height:45px;background:url(plug-in/mystick/online_arrow.jpg) no-repeat;
 		position:fixed;top:45%;right:-5px;  --> 
 </div>
 <!-- zczforreturn --> 
	<div style="padding-left:2%;padding-right:2%;">
		<div style="margin-top: 20px;" class="div1">
			<span class="span1" >收款物业名称	</span>
			<span class="span2" >${hoursemodel.companyname } </span>
		</div>
		<div class="div1" >
			<span class="span1" >
			小区名称</span>
			<span class="span2" >${hoursemodel.gardenname }</span>
		</div>
		
		<div class="div1">
			<span class="span1" >
			楼宇房间号</span>
			<span class="span2" >${hoursemodel.hourseno }</span>
		</div>
		
		<div class="div1">
			<span  class="span1">
			户主</span>
			<span class="span2" >${hoursemodel.name }</span>
		</div>
		<div class="div1">
			<span  class="span1">
			物业交至日期</span>
			<span class="span2" ><fmt:formatDate value="${hoursemodel.years }" type="date" pattern="yyyy-MM"/></span>
		</div>
		<hr>
		<div style="height: 100px;line-height: 100px;">
			<span class="span1" >
			缴费金额</span>
			<span class="span2" ><span style="font-size: 30px">${hoursemodel.price }</span>元</span>
		</div>
		
		<div style="text-align: center; width: 100%;">
			<button  onclick="pay()" style="border:1px solid black;width: 100%; height: 50px;font-size: 20px;line-height: 50px;background-color: #4D83EE;color: white;border-radius: 5px;">确认支付</button>
		</div>
	</div>
	
	
	
	<div>
		<input id="appid" value="${dp.appId }"  type="hidden"/>
		<input id="timeStamp" value="${dp.timeStamp }" type="hidden" />
		<input id="nonceStr" value="${dp.nonceStr }" type="hidden"/>
		<input id="package1" value="${dp.package1 }" type="hidden"/>
		<input id="paySign" value="${dp.paySign }" type="hidden"/>
	</div>
	 <%-- <div>
		appid111<input id="appid" value="${dp.appId }" />
		timeStamp222<input id="timeStamp" value="${dp.timeStamp }"  />
		nonceStr333<input id="nonceStr" value="${dp.nonceStr }" />
		package1444<input id="package1" value="${dp.package1 }" />
		paySign555<input id="paySign" value="${dp.paySign }" />
	</div> --%>
	<div>
		<input id="yue" value="${yue }"  type="hidden"/>
	</div>
	<form id="formId" action="">
		<!-- openid: --><input name=openidfrom value="${weixinsubloc.id }"  type="hidden"/>        
		<!-- 真名： --><input name="namefrom" value="${weixinsubloc.realname }"  type="hidden"/>   
		<!-- 商户号 --><input name="mchidto" value="${tbcompany.mchid }"  type="hidden"/>   
		<!-- 商户名称： --><input name="nameto" value="${hoursemodel.companyname }" type="hidden"  />   
		<!-- 金额 --><input name="je" value="${hoursemodel.price }" type="hidden" />  
		<!-- 时长： --><input name="months" value="${months }" type="hidden" />   
		<!-- 订单号： --><input name="outtradeno" value="${outtradeno }" type="hidden" />   
		<!-- 房间号： --><input name="houseno" value="${hoursemodel.hourseno }" type="hidden" />  
		<!-- 小区号： --><input name="gardenid" value="${hoursemodel.gardenid }" type="hidden" />  
	</form>
	
	
	
	
	
		<%-- 收款物业名称：${wuyecompany.companyname }<br>
	小区名称：${hoursemodel.gardenname }<br>
	楼宇房间号：${hoursemodel.hourseno }<br>
	户主：${hoursemodel.hourseno }<br>
	缴费金额：${hoursemodel.price }<br> --%>
	<%-- <table>
		<tr>
		<td>收款物业名称：</td><td>${wuyecompany.companyname }
		</tr>
		<tr><td>小区名称：</td><td>${hoursemodel.gardenname }</td></tr>
		<tr><td>楼宇房间号：</td><td>${hoursemodel.hourseno }</td></tr>
		<tr><td>户主：</td><td>${hoursemodel.name }</td></tr>
		<tr>
		<td>缴费金额：</td><td>${hoursemodel.price }</td></tr>
	</table> --%>
	
	<%-- <div id="appid">${appId }</div>
	<div id="timeStamp">${timeStamp }</div>
	<div id="nonceStr">${nonceStr }</div>
	<div id="package1">${package }</div>
	<div id="paySign">${paySign }</div>
	<button onclick="pay()">支付</button> --%>
</body>
</html>
