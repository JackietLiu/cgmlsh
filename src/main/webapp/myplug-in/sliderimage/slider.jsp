<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- <jsp:include page="/webpage/com/sctf/jxtwx/weixin/pageTitle/pageTitle.jsp">

 <jsp:param value="${imagelist }" name="imagelist"/>
  <jsp:param value="${firstimage }" name="firstimage"/>
 <jsp:param value="${lastimage }" name="lastimage"/>
</jsp:include> --%>

 <link rel="stylesheet" href="/myplug-in/mui/css/mui.min.css">
 	<script type="text/javascript" src="/myplug-in/mui/js/mui.min.js"></script>
<!DOCTYPE html>
  <!--  图片滚动  begin -->
	<div id="slider" class="mui-slider" >
		<div class="mui-slider-group mui-slider-loop">
		
		 <div class="mui-slider-item mui-slider-item-duplicate">
			<a href="#">
				<img src="${lastimage}" >
			</a>
		</div>
		<c:forEach  var="it" items="${imagelist}" varStatus="st"> 
		"1111"
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
					<c:if test="${st.first}">
						<div class="mui-indicator mui-active"></div>
					</c:if>					
					
					<div class="mui-indicator"></div>
				 
				</c:forEach> 	
			
			</div>
		</div>
	<!--  图片滚动  end -->