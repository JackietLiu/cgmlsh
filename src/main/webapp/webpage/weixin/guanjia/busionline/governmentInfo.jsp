<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

 <!DOCTYPE html>
<html lang="zh">
<head>
<!--ZCZSN 20180926202438 -->
<meta name="viewport"
	content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
	
	<title>${title }</title>
		<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	    <link href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
<!-- 	<link href="webpage/com/shanyang/busionline/css/bootstrap.min.css" rel="stylesheet">
	  <link href="webpage/com/shanyang/busionline/css/font-awesome.min.css" rel="stylesheet">   -->
	<!--   <link rel="stylesheet" type="text/css" href="webpage/com/shanyang/busionline/css/htmleaf-demo.css">   -->
	<style type="text/css">
		
		.demo{padding: 1px; 0;}
		a:hover,a:focus{
		    text-decoration: none;
		    outline: none;
		}
		#accordion .panel{
		    border: none;
		    border-top: 1px solid #e8e8e8;
		    box-shadow: none;
		    border-radius: 0;
		    margin: 0;
		}
		#accordion .panel:last-child{
		    border-bottom: 1px solid #e8e8e8;
		}
		#accordion .panel-heading{
		    padding: 0;
		}
		#accordion .panel-title a{
		    display: block;
		    font-size: 16px;
		    font-weight: bold;
		    line-height: 24px;
		    color: #635858;
		    background: #fff;
		    padding: 15px 20px 15px 47px;
		    position: relative;
		    transition: all 0.5s ease 0s;
		}
		#accordion .panel-title a:before{
		     content: "\f068";  
		    font-family: 'FontAwesome';
		    display: block;
		    width: 30px;
		    height: 30px;
		    line-height: 32px;
		    border-radius: 50%;
		    background: #888bc2;
		    font-size: 14px;
		    color: #fff;
		    text-align: center;
		    position: absolute;
		    top: 25%;
		    left: 0;
		    transition: all 0.3s ease 0s;
		}
		#accordion .panel-title a.collapsed:before{
		    content: "\f067";
		}
		#accordion .panel-body{
		    font-size: 15px;
		    color: #635858;
		    line-height: 25px;
		    border: none;
		    padding: 0px 0px 0px 0px;
		    -webkit-overflow-scrolling: touch;  
            overflow-y: scroll;
		    
		}
	</style>
</head>
<body>
 <!-- zczforreturn --> 
 <link href="plug-in/mystick/style.css" rel="stylesheet" type="text/css" />
 <div id="rightArrow" style="width:40px;height:25px;background:url(plug-in/mystick/online_arrow.png)  no-repeat;background-size:40px 25px;
 		position:fixed;top:1%;right:0px;  "><a href="javascript:window.history.go(-1);  "  ></a></div>
		<!-- width:50px;height:45px;background:url(plug-in/mystick/online_arrow.jpg) no-repeat;
 		position:fixed;top:45%;right:-5px;  --> 
 </div>
 <!-- zczforreturn --> 
		<div class="demo">
	        <div class="container">
	            <div class="row">
	                <div class="col-md-offset-3 col-md-6">
	                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">	                      
                       
	                       <c:forEach items="${list }" var="m">	 
	                       
	                         <div class="panel panel-default">
	                            <div class="panel-heading" role="tab" id="headingOne_${m.id}">
	                                <h4 class="panel-title">
	                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#${m.id}" aria-expanded="true" aria-controls="${m.id}">
	                                        ${m.itemname}
	                                    </a>
	                                </h4>
	                            </div>
	                            <div id="${m.id}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne${m.id}">
	                                <div class="panel-body" style="height:500px; ">
	                                    <iframe  marginWidth=0 marginHeight=0 src="${m.url}"
	                                     frameBorder=0 width=100% height=100%></iframe>
	                                </div>
	                            </div>
	                        </div>	                       
		  
	                       </c:forEach>  
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
		
 
	
	 <script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
	<!-- <script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script> -->
 <script src="http://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
</body>
</html>


