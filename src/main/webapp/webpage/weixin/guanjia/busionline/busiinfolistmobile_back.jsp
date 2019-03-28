<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <!--ZCZSN 20180926202447 -->
 <meta name="viewport"
	content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" />
<meta name="apple-mobile-web-app-capable" content="yes" /> 
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
  <title>${title}</title>
   <style type="text/css">
   
    body{margin: 0px;background-image: url("images/sb.png");
	 background-size: 100% 100%;}
 
   </style>
   
     <link rel="stylesheet" href="/myplug-in/mui/css/mui.min.css">
 	<script type="text/javascript" src="/myplug-in/mui/js/mui.min.js"></script>
 	
   <script type="text/javascript">
   
   $(function(){
	   mui.init({
			swipeBack:true //启用右滑关闭功能
		});
	   
	   var slider = mui("#slider");
	    
	   slider.slider({
			interval: 5000
		});
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
		height: 60px;
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
	
   </style>
  </head>
  <body> 
  			<!-- top -->
  			<div style="width:100%;height:250px;">
  			
  				<!--  图片滚动  begin -->
	<div id="slider" class="mui-slider" >
		<div class="mui-slider-group mui-slider-loop">
		
		 <div class="mui-slider-item mui-slider-item-duplicate">
			<a href="#">
				<img width="100%" src="${lastimage}" >
			</a>
		</div>
		<c:forEach  var="it" items="${imagelist}" varStatus="st"> 
		 www
			<div class="mui-slider-item">
				<a href="#">
					<img src="${it.imgurl }">
				</a>
			</div>		
		 
		</c:forEach> 
					
		<div class="mui-slider-item mui-slider-item-duplicate">
			<a href="#">
				<img src="${firstimage}">
			</a>
		</div>
		</div>
			
			
			<div class="mui-slider-indicator">
				<c:forEach  var="item" items="${imagelist}" varStatus="st"> 
					<%-- <c:if test="${st.first}">
						<div class="mui-indicator mui-active"></div>
					</c:if>	 --%>				
					
				</c:forEach> 	
			<div class="mui-indicator mui-active"></div>
					  <div class="mui-indicator"></div>  
				   <div class="mui-indicator"></div> 
			</div>
		</div>
	<!--  图片滚动  end -->
  	</div>
  		  			
	  		<ul class="mainmenu">
	  			<c:forEach items="${list }" var="m"> 
					<li><a href="${m.url}&title=${m.businameshort}" ><b>
					<img src="${m.photopath}" /></b><span>${m.businameshort }</span></a></li>
				</c:forEach>
			</ul> 		
  </body>
</html> 
