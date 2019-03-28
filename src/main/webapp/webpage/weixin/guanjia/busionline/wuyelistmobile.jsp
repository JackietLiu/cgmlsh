<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!--ZCZSN 20180926200556 -->
<%-- <t:base type="jquery,easyui,tools,DatePicker"></t:base> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 
 <meta name="viewport"
	content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" />
<meta name="apple-mobile-web-app-capable" content="yes" /> 
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
  <title>物业服务</title>
   <style type="text/css">
    body{margin: 0px;}
 
   </style>
   <script type="text/javascript">
   
   	/* window.onload=function(){
   		var openid = $("input[name='openid']").val();

   		localStorage.setItem("openid", openid);
   	     alert(localStorage.getItem("openid"));  
   	} */
   	
   	$(function(){  
	     pushHistory();   
	    window.addEventListener("popstate", function(e) {  
	    
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
		background-image: url("images/sb.png");
	 background-size: 100% 100%;height: 100%;
		
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
	/* 	background-color: #FFF; */
		color: #999;
		font-size: 14px;
		font-weight: bold;
	}
	
	
   </style>
  </head>
  <body>
  			<!-- top -->
  			<div style="width:100%;">
  				 <img width=100%  height=200px alt="图片" src="images/wuyelistmobile.jpg">
  			</div>
  		<ul class="mainmenu">
  			<c:forEach items="${list }" var="m">  			 
				<li><a href="${m.url}" ><b>
				<img src="${m.photopath}" /></b><span>${m.businameshort }</span></a></li>
			</c:forEach>				
		</ul>	
 		
  </body>
</html> 
