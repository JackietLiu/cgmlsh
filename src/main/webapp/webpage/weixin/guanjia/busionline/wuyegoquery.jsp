<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--ZCZSN 20180926200647 -->
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
<title>物业服务查询</title>
<style type="text/css">
body {
	margin: 0px;
	background-image: url("images/sb.png");
	 background-size: 100% 100%;
}

.mytdlabel{
 width: 22%;
  border-radius:4px;
   text-align: right; 
   font-size: 14px;
}
.mytdcontent{
 width: 79%;
  border-radius:4px;
   text-align: left; 
   padding-left:20px;
   font-size: 14px;
}


</style>
<script type="text/javascript">
function goSearch() {	  
	var gardenname = $('#gardenname').val();
	
	window.location.href = 'tBWuyeGardenInfoController.do?wuyegoquery&gardenname='+gardenname
}	 

	/*   function search() {
	    var gardenid = $('#gardenid').val();
	    var hourseno = $('#hourseno').val();	    
	   
	    $.ajax({
			cache:true,
			type:"get",
			url:"tBWuyeGardenInfoController.do?hourseselect&gardenid="+gardenid+"&hourseno=" +hourseno  ,
			//data:$('#formId').serialize(),
			dataType:"json",
			success: function(data){	
				alert(JSON.stringify(data));
				   $.each(data, function (index, value) { 
				 
					 $("#hoursenor").append("<option value='" + data[index].id + "'>" + data[index].yezhu + "</option>");     
				 
				   });
			},
			error:function(data){				
				alert(data);
			}
		})
	 
	 }  */
</script>
</head>
<body>
 <!-- zczforreturn --> 
 <link href="plug-in/mystick/style.css" rel="stylesheet" type="text/css" />
 <div id="rightArrow" style="width:40px;height:25px;background:url(plug-in/mystick/online_arrow.png)  no-repeat;background-size:40px 25px;
 		position:fixed;top:10%;left:0px;  "><a href="javascript:window.history.go(-1);  "  ></a></div>
		<!-- width:50px;height:45px;background:url(plug-in/mystick/online_arrow.jpg) no-repeat;
 		position:fixed;top:45%;right:-5px;  --> 
 </div>
 <!-- zczforreturn --> 
	<div class="wrap">
		<div style="padding-left: 2px; padding-right: 5px;">
			<form id="formId" name="formId"
				action="" method="post"
				style="margin-top: 9px;">
					<%-- <input type="hidden" style="width: 100%;  padding-left: 10px; margin-left: 3%; line-height: 42px; border-radius: 4px;"
							id="openid" name="openid" type="text" value='${openid }' /> --%>
				<table style="width: 100%;">
						 
					<tr>
						<td 
							style="width: 20%; border-radius:4px; text-align: center; font-size: 14px; background: #378dcc; color: white;">小区名称
						</td>
						<td style="width: 60%; height: 30px;">
							<input
							style="width: 100%;font-size: 14px; padding-left: 10px; margin-left: 3%; line-height: 42px; border-radius: 4px;"
							id="gardenname" name="gardenname" type="text" value='${gardenname}' placeholder="请输入小区名称或物业公司名称" />
						</td>							 
						<td style="width: 20%; height: 30px;">							  
						<div
							style="margin-left: 20%;  color: white; width: 30px; border-radius: 4px; height: 30px;  background-image: url(images/serch.jpg);background-size: 100% 100%;"
							  onclick="goSearch();"> </div>
							</td>
					</tr>				
				</table> 
			</form>
			<table  style="width: 100%;">
			<c:forEach items="${list }" var="m">	
			
			<tr>
				<td class="mytdlabel">物业公司</td>
				<td class="mytdcontent">${m.companyname}</td>
			</tr>
			<tr>
				<td class="mytdlabel">小区名称</td>
				<td class="mytdcontent">${m.gardenname}</td>
			</tr>
			<tr>
				<td class="mytdlabel">小区经理</td>
				<td class="mytdcontent">${m.gardenmanager} </td>
			</tr>
			<tr>
				<td class="mytdlabel">联系电话</td>
				<td >
					<a style="font-size: 22px;padding-left:20px;" href="tel:${m.gardenmangertel}" >
					     ${m.gardenmangertel}
					</a> 
				</td>
			</tr>
			<tr>
				<td class="mytdlabel">服务台电话</td>
				<td >				 
				<a  style="font-size: 22px; padding-left:20px;" href="tel:${m.servicetel}" >
				      ${m.servicetel}
				 </a> 
				</td>
			</tr>
				<%-- <tr>
				<td class="mytdlabel">管理部地址</td>
				<td class="mytdcontent">${m.addressmanager} </td>
			</tr> --%>
			<tr>
				<td colspan="2"><hr/></td>
			</tr>
							 
		 
	</c:forEach>
			
		</table>	
			
		</div>

		<div style="margin-top: 35px; border-bottom: 1px solid #f5f6f7;"></div>
	</div>
</body>
</html>
