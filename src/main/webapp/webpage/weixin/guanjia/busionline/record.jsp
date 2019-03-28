<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <!--ZCZSN 20180926202412 -->
 <meta name="viewport"
	content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" />
<meta name="apple-mobile-web-app-capable" content="yes" /> 
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
  <title>备案</title>
   <style type="text/css">
    body{margin: 0px;}
 
   </style>
   <script type="text/javascript">
   
   
   	
   	$(function(){  
	     pushHistory();   
	    window.addEventListener("popstate", function(e) {  
	    	//监听之后，执行的函数
	   
	     //alert("监听到了");
	      //WeixinJSBridge.call('closeWindow');
	     setTimeout(function(){WeixinJSBridge.call('closeWindow');},500);
	    	
	}, false);  
	     function pushHistory() {  
	        var state = {  
	            title: "title",  
	            url: "#"  
	        };  
	        window.history.pushState(state, "title", "#");  
	    }; 	      
	});    	
   	
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
		background-color: #FFF;
		color: #999;
		font-size: 14px;
	}
	
	
   </style>
  </head>
  <body>
  			<!-- top -->
  			<div style="width:100%;">
  				 <img width=100%  height=200px alt="图片" src="images/government.jpg">
  			</div>
  		<ul class="mainmenu">
				<li><a href="tBBusionlineInfoController.do?detailsRecord" ><b><img src="images/xinxi.png" /></b><span>临时备案申请表</span></a></li>
				<li><a href="#" ><b><img src="images/xinxi.png" /></b><span>临时备案告知承诺书（样式）</span></a></li>
				<li><a href="#" ><b><img src="images/xinxi.png" /></b><span>临时备案申请材料清单</span></a></li>
				<li><a href="#" ><b><img src="images/xinxi.png" /></b><span>临时备案办理条件</span></a></li>
				<li><a href="#" ><b><img src="images/xinxi.png" /></b><span>经营场所和设备设施基本要求</span></a></li>
				<li><a href="#" ><b><img src="images/xinxi.png" /></b><span>临时备案禁止经营行为</span></a></li>
				<li><a href="#" ><b><img src="images/xinxi.png" /></b><span>便民饮食店临时备案公示卡（样式）</span></a></li>
				<li><a href="#" ><b><img src="images/xinxi.png" /></b><span>临时备案信息告知单（样式）</span></a></li>
				<li><a href="#" ><b><img src="images/xinxi.png" /></b><span>便民饮食店经营品种目录</span></a></li>
				<li><a href="#" ><b><img src="images/xinxi.png" /></b><span>小型餐饮服务提供者临时备案试点工作
推进情况统计表</span></a></li>
						
		</ul>	
 		
  </body>
</html> 
