<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%@ page import="java.util.*"%>

<%
String __jspName = this.getClass().getSimpleName().replaceAll("_", ".");
System.out.println("current page:"+ __jspName.replaceAll(".005f", "_").replaceAll(".002d", "-"));
%> 
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script> 

//alert(strPage);
</script>
 <!-- 申购单购物车页面 -->
	 
<script type="text/javascript" language="javascript">


/**
 * 点击事件
 */
 function onok(consid){
	 document.getElementById("myframe").src= "<%=request.getContextPath() %>/tBaConsortiumHospitalController.do?list&consid=" +consid ;
 };
function onck(){	
     <%-- document.getElementById("myframe").src= "<%=request.getContextPath() %>/WzDProdControllerToChooseGoods.do?toNodeList&id=" +yc+"&sou="+sou  ;  --%> 
};

$(document).ready(function(){
    document.getElementById("myframe2").src= "<%=request.getContextPath() %>/tBaMedicalConsortiumController.do?leftlist" ;
});


</script>  
 
<!--add-end--Author:luobaoli  Date:20150607 for：增加表单树型列表-->

<div class="easyui-layout" fit="true">
 <!-- 当前页面 mchlist.jsp  -->
<!--update-start--Author:luobaoli  Date:20150609 for：panel调整为默认关闭-->
<div region="west" style="width: 780px;overflow: hidden;" title="医联体" split="true" collapsed="false">
<iframe id="myframe2" name="myframe2"   style="width:100%;height:100%;border: 1px solid #ccc" scrolling="no">
</iframe>
</div>
<div region="center" style="padding:0px;border:0px" title="基层医院" >
<iframe id="myframe" name="myframe"   style="width:100%;height:100%;border: 1px solid #ccc"></iframe>
  
</div> 
</div>
