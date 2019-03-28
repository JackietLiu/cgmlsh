<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!--ZCZSN 20180927110005 -->
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
 
<script type="text/javascript" src="plug-in/idcard/myidcard.js"></script>
 <link rel="stylesheet" href="myplug-in/mui/css/mui.min.css">
 <script type="text/javascript" src="myplug-in/mui/js/mui.min.js"></script>
 
<title>实名认证</title>
<style type="text/css">
body {
	margin: 0px;
	background-image: url("images/sb.png");
	 background-size: 100% 100%;
}
  	
</style>
<script type="text/javascript">
var neibuClickFlag = false;
function neibuClick() {
	neibuClickFlag = true;
	var actionurl = $('#formId').attr('action');//提交路径
	var finalaction = actionurl;
	var mobile = $('#mobile').val().trim();
	var ttt = $('#idcard').val().trim();
	var realname = $('#realname').val();
	 
	//var sex1 = $('#sex1').val().trim();
	 
	if (ttt !== null && ttt !== undefined && ttt !== ''
			&& ttt.length == 18) {
	}else{
		alert("请输入正确的身份证号码！");
		return false;
	}
	 
	 
	if(mobile=="" || mobile==null){
		alert("请输入手机号！");
		return false;
	}
	 
	$.ajax({
		cache:true,
		type:"post",
		url:finalaction,
		data:$('#formId').serialize(),
		dataType:"json",
		success: function(data){		
			mui.toast(data.msg);
			/* window.location.href="weixinSubscribeLocalController.do?personal"; */
			window.history.go(-1);
		}		
		
	})
}
 
 
$(document).ready(function(){
	var idcard = $("#idcard").val();
	
	/* var residencevillageid = $("#residencevillageid").val();
	if(residencevillageid=='vbgyjj'){
		$("#a1").removeClass("dis");
	} 
	
	$("#residencevillageid").change(function(){  
		var residencevillageid = $("#residencevillageid").val();
		if(residencevillageid=='vbgyjj'){
			$("#a1").removeClass("dis");
		}else{
			$("#a1").addClass("dis");
		}
		});*/
	
	if(idcard =='' ){
		$("#alertFram").css("display","none");
	}else{
		$("#alertFram").css("display","black");
		var title = "实名认证";
		var content = "您已实名认证过，是否修改？";

		$.Confirm(title,content).ok(function(){
		    //这是确定的回调
			$("#alertFram").css("display","none");
		}).cancel(function(){
		    //这是取消的回调
			/* window.location.href="weixinSubscribeLocalController.do?personal"; */
			window.history.go(-1);
		});
	}
	
	
})

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
	<div class="wrap">
		<div style="padding-left: 2px; padding-right: 5px;">
		<!-- 	<div id="a"
				style="margin-top: 19px; border-radius: 4px; width: 100%; height: 42px;
				 line-height: 42px; font-size: 12px; text-align: center; color: white; display: none"></div> -->
				 
		 


		<form id="formId" name="formId" method="post" action="weixinSubscribeLocalController.do?doUpdateReal" class="mui-input-group">
			 <div style="display:block;">
					<input id="id" name="id" type="text" class="form-control"
						value='${openid }' ignore="ignore" />
				</div>
					<div class="mui-input-row">
						<label>身份证号</label>
						<input id="idcard" name="idcard" type="text" value='${weixinSubscribeLocalPage.idcard}'
						 class="mui-input-clear"  onblur="test();" placeholder="请输入身份证号">
					</div>

					<div class="mui-input-row ">
						<label>姓名</label>
						<input type="text" id="realname" name="realname" value='${weixinSubscribeLocalPage.realname}' class="mui-input-clear" placeholder="请输入姓名">
					</div>
					
					<div class="mui-input-row">
						<label>手机号码</label>
						<input type="text" id="mobile" name="mobile"  
							value='${weixinSubscribeLocalPage.mobile}' 
							class="mui-input-clear" placeholder="请本人手机号码">
					</div>
					
					<div class="mui-button-row">
						<button type="button" class="mui-btn mui-btn-primary" onclick="neibuClick();">确认</button>&nbsp;&nbsp;
						<button type="button" class="mui-btn mui-btn-danger" onclick="return false;">取消</button>
					</div>
				 	
				 <%-- 	<tr>
				 		<td class="tdlabel">性别<span class="required">*</span>
				 		</td>
				 		<td>
				 		<t:dictSelect
								field="sex1" type="list" id="sex1"  defaultVal='${weixinSubscribeLocalPage.sex1}'
								extendJson="{class:'form-control',style:'width:100%;margin-left: 3% '}"
								typeGroupCode="sex" hasLabel="false" title="性别"></t:dictSelect>
								</td>
				 	</tr> --%>
			  
				
			</form>
		</div>

	 


</body>

</html>
