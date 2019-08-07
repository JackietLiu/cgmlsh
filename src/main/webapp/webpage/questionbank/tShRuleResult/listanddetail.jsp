<!--thisisid: listanddetail -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui"></t:base>
<div class="easyui-layout" fit="true">
   <div region="center" style="padding:0px;border:0px;overflow-x:hidden;">
    <iframe id="tShRuleResultList" src="${webRoot}/tShRuleResultController.do?list" frameborder="0" height="49%" width="100%"></iframe>
     <div id="accDiv" class="easyui-accordion" style="padding-right:15px;overflow-x:hidden;box-sizing: border-box;">  
		<div title="审核结果明细" data-options="iconCls:'icon-ok'" style="overflow:auto;box-sizing: border-box;">
			 <iframe id="tShNotfitruleDetailList" height="400"
                     src="${webRoot}/tShNotfitruleDetailController.do?list"
                     frameborder="0" width="100%" ></iframe>
		</div>
		 
   </div> 
  </div>
</div>
<script type="text/javascript">
	  function getCustomerList(id,ruleid){
		$("#tShNotfitruleDetailList")[0].contentWindow.getCustomerList(id,ruleid);
	}
 
	$(function(){
		var abc = parseInt(document.body.clientWidth)-17;
		$("#accDiv").css("width", abc);
	});

	
</script>