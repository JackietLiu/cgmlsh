<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<t:base type="jquery,easyui,tools,DatePicker"></t:base>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--ZCZSN 20180926200706 -->
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
<title>微信业主绑定</title>
<style type="text/css">
body {
	margin: 0px;
	background-image: url("images/sb.png");
	 background-size: 100% 100%;
}
.tdlabel
 {
 width: 26%; 
 text-align: right;
  font-size: 14px; 
  background: #378dcc;
   color: white;
   
 }
 .tdinput
 {
  width: 72%;
  height: 42px;
	font-size: 14px;    
 }
 
 .divtop{
		margin-top:5px;
	}
	.divs{
	float: left;
	width:30%;
	height:25px;
	text-align: center;
	border-bottom:1px dashed  green;
	margin-left:2px;
	}
	.divs1{
	float: left;
	width: 30%;
	height:25px;
	text-align: center;
	border-bottom:1px dashed  green;
	margin-left:2px;
	}
	.divs2{
	float: left;
	width:36%;
	height:25px;
	text-align: center;
	border-bottom:1px dashed  green;
	margin-left:2px;
	}
	.divstop{
	
	float: left;
	width:30%;
	height:25px;
	text-align: center;
	font-size: 14px;
	background-color: #FFF;
	margin-left:2px;
	}
</style>
<script type="text/javascript">

