<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
<!--ZCZSN 20180926202428 -->
 <meta name="viewport"
	content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" />
<meta name="apple-mobile-web-app-capable" content="yes" /> 
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
  <title>附件下载</title>
   <style type="text/css">
    body{margin: 0px;}
 
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
		background-color: #FFF;
		color: #999;
		font-size: 14px;
	}
	
	
   </style>
  </head>
  <body>
  			<!-- top -->
  			<div style="width:100%;font-size:14px;">
			   &nbsp;&nbsp;&nbsp;&nbsp;下列附件只是办理该项业务时需要填报的表单，可自行下载、打印并预先填写，办理业务时携带至受理窗口，可帮助加快业务办理.
  			</div>
  			<hr/>
  		<ul class="mainmenu">
  		 
  		<c:if test="${!empty theentity.attachment1}">
  		<li><a href="${theentity.attachment1}" ><b>
				<img src="images/attachment.jpg" /></b><span>附件1下载</span></a></li>
  		</c:if>
  		
  		
  		<c:if test="${!empty theentity.attachment2}">
  		<li><a href="${theentity.attachment2}" ><b>
				<img src="images/attachment.jpg" /></b><span>附件2下载</span></a></li>
  		</c:if>
  		  		
  		<c:if test="${!empty theentity.attachment3}">
  		<li><a href="${theentity.attachment3}" ><b>
				<img src="images/attachment.jpg" /></b><span>附件3下载</span></a></li>
  		</c:if>
  		
  		<%-- 	<c:forEach items="${list }" var="m">  			 
				<li><a href="${m.url}" ><b>
				<img src="${m.photopath}" /></b><span>${m.businameshort }</span></a></li>
			</c:forEach> --%>				
		</ul>	
 		
  </body>
</html> 
