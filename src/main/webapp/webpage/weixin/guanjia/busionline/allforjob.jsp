<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!--ZCZSN  20180926194727-->
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  
 <meta name="viewport"
	content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" />
<meta name="apple-mobile-web-app-capable" content="yes" /> 
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
  <title>创业服务</title>
   <style type="text/css">
    body{margin: 0px;background-image: url("images/sb.png");
	 background-size: 100% 100%;}
 
   </style>
   <script type="text/javascript"> 
   
   	
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
		/* background-color: #FFF; */
		color: #999;
		font-size: 14px;
		font-weight: bold;
	}	
	#toper{
		position:fixed;	
		width:100%;
		height:145px;
		z-index:9999;
		top:55px;
		background: black;
		opacity: 0.6;
		color:white;
		text-indent: 2em;
		
	}
	#footer{
		width:100%;
		color:black;
		text-indent: 2em;
		z-index:9999;
	}
   </style>
  </head>
  <body>
  			<!-- top -->
  			<!-- <div style="width:100%;">
  				 <img width=100%  height=200px alt="图片" src="images/allforjob.png">
  			</div>
  			<div id="toper" >
				位于金山区委、区政府的中心区域，金山新城区开发建设的重点区域，山阳的创业环境得天独厚。
3个创业孵化基地，5个创业园区，为你提供旅游、文化、科技、农业、金融等多个领域的创业园区。
近三年来扶持160家企业成功创业，为43家企业申请创业扶持资金。山阳创业指导室全年提供政策咨询、专家指导、创业培训、创业见习、扶持资金申请等创业一条龙服务。
“金山明珠”——山阳，欢迎您加入我们的创业行列中来~！
			</div> -->
			<div style="width:100%;">
  				 <img width=100%  height=150px alt="图片" src="images/allforjob.png">
  			</div>
	  		<ul class="mainmenu">
	  			<c:forEach items="${list }" var="m">  			 
					<li><a href="${m.url}&title=${m.businameshort}" ><b>
					<img src="${m.photopath}" /></b><span>${m.businameshort }</span></a></li>
				</c:forEach>
			</ul> 		
			<div id="footer" >
				位于金山区委、区政府的中心区域，金山新城区开发建设的重点区域，山阳的创业环境得天独厚。
3个创业孵化基地，5个创业园区，为你提供旅游、文化、科技、农业、金融等多个领域的创业园区。
近三年来扶持160家企业成功创业，为43家企业申请创业扶持资金。山阳创业指导室全年提供政策咨询、专家指导、创业培训、创业见习、扶持资金申请等创业一条龙服务。
“金山明珠”——山阳，欢迎您加入我们的创业行列中来~！
			</div>
  </body>
</html> 
