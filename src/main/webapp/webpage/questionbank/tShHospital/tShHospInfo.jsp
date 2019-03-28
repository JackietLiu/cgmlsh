<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>医院上传信息</title>
		<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
		
		<link rel="stylesheet" type="text/css" href="webpage/questionbank/tShHospital/info/css/default.css" />
		<link rel="stylesheet" type="text/css" href="webpage/questionbank/tShHospital/info/css/component.css" />
		<script type="text/javascript" src="webpage/questionbank/tShHospital/info/js/modernizr.custom.js"></script>

	</head>
	<style>
	.main{
	background-color:whit;
	padding:15px 0px 8px 0px;
	}
	
	</style>
<body style="overflow:hidden;overflow-y:auto;margin-top: 20px">

<div class="container">	
			<header class="clearfix">
			<div class="form-group">
		 <div class="input-group" style="font-size:20px">
			<label for="hosplevel" class="col-sm-3 control-label" style="font-size:20px">等级：</label> 
			<t:dictSelect field="hosplevel" type="radio" extendJson="{onchange:'isInter(this)'}" defaultVal="3"  typeGroupCode="hosplevel"  hasLabel="false"  title="等级" ></t:dictSelect>
		 </div>
	 	</div>
			</header>
			 <!-- 三级医院 -->
			<div class="main" id="level3" style="display:inline;">
				<ul id="og-grid" class="og-grid" >
				 <c:forEach items="${infolist}" var="m">
				 <c:choose>
				 <c:when test="${m.hosplevel=='3'}" > 
					<li>
						<a>
							<img  src="${m.logofilename}" alt="${m.logofilename}"/>
						</a>
						<div class="col-sm-7" style="padding-top:20px">
							 <div  style="width:100%">
							<span style="font-size:20px">${m.hospname}</span>
							</div>
						</div>
							<div class="col-sm-7" style="padding-top:30px">
							 	<div id="span3" style="width:100%">
							 <c:if test="${m.hospid ==''}" ><span style="font-size:20px;color:red">未上传</span></c:if>
							<c:if test="${m.hospid !=''}" ><span style="font-size:20px;padding-right:20px;color:blue">已上传</span>
							<c:if test="${m.thestatus =='1'}" ><span style="font-size:20px;color:blue">已审核</span></c:if>
							<c:if test="${m.thestatus !='1'}" ><span ><a style="font-size:20px;color:red" href="#" >待审核</a></span></c:if>
							</c:if>
								</div>
							</div>
						
					</li>
					 </c:when>
			 </c:choose>
					</c:forEach> 
				</ul>
			</div>
			 <!-- 二级医院 -->
			<div class="main" id="level2" style="display:none;">
				<ul id="og-grid" class="og-grid" >
				 <c:forEach items="${infolist}" var="m">
				 <c:choose>
				 <c:when test="${m.hosplevel=='2'}" > 
					<li>
						<a>
							<img  src="${m.logofilename}" alt="${m.logofilename}"/>
						</a>
						<div class="col-sm-7" style="padding-top:20px">
							 <div  style="width:100%">
							<span style="font-size:20px">${m.hospname}</span>
							</div>
						</div>
							<div class="col-sm-7" style="padding-top:30px">
							 	<div  id="span2" style="width:100%">
							 <c:if test="${m.hospid ==''}" ><span style="font-size:20px;color:red">未上传</span></c:if>
							<c:if test="${m.hospid !=''}" ><span style="font-size:20px;padding-right:20px;color:blue">已上传</span>
							<c:if test="${m.thestatus =='1'}" ><span style="font-size:20px;color:blue">已审核</span></c:if>
							<c:if test="${m.thestatus !='1'}" ><span ><a style="font-size:20px;color:red" href="#" >待审核</a></span></c:if>
							</c:if>
								</div>
							</div>
						
					</li>
					 </c:when>
			 </c:choose>
					</c:forEach> 
				</ul>
			</div>
		<!-- 一级医院 -->
			<div class="main" id="level1" style="display:none;">
				<ul id="og-grid" class="og-grid" >
				 <c:forEach items="${infolist}" var="m">
				 <c:choose>
				 <c:when test="${m.hosplevel=='1'}" > 
					<li>
						<a>
							<img  src="${m.logofilename}" alt="${m.logofilename}"/>
						</a>
						<div class="col-sm-7" style="padding-top:20px">
							 <div  style="width:100%">
							<span style="font-size:20px">${m.hospname}</span>
							</div>
						</div>
							<div class="col-sm-7" style="padding-top:30px">
							 	<div  style="width:100%">
							 <c:if test="${m.hospid ==''}" ><span style="font-size:20px;color:red">未上传</span></c:if>
							<c:if test="${m.hospid !=''}" ><span style="font-size:20px;padding-right:20px;color:blue">已上传</span>
							<c:if test="${m.thestatus =='1'}" ><span style="font-size:20px;color:blue">已审核</span></c:if>
							<c:if test="${m.thestatus !='1'}" ><span ><a style="font-size:20px;color:red" href="#" >待审核</a></span></c:if>
							</c:if>
								</div>
							</div>
						
					</li>
					 </c:when>
			 </c:choose>
					</c:forEach> 
				</ul>
			</div> 
			</div>
		<!-- /container -->
		<script src="js/jquery.min.js"></script>
		<script src="js/grid.js"></script>
		<script type="text/javascript">
			$(function() {
				Grid.init();
				// adding more items
				$('#og-additems').on( 'click', function() {
					var $items = $( '<li><a href="http://www.htmleaf.com/ " target="_blank" data-largesrc="images/1.jpg" data-title="Azuki bean" data-description="Swiss chard pumpkin bunya nuts maize plantain aubergine napa cabbage soko coriander sweet pepper water spinach winter purslane shallot tigernut lentil beetroot."><img src="images/thumbs/1.jpg" alt="img01"/></a></li><li><a href="http://www.htmleaf.com/ " target="_blank" data-largesrc="images/1.jpg" data-title="Azuki bean" data-description="Swiss chard pumpkin bunya nuts maize plantain aubergine napa cabbage soko coriander sweet pepper water spinach winter purslane shallot tigernut lentil beetroot."><img src="images/thumbs/1.jpg" alt="img01"/></a></li><li><a href="http://www.htmleaf.com/ " target="_blank" data-largesrc="images/1.jpg" data-title="Azuki bean" data-description="Swiss chard pumpkin bunya nuts maize plantain aubergine napa cabbage soko coriander sweet pepper water spinach winter purslane shallot tigernut lentil beetroot."><img src="images/thumbs/1.jpg" alt="img01"/></a></li><li><a href="http://www.htmleaf.com/ " target="_blank" data-largesrc="images/1.jpg" data-title="Azuki bean" data-description="Swiss chard pumpkin bunya nuts maize plantain aubergine napa cabbage soko coriander sweet pepper water spinach winter purslane shallot tigernut lentil beetroot."><img src="images/thumbs/1.jpg" alt="img01"/></a></li><li><a href="http://www.htmleaf.com/ " target="_blank" data-largesrc="images/1.jpg" data-title="Azuki bean" data-description="Swiss chard pumpkin bunya nuts maize plantain aubergine napa cabbage soko coriander sweet pepper water spinach winter purslane shallot tigernut lentil beetroot."><img src="images/thumbs/1.jpg" alt="img01"/></a></li><li><a href="http://www.htmleaf.com/ " target="_blank" data-largesrc="images/1.jpg" data-title="Azuki bean" data-description="Swiss chard pumpkin bunya nuts maize plantain aubergine napa cabbage soko coriander sweet pepper water spinach winter purslane shallot tigernut lentil beetroot."><img src="images/thumbs/1.jpg" alt="img01"/></a></li><li><a href="http://www.htmleaf.com/ " target="_blank" data-largesrc="images/1.jpg" data-title="Azuki bean" data-description="Swiss chard pumpkin bunya nuts maize plantain aubergine napa cabbage soko coriander sweet pepper water spinach winter purslane shallot tigernut lentil beetroot."><img src="images/thumbs/1.jpg" alt="img01"/></a></li><li><a href="http://www.htmleaf.com/ " target="_blank" data-largesrc="images/1.jpg" data-title="Azuki bean" data-description="Swiss chard pumpkin bunya nuts maize plantain aubergine napa cabbage soko coriander sweet pepper water spinach winter purslane shallot tigernut lentil beetroot."><img src="images/thumbs/1.jpg" alt="img01"/></a></li><li><a href="http://www.htmleaf.com/ " target="_blank" data-largesrc="images/1.jpg" data-title="Azuki bean" data-description="Swiss chard pumpkin bunya nuts maize plantain aubergine napa cabbage soko coriander sweet pepper water spinach winter purslane shallot tigernut lentil beetroot."><img src="images/thumbs/1.jpg" alt="img01"/></a></li><li><a href="http://www.htmleaf.com/ " target="_blank" data-largesrc="images/1.jpg" data-title="Azuki bean" data-description="Swiss chard pumpkin bunya nuts maize plantain aubergine napa cabbage soko coriander sweet pepper water spinach winter purslane shallot tigernut lentil beetroot."><img src="images/thumbs/1.jpg" alt="img01"/></a></li>' ).appendTo( $( '#og-grid' ) );
					
					Grid.addItems( $items );
					return false;
				} );
				
				
			});
			
			

			function isInter(cthis){
				
		        //一级：1；二级：2 ；三级：3；
		         var isInter = cthis.value;
		        if (isInter==1) {

		        	document.getElementById("level1").style.display="inline"; 
		        	document.getElementById("level2").style.display="none"; 
		        	document.getElementById("level3").style.display="none"; 
		          
		        }
		        if(isInter==2){
		        	document.getElementById("level1").style.display="none"; 
		        	document.getElementById("level2").style.display="inline"; 
		        	document.getElementById("level3").style.display="none";
		        
		        }
		        if(isInter==3){
		        	document.getElementById("level1").style.display="none"; 
		        	document.getElementById("level2").style.display="none"; 
		        	document.getElementById("level3").style.display="inline";
		        	 
		        }
		        
		    }
		</script>
		
</body>
</html>