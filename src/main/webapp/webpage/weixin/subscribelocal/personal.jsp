<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <!--ZCZSN 20180926213639 -->
 <meta name="viewport"
	content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" />
<meta name="apple-mobile-web-app-capable" content="yes" /> 
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
  <title>个人中心</title>
   <style type="text/css">
    body{margin: 0px;
    background-image: url("images/sb.png");
	 background-size: 100% 100%;
    }
 
   </style>
   <script type="text/javascript">
   
  /*  document.addEventListener('visibilitychange',()=>{
	   if(document.visibilityStatr == 'hidden'){
		   call('userLeave',{
			   window.href.location = "tBScoreInfoController.do?listmobile";
		   });
	   }
   }) */
   
   
   /* window.onbeforeunload = function(){
	  alert(111);
	  return "quit?";
  } */
   
   	function tbscore(){
   		var openid=$("[name=openid]").val();
   		$.ajax({
   			cache:true,
            type: "post",//数据发送的方式（post 或者 get）
            url: "tbscoreDetailController.do?instsss",//要发送的后台地址
           data:{openid:openid},
            dataType: "json",//后台处理后返回的数据格式
            success: function (data) {//ajax请求成功后触发的方法
            	alert(data.msg);
           		/*  alert(JSON.stringify(data)); */
	            if(data.attributes.score!=undefined){
	           		/*  alert(data.attributes.score); */
	           		 $("#jifen").text(data.attributes.score);
	            }
            },
            error: function (data) {//ajax请求失败后触发的方法
            	alert(data.msg);
            	
            }
        });

   	}
   </script>
   
<style>
	html, body {
		color: #222;
		font-family: Microsoft YaHei, Helvitica, Verdana, Tohoma, Arial,
			san-serif;
		margin: 0;
		padding: 0;
		text-decoration: none;
	}
	
	img {
		border: 0;
	}
	
	ul {
		list-style: none outside none;
		margin: 0;
		padding: 0;
	}
	
	/* body {
		background-color: #eee;
	} */
	
	body .mainmenu:after {
		clear: both;
		content: " ";
		display: block;
	}
	
	body .mainmenu li {
		float: left;
		/* margin-left: 2.5%;
		margin-top: 2.5%; */
		width: 32.999%;
		/* border-radius: 3px; */
		overflow: hidden;
		border-bottom: 1px solid #ddd;
		border-right:1px solid #ddd;
	}
	
	body .mainmenu li a {
		display: block;
		color: #FFF;
		text-align: center
	}
	
	body .mainmenu li a b {
		display: block;
		height: 80px;
	}
	
	body .mainmenu li a img {
		margin: 15px auto 15px;
		width: 50px;
		height: 50px;
	}
	
	body .mainmenu li a span {
		display: block;
		height: 30px;
		line-height: 30px;
		//background-color: #FFF;
		color: #999;
		font-size: 14px;
		font-weight: bold;
	}
	
	
   </style>
  </head>
  <body>
  			<!-- top -->
  			<div style="background: #d5004d;">
  			<c:if test="${not empty sub.idcard }">
  			 <div style="float:right;margin-top: 10px;margin-right: 10px;color:#ccc">已认证</div> 
  			</c:if>
  			<c:if test="${ empty sub.idcard }">
  			 <div style="float:right;margin-top: 10px;margin-right: 10px;color:#ccc">未认证</div> 
  			</c:if>	
  				
  				<div style="text-align: center;padding-top: 20px">
  				<input type="hidden" name="openid" value="${sub.id }"/>
	  					<%-- <div style="width:30px;height:30px"><img  src="${sub.headimgurl }"></div> --%>
	  					<div style=";border-radius:40px;margin:0 auto;width:80px;height:80px;background:url('${sub.headimgurl }');background-size:100% 100%;"></div>
	  					<div style="color:white;">${sub.nickname }</div>
	  					<div style="color:white;">积分：<span id="jifen"> ${sub.integral }</span></div>
  				</div>
  				
  			</div>
  		<ul class="mainmenu">
				<li><a href="weixinSubscribeLocalController.do?goUpdateReal&openid=${sub.id }" ><b><img src="myplug-in/images/realname.png" /></b><span>实名认证</span></a></li> 
				<li><a onclick="tbscore()" ><b><img src="myplug-in/images/qiandao.png" /></b><span>每日打卡</span></a></li>
				<li><a href="tbscoreDetailController.do?getscoreDetal&openid=${sub.id }" ><b><img src="myplug-in/images/zhangdan.png" /></b><span>我的缴费</span></a></li>
<%--				<li><a href="tBGoodInfoController.do?goodlistmobile&openid=${sub.id }" ><b><img src="myplug-in/images/duihuan.png" /></b><span>我的兑换</span></a></li>--%>
				<li><a href="tQbErrorcollectionController.do?errorcollectitemlistmobile" ><b><img src="myplug-in/images/guize.png" /></b><span>我的错题</span></a></li>
				<li><a href="tQbCollectionController.do?collectitemlistmobile" ><b><img src="myplug-in/images/yuyue.png" /></b><span>我的收藏</span></a></li>
  
				<%-- <li><a href="sySuggListController.do?goAddMobile2&openid=${sub.id }" ><b><img src="images/xinxi.png" /></b><span>金玉良言</span></a></li> --%>
				<%--<li><a href="sySocialApplyController.do?queryoldapply&openid=${sub.id }" ><b><img src="myplug-in/images/wodeyanglao.png" /></b><span>我的养老申请</span></a>--%></li>
				<%-- <li><a href="tBNetvillageController.do?goAddMobile&openid=${sub.id }" ><b><img src="images/wanggegianli.png" /></b><span>网格管理员</span></a></li> 
				<li><a href="tBPetitionListController.do?listMobile&openid=${sub.id }" ><b><img src="images/wodexinfang2.png" /></b><span>我的信访</span></a></li>
				<li><a href="tBLlzxAppointController.do?listMobile&openid=${sub.id }" ><b><img src="images/gongnengquyy.png" /></b><span>功能区预约详情</span></a></li>
				<c:if test="${isa == '1' }">
				<li><a href="tBNetreportvillageController.do?listMobile&openid=${sub.id }" ><b><img src="images/wodeshangbao.png" /></b><span>我的上报</span></a></li>
				</c:if>
				--%>
	</ul>	
 		
  </body>
</html> 
