<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!--ZCZSN 20180926200629 -->
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
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
.b{
	    width: 48%;
   		 float: left;
   		 line-height: 30px;
   		 border: 1px solid;
   		 border-radius: 4px;
}
.d{
	float: right;
    width: 48%;
    line-height: 30px;
    border: 1px solid;
    border-radius: 4px;
}
.er{
	padding-left: 2%;padding-right: 2%;margin-top: 20px;
}
.sel{
	background:#001EFF;
	color:white;
}
</style>
<script type="text/javascript">
 	function gojiaofei(id,gid,price,hourseno,appid){
 		$("#appid").val(appid);
 		$("[name='back']").removeClass("sel");
 		$("#"+id).addClass("sel");
 		/* $("#"+id).css("color","white"); */
 		$("#gid").val(gid);
 		$("#hourseno").val(hourseno);
 		$(".er").remove();
 		var str = "";
 		str+="<div class=\"er\"><div id=\"c1\" name=\"topay\" class=\"b\" onclick=\"gopay('c1','1')\" >一个月<br>"+parseFloat(1*price).toFixed(2)+"元</div><div id=\"c3\" class=\"d\" name=\"topay\"  onclick=\"gopay('c3','3')\" >三个月<br>"+parseFloat(3*price).toFixed(2)+"元</div><div id=\"c6\" class=\"b\" name=\"topay\"  style=\"margin-top: 5px;\" onclick=\"gopay('c6','6')\">半年<br>"+parseFloat(6*price).toFixed(2)+"元</div><div id=\"c12\" class=\"d\" name=\"topay\"  style=\"margin-top: 5px;\" onclick=\"gopay('c12','12')\">一年<br>"+parseFloat(12*price).toFixed(2)+"元</div></div>";
 		$("#month").append(str);
 	}
 	
 	
 	
 	function gopay(id,mon){
 		var appid = $("#appid").val();
 		$("[name='topay']").removeClass("sel");
 		$("#"+id).addClass("sel");
 		 hourseno=$("#hourseno").val();
 		/*window.location.href="tBWuyeGardenInfoController.do?goPay&gid="+$("#gid").val()+"&yue="+mon+"&hourseno="+hourseno;
 		 */
 		 //房间号+小区+每月价格
 		var STATE = hourseno+","+$("#gid").val()+","+mon;
 		 /*这里的appid还需要更换*/
 		/* window.location.href ="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+"&redirect_uri=http%3A%2F%2Fthezcz.tunnel.echomod.cn%2FpayController.do%3fwuYeOpenid&response_type=code&scope=snsapi_base&state="+STATE+"#wechat_redirect"; 
  */		window.location.href ="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+"&redirect_uri=http%3A%2F%2Fwww.jrshanyang.com%2FpayController.do%3fwuYeOpenid&response_type=code&scope=snsapi_base&state="+STATE+"#wechat_redirect"; 


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
	<c:if test="${not empty list }">
	<div style="font-size: 16px;margin-top: 15px;margin-left: 2%; height: 30px;line-height: 30px;">请选择需要缴费的小区：</div>
	<input id="gid" type="hidden" value=''/>
	<input id="appid" type="hidden" value=''/>
	<input id="hourseno" type="hidden" value=''/>
	<div style="overflow: hidden;padding-left: 2%;padding-right: 2%;">
			<c:forEach items="${list }" var="m"
			varStatus="sta">
						<c:if test="${sta.count%2==1 }">
						<div style="float: left;width: 48%;text-align: center;border: 1px solid;border-radius: 4px;" id="${sta.count }" name="back"  onclick="gojiaofei('${sta.count }','${m.gardenid }','${m.price }','${m.hourseno }','${m.appid }')"> 
							${m.gardenname }<br>(${m.hourseno })
						</div>
						</c:if>
						<c:if test="${sta.count%2!=1 }">
						<div style="float: right;width: 48%;text-align: center;border: 1px solid;border-radius: 4px;" id="${sta.count }" name="back" onclick="gojiaofei('${sta.count }','${m.gardenid }','${m.price }','${m.hourseno }','${m.appid }')">
							${m.gardenname }<br>(${m.hourseno })
						</div>
						</c:if>
					
			 </c:forEach>
	</div>
			 <div style="text-align: center" id="month">
			 				<!-- <div id="c1" class="b" onclick="gopay('1')" >一个月</div>
			 				<div id="c3" class="b" onclick="gopay('3')" >三个月</div>
			 				<div id="c6" class="b" onclick="gopay('6')">半年</div>
			 				<div id="c12" class="b" onclick="gopay('12')">一年</div> -->
			 </div>
			 

	</c:if>
	<c:if test="${empty list }">
			<div style="text-align: center;
    margin-top: 50%;
    font-size: 25px;">
				请先绑定小区后再进行缴费！
			</div>
	</c:if>
</body>
</html>