function nextClick(id) {   	    	 
		var finalaction ="tBWuyeGardenInfoController.do?wuyebind_undo" + "&id=" + id ;
		 
		$.ajax({
			cache:true,
			type:"post",
			url:finalaction,
			data:"",
			dataType:"json",
			success: function(data){	
				/* window.location.href="tBWuyeGardenInfoController.do?wuyebind; */
 				window.location.href="tBWuyeGardenInfoController.do?wuyebind";
			 
			},
		  error: function (data) {//ajax请求失败后触发的方法
			  window.location.href="tBWuyeGardenInfoController.do?wuyebind";
      	
      }
		})
	}
	

	function bind() {
		neibuClickFlag = true;
		var id = $('#hoursenor').val();
		var myopenid = $('#openid').val();
		$.ajax({
			cache : true,
			type : "post",
			url : "tBWuyeGardenInfoController.do?doBind&id="+id+"&openid=" +myopenid,
			data : "",
			dataType : "json",
			success : function(data) {
				/* swal(data.msg, "", "success"); */
				/* alert(JSON.stringify(data)); */
				if(data.id=='1'){
					alert(data.msg);
				}else{
					window.location.href="tBWuyeGardenInfoController.do?wuyebind&openid=" +myopenid ;
				}
				
			}
		})
	}	 

	  function search() {
		 $("#hoursenor").empty();
	    var gardenid = $('#gardenid').val();	    
	    var hourseno = $('#hourseno').val();	    
	   
	    $.ajax({
			cache:true,
			type:"get",
			url:"tBWuyeGardenInfoController.do?hourseselect&gardenid="+gardenid+"&hourseno=" +hourseno  ,
			//data:$('#formId').serialize(),
			dataType:"json",
			success: function(data){ 
				//alert(JSON.stringify(data));
				   $.each(data, function (index, value) { 			 
					 $("#hoursenor").append("<option value='" + data[index].id + "'>" + data[index].yezhu + "</option>");     
					/*  var optionObj = new Option(data[index].id, data[index].yezhu,false,false);
					// optionObj = new Option(text, value, false, true); //默认选中
					 document.getElementById('hourseno').options.add(optionObj);					
					/*  var sltObj = document.getElementById("hourseno"); //获取select对象
					 var optionObj = document.createElement("option"); //创建option对象
					 optionObj.value = data[index].id;
					 optionObj.innerHTML = data[index].yezhu;
					 optionObj.selected = false;//默认选中
					 sltObj.appendChild(optionObj);  //添加到select */
				   });					 
					//  $("#hourseno").append("<option value='" + data[index].id + "'>" + data[index].yezhu + "</option>");				
				   // $("#hourseno").append(options.join(''));					
			},
			error:function(data){				
				alert(data);
			}
		})	 
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
	<div class="wrap">
		<div style="padding-left: 2px; padding-right: 5px;">
			<form id="formId" name="formId"
				action="" method="post"
				style="margin-top: 9px;">
					<input type="hidden" style="width: 100%;  padding-left: 10px; margin-left: 3%; line-height: 42px; border-radius: 4px;"
							id="openid" name="openid" type="text" value='${openid }' />
				<table style="width: 98%;">
					<tr>
						<td	class="tdlabel">居住小区
						</td>
						<td style="width: 67%; height: 42px;">
						
					 	  <t:dictSelect
								field="gardenid" type="list" id="gardenid"
								defaultVal='${hourseentity.gardenid}'
								extendJson="{ class:'form-control',style:'width:100%;margin-left: 3% '}"
								dictTable="t_b_wuye_garden_info" dictField="id"
								dictText="gardenname"
								dictCondition=" where isactive ='1' and gardenname is not null and memo like '%开通微信缴费%' order by sortindex"
								typeGroupCode="oldmantype"  hasLabel="false" title="居住小区"></t:dictSelect>    
								 
							</td>
					</tr>
					<tr>
						<td rowspan="1"	class="tdlabel">楼(栋)号/房间号
						</td>
						<td style="width: 67%; height: 42px;">
							<input
							style="width: 72%; padding-left: 5px; 
								margin-left: 3%; line-height: 42px; border-radius: 4px;" 
							placeholder="103.102(代表103栋102室)" id="hourseno" name="hourseno" type="text" 
							value='${hourseentity.hourseno}' /> 
							<input
							style="margin-top: 3px;margin-left: 1px; font-size: 14px; color: white; width: 40px; line-height: 35px; border-radius: 4px; height: 30px; text-align: center; background: #378dcc;"
							type="button" value="查询" onclick="search();"> 							 
						</td>							 
					</tr>
					<!-- <tr>					 
						<td style="width: 67%; height: 42px;">							  
						<input
							style="margin-top: 3px;margin-left: 3%; font-size: 16px; color: white; width: 100%; line-height: 42px; border-radius: 4px; height: 42px; text-align: center; background: #378dcc;"
							type="button" value="查询" onclick="search();"> 
							</td>
					</tr> -->

					<tr>
						<td	class="tdlabel">查询结果
						</td>
						<td style="width: 67%; height: 42px;">
						
						<select  style="width:100%;margin-left: 3%" id="hoursenor" name="hoursenor">
													  
						</select>
						</td>
					</tr>
				</table>

				<table style="width: 100%;">
					<tr>
						<td
							style="width: 100%; text-align: center; background: #378dcc; color: white;">
							<input
							style="margin-top: 3px; font-size: 16px; color: white; width: 100%; line-height: 42px; border-radius: 4px; height: 42px; text-align: center; background: #378dcc;"
							type="button" value="绑定" onclick="bind();">

						</td>
					</tr>
				</table>
			
			</form>
		</div>

<hr>
  			<div class="divs" style="border-bottom:1px solid green;">小区名称</div>
  			<div class="divs1" style="border-bottom:1px solid green;">户号</div>
  			<div class="divs2" style="border-bottom:1px solid green;">操作</div>
  		<c:forEach items="${bindlist }" var="wuye" varStatus="status">
  		<div class="divtop">
  		<div class="divs">${wuye.gardenname}</div>
  		<div class="divs1">${wuye.hourseno} (${wuye.name})</div>
  		<div class="divs2"> 
  				<input
					style="margin-top: 0px; font-size: 18px; color: white; width: 100%; 
					line-height: 30px; border-radius: 1px; height: 30px; 
					text-align: center; background: #378dcc;"
					type="button" value="解除绑定" onclick="nextClick('${wuye.id}');">
  		</div>
  		</div>
  		</c:forEach>
		 
	</div>
</body>
</html>
