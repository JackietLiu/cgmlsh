<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%
mypartial.ResourceUtil_Expand.consolePrintName(this.getClass(),"") ;
%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
 	<t:tabs id="tabsOne" iframe="true" tabPosition="top" fit="false" heigth="600px" >
		<t:tab href="tbConfig2Controller.do?list&id=${id }" icon="" title="默认配置" id="tab1"></t:tab>
		<t:tab href="tbConfigDetailController.do?list&confid=${id}" icon="" title="用户配置" id="tab2"></t:tab>
		<t:tab href="tbConfigDetailController.do?list2&confid=${id}" icon="" title="角色配置" id="tab3"></t:tab>
		<t:tab href="tbConfigDetailController.do?list3&confid=${id}" icon="" title="部门配置" id="tab4"></t:tab>
	</t:tabs>
	</div>
 <script src = "webpage/wz/tbconfig/tbConfig2List.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tbConfig2Controller.do?upload', "tbConfig2List");
}

//导出
function ExportXls() {
	JeecgExcelExport("tbConfig2Controller.do?exportXls","tbConfig2List");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tbConfig2Controller.do?exportXlsByT","tbConfig2List");
}

 </script>